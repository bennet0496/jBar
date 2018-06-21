package net.bgde.jbar.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GenericIngredient extends Ingredient {
    public GenericIngredient(String name){
        super(name);
    }
}
