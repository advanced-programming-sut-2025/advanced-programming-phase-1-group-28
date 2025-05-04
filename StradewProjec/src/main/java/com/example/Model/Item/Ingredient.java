package com.example.Model.Item;

import com.example.Model.Enums.Ingredients;

public class Ingredient extends  Item{
    private Ingredients ingredient;
    private String quality;
    public Ingredient(int count , Ingredients ingredient ) {
        super(count, ingredient.toString());
        this.ingredient = ingredient;
    }

    public Ingredients getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredients ingredient) {
        this.ingredient = ingredient;
        this.name = ingredient.toString();
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public Ingredient getCopy(){
        return new Ingredient(count, ingredient);
    }
}
