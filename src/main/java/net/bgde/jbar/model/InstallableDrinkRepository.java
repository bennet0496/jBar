package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallableDrinkRepository extends CrudRepository<InstallableDrink, Long> {
    Iterable<InstallableDrink> findAll();

    Iterable<InstallableDrink> findAllByName(String name);

    Iterable<InstallableDrink> findAllByType(DrinkType type);
    
}
