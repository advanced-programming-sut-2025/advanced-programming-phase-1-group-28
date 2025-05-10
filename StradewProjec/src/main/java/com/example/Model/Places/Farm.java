package com.example.Model.Places;

import com.example.Model.Tile.Animal;

import java.util.ArrayList;

public class Farm extends Place {

    private ArrayList<Animal> Animals;
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
        this.greenHouse = greenHouse;
        this.cabin = cabin;
        this.lake = lake;
        this.quarry = quarry;
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
