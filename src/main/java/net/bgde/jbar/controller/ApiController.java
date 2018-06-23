package net.bgde.jbar.controller;

import net.bgde.jbar.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApiController {
    private final CocktailService cocktailService;
    private final GenericIngredientRepository genericIngredientRepository;
    private final ConcreteIngredientRepository concreteIngredientRepository;
    private final CocktailRepository cocktailRepository;
    private final CocktailIngredientRepository cocktailIngredientRepository;

    public ApiController(CocktailService cocktailService, GenericIngredientRepository genericIngredientRepository, ConcreteIngredientRepository concreteIngredientRepository, CocktailRepository cocktailRepository, CocktailIngredientRepository cocktailIngredientRepository) {
        this.cocktailService = cocktailService;
        this.genericIngredientRepository = genericIngredientRepository;
        this.concreteIngredientRepository = concreteIngredientRepository;
        this.cocktailRepository = cocktailRepository;
        this.cocktailIngredientRepository = cocktailIngredientRepository;
    }

    @GetMapping(value = "/api/cocktails", produces = "application/json")
    public List<Cocktail> getCocktails() {
        if(cocktailService.findAll().count() < 1) {
            GenericIngredient typ1 = genericIngredientRepository.save(new GenericIngredient("Rum"));
            GenericIngredient typ2 = genericIngredientRepository.save(new GenericIngredient("Cola"));

            LinkedList<GenericIngredient> typ1List = new LinkedList<>();
            typ1List.add(typ1);

            LinkedList<GenericIngredient> typ2List = new LinkedList<>();
            typ2List.add(typ2);

            ConcreteIngredient zutat1 = concreteIngredientRepository.save(new ConcreteIngredient("Havanna", typ1List));
            ConcreteIngredient zutat2 = concreteIngredientRepository.save(new ConcreteIngredient("Coca Cola", typ2List));

            CocktailIngredient czutat1 = cocktailIngredientRepository.save(new CocktailIngredient(zutat1, 3));
            CocktailIngredient czutat2 = cocktailIngredientRepository.save(new CocktailIngredient(zutat2, 25));
            CocktailIngredient czutat3 = cocktailIngredientRepository.save(new CocktailIngredient(typ1, 4));

            LinkedList<CocktailIngredient> cocktailIngredients = new LinkedList<>();
            cocktailIngredients.add(czutat1);
            cocktailIngredients.add(czutat2);

            LinkedList<CocktailIngredient> cocktailIngredients1 = new LinkedList<>();
            cocktailIngredients1.add(czutat2);
            cocktailIngredients1.add(czutat3);

            cocktailRepository.save(new Cocktail("Cuba Libre", "/dev/null",cocktailIngredients));
            cocktailRepository.save(new Cocktail("Rucola", "/dev/null",cocktailIngredients1));
        }
        return cocktailService.findAll().collect(Collectors.toList());
    }
}
