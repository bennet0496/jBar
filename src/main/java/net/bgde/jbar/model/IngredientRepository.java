package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
    Iterable<Ingredient> findAll();

    Iterable<Ingredient> findAllByName(String name);

    Iterable<Ingredient> findAllByType(GenericIngredient type);
}
