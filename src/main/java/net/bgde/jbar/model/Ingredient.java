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
    private DrinkType type;

    public Ingredient(String name, DrinkType type) {
        this.name = name;
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

    public void setType(DrinkType type) {
        this.type = type;
    }
}
