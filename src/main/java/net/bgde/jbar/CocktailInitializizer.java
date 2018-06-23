package net.bgde.jbar;

import net.bgde.jbar.core.DataInitializer;
import net.bgde.jbar.model.*;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class CocktailInitializizer implements DataInitializer {
    private final IngredientService ingredientService;
    private final GenericIngredientRepository genericIngredientRepository;
    private final ConcreteIngredientRepository concreteIngredientRepository;
    private final CocktailRepository cocktailRepository;
    private final CocktailIngredientRepository cocktailIngredientRepository;

    public CocktailInitializizer(IngredientService ingredientService, GenericIngredientRepository genericIngredientRepository, ConcreteIngredientRepository concreteIngredientRepository, CocktailRepository cocktailRepository, CocktailIngredientRepository cocktailIngredientRepository) {
        this.ingredientService = ingredientService;
        this.genericIngredientRepository = genericIngredientRepository;
        this.concreteIngredientRepository = concreteIngredientRepository;
        this.cocktailRepository = cocktailRepository;
        this.cocktailIngredientRepository = cocktailIngredientRepository;
    }

    @Override
    public void initialize() {
        GenericIngredient typ1 = genericIngredientRepository.save(new GenericIngredient("Rum"));
        GenericIngredient typ2 = genericIngredientRepository.save(new GenericIngredient("Cola"));

        LinkedList<GenericIngredient> typ1List = new LinkedList<>();
        typ1List.add(typ1);

        LinkedList<GenericIngredient> typ2List = new LinkedList<>();
        typ2List.add(typ2);

        ConcreteIngredient zutat1 = concreteIngredientRepository.save(new ConcreteIngredient("Havanna", typ1List, "/dev/null"));
        ConcreteIngredient zutat2 = concreteIngredientRepository.save(new ConcreteIngredient("Coca Cola", typ2List, "/dev/null"));

        //Havanna
        CocktailIngredient czutat1 = cocktailIngredientRepository.save(new CocktailIngredient(zutat1, 3));
        //Coca Cola
        CocktailIngredient czutat2 = cocktailIngredientRepository.save(new CocktailIngredient(zutat2, 25));

        //Rum
        CocktailIngredient czutat3 = cocktailIngredientRepository.save(new CocktailIngredient(typ1, 4));
        //Coca Cola
        CocktailIngredient czutat4 = cocktailIngredientRepository.save(new CocktailIngredient(typ2, 25));

        LinkedList<CocktailIngredient> cocktailIngredients = new LinkedList<>();
        cocktailIngredients.add(czutat1);
        cocktailIngredients.add(czutat2);

        LinkedList<CocktailIngredient> cocktailIngredients1 = new LinkedList<>();
        cocktailIngredients1.add(czutat3);
        cocktailIngredients1.add(czutat4);

        cocktailRepository.save(new Cocktail("Cuba Libre", "/dev/null",cocktailIngredients));
        cocktailRepository.save(new Cocktail("Rucola", "/dev/null",cocktailIngredients1));
    }
}
