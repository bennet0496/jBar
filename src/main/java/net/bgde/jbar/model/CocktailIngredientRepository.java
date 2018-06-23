package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CocktailIngredientRepository extends CrudRepository<CocktailIngredient, Long> {
    @Override
    <S extends CocktailIngredient> S save(S entity);

    @Override
    <S extends CocktailIngredient> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<CocktailIngredient> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<CocktailIngredient> findAll();

    @Override
    Iterable<CocktailIngredient> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(CocktailIngredient entity);

    @Override
    void deleteAll(Iterable<? extends CocktailIngredient> entities);

    @Override
    void deleteAll();
}
