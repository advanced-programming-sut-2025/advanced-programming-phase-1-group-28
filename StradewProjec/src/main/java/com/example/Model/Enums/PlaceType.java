package com.example.Model.Enums;

public enum PlaceType {
    NORMAL(true , 1 , 1),
    FARM(true , 45 , 45),
    VILLAGE(true , 6 , 6),
    CABIN(true ,4 , 4),
    QUARRY(true , 5 , 5),
    GREENHOUSE(true , 5 , 6),
    LAKE(false , 4 , 4);
    public final boolean isWalkable;
    public final int XLenght;
    public final int Ylenght;
    PlaceType(boolean isWalkable , int XLenght, int Ylenght) {
        this.XLenght = XLenght;
        this.Ylenght = Ylenght;
        this.isWalkable = isWalkable;
    }
    public boolean isWalkable() {return this.isWalkable;}
}