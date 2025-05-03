package com.example.Model.Enums;

import java.util.ArrayList;

public enum Plants {
    BLUE_JAZZ("Jazz Seeds", "1-2-2-2", 7, true, 0, 50, true, 45, "Spring", false),
    CARROT("Carrot Seeds", "1-1-1", 3, true, 0, 35, true, 75, "Spring", false),
    CAULIFLOWER("Cauliflower Seeds", "1-2-4-4-1", 12, true, 0, 175, true, 75, "Spring", true),
    COFFEE_BEAN("Coffee Bean", "1-2-2-3-2", 10, false, 2, 15, false, 0, "Spring & Summer", false),
    GARLIC("Garlic Seeds", "1-2-2-2", 4, true, 0, 60, true, 20, "Spring", false),
    GREEN_BEAN("Bean Starter", "1-1-1-3-4", 10, false, 3, 40, true, 25, "Spring", false),
    KALE("Kale Seeds", "1-2-2-1", 6, true, 0, 110, true, 50, "Spring", false),
    PARSNIP("Parsnip Seeds", "1-1-2", 4, true, 0, 35, true, 25, "Spring", false),
    POTATO("Potato Seeds", "1-1-1-2-1", 6, true, 0, 80, true, 25, "Spring", false),
    RHUBARB("Rhubarb Seeds", "2-2-2-3-4", 13, true, 0, 220, false, 0, "Spring", false),
    STRAWBERRY("Strawberry Seeds", "1-1-2-2", 8, false, 4, 120, true, 50, "Spring", false),
    TULIP("Tulip Bulb", "1-1-2", 6, true, 0, 30, true, 45, "Spring", false),
    UNMILLED_RICE("Rice Shoot", "1-2-2-3", 6, true, 0, 30, true, 3, "Spring", false),
    BLUEBERRY("Blueberry Seeds", "1-3-3-4-2", 13, false, 4, 50, true, 25, "Summer", false),
    CORN("Corn Seeds", "2-3-3-3-3", 14, false, 4, 50, true, 25, "Summer & Fall", false),
    HOPS("Hops Starter", "1-1-2-3-4", 11, false, 1, 25, true, 20, "Summer", false),
    HOT_PEPPER("Pepper Seeds", "1-2-2-2-2", 8, false, 3, 40, true, 25, "Summer", false),
    MELON("Melon Seeds", "1-2-3-3-3", 12, true, 0, 250, true, 113, "Summer", true),
    POPPY("Poppy Seeds", "1-2-2", 7, true, 0, 140, true, 45, "Summer", false),
    RADISH("Radish Seeds", "2-1-2-1", 6, true, 0, 90, true, 45, "Summer", false),
    RED_CABBAGE("Red Cabbage Seeds", "1-1-2-2-2", 9, true, 0, 260, true, 75, "Summer", false),
    STARFRUIT("Starfruit Seeds", "2-2-3-3-3", 13, true, 0, 750, true, 125, "Summer", false),
    SUMMER_SPANGLE("Spangle Seeds", "1-2-3-1", 8, true, 0, 90, true, 45, "Summer", false),
    SUMMER_SQUASH("Summer Squash Seeds", "1-1-1-2-1", 6, false, 3, 45, true, 63, "Summer", false),
    SUNFLOWER("Sunflower Seeds", "1-2-3-2", 8, true, 0, 80, true, 45, "Summer & Fall", false),
    TOMATO("Tomato Seeds", "1-2-2-1-2", 11, false, 4, 60, true, 20, "Summer", false),
    WHEAT("Wheat Seeds", "1-1-1", 4, true, 0, 25, false, 0, "Summer & Fall", false),
    AMARANTH("Amaranth Seeds", "1-2-2-2", 7, true, 0, 150, true, 50, "Fall", false),
    ARTICHOKE("Artichoke Seeds", "1-2-3-4", 8, true, 0, 160, true, 30, "Fall", false),
    BEET("Beet Seeds", "1-1-2", 6, true, 0, 100, true, 30, "Fall", false),
    BOK_CHOY("Bok Choy Seeds", "1-1-2", 4, true, 0, 80, true, 25, "Fall", false),
    BROCCOLI("Broccoli Seeds", "2-2-1-2", 7, true, 0, 70, true, 63, "Fall", false),
    CRANBERRIES("Cranberry Seeds", "1-1-2-3", 10, false, 5, 75, true, 38, "Fall", false),
    EGGPLANT("Eggplant Seeds", "1-1-1-1", 5, false, 5, 60, true, 20, "Fall", false),
    FAIRY_ROSE("Fairy Seeds", "2-2-3-2", 12, true, 0, 290, true, 45, "Fall", false),
    GRAPE("Grape Starter", "1-2-3-3", 10, false, 3, 80, true, 38, "Fall", false),
    PUMPKIN("Pumpkin Seeds", "1-2-3-4-3", 13 , true , 0 , 320 , false , 0 , "Fall", true),
    YAM("Yam Seeds" , "1-3-3-3" , 10 , true , 0 , 160 , true , 45 , "Fall", false),
    SWEET_GEM_BERRY("Rare Seed" , "2-4-6-6-6" , 24 , true , 0 , 3000 , false , 0 , "Fall", false),
    POWDERMELON("Powdermelon Seeds" , "1-2-1-2-1" , 7 , true , 0 , 60 , true , 63 , "Winter" , true),
    ANCIENT_FRUIT("Ancient Seeds" , "2-7-7-7-5" , 28 , false , 7 , 550 , false , 0 ,  "Spring & Summer & Fall", false),
    CommonMushroom(null , null , 0 , false , 0 , 40 , true , 38 , Season.SPRING.name() , false),
    DafDolli(null , null , 0 , false , 0 , 30 , true , 0 ,Season.SPRING.name()   , false),
    DandeLion(null , null , 0 , false , 0 , 40 , true , 25 ,Season.SPRING.name()  , false),
    Leek(null , null , 0 , false , 0 , 60 , true , 40 ,Season.SPRING.name()  , false),
    Morel(null , null , 0 , false , 0 , 150 , true , 20 , Season.SPRING.name()  , false),
    SalmonBerry(null , null , 0 , false , 0 , 5 , true , 25 , Season.SPRING.name()  , false),
    SpringOnion(null , null , 0 , false , 0 , 8 , true , 13 , Season.SPRING.name()  , false),
    WildHorseradish(null , null , 0 , false , 0 , 50 , true , 13 , Season.SPRING.name()  , false),
    FiddledHedFern(null , null , 0 , false , 0 , 90 , true , 25 , Season.SUMMER.name()  , false),
    REDMushroom(null , null , 0 , false , 0 , 75 , true , -50 ,Season.SUMMER.name()   , false),
    SpiceBerry(null , null , 0 , false , 0 , 80 , true , 25 ,Season.SUMMER.name()   , false),
    SweetPea(null , null , 0 , false , 0 , 50 , true , 0 , Season.SUMMER.name() , false),
    BlackBerry(null , null , 0 , false , 0 , 25 , true , 25 , Season.FALL.name() , false),
    Chanterele(null , null , 0 , false , 0 , 160 , true , 75 ,Season.FALL.name(), false),
    HazelNut(null , null , 0 , false , 0 , 40 , true , 38 , Season.FALL.name(), false),
    PurpleMushroom(null , null , 0 , false , 0 , 90 , true , 30 , Season.FALL.name() , false),
    WildPlum(null , null , 0 , false , 0 , 80 , true , 25 , Season.FALL.name() , false),
    Crocus(null , null , 0 , false , 0 , 60 , true , 0 , Season.WINTER.name(),  false),
    CrystalFruit(null , null , 0 , false , 0 , 150 , true , 63 , Season.WINTER.name() , false),
    Holly(null , null , 0 , false , 0 , 80 , true , -37 , Season.WINTER.name() , false),
    SnowYam(null , null , 0 , false , 0 , 100 , true , 30 , Season.WINTER.name() , false),
    WinterRoot(null , null , 0 , false , 0 , 70 , true , 25 ,Season.WINTER.name(), false),
    ;

    public final String Source;
    public final String stage;
    public final int TotalTimeHarvest;
    public final boolean OnTime;
    public final int RegrowthTime;
    public final int BasePrice;
    public final boolean IsEdible;
    public final int energy;
    public final String season;
    public final boolean CanBecomeGiant;

    private static final ArrayList<Plants> loadedPlants = new ArrayList<>();

    Plants(String source, String stage, int totalTimeHarvest, boolean onTime, int regrowthTime, int basePrice, boolean isEdible, int energy, String season, boolean canBecomeGiant) {
        Source = source;
        this.stage = stage;
        TotalTimeHarvest = totalTimeHarvest;
        OnTime = onTime;
        RegrowthTime = regrowthTime;
        BasePrice = basePrice;
        IsEdible = isEdible;
        this.energy = energy;
        this.season = season;
        CanBecomeGiant = canBecomeGiant;
    }


}