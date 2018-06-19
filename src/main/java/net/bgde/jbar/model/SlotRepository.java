package net.bgde.jbar.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends CrudRepository<Slot, Long>{
    Interable<Slot> findAll();

    Interable<Slot> findAllByPositon(String positon);

    Interable<Slot> findAllByInstalledDrink(InstallableDrink InstalledDrink);

}
