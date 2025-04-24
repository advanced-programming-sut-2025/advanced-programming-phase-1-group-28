package com.example.Model.Places;

import com.example.Model.Tile.Animal;

import java.util.ArrayList;

public class Farm extends Place {
    private ArrayList<Animal> Animals;
    private GreenHouse greenHouse;
    private Cabin cabin; // attention if we construct in Cabin Class then Apply Here
    private Lake lake;
    private Quarry quarry;

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
}
