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

    @Deprecated
    private ConcreteIngredient() {
        super();
    }

    public ConcreteIngredient(String name, List<GenericIngredient> type){
        super(name);
        this.type = type;
    }

    public List<GenericIngredient> getType() {
        return type;
    }

    public void setType(List<GenericIngredient> type) {
        this.type = type;
    }
}
