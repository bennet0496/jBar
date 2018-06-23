package net.bgde.jbar.controller;

import net.bgde.jbar.model.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api")
public class ApiController {
    private final CocktailService cocktailService;
    private final IngredientService ingredientService;

    public ApiController(CocktailService cocktailService, IngredientService ingredientService) {
        this.cocktailService = cocktailService;
        this.ingredientService = ingredientService;
    }

    @GetMapping(value = "/cocktails", produces = "application/json")
    public List<Cocktail> getCocktails() {
        return cocktailService.findAll().collect(Collectors.toList());
    }

    @PostMapping(value = "/cocktails")
    public Cocktail postCocktails(@RequestBody Cocktail cocktail){
        return cocktailService.save(cocktail);
    }

    @GetMapping(value = "/cocktails/{id}")
    public Optional<Cocktail> getCocktailsId(@PathVariable Long id) {
        return cocktailService.findOne(id);
    }

    @DeleteMapping(value = "/cocktails/{id}")
    public void deleteCocktailId(@PathVariable Long id){
        cocktailService.delete(id);
    }

    @GetMapping(value = "/ingredients")
    public List<Ingredient> getIngredients() {
        return ingredientService.findAllIngredients().collect(Collectors.toList());
    }

    @GetMapping(value = "/ingredients/{id}")
    public Optional<Ingredient> getIngredientsId(@PathVariable Long id) {
        return ingredientService.findOne(id);
    }

    @GetMapping(value = "/ingredients/concrete")
    public List<ConcreteIngredient> getIngredientsConcreate() {
        return ingredientService.findAllConcreteIngredients().collect(Collectors.toList());
    }

    @PostMapping(value = "/ingredients/concrete")
    public ConcreteIngredient postIngredientsConcreate(@RequestBody ConcreteIngredient concreteIngredient) {
        return ingredientService.saveConcrete(concreteIngredient);
    }

    @GetMapping(value = "/ingredients/concrete/{id}")
    public Optional<ConcreteIngredient> getIngredientsConcreteId(@PathVariable Long id) {
        return ingredientService.findOne(id).map(i -> (ConcreteIngredient)i);
    }

    @GetMapping(value = "/ingredients/generic")
    public List<GenericIngredient> getIngredientsGeneric() {
        return ingredientService.findAllGenericIngredients().collect(Collectors.toList());
    }

    @PostMapping(value = "/ingredients/generic")
    public GenericIngredient postIngredientsGeneric(@RequestBody GenericIngredient genericIngredient) {
        return ingredientService.saveGeneric(genericIngredient);
    }

    @GetMapping(value = "/ingredients/generic/{id}")
    public Optional<GenericIngredient> getIngredientsGenericId(@PathVariable Long id) {
        return ingredientService.findOne(id).map(i -> (GenericIngredient)i);
    }

    @GetMapping(value = "/ingredients/concrete/{id}/image")
    public byte[] getIngredientsConcreteIdImage(@PathVariable Long id) throws IOException {
        Path path = ingredientService.findConcreteOne(id).map(ingredient -> Paths.get(ingredient.getImagePath())).orElse(Paths.get("/dev/null"));
        return Files.readAllBytes(path);
    }
}
