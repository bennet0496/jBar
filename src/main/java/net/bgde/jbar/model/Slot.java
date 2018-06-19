package net.bgde.jbar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Slot {
    @Id
    @GeneratedValue
    private Long id;
    private String positon;
    private InstallableDrink InstalledDrink;

    public Slot(String positon, InstallableDrink installedDrink) {
        this.positon = positon;
        InstalledDrink = installedDrink;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    public InstallableDrink getInstalledDrink() {
        return InstalledDrink;
    }

    public void setInstalledDrink(InstallableDrink installedDrink) {
        InstalledDrink = installedDrink;
    }
}
