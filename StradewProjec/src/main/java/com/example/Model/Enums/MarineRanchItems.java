package com.example.Model.Enums;

public enum MarineRanchItems {
    Hay("Hay" , -1 , 50),
    Milk_Pail("Milk Pail" , 0 , 1000),
    Shears("Shears" , 1 , 1000),
    Chicken("Chicken" , 2 , 800),
    Duck("Duck" , 5 , 1200),
    Rabbit("Rabbit" , 7 , 8000),
    Dinosaur("Dinosaur" , 8 , 14000),
    Cow("Cow" , 3 , 1500),
    Goat("Goat" , 4 , 4000),
    Sheep("Sheep" , 6 , 8000),
    Pig("Pig" , 9 , 16000);

    public final String name;
    public final int limitIndex;
    public final int Price;

    MarineRanchItems(String name, int limitIndex, int price) {
        this.name = name;
        this.limitIndex = limitIndex;
        Price = price;
    }
}
