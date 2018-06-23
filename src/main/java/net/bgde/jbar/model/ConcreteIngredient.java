package net.bgde.jbar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class ConcreteIngredient extends Ingredient {

    @ManyToMany
    private List<GenericIngredient> type;

    private Float fillLevel;

    protected String imagePath;

    @Deprecated
    private ConcreteIngredient() {
        super();
    }

    public ConcreteIngredient(String name, List<GenericIngredient> type, String imagePath){
        super(name);
        this.type = type;
        this.imagePath = imagePath;
        fillLevel = 1.0F;
    }

    public List<GenericIngredient> getType() {
        return type;
    }

    public void setType(List<GenericIngredient> type) {
        this.type = type;
    }

    public Float getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(Float fillLevel) {
        this.fillLevel = fillLevel;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
