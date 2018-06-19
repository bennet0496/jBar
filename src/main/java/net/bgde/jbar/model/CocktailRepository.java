package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocktailRepository extends CrudRepository<Cocktail, Long> {
    Iterable<Cocktail> findAll();

    Iterable<Cocktail> findByName(String name);
}
