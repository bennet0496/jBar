package net.bgde.jbar.model;

import com.google.common.collect.Streams;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Stream<Ingredient> findAll(){
        return Streams.stream(ingredientRepository.findAll());
    }

    public Stream<Ingredient> findAllByName(String name){
        return Streams.stream(ingredientRepository.findAllByName(name));
    }

    public Stream<Ingredient> findAllByType(GenericIngredient type){
        return Streams.stream(ingredientRepository.findAllByType(type));
    }

    public List<ConcreteIngredient> getConcreateDrinks(GenericIngredient ingredient){
        return new LinkedList<ConcreteIngredient>();
    }
}
