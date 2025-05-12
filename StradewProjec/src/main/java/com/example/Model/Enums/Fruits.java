package com.example.Model.Enums;

public enum Fruits {
    APRICOT("Apricot", 59, true, 38, Season.SPRING),
    CHERRY("Cherry", 80, true, 38, Season.SPRING),
    BANANA("Banana", 150, true, 75, Season.SUMMER),
    MANGO("Mango", 130, true, 100, Season.SUMMER),
    ORANGE("Orange", 100, true, 38, Season.SUMMER),
    PEACH("Peach", 140, true, 38, Season.SUMMER),
    APPLE("Apple", 100, true, 38, Season.FALL),
    POMEGRANATE("Pomegranate", 140, true, 38, Season.FALL),
    OAK("Oak Resin", 150, false, 0, null),
    MAPLE("Maple Syrup", 200, false, 0, null),
    PINE("Pine Tar", 100, false, 0, null),
    MAHOGANY("Sap", 2, true, -2, null),
    MUSHROOM("Common Mushroom", 40, true, 38, null),
    MYSTIC("Mystic Syrup", 1000, true, 500, null);

    public final String Name;
    public final int baseCellPrice;
    public final boolean IsFruitEdible;
    public final int Energy;
    public final Season season;

    Fruits(String name, int baseCellPrice, boolean isFruitEdible, int energy, Season season) {
        Name = name;
        this.baseCellPrice = baseCellPrice;
        IsFruitEdible = isFruitEdible;
        Energy = energy;
        this.season = season;
    }
}
