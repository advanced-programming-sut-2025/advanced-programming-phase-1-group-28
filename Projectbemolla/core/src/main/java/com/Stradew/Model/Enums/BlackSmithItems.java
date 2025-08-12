package com.Stradew.Model.Enums;

public enum BlackSmithItems {
    Copper_Ore("Copper Ore"  , -1 , 75),
    Iron_Ore("Iron Ore" , -1 , 150),
    Gold_Ore("Gold Ore"  , -1 , 400),
    Coal("Coal"  , -1 , 150),
    Copper_Axe("Copper Axe", 0, 2000),
    Steel_Axe("Steel Axe", 1, 5000),
    Gold_Axe("Gold Axe", 2, 10000),

    Copper_Hoe("Copper Hoe", 0, 2000),
    Steel_Hoe("Steel Hoe", 1, 5000),
    Gold_Hoe("Gold Hoe", 2, 10000),

    Copper_MilkPail("Copper MilkPail", 0, 2000),
    Steel_MilkPail("Steel MilkPail", 1, 5000),
    Gold_MilkPail("Gold MilkPail", 2, 10000),

    Copper_WaterCan("Copper WaterCan", 0, 2000),
    Steel_WaterCan("Steel WaterCan", 1, 5000),
    Gold_WaterCan("Gold WaterCan", 2, 10000),

    Copper_Shear("Copper Shear", 0, 2000),
    Steel_Shear("Steel Shear", 1, 5000),
    Gold_Shear("Gold Shear", 2, 10000),

    Copper_Pickaxe("Copper Pickaxe", 0, 2000),
    Steel_Pickaxe("Steel Pickaxe", 1, 5000),
    Gold_Pickaxe("Gold Pickaxe", 2, 10000),

    Copper_Seythe("Copper Seythe", 0, 2000),
    Steel_Seythe("Steel Seythe", 1, 5000),
    Gold_Seythe("Gold Seythe", 2, 10000),

    Copper_Trash_Can("Copper Trash Can"  , 3 , 1000),
    Steel_Trash_Can("Steel Trash Can"  , 4 , 2500),
    Gold_Trash_Can("Gold Trash Can"  , 5 , 5000)
    ;
    public final String name;
    public final int limitIndex;
    public final int Price;
    BlackSmithItems(String name, int limitIndex, int price) {
        this.name = name;
        this.limitIndex = limitIndex;
        Price = price;
    }
}
