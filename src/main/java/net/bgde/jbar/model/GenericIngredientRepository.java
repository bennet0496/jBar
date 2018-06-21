package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericIngredientRepository extends CrudRepository<GenericIngredient, String> {
    Iterable<GenericIngredient> findAll();

    GenericIngredient findOne(String name);
}
