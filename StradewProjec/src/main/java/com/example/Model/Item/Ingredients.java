package com.example.Model.Item;

public class Ingredients extends  Item{
    private com.example.Model.Enums.Ingredients ingredient;
    public Ingredients(int count, String quality , com.example.Model.Enums.Ingredients ingredient ) {
        super(count, quality);
        this.ingredient = ingredient;
        this.name = ingredient.toString();
    }

    public com.example.Model.Enums.Ingredients getIngredient() {
        return ingredient;
    }

    public void setIngredient(com.example.Model.Enums.Ingredients ingredient) {
        this.ingredient = ingredient;
        this.name = ingredient.toString();
    }
}
