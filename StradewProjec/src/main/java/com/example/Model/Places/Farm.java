package com.example.Model.Places;

import com.example.Model.Enums.PlaceType;
import com.example.Model.Enums.Terrain;
import com.example.Model.Tile.Animal;
import com.example.Model.Tile.Tile;

import java.util.ArrayList;

public class Farm extends Place {

    private ArrayList<Animal> Animals;
    private GreenHouse greenHouse;
    private Cabin cabin; // attention if we construct in Cabin Class then Apply Here
    private Lake lake;
    private Quarry quarry;
    private ArrayList<Coop> Coops;

    public void UpdateFarm()
    {
        Tile[][] NewGround = new Tile[45][45];
        for(int x = 0; x < 45; x++)
        {
            for (int y = 0; y < 45; y++)
            {
                NewGround[x][y] = new Tile(Terrain.DIRT , null , null);
            }
        }
        for(int x = this.lake.X_Coordinate; x < this.lake.X_Coordinate + PlaceType.LAKE.XLenght ; x++)
        {
            for(int y = this.lake.Y_Coordinate; y < this.lake.Y_Coordinate + PlaceType.LAKE.Ylenght ; y++)
            {
                NewGround[x][y].setPlaceType(PlaceType.LAKE);
                NewGround[x][y].setTerrain(Terrain.WATER);
            }
        }
        for(int x = this.cabin.X_Coordinate ; x < this.cabin.X_Coordinate + PlaceType.CABIN.XLenght ; x++)
        {
            for(int y = this.cabin.Y_Coordinate ; y < this.cabin.Y_Coordinate + PlaceType.CABIN.Ylenght ; y++)
            {
                NewGround[x][y].setPlaceType(PlaceType.CABIN);
                NewGround[x][y].setTerrain(Terrain.FLOOR);
            }
        }
        for(int x = this.greenHouse.X_Coordinate ; x < this.greenHouse.X_Coordinate + PlaceType.GREENHOUSE.XLenght ; x++)
        {
            for(int y = this.greenHouse.Y_Coordinate ; y < this.greenHouse.Y_Coordinate + PlaceType.GREENHOUSE.Ylenght ; y++)
            {
                NewGround[x][y].setPlaceType(PlaceType.GREENHOUSE);
                NewGround[x][y].setTerrain(Terrain.FLOOR);
            }
        }
        for(int x = this.quarry.X_Coordinate ; x < this.quarry.X_Coordinate + PlaceType.QUARRY.XLenght ; x++)
        {
            for(int y = this.quarry.Y_Coordinate ; y < this.quarry.Y_Coordinate + PlaceType.QUARRY.Ylenght ; y++)
            {
                NewGround[x][y].setPlaceType(PlaceType.QUARRY);
                NewGround[x][y].setTerrain(Terrain.FLOOR);
            }
        }
        this.setGround(NewGround);
    }

    public ArrayList<Coop> getCoops() {
        return Coops;
    }

    public void setCoops(ArrayList<Coop> coops) {
        Coops = coops;
    }

    public ArrayList<Animal> getAnimals() {
        return Animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        Animals = animals;
    }

    public GreenHouse getGreenHouse() {
        return greenHouse;
    }

    public void setGreenHouse(GreenHouse greenHouse) {
        this.greenHouse = greenHouse;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }

    public Lake getLake() {
        return lake;
    }

    public void setLake(Lake lake) {
        this.lake = lake;
    }

    public Quarry getQuarry() {
        return quarry;
    }

    public void setQuarry(Quarry quarry) {
        this.quarry = quarry;
    }

    public void RandFeatures()
    {
        //To Put Rand Features
    }

    public Farm(GreenHouse greenHouse, Cabin cabin, Lake lake, Quarry quarry) {
        this.greenHouse = greenHouse;
        this.cabin = cabin;
        this.lake = lake;
        this.quarry = quarry;
        UpdateFarm();
    }
}
