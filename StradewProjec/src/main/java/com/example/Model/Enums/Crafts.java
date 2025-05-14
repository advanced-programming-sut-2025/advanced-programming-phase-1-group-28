package com.example.Model.Enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum Crafts {
    CherryBomb("Cherry Bomb" , new ArrayList<>(Arrays.asList("Copper Ore" , "Coal")) , new ArrayList<>(Arrays.asList(4 , 1)) , Skills.Mining , 1 , 50),
    Bomb("Bomb" , new ArrayList<>(Arrays.asList("Iron Ore" ,"Coal" )) ,new ArrayList<>(Arrays.asList(4 , 1)) , Skills.Mining , 2 , 50),
    MegaBomb("Mega Bomb" , new ArrayList<>(Arrays.asList("Gold Ore" ,"Coal")) ,new ArrayList<>(Arrays.asList(4 , 1)) , Skills.Mining , 3  , 50),
    Sprinkler("Sprinkler" , new ArrayList<>(Arrays.asList("Copper Bar" , "Iron Bar")) ,new ArrayList<>(Arrays.asList(1 , 1)) , Skills.Farming , 1 , 0),
    QualitySprinkler("Quality Sprinkler" , new ArrayList<>(Arrays.asList("Iron Bar" , "Gold Bar")) , new ArrayList<>(Arrays.asList(1 , 1)) ,Skills.Farming , 2 , 0),
    IridiumSprinkler("Iridium Sprinkler" , new ArrayList<>(Arrays.asList("Gold Bar" , "Iridium Bar")) , new ArrayList<>(Arrays.asList(1 , 1)) ,Skills.Farming , 3 , 0),
    CharcoalKlin("Charcoa Klin" , new ArrayList<>(Arrays.asList("Wood" , "Copper Bar")), new ArrayList<>(Arrays.asList(20 , 2)) , Skills.Foraging , 1 , 0),
    Furnace("Furnace" , new ArrayList<>(Arrays.asList("Copper Ore" , "Stone")) , new ArrayList<>(Arrays.asList(20 , 25)) , null , 0 , 0),
    Scarecrow("Scarecrow" , new ArrayList<>(Arrays.asList("Wood" , "Coal" , "Fiber")) ,new ArrayList<>(Arrays.asList(50 , 1 , 20)) , null , 0 , 0),
    DeluxeScarecrow("Delux Scarecrow" ,new ArrayList<>(Arrays.asList("Wood" , "Coal" , "Fiber" , "Iridium Ore")) , new ArrayList<>(Arrays.asList(50 , 1 , 20 , 1)) , Skills.Farming , 2 , 0),
    BeeHouse("Bee House", new ArrayList<>(Arrays.asList("Wood" , "Coal" , "Iron Bar")) , new ArrayList<>(Arrays.asList(40 , 8 , 1)) , Skills.Farming , 1  , 0),
    CheesePress("Cheese Press" , new ArrayList<>(Arrays.asList("Wood" , "Stone" , "Copper Bar")) , new ArrayList<>(Arrays.asList(45 , 45 , 1)) , Skills.Farming , 2 , 0),
    Keg("Keg" , new ArrayList<>(Arrays.asList("Wood" , "Copper Bar", "Iron Bar")) , new ArrayList<>(Arrays.asList(30  ,1 , 1)) , Skills.Farming , 3 , 0),
    Loom("Loom", new ArrayList<>(Arrays.asList("Wood" , "Fiber")) ,new ArrayList<>(Arrays.asList(60 , 30)) , Skills.Farming , 3 , 0),
    MayonnaiseMachine("Mayonnaise Machine" , new ArrayList<>(Arrays.asList("Wood" , "Stone" , "Coopper Bar")) , new ArrayList<>(Arrays.asList(15 , 15 , 1)) , null , 0 , 0),
    OilMaker("Oil Maker" , new ArrayList<>(Arrays.asList("Wood" , "Gold Bar" , "Iron Bar")) ,new ArrayList<>(Arrays.asList(100 , 1 , 1)) , Skills.Farming , 3 , 0),
    PreservesJar("Preserves Jar" , new ArrayList<>(Arrays.asList("Wood" , "Stone" , "Coal")) ,new ArrayList<>(Arrays.asList(50 , 40 , 8)) , Skills.Farming , 2 , 0),
    Dehydrator("Dehydrator" , new ArrayList<>(Arrays.asList("Wood" , "Stone" , "Fiber")) , new ArrayList<>(Arrays.asList(30 , 20 , 30)) , null , 0 , 0),
    GrassStarter("Grass Starter" , new ArrayList<>(Arrays.asList("Wood" , "Fiber")) , new ArrayList<>(Arrays.asList(1  , 1)) , null , 0 ,  0),
    FishSmoker("Fish Smoker" , new ArrayList<>(Arrays.asList("Wood" , "Iron Bar" , "Coal")) , new ArrayList<>(Arrays.asList(50 , 3 , 10)) ,null , 0  , 0),
    //MysticTreeSeed(new ArrayList<>(Arrays.asList("")) ,),
    // in Shop
    SpeedGro("SpeedGro" , new ArrayList<>(Arrays.asList()), new ArrayList<>(Arrays.asList()) , null ,  0 ,  0);
    public final String Name;
    public final ArrayList<String> Ingredients;
    public final ArrayList<Integer> Count;
    public final Skills skill;
    public final int level;
    public final int SellPrice;

    Crafts(String Name , ArrayList<String> ingredients , ArrayList<Integer> Count, Skills skill, int level, int sellPrice) {
        this.Name = Name;
        this.Count = Count;
        Ingredients = ingredients;
        this.skill = skill;
        this.level = level;
        SellPrice = sellPrice;
    }
}
