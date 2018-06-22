package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
   Iterable<Ingredient> findAllByName(String name);

    @Override
    <S extends Ingredient> S save(S entity);

    @Override
    <S extends Ingredient> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Ingredient> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<Ingredient> findAll();

    @Override
    Iterable<Ingredient> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Ingredient entity);

    @Override
    void deleteAll(Iterable<? extends Ingredient> entities);

    @Override
    void deleteAll();
}
