package Model.Places;

import Model.Tile.Tile;

public class GreenHouse extends Place {
    public int Bucket_x_Coordinate;
    public int Bucket_y_Coordinate;
    public GreenHouse(int ownerIndex , int x_Coordinate, int y_Coordinate){
        Ground = new Tile[5][6];
        Locked = true;
        OwnerIndex = ownerIndex;
        X_Coordinate = x_Coordinate;
        Y_Coordinate = y_Coordinate;
    }
}
