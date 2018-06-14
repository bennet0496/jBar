package net.bgde.jbar.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DrinkType {
    @Id
    private String name;

    public DrinkType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
