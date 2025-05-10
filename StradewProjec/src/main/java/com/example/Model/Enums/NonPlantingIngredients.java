package com.example.Model.Enums;

public enum NonPlantingIngredients {
    ChickenEgg("chicken egg", 50),
    LargeChickenEgg("large chicken egg", 95),
    DuckEgg("duck egg", 95),
    DuckFeather("duck feather", 250),
    RabbitWool("wool", 340),
    RabbitFoot("rabbit foot", 565),
    DinosaurEgg("dinosaur egg", 350),
    CowMilk("milk", 125),
    LargeCowMilk("large milk", 190),
    GoatMilk("goat milk", 225),
    LargeGoatMilk("large goat milk", 345),
    SheepMilk("sheep milk", 220),
    SheepWool("sheep wool", 340),
    Truffle("truffle", 625);

    public final String Name;
    public final int SellPrice;

    NonPlantingIngredients(String Name, int sellPrice) {
        this.Name = Name;
        this.SellPrice = sellPrice;
    }
}
