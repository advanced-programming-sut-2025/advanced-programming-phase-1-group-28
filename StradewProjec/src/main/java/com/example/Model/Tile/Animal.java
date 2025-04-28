package com.example.Model.Tile;

import com.example.Model.Enums.Animals;
import com.example.Model.Enums.Entitity;
import com.example.Model.Enums.PlaceType;
import com.example.Model.Enums.Terrain;
import com.example.Model.Item.Item;

import java.util.ArrayList;

public class Animal extends Tile{
    private String PetName;
    private int FriendShip = 0;
    private Animals animalType;
    private ArrayList<Item> NoneHarvestingItems = new ArrayList<>();
    private boolean IsFed = true;

    public Animal(String petName, Animals animalType) {
        super(Terrain.GRASS , PlaceType.NORMAL , Entitity.ANIMAL);
        PetName = petName;
        this.animalType = animalType;
    }

    public String getPetName() {
        return PetName;
    }

    public void setPetName(String petName) {
        PetName = petName;
    }

    public int getFriendShip() {
        return FriendShip;
    }

    public void setFriendShip(int friendShip) {
        FriendShip = friendShip;
    }

    public Animals getAnimalType() {
        return animalType;
    }

    public void setAnimalType(Animals animalType) {
        this.animalType = animalType;
    }

    public ArrayList<Item> getNoneHarvestingItems() {
        return NoneHarvestingItems;
    }

    public void setNoneHarvestingItems(ArrayList<Item> noneHarvestingItems) {
        NoneHarvestingItems = noneHarvestingItems;
    }

    public boolean isFed() {
        return IsFed;
    }

    public void setFed(boolean fed) {
        IsFed = fed;
    }
}
