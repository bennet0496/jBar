package net.bgde.jbar.model;

import com.google.common.collect.Streams;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;
import net.bgde.jbar.core.SerialPort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

@Service
@Transactional
public class CocktailService {
    private final CocktailRepository cocktailRepository;
    private final IngredientService ingredientService;
    private final SlotRepository slotRepository;

    private final SerialPort serialPort;

    public CocktailService(CocktailRepository cocktailRepository, IngredientService ingredientService, SlotRepository slotRepository, SerialPort serialPort) {
        this.cocktailRepository = cocktailRepository;
        this.ingredientService = ingredientService;
        this.slotRepository = slotRepository;
        this.serialPort = serialPort;
    }

    /**
     * Retrieve all saved Cocktails as Stream
     * @return all Cocktails
     */
    public Stream<Cocktail> findAll(){
        return Streams.stream(cocktailRepository.findAll());
    }

    /**
     * Search for a Cocktail by it's name
     * @param name Name of the Cocktail
     * @return Matching Cocktails
     */
    public Stream<Cocktail> findByName(String name){
        return Streams.stream(cocktailRepository.findAllByNameContains(name));
    }

    public boolean isCocktailAvailable(Cocktail cocktail){
        return cocktail.getIngredients().stream().allMatch(ingredient ->
                (
                        ingredient.getIngredient() instanceof ConcreteIngredient &&
                        Streams.stream(slotRepository.findAll()).anyMatch(slot -> slot.getInstalledDrink().equals(ingredient.getIngredient()))
                ) || (
                        ingredient.getIngredient() instanceof GenericIngredient &&
                                ingredientService.findAllConcreteIngredients().anyMatch(concreteIngredient ->
                                        concreteIngredient.getType().stream().anyMatch(genericIngredient ->
                                                genericIngredient.equals(ingredient.getIngredient())) &&
                                        Streams.stream(slotRepository.findAll()).anyMatch(slot -> slot.getInstalledDrink().equals(concreteIngredient))
                                )
                )
        );
    }

    private void waitForString(String string){
        long counter = 0;

        try {
            do {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
            } while (serialPort.in().readLine().equalsIgnoreCase(string) && counter < 1000);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Communication Failed! Breaking Loop", e);
        }
    }

    public Cocktail serveCocktail(Cocktail cocktail) throws Exception {
        if(isCocktailAvailable(cocktail)) {
            if(!serialPort.connected())
                serialPort.connect();

            serialPort.out().println("HELO API CONNECTOR");
            try {
                cocktail.getIngredients().forEach(cocktailIngredient -> {
                    Slot slot = slotRepository.findByInstalledDrink(
                            ingredientService.mapToConcreteIngredient(cocktailIngredient.getIngredient()));

                    serialPort.out().println(String.format("SERVE %s", slot.getPositon()));
                    waitForString("250 - Ok");
                    serialPort.out().println(String.format("UNITS %d", cocktailIngredient.getAmount()));
                    waitForString("300 Queued");
                    waitForString("251 done");
                });
            } catch (RuntimeException e){
                throw new IOException("Communication with Robot failed!", e);
            }
            serialPort.out().println("QUIT");
            return cocktail;
        } else {
            return null;
        }
    }

    public Optional<Cocktail> findOne(Long id) {
        return cocktailRepository.findById(id);
    }

    public Cocktail save(Cocktail cocktail) {
        return cocktailRepository.save(cocktail);
    }

    public void delete(Long id) {
        cocktailRepository.deleteById(id);
    }
}
