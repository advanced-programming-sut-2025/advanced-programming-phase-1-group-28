package com.Stradew.Model.Places;

import com.Stradew.Controller.MainMenuController.MapController;
import com.Stradew.Model.Enums.PlaceType;
import com.Stradew.Model.Enums.Terrain;
import com.Stradew.Model.Tile.Tile;
import com.Stradew.View.MainMenu.MechanicGame.ShopMenu.StarDropSaloon;

public class Village {
    private Tile[][] ground = new Tile[MapController.MAP_ROWS][MapController.MAP_COLS];
    public Village() {
        for (int i = 0; i < MapController.MAP_ROWS; i++) {
            for (int j = 0; j < MapController.MAP_COLS; j++) {
                ground[i][j] = new Tile(Terrain.DIRT , null , null);
            }
        }

        for(int i = 10 ; i <= PlaceType.StarDropSaloon.XLength + 10 ; i++)
        {
            for(int j = 10 ; j <= 10 + PlaceType.StarDropSaloon.YLength ; j++)
            {
                ground[i][j].setPlaceType(PlaceType.StarDropSaloon);
                ground[i][j].setTerrain(null);
                ground[i][j].setEntitity(null);
            }
        }

        ground[1][10].setPlaceType(PlaceType.Portal);
    }

    public Tile[][] getGround() {
        return ground;
    }
}
