package net.bgde.jbar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Slot {
    @Id
    @GeneratedValue
    private Long id;
    private Sting positon;
    private InstallableDrink InstalledDrink;

    public Slot(Sting positon, InstallableDrink installedDrink) {
        this.positon = positon;
        InstalledDrink = installedDrink;
    }

    public Sting getPositon() {
        return positon;
    }

    public void setPositon(Sting positon) {
        this.positon = positon;
    }

    public InstallableDrink getInstalledDrink() {
        return InstalledDrink;
    }

    public void setInstalledDrink(InstallableDrink installedDrink) {
        InstalledDrink = installedDrink;
    }
}
