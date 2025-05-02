package com.example.Model.Item;

public class Ingredients extends  Item{
    com.example.Model.Enums.Ingredients ingredient;
    public Ingredients(int count, String quality , com.example.Model.Enums.Ingredients ingredient ) {
        super(count, quality);
        this.ingredient = ingredient;
    }
}
