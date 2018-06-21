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
    private ConcreteIngredient InstalledDrink;

    public Slot(String positon, ConcreteIngredient installedDrink) {
        this.positon = positon;
        InstalledDrink = installedDrink;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    public ConcreteIngredient getInstalledDrink() {
        return InstalledDrink;
    }

    public void setInstalledDrink(ConcreteIngredient installedDrink) {
        InstalledDrink = installedDrink;
    }
}
