package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcreteIngredientRepository extends CrudRepository<ConcreteIngredient, Long> {
    Iterable<ConcreteIngredient> findAll();

    Iterable<ConcreteIngredient> findAllByName(String name);

    Iterable<ConcreteIngredient> findAllByType(GenericIngredient type);
    
}
