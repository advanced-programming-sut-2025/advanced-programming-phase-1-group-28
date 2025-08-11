package com.Stradew.Model.Enums;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public enum Animals {
    Chicken(800 , new ArrayList<>(List.of(Ingredients.Egg , Ingredients.LargeEgg)), "Animals/Blue_Chicken.png"),
    Duck(1200 , new ArrayList<>(List.of(Ingredients.DuckEgg , Ingredients.DuckFeather)), "Animals/Duck.png"),
    Rabbit(8000 , new ArrayList<>(List.of(Ingredients.RabbitLeg , Ingredients.RabbitWool)), "Animals/Rabbit.png"),
    Dinosaur(14000 , new ArrayList<>(List.of(Ingredients.DinosaurEgg)), "Animals/Dinosaur.png"),
    Cow(1500 , new ArrayList<>(List.of(Ingredients.CowMilk , Ingredients.LargeCowMilk)), "Animals/Brown_Cow.png"),
    Goat(4000 , new ArrayList<>(List.of(Ingredients.GoatMilk , Ingredients.LargeGoatMilk)), "Animals/Goat.png"),
    Sheep(8000 , new ArrayList<>(List.of(Ingredients.SheepCotton)), "Animals/Sheep.png"),
    Pig(16000 , new ArrayList<>(List.of(Ingredients.Truffle)), "Animals/Pig.png");
    public final int Price;
    public final ArrayList<Ingredients> Products;
    public final Texture texture;

    Animals(int price, ArrayList<Ingredients> products, String texture) {
        Price = price;
        Products = products;
        this.texture = new Texture(texture);
    }
}
