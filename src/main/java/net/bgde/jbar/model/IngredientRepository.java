package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
    Iterable<InstallableDrink> findAll();

    Iterable<InstallableDrink> findAllByName(String name);

    Iterable<InstallableDrink> findAllByType(DrinkType type);
}
