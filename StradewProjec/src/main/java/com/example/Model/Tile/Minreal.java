package com.example.Model.Tile;

import com.example.Model.Enums.Entitity;
import com.example.Model.Enums.Minerals;
import com.example.Model.Enums.PlaceType;
import com.example.Model.Enums.Terrain;

public class Minreal extends Tile{
    private Minerals mineral;

    public Minreal(Terrain terrain, PlaceType placeType, Entitity entitity) {
        super(terrain, placeType, entitity);
    }
}
