package com.example.Model.Tile;

import com.example.Model.Enums.Entitity;
import com.example.Model.Enums.PlaceType;
import com.example.Model.Enums.Terrain;


public class Tile {
    private boolean IsHow = false;
    private boolean ISAttackedByCrow = false;
    private Terrain terrain;
    private PlaceType placeType;
    private Entitity entitity;
    protected int x;
    protected int y;
    public Tile(Terrain terrain, PlaceType placeType, Entitity entitity) {
        this.terrain = terrain;
        this.placeType = placeType;
        this.entitity = entitity;
    }

    public boolean isISAttackedByCrow() {
        return ISAttackedByCrow;
    }

    public void setISAttackedByCrow(boolean ISAttackedByCrow) {
        this.ISAttackedByCrow = ISAttackedByCrow;
    }

    public boolean isHow() {
        return IsHow;
    }

    public void setHow(boolean how) {
        IsHow = how;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }

    public Entitity getEntitity() {
        return entitity;
    }

    public void setEntitity(Entitity entitity) {
        this.entitity = entitity;
    }

    public boolean isWalkable() {
        return (terrain.isWalkable() && placeType.isWalkable() && entitity.isWalkable());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
