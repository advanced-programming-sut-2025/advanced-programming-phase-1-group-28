package com.example.Model.Enums;

public enum BlackSmithItems {
    Copper_Ore("Copper Ore"  , -1 , 75),
    Iron_Ore("Iron Ore" , -1 , 150),
    Gold_Ore("Gold Ore"  , -1 , 400),
    Coal("Coal"  , -1 , 150),
    Copper_Tool("Copper Tool"  , 0 , 2000),
    Steel_Tool("Steel Tool"  , 1 , 5000),
    Gold_Tool("Gold Tool"  , 2 , 10000),
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
