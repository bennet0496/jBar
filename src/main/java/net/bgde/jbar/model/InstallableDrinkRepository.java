package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallableDrinkRepository extends CrudRepository<InstallableDrinkRepository, Long> {
    Iterable<InstallableDrinkRepository> findAll();

    Iterable<InstallableDrinkRepository> findAllByName(String name);

    Iterable<InstallableDrinkRepository> findAllByType(DrinkType type);
    
}
