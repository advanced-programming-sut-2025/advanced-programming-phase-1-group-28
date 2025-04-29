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
    BARN(true , 7 , 4),;
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