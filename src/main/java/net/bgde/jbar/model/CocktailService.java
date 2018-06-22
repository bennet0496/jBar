package net.bgde.jbar.model;

import com.google.common.collect.Streams;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Stream;

@Service
@Transactional
public class CocktailService {
    private final CocktailRepository cocktailRepository;
    private final IngredientService ingredientService;
    private final SlotRepository slotRepository;

    public CocktailService(CocktailRepository cocktailRepository, IngredientService ingredientService, SlotRepository slotRepository) {
        this.cocktailRepository = cocktailRepository;
        this.ingredientService = ingredientService;
        this.slotRepository = slotRepository;
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
        return cocktail.getIngredients().keySet().stream().allMatch(ingredient ->
                (
                        ingredient instanceof ConcreteIngredient &&
                        Streams.stream(slotRepository.findAll()).anyMatch(slot -> slot.getInstalledDrink().equals(ingredient))
                ) || (
                        ingredient instanceof GenericIngredient &&
                                ingredientService.findAllConcreteIngredients().anyMatch(concreteIngredient ->
                                        concreteIngredient.getType().stream().anyMatch(genericIngredient ->
                                                genericIngredient.equals(ingredient)) &&
                                        Streams.stream(slotRepository.findAll()).anyMatch(slot -> slot.getInstalledDrink().equals(concreteIngredient))
                                )
                )
        );
    }

    public Cocktail serveCocktail(Cocktail cocktail){
        if(isCocktailAvailable(cocktail)) {
            //TODO: implement Serial Communication
            System.out.println("HELO API CONNECTOR");
            cocktail.getIngredients().forEach((i, a) ->
                    slotRepository.findByInstalledDrink(ingredientService.mapToConcreteIngredient(i)).serve(a)
            );
            System.out.println("DONE");
            return cocktail;
        } else {
            return null;
        }
    }
}
