package com.example.Model.Item;

public class Ingredients extends  Item{
    private com.example.Model.Enums.Ingredients ingredient;
    private String quality;
    public Ingredients(int count, String quality , com.example.Model.Enums.Ingredients ingredient ) {
        super(count, ingredient.toString());
        this.ingredient = ingredient;
        this.quality = quality;
    }

    public com.example.Model.Enums.Ingredients getIngredient() {
        return ingredient;
    }

    public void setIngredient(com.example.Model.Enums.Ingredients ingredient) {
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
    public Ingredients getCopy(){
        return new Ingredients(count, quality, ingredient);
    }
}
