package com.example.Model.Enums;

public enum Entitity {
    TOOL(true),
    PLANTS(true),
    Minreal(true),
    STONE(false),
    TREE(false),
    ANIMAL(false),
    EMPTY(true);
    private boolean isWalkable;
    Entitity(boolean isWalkable) {
        this.isWalkable = isWalkable;
    }
    public boolean isWalkable() {return this.isWalkable;}

}
