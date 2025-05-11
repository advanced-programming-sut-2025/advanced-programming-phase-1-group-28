package com.example.Model.Places;

import com.example.Model.Enums.PlaceType;
import com.example.Model.Enums.Terrain;
import com.example.Model.Tile.Animal;
import com.example.Model.Tile.Tile;

import java.util.ArrayList;

public class Farm extends Place {

    private ArrayList<Animal> Animals = new ArrayList<>();
    private GreenHouse greenHouse;
    private Cabin cabin; // attention if we construct in Cabin Class then Apply Here
    private Lake lake;
    private Quarry quarry;
    private ArrayList<AnimalHouse> Coops;
    private ArrayList<AnimalHouse> Barns;

    public ArrayList<AnimalHouse> getBarns() {
        return Barns;
    }

    public void setBarns(ArrayList<AnimalHouse> barns) {
        Barns = barns;
    }

    public ArrayList<AnimalHouse> getCoops() {
        return Coops;
    }

    public void setCoops(ArrayList<AnimalHouse> coops) {
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
        System.out.println("what the fuck");
        this.greenHouse = greenHouse;
        this.cabin = cabin;
        this.lake = lake;
        this.quarry = quarry;
        setGround(new Tile[500][500]);
        for(int i = 0;i < 500 ;i++)
        {
            for(int j = 0;j < 500 ;j++)
            {
                getGround()[i][j] = new Tile(Terrain.DIRT , null , null);
            }
        }
        for(int i = 0;i < PlaceType.GREENHOUSE.XLength ; i++)
        {
            for(int j = 0;j < PlaceType.GREENHOUSE.YLength ;j++)
            {
                int Newi = i + greenHouse.X_Coordinate;
                int Newj = j + greenHouse.Y_Coordinate;
                getGround()[Newi][Newj].setTerrain(null);
                getGround()[Newi][Newj].setPlaceType(PlaceType.GREENHOUSE);
            }
        }
        for(int i = 0 ; i < PlaceType.CABIN.XLength ; i++)
        {
            for(int j = 0 ;j < PlaceType.CABIN.YLength ;j++)
            {
                int Newi = i + cabin.X_Coordinate;
                int Newj = j + cabin.Y_Coordinate;
                getGround()[Newi][Newj].setTerrain(null);
                getGround()[Newi][Newj].setPlaceType(PlaceType.CABIN);
            }
        }
        for(int i = 0 ; i < PlaceType.LAKE.XLength ; i++)
        {
            for(int j = 0 ;j < PlaceType.LAKE.YLength ;j++)
            {
                int Newi = i + lake.X_Coordinate;
                int Newj = j + lake.Y_Coordinate;
                getGround()[Newi][Newj].setTerrain(null);
                getGround()[Newi][Newj].setPlaceType(PlaceType.LAKE);
            }
        }
        for(int i = 0 ; i < PlaceType.QUARRY.XLength ; i++)
        {
            for(int j = 0 ;j < PlaceType.QUARRY.YLength ;j++)
            {
                int Newi = i + quarry.X_Coordinate;
                int Newj = j + quarry.Y_Coordinate;
                getGround()[Newi][Newj].setTerrain(null);
                getGround()[Newi][Newj].setPlaceType(PlaceType.QUARRY);
            }
        }
    }

    public Animal getAnimalByName(String name){
        for (Animal animal: Animals){
            if (animal.getPetName().equals(name)){
                return animal;
            }
        }
        return null;
    }

    public void removeAnimal(Animal animal){
        Animals.remove(animal);
    }
}
