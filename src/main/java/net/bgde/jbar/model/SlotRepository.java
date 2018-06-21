package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends CrudRepository<Slot, Long>{
    Iterable<Slot> findAll();

    Iterable<Slot> findAllByPositon(String positon);

    Iterable<Slot> findAllByInstalledDrink(ConcreteIngredient InstalledDrink);

}
