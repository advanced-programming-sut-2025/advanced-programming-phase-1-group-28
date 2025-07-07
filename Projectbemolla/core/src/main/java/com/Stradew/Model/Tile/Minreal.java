package com.Stradew.Model.Tile;

import com.Stradew.Model.Enums.Entitity;
import com.Stradew.Model.Enums.Minerals;
import com.Stradew.Model.Enums.PlaceType;
import com.Stradew.Model.Enums.Terrain;

public class Minreal extends Tile{
    private Minerals mineral;

    public Minerals getMineral() {
        return mineral;
    }

    public void setMineral(Minerals mineral) {
        this.mineral = mineral;
    }

    public Minreal(Terrain terrain, PlaceType placeType, Entitity entitity) {
        super(terrain, placeType, entitity);
    }
}
