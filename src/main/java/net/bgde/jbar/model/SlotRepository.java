package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SlotRepository extends CrudRepository<Slot, Long>{
    Iterable<Slot> findAllByPositon(String positon);

    Slot findByInstalledDrink(ConcreteIngredient installedDrink);

    @Override
    <S extends Slot> S save(S entity);

    @Override
    <S extends Slot> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Slot> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<Slot> findAll();

    @Override
    Iterable<Slot> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Slot entity);

    @Override
    void deleteAll(Iterable<? extends Slot> entities);

    @Override
    void deleteAll();
}
