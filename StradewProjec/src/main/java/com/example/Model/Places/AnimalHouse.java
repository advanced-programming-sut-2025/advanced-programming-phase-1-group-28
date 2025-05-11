package com.example.Model.Places;

public class AnimalHouse extends Place{
    private String AnimalHouse;
    private int Capacity;
    public AnimalHouse(int x , int y , String animalHouse , int Capacity) {
        X_Coordinate = x;
        Y_Coordinate = y;
        this.AnimalHouse = animalHouse;
        this.Capacity = Capacity;
    }

    public String getAnimalHouse() {
        return AnimalHouse;
    }

    public void setCoopType(String animalHouse) {
        AnimalHouse = animalHouse;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }
}
