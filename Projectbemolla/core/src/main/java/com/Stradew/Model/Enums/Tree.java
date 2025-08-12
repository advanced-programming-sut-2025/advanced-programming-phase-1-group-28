package com.Stradew.Model.Enums;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public enum Tree {
    APRICOT_TREE("Apricot Sapling", "7-7-7-7", 28, Fruits.APRICOT, 1 , new Texture(Gdx.files.internal("Trees/Apricot_Stage_4.png"))),
    CHERRY_TREE("Cherry Sapling", "7-7-7-7", 28, Fruits.CHERRY, 1 , new Texture(Gdx.files.internal("Trees/Cherry_Stage_4.png"))),
    BANANA_TREE("Banana Sapling", "7-7-7-7", 28, Fruits.BANANA, 1 , new Texture(Gdx.files.internal("Trees/Banana_Stage_4.png"))),
    MANGO_TREE("Mango Sapling", "7-7-7-7", 28, Fruits.MANGO, 1 , new Texture(Gdx.files.internal("Trees/Mango_Stage_4.png"))),
    ORANGE_TREE("Orange Sapling", "7-7-7-7", 28, Fruits.ORANGE, 1 , new Texture(Gdx.files.internal("Trees/Orange_Stage_4.png"))),
    PEACH_TREE("Peach Sapling", "7-7-7-7", 28, Fruits.PEACH, 1 , new Texture(Gdx.files.internal("Trees/Peach_Stage_4.png"))),
    APPLE_TREE("Apple Sapling", "7-7-7-7", 28, Fruits.APPLE, 1 , new Texture(Gdx.files.internal("Trees/Apple_Stage_4.png"))),
    POMEGRANATE_TREE("Pomegranate Sapling", "7-7-7-7", 28, Fruits.POMEGRANATE, 1 , new Texture(Gdx.files.internal("Trees/Pomegranate_Stage_4.png"))),
    OAK_TREE("Acorns", "7-7-7-7", 28, Fruits.OAK, 7 , new Texture(Gdx.files.internal("Trees/Oak_Resin.png"))),
    MAPLE_TREE("Maple Seeds", "7-7-7-7", 28, Fruits.MAPLE, 9 , new Texture(Gdx.files.internal("Trees/Maple_Stage_5.png"))),
    PINE_TREE("Pine Cones", "7-7-7-7", 28, Fruits.PINE, 5 , new Texture(Gdx.files.internal("Trees/Pine_Stage_5.png"))),
    MAHOGANY_TREE("Mahogany Seeds", "7-7-7-7", 28, Fruits.MAHOGANY, 1 , new Texture(Gdx.files.internal("Trees/Mahogany_Stage_5.png"))),
    MUSHROOM_TREE("Mushroom Tree Seeds", "7-7-7-7", 28, Fruits.MUSHROOM, 1 , new Texture(Gdx.files.internal("Trees/MushroomTree_Stage_5.png"))),
    MYSTIC_TREE("Mystic Tree Seeds", "7-7-7-7", 28, Fruits.MYSTIC, 7 , new Texture(Gdx.files.internal("Trees/Apricot.png")));


    public final String Source;
    public final String stage;
    public final int TotalTimeHarvest;
    public final Fruits fruits;
    public final int HarvestCycle;
    public final Texture TreeTexture;


    Tree(String source, String stage, int totalTimeHarvest, Fruits fruits, int harvestCycle , Texture TreeTexture) {
        Source = source;
        this.stage = stage;
        TotalTimeHarvest = totalTimeHarvest;
        this.fruits = fruits;
        HarvestCycle = harvestCycle;
        this.TreeTexture = TreeTexture;
    }
}
