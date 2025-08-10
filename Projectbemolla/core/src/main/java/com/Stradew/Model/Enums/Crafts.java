package com.Stradew.Model.Enums;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Arrays;

public enum Crafts {
    CherryBomb("Cherry Bomb" , new ArrayList<>(Arrays.asList("Copper Ore" , "Coal")) , new ArrayList<>(Arrays.asList(4 , 1)) , Skills.Mining , 1 , 50 , new Texture(Gdx.files.internal("Crafting/Cherry_Bomb.png"))),
    Bomb("Bomb" , new ArrayList<>(Arrays.asList("Iron Ore" ,"Coal" )) ,new ArrayList<>(Arrays.asList(4 , 1)) , Skills.Mining , 2 , 50 , new Texture(Gdx.files.internal("Crafting/Bomb.png"))),
    MegaBomb("Mega Bomb" , new ArrayList<>(Arrays.asList("Gold Ore" ,"Coal")) ,new ArrayList<>(Arrays.asList(4 , 1)) , Skills.Mining , 3  , 50 , new Texture(Gdx.files.internal("Crafting/Mega_Bomb.png"))),
    Sprinkler("Sprinkler" , new ArrayList<>(Arrays.asList("Copper Bar" , "Iron Bar")) ,new ArrayList<>(Arrays.asList(1 , 1)) , Skills.Farming , 1 , 0 ,  new Texture(Gdx.files.internal("Crafting/Sprinkler.png"))),
    QualitySprinkler("Quality Sprinkler" , new ArrayList<>(Arrays.asList("Iron Bar" , "Gold Bar")) , new ArrayList<>(Arrays.asList(1 , 1)) ,Skills.Farming , 2 , 0 , new Texture(Gdx.files.internal("Crafting/Quality_Sprinkler.png"))),
    IridiumSprinkler("Iridium Sprinkler" , new ArrayList<>(Arrays.asList("Gold Bar" , "Iridium Bar")) , new ArrayList<>(Arrays.asList(1 , 1)) ,Skills.Farming , 3 , 0 , new Texture(Gdx.files.internal("Crafting/Iridium_Sprinkler.png"))),
    CharcoalKlin("Charcoa Klin" , new ArrayList<>(Arrays.asList("Wood" , "Copper Bar")), new ArrayList<>(Arrays.asList(20 , 2)) , Skills.Foraging , 1 , 0 , new Texture(Gdx.files.internal("Crafting/Charcoal_Kiln.png"))),
    Furnace("Furnace" , new ArrayList<>(Arrays.asList("Copper Ore" , "Stone")) , new ArrayList<>(Arrays.asList(20 , 25)) , null , 0 , 0 , new Texture(Gdx.files.internal("Crafting/Furnace.png"))),
    Scarecrow("Scarecrow" , new ArrayList<>(Arrays.asList("Wood" , "Coal" , "Fiber")) ,new ArrayList<>(Arrays.asList(50 , 1 , 20)) , null , 0 , 0 , new Texture(Gdx.files.internal("Crafting/Scarecrow.png"))),
    DeluxeScarecrow("Delux Scarecrow" ,new ArrayList<>(Arrays.asList("Wood" , "Coal" , "Fiber" , "Iridium Ore")) , new ArrayList<>(Arrays.asList(50 , 1 , 20 , 1)) , Skills.Farming , 2 , 0 , new Texture(Gdx.files.internal("Crafting/Deluxe_Scarecrow.png"))),
    BeeHouse("Bee House", new ArrayList<>(Arrays.asList("Wood" , "Coal" , "Iron Bar")) , new ArrayList<>(Arrays.asList(40 , 8 , 1)) , Skills.Farming , 1  , 0 , new Texture(Gdx.files.internal("Crafting/Bee_House.png"))),
    CheesePress("Cheese Press" , new ArrayList<>(Arrays.asList("Wood" , "Stone" , "Copper Bar")) , new ArrayList<>(Arrays.asList(45 , 45 , 1)) , Skills.Farming , 2 , 0 , new Texture(Gdx.files.internal("Crafting/Cheese_Press.png"))),
    Keg("Keg" , new ArrayList<>(Arrays.asList("Wood" , "Copper Bar", "Iron Bar")) , new ArrayList<>(Arrays.asList(30  ,1 , 1)) , Skills.Farming , 3 , 0 , new Texture(Gdx.files.internal("Crafting/Keg.png"))),
    Loom("Loom", new ArrayList<>(Arrays.asList("Wood" , "Fiber")) ,new ArrayList<>(Arrays.asList(60 , 30)) , Skills.Farming , 3 , 0 , new Texture(Gdx.files.internal("Crafting/Loom.png"))),
    MayonnaiseMachine("Mayonnaise Machine" , new ArrayList<>(Arrays.asList("Wood" , "Stone" , "Coopper Bar")) , new ArrayList<>(Arrays.asList(15 , 15 , 1)) , null , 0 , 0 , new Texture(Gdx.files.internal("Crafting/Mayonnaise_Machine.png"))),
    OilMaker("Oil Maker" , new ArrayList<>(Arrays.asList("Wood" , "Gold Bar" , "Iron Bar")) ,new ArrayList<>(Arrays.asList(100 , 1 , 1)) , Skills.Farming , 3 , 0 , new Texture(Gdx.files.internal("Crafting/Oil_Maker.png"))),
    PreservesJar("Preserves Jar" , new ArrayList<>(Arrays.asList("Wood" , "Stone" , "Coal")) ,new ArrayList<>(Arrays.asList(50 , 40 , 8)) , Skills.Farming , 2 , 0 , new Texture(Gdx.files.internal("Crafting/Cherry_Bomb.png"))),
    Dehydrator("Dehydrator" , new ArrayList<>(Arrays.asList("Wood" , "Stone" , "Fiber")) , new ArrayList<>(Arrays.asList(30 , 20 , 30)) , null , 0 , 0 , new Texture(Gdx.files.internal("Crafting/Cherry_Bomb.png"))),
    GrassStarter("Grass Starter" , new ArrayList<>(Arrays.asList("Wood" , "Fiber")) , new ArrayList<>(Arrays.asList(1  , 1)) , null , 0 ,  0 , new Texture(Gdx.files.internal("Crafting/Cherry_Bomb.png"))),
    FishSmoker("Fish Smoker" , new ArrayList<>(Arrays.asList("Wood" , "Iron Bar" , "Coal")) , new ArrayList<>(Arrays.asList(50 , 3 , 10)) ,null , 0  , 0 , new Texture(Gdx.files.internal("Crafting/Cherry_Bomb.png"))),
    //MysticTreeSeed(new ArrayList<>(Arrays.asList("")) ,),
    // in Shop
    SpeedGro("SpeedGro" , new ArrayList<>(Arrays.asList()), new ArrayList<>(Arrays.asList()) , null ,  0 ,  0 , null);
    public final String Name;
    public final ArrayList<String> Ingredients;
    public final ArrayList<Integer> Count;
    public final Skills skill;
    public final int level;
    public final int SellPrice;
    public final Texture Craftimage;


    Crafts(String Name , ArrayList<String> ingredients , ArrayList<Integer> Count, Skills skill, int level, int sellPrice , Texture Craftimage ) {
        this.Name = Name;
        this.Count = Count;
        Ingredients = ingredients;
        this.skill = skill;
        this.level = level;
        SellPrice = sellPrice;
        this.Craftimage = Craftimage;
    }
}
