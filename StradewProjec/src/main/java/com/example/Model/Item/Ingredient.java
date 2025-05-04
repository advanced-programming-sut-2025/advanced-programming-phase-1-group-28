package com.example.Model.Item;

import com.example.Model.Enums.Ingredients;

public class Ingredient extends  Item{
    private Ingredients ingredient;
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

    @Override
    public Ingredient getCopy(){
        return new Ingredient(count, ingredient);
    }
}
