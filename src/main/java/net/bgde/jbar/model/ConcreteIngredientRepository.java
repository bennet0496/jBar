package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConcreteIngredientRepository extends CrudRepository<ConcreteIngredient, Long> {
    Iterable<ConcreteIngredient> findAllByName(String name);

    Iterable<ConcreteIngredient> findAllByType(GenericIngredient type);

    @Override
    <S extends ConcreteIngredient> S save(S entity);

    @Override
    <S extends ConcreteIngredient> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<ConcreteIngredient> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<ConcreteIngredient> findAll();

    @Override
    Iterable<ConcreteIngredient> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(ConcreteIngredient entity);

    @Override
    void deleteAll(Iterable<? extends ConcreteIngredient> entities);

    @Override
    void deleteAll();
}
