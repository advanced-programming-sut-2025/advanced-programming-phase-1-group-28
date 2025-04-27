package com.example.Model.Enums;

public enum PlaceType {
    NORMAL(true),
    FARM(true),
    VILLAGE(true),
    CABIN(true),
    QUARRY(true),
    GREENHOUSE(true),
    LAKE(false);
    private final boolean isWalkable;
    PlaceType(boolean isWalkable) {
        this.isWalkable = isWalkable;
    }
    public boolean isWalkable() {return this.isWalkable;}
}