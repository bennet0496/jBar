package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkTypeRepository extends CrudRepository<DrinkType, String> {
    Iterable<DrinkType> findAll();

    DrinkType findOne(String name);
}
