package net.bgde.jbar.model;

import com.google.common.collect.Streams;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final InstallableDrinkService installableDrinkService;

    public IngredientService(IngredientRepository ingredientRepository, InstallableDrinkService installableDrinkService) {
        this.ingredientRepository = ingredientRepository;
        this.installableDrinkService = installableDrinkService;
    }

    public Stream<Ingredient> findAll(){
        return Streams.stream(ingredientRepository.findAll());
    }

    public Stream<Ingredient> findAllByName(String name){
        return Streams.stream(ingredientRepository.findAllByName(name));
    }

    public Stream<Ingredient> findAllByType(DrinkType type){
        return Streams.stream(ingredientRepository.findAllByType(type));
    }

    public List<InstallableDrink> getDrinks(Ingredient ingredient){
        return installableDrinkService.findAllByType(ingredient.getType()).collect(Collectors.toList());
    }
}
