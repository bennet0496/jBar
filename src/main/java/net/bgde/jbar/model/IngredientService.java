package net.bgde.jbar.model;

import com.google.common.collect.Streams;
import jdk.nashorn.internal.objects.NativeArray;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Transactional
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final GenericIngredientRepository genericIngredientRepository;
    private final ConcreteIngredientRepository concreteIngredientRepository;

    public IngredientService(IngredientRepository ingredientRepository, GenericIngredientRepository genericIngredientRepository, ConcreteIngredientRepository concreteIngredientRepository) {
        this.ingredientRepository = ingredientRepository;
        this.genericIngredientRepository = genericIngredientRepository;
        this.concreteIngredientRepository = concreteIngredientRepository;
    }

    public Stream<Ingredient> findAllIngredients(){
        return Streams.stream(ingredientRepository.findAll());
    }

    public Stream<GenericIngredient> findAllGenericIngredients(){
        return Streams.stream(genericIngredientRepository.findAll());
    }

    public Stream<ConcreteIngredient> findAllConcreteIngredients(){
        return Streams.stream(concreteIngredientRepository.findAll());
    }


    public Stream<Ingredient> findAllByName(String name){
        return Streams.stream(ingredientRepository.findAllByName(name));
    }

    public Stream<ConcreteIngredient> findAllConcreteIngredientsByType(GenericIngredient type){
        return Streams.stream(concreteIngredientRepository.findAllByType(type));
    }

    public List<ConcreteIngredient> getConcreateDrinks(GenericIngredient ingredient){
        return new LinkedList<ConcreteIngredient>();
    }

    public ConcreteIngredient mapToConcreteIngredient(Ingredient ingredient) {
        if(ingredient instanceof ConcreteIngredient) {
            return (ConcreteIngredient) ingredient;
        } else {
            return Streams.stream(concreteIngredientRepository.findAllByType((GenericIngredient)ingredient)).findAny().orElse(null);
        }
    }

    public Optional<Ingredient> findOne(Long id) {
        return ingredientRepository.findById(id);
    }

    public Optional<ConcreteIngredient> findConcreteOne(Long id) {
        return concreteIngredientRepository.findById(id);
    }

    public ConcreteIngredient saveConcrete(ConcreteIngredient concreteIngredient) {
        return concreteIngredientRepository.save(concreteIngredient);
    }

    public GenericIngredient saveGeneric(GenericIngredient genericIngredient) {
        return genericIngredientRepository.save(genericIngredient);
    }
}
