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

    public Stream<Cocktail> findAll(){
        return Streams.stream(cocktailRepository.findAll());
    }

    public Stream<Cocktail> findByName(String name){
        return Streams.stream(cocktailRepository.findByName(name));
    }

    public boolean isCocktailAvailable(Cocktail cocktail){
        /*cocktail.getIngredients().keySet().stream().allMatch(ingredient ->
            ingredientService.getDrinks()
        )*/
        return false;
    }
}
