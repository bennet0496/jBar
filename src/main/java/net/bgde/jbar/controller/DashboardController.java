package net.bgde.jbar.controller;

import net.bgde.jbar.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.stream.Collectors;

@Controller
public class DashboardController {
    private final CocktailService cocktailService;
    private final GenericIngredientRepository genericIngredientRepository;
    private final ConcreteIngredientRepository concreteIngredientRepository;
    private final CocktailRepository cocktailRepository;
    private final CocktailIngredientRepository cocktailIngredientRepository;

    @Autowired
    public DashboardController(CocktailService cocktailService, GenericIngredientRepository genericIngredientRepository, ConcreteIngredientRepository concreteIngredientRepository, CocktailRepository cocktailRepository, CocktailIngredientRepository cocktailIngredientRepository) {
        this.cocktailService = cocktailService;
        this.genericIngredientRepository = genericIngredientRepository;
        this.concreteIngredientRepository = concreteIngredientRepository;
        this.cocktailRepository = cocktailRepository;
        this.cocktailIngredientRepository = cocktailIngredientRepository;
    }

    @GetMapping("/cocktails")
    public String getCocktails(Model model){
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

            LinkedList<CocktailIngredient> cocktailIngredients = new LinkedList<>();
            cocktailIngredients.add(czutat1);
            cocktailIngredients.add(czutat2);
            cocktailRepository.save(new Cocktail("Cuba Libre", "/dev/null",cocktailIngredients));
        }
        model.addAttribute("cocktails", cocktailService.findAll().collect(Collectors.toList()));
        return "cocktails";
    }
}
