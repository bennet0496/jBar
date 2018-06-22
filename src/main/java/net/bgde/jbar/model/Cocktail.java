package net.bgde.jbar.model;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Cocktail {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String path;

    @ManyToMany
    @JoinTable(
            name = "CocktailIngredient",
            joinColumns = {@JoinColumn(name = "ingredient_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "cocktail_id", referencedColumnName = "id")}
    )
    @MapKeyJoinColumn(name = "id")
    private Map<Ingredient, Integer> ingredients;

    @Deprecated
    private Cocktail() {
    }

    public Cocktail(String name, String path, Map<Ingredient, Integer> ingredients) {
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

    public Map<Ingredient, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Ingredient, Integer> ingredients) {
        this.ingredients = ingredients;
    }
}
