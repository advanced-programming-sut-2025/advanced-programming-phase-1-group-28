package com.example.Model.Enums;

public enum Tree {
    APRICOT_TREE("Apricot Sapling", "7-7-7-7", 28, Fruits.APRICOT, 1),
    CHERRY_TREE("Cherry Sapling", "7-7-7-7", 28, Fruits.CHERRY, 1),
    BANANA_TREE("Banana Sapling", "7-7-7-7", 28, Fruits.BANANA, 1),
    MANGO_TREE("Mango Sapling", "7-7-7-7", 28, Fruits.MANGO, 1),
    ORANGE_TREE("Orange Sapling", "7-7-7-7", 28, Fruits.ORANGE, 1),
    PEACH_TREE("Peach Sapling", "7-7-7-7", 28, Fruits.PEACH, 1),
    APPLE_TREE("Apple Sapling", "7-7-7-7", 28, Fruits.APPLE, 1),
    POMEGRANATE_TREE("Pomegranate Sapling", "7-7-7-7", 28, Fruits.POMEGRANATE, 1),
    OAK_TREE("Acorns", "7-7-7-7", 28, Fruits.OAK, 7),
    MAPLE_TREE("Maple Seeds", "7-7-7-7", 28, Fruits.MAPLE, 9),
    PINE_TREE("Pine Cones", "7-7-7-7", 28, Fruits.PINE, 5),
    MAHOGANY_TREE("Mahogany Seeds", "7-7-7-7", 28, Fruits.MAHOGANY, 1),
    MUSHROOM_TREE("Mushroom Tree Seeds", "7-7-7-7", 28, Fruits.MUSHROOM, 1),
    MYSTIC_TREE("Mystic Tree Seeds", "7-7-7-7", 28, Fruits.MYSTIC, 7);


    public final String Source;
    public final String stage;
    public final int TotalTimeHarvest;
    public final Fruits fruits;
    public final int HarvestCycle;

    Tree(String source, String stage, int totalTimeHarvest, Fruits fruits, int harvestCycle) {
        Source = source;
        this.stage = stage;
        TotalTimeHarvest = totalTimeHarvest;
        this.fruits = fruits;
        HarvestCycle = harvestCycle;
    }
}
