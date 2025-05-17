package com.example.Model.Enums;

public enum PlaceType {
    NORMAL(true , 1 , 1),
    FARM(true , 45 , 45),
    VILLAGE(true , 6 , 6),
    CABIN(true ,4 , 4),
    QUARRY(true , 5 , 5),
    GREENHOUSE(true , 5 , 6),
    LAKE(false , 4 , 4),
    COOP(true , 6 , 3),
    BARN(true , 7 , 4),
    SHIPPING_BIN(false , 1 , 1),
    BlackSmith(true , 0 , 0),
    CarpenterShop(true , 0 , 0),
    FishShop(true , 0 , 0),
    JojaMart(true , 0 , 0),
    MarineRanch(true , 0 , 0),
    PerrieGeneralStore(true , 0 , 0),
    StarDropSaloon(true , 0 , 0);

    public final boolean isWalkable;
    public final int XLength;
    public final int YLength;
    PlaceType(boolean isWalkable , int XLength, int YLength) {
        this.XLength = XLength;
        this.YLength = YLength;
        this.isWalkable = isWalkable;
    }
    public boolean isWalkable() {return this.isWalkable;}
}