package com.example.Model.Enums;

import java.util.ArrayList;
import java.util.List;

public enum Animals {
    Chicken(800 , new ArrayList<>(List.of(Ingredients.Egg , Ingredients.LargeEgg))),
    Duck(1200 , new ArrayList<>(List.of(Ingredients.DuckEgg , Ingredients.DuckFeather))),
    Rabbit(8000 , new ArrayList<>(List.of(Ingredients.RabbitLeg , Ingredients.RabbitWool))),
    Dinosaur(14000 , new ArrayList<>(List.of(Ingredients.DinosaurEgg))),
    Cow(1500 , new ArrayList<>(List.of(Ingredients.CowMilk , Ingredients.LargeCowMilk))),
    Goat(4000 , new ArrayList<>(List.of(Ingredients.GoatMilk , Ingredients.LargeGoatMilk))),
    Sheep(8000 , new ArrayList<>(List.of(Ingredients.SheepCotton))),
    Pig(16000 , new ArrayList<>(List.of(Ingredients.Truffle)));
    public final int Price;
    public final ArrayList<Ingredients> Products;

    Animals(int price, ArrayList<Ingredients> products) {
        Price = price;
        Products = products;
    }
}
