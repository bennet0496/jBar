package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CocktailRepository extends CrudRepository<Cocktail, Long> {
    Iterable<Cocktail> findAllByNameIgnoreCaseContains(String name);

    @Override
    <S extends Cocktail> S save(S entity);

    @Override
    <S extends Cocktail> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Cocktail> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<Cocktail> findAll();

    @Override
    Iterable<Cocktail> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Cocktail entity);

    @Override
    void deleteAll(Iterable<? extends Cocktail> entities);

    @Override
    void deleteAll();
}
