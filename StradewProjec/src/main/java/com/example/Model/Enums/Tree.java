package com.example.Model.Enums;

public enum Tree {
    APRICOT_TREE("Apricot Sapling", "7-7-7-7", 28, "Apricot", 1, 59, true, 38, "Spring"),
    CHERRY_TREE("Cherry Sapling", "7-7-7-7", 28, "Cherry", 1, 80, true, 38, "Spring"),
    BANANA_TREE("Banana Sapling", "7-7-7-7", 28, "Banana", 1, 150, true, 75, "Summer"),
    MANGO_TREE("Mango Sapling", "7-7-7-7", 28, "Mango", 1, 130, true, 100, "Summer"),
    ORANGE_TREE("Orange Sapling", "7-7-7-7", 28, "Orange", 1, 100, true, 38, "Summer"),
    PEACH_TREE("Peach Sapling", "7-7-7-7", 28, "Peach", 1, 140, true, 38, "Summer"),
    APPLE_TREE("Apple Sapling", "7-7-7-7", 28, "Apple", 1, 100, true, 38, "Fall"),
    POMEGRANATE_TREE("Pomegranate Sapling", "7-7-7-7", 28, "Pomegranate", 1, 140, true, 38, "Fall"),
    OAK_TREE("Acorns", "7-7-7-7", 28, "Oak Resin", 7, 150, false, 0, "Special"),
    MAPLE_TREE("Maple Seeds", "7-7-7-7", 28, "Maple Syrup", 9, 200, false, 0, "Special"),
    PINE_TREE("Pine Cones", "7-7-7-7", 28, "Pine Tar", 5, 100, false, 0, "Special"),
    MAHOGANY_TREE("Mahogany Seeds", "7-7-7-7", 28, "Sap", 1, 2, true, -2, "Special"),
    MUSHROOM_TREE("Mushroom Tree Seeds", "7-7-7-7", 28, "Common Mushroom", 1, 40, true, 38, "Special"),
    MYSTIC_TREE("Mystic Tree Seeds", "7-7-7-7", 28, "Mystic Syrup", 7, 1000, true, 500, "Special");


    public final String Source;
    public final String stage;
    public final int TotalTimeHarvest;
    public final String Fruit;
    public final int HarvestCycle;
    public final int BaseSellPrice;
    public final boolean IsFruitEdible;
    public final int energy;
    public final String season;
    Tree(String source, String stage, int totalTimeHarvest, String fruit, int harvestCycle, int baseSellPrice, boolean isFruitEdible, int energy, String season) {
        Source = source;
        this.stage = stage;
        TotalTimeHarvest = totalTimeHarvest;
        Fruit = fruit;
        HarvestCycle = harvestCycle;
        BaseSellPrice = baseSellPrice;
        IsFruitEdible = isFruitEdible;
        this.energy = energy;
        this.season = season;
    }
}
