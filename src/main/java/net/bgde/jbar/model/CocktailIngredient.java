package net.bgde.jbar.model;

import javax.persistence.*;

@Entity
public class CocktailIngredient {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Ingredient ingredient;
    private Integer amount;

    public CocktailIngredient(Ingredient ingredient, Integer amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    @Deprecated
    private CocktailIngredient() {
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
