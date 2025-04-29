package com.example.Model.Tile;

import com.example.Model.Enums.Entitity;
import com.example.Model.Enums.PlaceType;
import com.example.Model.Enums.Terrain;


public class Tile {
    private boolean IsHow = false;
    private Terrain terrain;
    private PlaceType placeType;
    private Entitity entitity;
    public Tile(Terrain terrain, PlaceType placeType, Entitity entitity) {
        this.terrain = terrain;
        this.placeType = placeType;
        this.entitity = entitity;
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
}
