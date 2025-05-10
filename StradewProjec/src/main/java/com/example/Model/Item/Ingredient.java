package com.example.Model.Item;

import com.example.Model.Enums.Ingredients;
import com.example.Model.Enums.NonPlantingIngredients;
import com.example.Model.Enums.Quality;

public class Ingredient extends  Item{
    private Ingredients ingredient;
    private NonPlantingIngredients nonPlantingIngredients;
    private Quality quality;
    public Ingredient(int count , Ingredients ingredient ) {
        super(count, null);
        if (ingredient != null){
            this.setName(ingredient.toString());
        }
        this.ingredient = ingredient;
    }

    public Ingredients getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredients ingredient) {
        this.ingredient = ingredient;
        this.name = ingredient.toString();
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public NonPlantingIngredients getNonPlantingIngredients() {
        return nonPlantingIngredients;
    }

    public void setNonPlantingIngredients(NonPlantingIngredients nonPlantingIngredients) {
        this.nonPlantingIngredients = nonPlantingIngredients;
        this.setName(nonPlantingIngredients.toString());
    }

    @Override
    public Ingredient getCopy(){
        return new Ingredient(count, ingredient);
    }
}
