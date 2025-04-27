package com.example.Model.Enums;

public enum Terrain {
    GRASS(true),
    WATER(false),
    DIRT(true),
    FLOOR(true);
    private final boolean isWalkable;
    Terrain(boolean isWalkable) {
        this.isWalkable = isWalkable;
    }
    public boolean isWalkable() {return this.isWalkable;}
}
