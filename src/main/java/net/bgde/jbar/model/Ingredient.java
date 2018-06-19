package net.bgde.jbar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int  amount;
    private DrinkType type;

    public InstallableDrink(String name, int amount, DrinkType type){
        this.name = name;
        this.amount = amoount;
        this.type = type;
    }

    public DrinkType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setType(DrinkType type) {
        this.type = type;
    }
}
