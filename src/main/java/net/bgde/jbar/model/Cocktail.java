package net.bgde.jbar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Map;

@Entity
public class Cocktail {
    @Id
    @GeneratedValue

    private Long id;
    private String name;
    private String path;
    private Map<InstallableDrink, Integer> ingredients;

    public Cocktail(String name, String path, Map<InstallableDrink, Integer> ingredients) {
        this.name = name;
        this.path = path;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<InstallableDrink, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<InstallableDrink, Integer> ingredients) {
        this.ingredients = ingredients;
    }
}
