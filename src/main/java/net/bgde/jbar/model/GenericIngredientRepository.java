package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenericIngredientRepository extends CrudRepository<GenericIngredient, Long> {
    @Override
    <S extends GenericIngredient> S save(S entity);

    @Override
    <S extends GenericIngredient> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<GenericIngredient> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<GenericIngredient> findAll();

    @Override
    Iterable<GenericIngredient> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(GenericIngredient entity);

    @Override
    void deleteAll(Iterable<? extends GenericIngredient> entities);

    @Override
    void deleteAll();
}
