package com.example.Model.Places;

import com.example.Model.Tile.Tile;

public class GreenHouse extends Place {
    private int Bucket_x_Coordinate;
    private int Bucket_y_Coordinate;

    public int getBucket_x_Coordinate() {
        return Bucket_x_Coordinate;
    }

    public void setBucket_x_Coordinate(int bucket_x_Coordinate) {
        Bucket_x_Coordinate = bucket_x_Coordinate;
    }

    public int getBucket_y_Coordinate() {
        return Bucket_y_Coordinate;
    }

    public void setBucket_y_Coordinate(int bucket_y_Coordinate) {
        Bucket_y_Coordinate = bucket_y_Coordinate;
    }

    public GreenHouse(int x_Coordinate, int y_Coordinate){
        Ground = new Tile[5][6];
        Locked = true;
        X_Coordinate = x_Coordinate;
        Y_Coordinate = y_Coordinate;
    }
}
