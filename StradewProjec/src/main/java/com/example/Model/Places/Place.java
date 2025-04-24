package com.example.Model.Places;

import com.example.Model.Tile.Tile;

public class Place{
    protected int X_Coordinate;
    protected int Y_Coordinate;
    protected Boolean Locked = false;
    protected Tile[][] Ground ;
    protected int OwnerIndex;

    public int getX_Coordinate() {
        return X_Coordinate;
    }

    public void setX_Coordinate(int x_Coordinate) {
        X_Coordinate = x_Coordinate;
    }

    public int getY_Coordinate() {
        return Y_Coordinate;
    }

    public void setY_Coordinate(int y_Coordinate) {
        Y_Coordinate = y_Coordinate;
    }

    public Boolean getLocked() {
        return Locked;
    }

    public void setLocked(Boolean locked) {
        Locked = locked;
    }

    public Tile[][] getGround() {
        return Ground;
    }

    public void setGround(Tile[][] ground) {
        Ground = ground;
    }

    public int getOwnerIndex() {
        return OwnerIndex;
    }

    public void setOwnerIndex(int ownerIndex) {
        OwnerIndex = ownerIndex;
    }
}


