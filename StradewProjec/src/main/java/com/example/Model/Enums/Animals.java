package com.example.Model.Enums;

public enum Animals {
    Chicken(800),
    Duck(1200),
    Rabbit(8000),
    Dinosaur(14000),
    Cow(1500),
    Goat(4000),
    Sheep(8000),
    Pig(16000);
    public final int Price;

    Animals(int price) {
        Price = price;
    }
}
