package net.bgde.jbar.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Cocktail {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String path;

    @OneToMany
    private List<CocktailIngredient> ingredients;

    @Deprecated
    private Cocktail() {
    }

    public Cocktail(String name, String path, List<CocktailIngredient> ingredients) {
        this.name = name;
        this.path = path;
        this.ingredients = ingredients;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<CocktailIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<CocktailIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
