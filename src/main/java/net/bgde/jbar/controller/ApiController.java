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
        return cocktailService.findAll().collect(Collectors.toList());
    }
}
