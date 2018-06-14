package net.bgde.jbar.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class InstallableDrink {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private DrinkType type;

    public InstallableDrink(String name, DrinkType type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DrinkType getType() {
        return type;
    }

    public void setType(DrinkType type) {
        this.type = type;
    }
}
