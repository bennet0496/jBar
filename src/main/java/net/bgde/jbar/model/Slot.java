package net.bgde.jbar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Slot {
    @Id
    @GeneratedValue
    private Long id;
    private String positon;
    @OneToOne
    private ConcreteIngredient installedDrink;

    @Deprecated
    private Slot(){}

    public Slot(String positon, ConcreteIngredient installedDrink) {
        this.positon = positon;
        this.installedDrink = installedDrink;
    }

    public Long getId() {
        return id;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    public ConcreteIngredient getInstalledDrink() {
        return installedDrink;
    }

    public void setInstalledDrink(ConcreteIngredient installedDrink) {
        this.installedDrink = installedDrink;
    }
}
