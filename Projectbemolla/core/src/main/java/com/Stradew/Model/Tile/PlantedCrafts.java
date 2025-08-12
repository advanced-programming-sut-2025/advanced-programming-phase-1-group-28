package com.Stradew.Model.Tile;

import com.Stradew.Model.Enums.Crafts;
import com.Stradew.Model.Enums.Entitity;
import com.Stradew.Model.Enums.PlaceType;
import com.Stradew.Model.Enums.Terrain;

public class PlantedCrafts extends Tile{
    private Crafts craft;


    public Crafts getCraft() {
        return craft;
    }

    public PlantedCrafts(Terrain terrain, PlaceType placeType, Entitity entitity , Crafts craft) {
        super(terrain, placeType, entitity);
        this.craft = craft;
    }

}
