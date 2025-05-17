package com.example.Model.Enums;

public enum CarpenterShopItems {
    Wood("Wood" , -1 , 10),
    Stone("Stone" , -1 , 20),
    Barn("Barn" , 0 , 6000),
    Big_Barn("Big Barn" , 1 , 12000),
    Deluxe_Barn("Deluxe Barn" , 2 , 25000),
    Coop("Coop" , 3 , 4000),
    Big_Coop("Big Coop" , 4 , 10000),
    Deluxe_Coop("Deluxe Coop" , 5 , 20000),
    Well("Well" , 6 , 8000),
    Shipping_Bin("Shipping Bin" , -1 , 250),

    ;
    public final String name;
    public final int limitIndex;
    public final int Price;

    CarpenterShopItems(String name, int limitIndex, int price) {
        this.name = name;
        this.limitIndex = limitIndex;
        Price = price;
    }
}
