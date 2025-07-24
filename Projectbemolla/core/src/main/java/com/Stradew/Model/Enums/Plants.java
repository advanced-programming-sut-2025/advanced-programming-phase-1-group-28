package com.Stradew.Model.Enums;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public enum Plants {
    BLUE_JAZZ("Jazz Seeds", "1-2-2-2", 7, true, 0, 50, true, 45, "Spring", false , new Texture(Gdx.files.internal("Crops/Blue_Jazz.png"))),
    CARROT("Carrot Seeds", "1-1-1", 3, true, 0, 35, true, 75, "Spring", false ,new Texture(Gdx.files.internal("Crops/Carrot.png")) ),
    CAULIFLOWER("Cauliflower Seeds", "1-2-4-4-1", 12, true, 0, 175, true, 75, "Spring", true , new Texture(Gdx.files.internal("Crops/Cauliflower.png"))),
    COFFEE_BEAN("Coffee Bean", "1-2-2-3-2", 10, false, 2, 15, false, 0, "Spring & Summer", false , new Texture(Gdx.files.internal("Crops/Coffee_Bean.png"))),
    GARLIC("Garlic Seeds", "1-2-2-2", 4, true, 0, 60, true, 20, "Spring", false , new Texture(Gdx.files.internal("Crops/Garlic.png"))),
    GREEN_BEAN("Bean Starter", "1-1-1-3-4", 10, false, 3, 40, true, 25, "Spring", false , new Texture(Gdx.files.internal("Crops/Green_Bean.png"))),
    KALE("Kale Seeds", "1-2-2-1", 6, true, 0, 110, true, 50, "Spring", false , new Texture(Gdx.files.internal("Crops/Kale.png"))),
    PARSNIP("Parsnip Seeds", "1-1-2", 4, true, 0, 35, true, 25, "Spring", false , new Texture(Gdx.files.internal("Crops/Parsnip.png"))),
    POTATO("Potato Seeds", "1-1-1-2-1", 6, true, 0, 80, true, 25, "Spring", false, new Texture(Gdx.files.internal("Crops/Potato.png"))),
    RHUBARB("Rhubarb Seeds", "2-2-2-3-4", 13, true, 0, 220, false, 0, "Spring", false , new Texture(Gdx.files.internal("Crops/Rhubarb.png"))),
    STRAWBERRY("Strawberry Seeds", "1-1-2-2", 8, false, 4, 120, true, 50, "Spring", false , new Texture(Gdx.files.internal("Crops/Strawberry.png"))),
    TULIP("Tulip Bulb", "1-1-2", 6, true, 0, 30, true, 45, "Spring", false , new Texture(Gdx.files.internal("Crops/Tulip.png"))),
    UNMILLED_RICE("Rice Shoot", "1-2-2-3", 6, true, 0, 30, true, 3, "Spring", false , new Texture(Gdx.files.internal("Crops/Unmilled_Rice.png"))),
    BLUEBERRY("Blueberry Seeds", "1-3-3-4-2", 13, false, 4, 50, true, 25, "Summer", false , new Texture(Gdx.files.internal("Crops/Blueberry.png"))),
    CORN("Corn Seeds", "2-3-3-3-3", 14, false, 4, 50, true, 25, "Summer & Fall", false , new Texture(Gdx.files.internal("Crops/Corn.png"))),
    HOPS("Hops Starter", "1-1-2-3-4", 11, false, 1, 25, true, 20, "Summer", false , new Texture(Gdx.files.internal("Crops/Hops.png"))),
    HOT_PEPPER("Pepper Seeds", "1-2-2-2-2", 8, false, 3, 40, true, 25, "Summer", false , new Texture(Gdx.files.internal("Crops/Hot_Pepper.png"))),
    MELON("Melon Seeds", "1-2-3-3-3", 12, true, 0, 250, true, 113, "Summer", true , new Texture(Gdx.files.internal("Crops/Melon.png"))),
    POPPY("Poppy Seeds", "1-2-2", 7, true, 0, 140, true, 45, "Summer", false,  new Texture(Gdx.files.internal("Crops/Poppy.png"))),
    RADISH("Radish Seeds", "2-1-2-1", 6, true, 0, 90, true, 45, "Summer", false , new Texture(Gdx.files.internal("Crops/Radish.png"))),
    RED_CABBAGE("Red Cabbage Seeds", "1-1-2-2-2", 9, true, 0, 260, true, 75, "Summer", false, new Texture(Gdx.files.internal("Crops/Red_Cabbage.png"))),
    STARFRUIT("Starfruit Seeds", "2-2-3-3-3", 13, true, 0, 750, true, 125, "Summer", false , new Texture(Gdx.files.internal("Crops/Starfruit.png"))),
    SUMMER_SPANGLE("Spangle Seeds", "1-2-3-1", 8, true, 0, 90, true, 45, "Summer", false , new Texture(Gdx.files.internal("Crops/Summer_Spangle.png"))),
    SUMMER_SQUASH("Summer Squash Seeds", "1-1-1-2-1", 6, false, 3, 45, true, 63, "Summer", false , new Texture(Gdx.files.internal("Crops/Summer_Squash.png"))),
    SUNFLOWER("Sunflower Seeds", "1-2-3-2", 8, true, 0, 80, true, 45, "Summer & Fall", false , new Texture(Gdx.files.internal("Crops/Sunflower.png"))),
    TOMATO("Tomato Seeds", "1-2-2-1-2", 11, false, 4, 60, true, 20, "Summer", false , new Texture(Gdx.files.internal("Crops/Tomato.png"))),
    WHEAT("Wheat Seeds", "1-1-1", 4, true, 0, 25, false, 0, "Summer & Fall", false , new Texture(Gdx.files.internal("Crops/Wheat.png"))),
    AMARANTH("Amaranth Seeds", "1-2-2-2", 7, true, 0, 150, true, 50, "Fall", false , new Texture(Gdx.files.internal("Crops/Amaranth.png"))),
    ARTICHOKE("Artichoke Seeds", "1-2-3-4", 8, true, 0, 160, true, 30, "Fall", false, new Texture(Gdx.files.internal("Crops/Artichoke.png"))),
    BEET("Beet Seeds", "1-1-2", 6, true, 0, 100, true, 30, "Fall", false , new Texture(Gdx.files.internal("Crops/Beet.png"))),
    BOK_CHOY("Bok Choy Seeds", "1-1-2", 4, true, 0, 80, true, 25, "Fall", false , new Texture(Gdx.files.internal("Crops/Bok_Choy.png"))),
    BROCCOLI("Broccoli Seeds", "2-2-1-2", 7, true, 0, 70, true, 63, "Fall", false , new Texture(Gdx.files.internal("Crops/Broccoli.png"))),
    CRANBERRIES("Cranberry Seeds", "1-1-2-3", 10, false, 5, 75, true, 38, "Fall", false , new Texture(Gdx.files.internal("Crops/Cranberries.png"))),
    EGGPLANT("Eggplant Seeds", "1-1-1-1", 5, false, 5, 60, true, 20, "Fall", false , new Texture(Gdx.files.internal("Crops/Eggplant.png"))),
    FAIRY_ROSE("Fairy Seeds", "2-2-3-2", 12, true, 0, 290, true, 45, "Fall", false , new Texture(Gdx.files.internal("Crops/Fairy_Rose.png"))),
    GRAPE("Grape Starter", "1-2-3-3", 10, false, 3, 80, true, 38, "Fall", false , new Texture(Gdx.files.internal("Crops/Grape.png"))),
    PUMPKIN("Pumpkin Seeds", "1-2-3-4-3", 13 , true , 0 , 320 , false , 0 , "Fall", true , new Texture(Gdx.files.internal("Crops/Pumpkin.png"))),
    YAM("Yam Seeds" , "1-3-3-3" , 10 , true , 0 , 160 , true , 45 , "Fall", false , new Texture(Gdx.files.internal("Crops/Yam.png"))),
    SWEET_GEM_BERRY("Rare Seed" , "2-4-6-6-6" , 24 , true , 0 , 3000 , false , 0 , "Fall", false , new Texture(Gdx.files.internal("Crops/Sweet_Gem_Berry.png"))),
    POWDERMELON("Powdermelon Seeds" , "1-2-1-2-1" , 7 , true , 0 , 60 , true , 63 , "Winter" , true , new Texture(Gdx.files.internal("Crops/Powdermelon.png"))),
    ANCIENT_FRUIT("Ancient Seeds" , "2-7-7-7-5" , 28 , false , 7 , 550 , false , 0 ,  "Spring & Summer & Fall", false , new Texture(Gdx.files.internal("Crops/Ancient_Fruit.png"))),
    CommonMushroom(null , null , 0 , false , 0 , 40 , true , 38 , Season.SPRING.name() , false , new Texture(Gdx.files.internal("Foraging/Common_Mushroom.png"))),
    DafDolli(null , null , 0 , false , 0 , 30 , true , 0 ,Season.SPRING.name()   , false , new Texture(Gdx.files.internal("Foraging/Daffodil.png"))),
    DandeLion(null , null , 0 , false , 0 , 40 , true , 25 ,Season.SPRING.name()  , false , new Texture(Gdx.files.internal("Foraging/Dandelion.png"))),
    Leek(null , null , 0 , false , 0 , 60 , true , 40 ,Season.SPRING.name()  , false , new Texture(Gdx.files.internal("Foraging/Leek.png"))),
    Morel(null , null , 0 , false , 0 , 150 , true , 20 , Season.SPRING.name()  , false , new Texture(Gdx.files.internal("Foraging/Morel.png"))),
    SalmonBerry(null , null , 0 , false , 0 , 5 , true , 25 , Season.SPRING.name()  , false , new Texture(Gdx.files.internal("Foraging/Salmonberry.png"))),
    SpringOnion(null , null , 0 , false , 0 , 8 , true , 13 , Season.SPRING.name()  , false , new Texture(Gdx.files.internal("Foraging/Spring_Onion.png"))),
    WildHorseradish(null , null , 0 , false , 0 , 50 , true , 13 , Season.SPRING.name()  , false , new Texture(Gdx.files.internal("Foraging/Wild_Horseradish.png"))),
    FiddledHedFern(null , null , 0 , false , 0 , 90 , true , 25 , Season.SUMMER.name()  , false , new Texture(Gdx.files.internal("Foraging/Fiddlehead_Fern.png"))),
    REDMushroom(null , null , 0 , false , 0 , 75 , true , -50 ,Season.SUMMER.name()   , false , new Texture(Gdx.files.internal("Foraging/Red_Mushroom.png"))),
    SpiceBerry(null , null , 0 , false , 0 , 80 , true , 25 ,Season.SUMMER.name()   , false , new Texture(Gdx.files.internal("Foraging/Spice_Berry.png"))),
    SweetPea(null , null , 0 , false , 0 , 50 , true , 0 , Season.SUMMER.name() , false , new Texture(Gdx.files.internal("Foraging/Sweet_Pea.png"))),
    BlackBerry(null , null , 0 , false , 0 , 25 , true , 25 , Season.FALL.name() , false , new Texture(Gdx.files.internal("Foraging/Blackberry.png"))),
    Chanterele(null , null , 0 , false , 0 , 160 , true , 75 ,Season.FALL.name(), false , new Texture(Gdx.files.internal("Foraging/Chanterelle.png"))),
    HazelNut(null , null , 0 , false , 0 , 40 , true , 38 , Season.FALL.name(), false , new Texture(Gdx.files.internal("Foraging/Hazelnut.png"))),
    PurpleMushroom(null , null , 0 , false , 0 , 90 , true , 30 , Season.FALL.name() , false  , new Texture(Gdx.files.internal("Foraging/Purple_Mushroom.png"))),
    WildPlum(null , null , 0 , false , 0 , 80 , true , 25 , Season.FALL.name() , false , new Texture(Gdx.files.internal("Foraging/Wild_Plum.png"))),
    Crocus(null , null , 0 , false , 0 , 60 , true , 0 , Season.WINTER.name(),  false , new Texture(Gdx.files.internal("Foraging/Crocus.png"))),
    CrystalFruit(null , null , 0 , false , 0 , 150 , true , 63 , Season.WINTER.name() , false , new Texture(Gdx.files.internal("Foraging/Crystal_Fruit.png"))),
    Holly(null , null , 0 , false , 0 , 80 , true , -37 , Season.WINTER.name() , false , new Texture(Gdx.files.internal("Foraging/Holly.png"))),
    SnowYam(null , null , 0 , false , 0 , 100 , true , 30 , Season.WINTER.name() , false , new Texture(Gdx.files.internal("Foraging/Snow_Yam.png"))),
    WinterRoot(null , null , 0 , false , 0 , 70 , true , 25 ,Season.WINTER.name(), false , new Texture(Gdx.files.internal("Foraging/Winter_Root.png"))),
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
    public final Texture PlantTexture;


    private static final ArrayList<Plants> loadedPlants = new ArrayList<>();
    //private final String Picture;

    Plants(String source, String stage, int totalTimeHarvest, boolean onTime, int regrowthTime, int basePrice, boolean isEdible, int energy, String season, boolean canBecomeGiant , Texture PlantTexture) {
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
        this.PlantTexture = PlantTexture;
    }


}
