package com.example.Model.Enums;

import com.example.Model.Item.*;

import java.util.ArrayList;
import java.util.Arrays;

public enum NPC {
    Sebastian("Sebastian" , "Singer" , new ArrayList<String>(Arrays.asList("City of Stars")),
            new ArrayList<Item>(Arrays.asList(new Food(1 , Foods.Pizza) , new Food(1 , Foods.PumpkinPie) , new Ingredient(1 , Ingredients.SheepCotton) , new Ingredient(1 , Ingredients.RabbitWool))) ,
            new ArrayList<Item>(Arrays.asList(new Item(50 , "Iron Bar") , new Food(1 , Foods.PumpkinPie) , new Item(150 , "Stone"))) ,
            new ArrayList<Item>(Arrays.asList(new MineralItem(1 , Minerals.Diamond) , new Item(5000 , "Gold Coin") , new MineralItem(50 , Minerals.Quartz)))),
    Abigail("Abigail" , "Astronaut" , new ArrayList<String>(Arrays.asList("Abigail is GONE!")),
            new ArrayList<Item>(Arrays.asList(new Item(1 , "Stone") , new MineralItem(1 , Minerals.Iron) , new Food(1 , Foods.TripleShotEspresso))) ,
            new ArrayList<Item>(Arrays.asList(new Item(1 , "Gold Bar") , new PlantsItem(1 , Plants.PUMPKIN) , new PlantsItem(50 , Plants.WHEAT))),
            new ArrayList<Item>(Arrays.asList(new Item(1 , "FriendShip") , new Item(500 , "Gold Coin") , new Item(1 , "Automatic Iridium Watering Can")))),
    Harvy("Harvy" , "Prosecutor" , new ArrayList<String>(Arrays.asList("You either die a hero or you live long enough to see yourself become the villain")),
            new ArrayList<Item>(Arrays.asList(new Food(1 , Foods.TripleShotEspresso) , new Food(1 , Foods.AppleWine) , new Food(1 , Foods.PotatoPickle))),
            new ArrayList<Item>(Arrays.asList(new Item(12 , "Plant") , new FishItem(1 , Fishes.SALMON) , new Item(1 , "Wine"))),
            new ArrayList<Item>(Arrays.asList(new Item(750 , "Gold Coin") , new Item(1 , "Friendship") , new Food(5 , Foods.Salad)))),
    Leia("Leia" , "Princess of Alderan" , new ArrayList<>(Arrays.asList("I know")),
            new ArrayList<Item>(Arrays.asList(new Food(1 , Foods.Salad) , new PlantsItem(1 , Plants.GRAPE) , new Food(1 , Foods.GrapeWine))),
            new ArrayList<Item>(Arrays.asList(new Item(10 , "Wood") , new FishItem(1, Fishes.SALMON) , new Item(200 , "Wood"))),
            new ArrayList<Item>(Arrays.asList(new Item(500 , "Gold Coin") , new Item(1 , "Dinner Salmon Recipe") , new Craft(3, Crafts.DeluxeScarecrow)))),
    Robin("Robin" , "Journalist" , new ArrayList<>(Arrays.asList("Everybody come and play")),
            new ArrayList<Item>(Arrays.asList(new Food(1 , Foods.Spaghetti) , new Item(1 , "Wood") , new Item(1 , "Iron Bar"))),
            new ArrayList<Item>(Arrays.asList(new Item(80 , "Wood") , new Item(10 , "Iron Bar") , new Item(1000 , "Wood"))),
            new ArrayList<Item>(Arrays.asList(new Item(1000 , "Gold Coin") , new Item(1 , "Bee House") , new Item(25000 , "Gold Coin"))));
    public final String name;
    public final String Job;
    public final ArrayList<String> Dialogs;
    public final ArrayList<Item> FavoriteItems;
    public final ArrayList<Item> GivenItems;
    public final ArrayList<Item> TakenItems;
    //public final ArrayList<Quest> Quests;
    NPC(String name, String job, ArrayList<String> dialogs, ArrayList<Item> favoriteItems, ArrayList<Item> givenItems, ArrayList<Item> takenItems) {
        this.name = name;
        Job = job;
        Dialogs = dialogs;
        FavoriteItems = favoriteItems;
        GivenItems = givenItems;
        TakenItems = takenItems;
    }
}
