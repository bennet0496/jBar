package net.bgde.jbar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Ingredient {
    @Id
    @GeneratedValue
    protected Long id;

    protected String name;



    @Deprecated
    protected Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
