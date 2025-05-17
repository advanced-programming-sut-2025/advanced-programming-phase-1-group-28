package com.example.Model.Enums;

public enum FishShopItems {
    FISH_SMOKER_RECIPE("FISH_SMOKER_RECIPE" , 0 , 10000),
    TROUT_SOUP("TROUT_SOUP" , 1 , 250),
    TRAINING_ROD("TRAINING_ROD" , 2 , 25),
    BAMBOO_POLE("BAMBOO_POLE" , 3 , 500),
    FIBERGLASS_ROD("FIBERGLASS_ROD" , 4 , 1800),
    IRIDIUM_ROD("IRIDIUM_ROD" , 5 , 7500)

    ;
    public final String name;
    public final int limitIndex;
    public final int price;

    FishShopItems(String name, int limitIndex, int price) {
        this.name = name;
        this.limitIndex = limitIndex;
        this.price = price;
    }
}
