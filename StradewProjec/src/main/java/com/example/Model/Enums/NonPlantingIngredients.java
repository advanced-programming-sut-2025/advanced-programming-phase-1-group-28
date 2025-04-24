package com.example.Model.Enums;

public enum NonPlantingIngredients {
    egg("mamad" , 1);
    public final String Name;
    public final int SellPrice;

    NonPlantingIngredients(String Name ,int sellPrice) {
        this.Name = Name;
        SellPrice = sellPrice;
    }
}
