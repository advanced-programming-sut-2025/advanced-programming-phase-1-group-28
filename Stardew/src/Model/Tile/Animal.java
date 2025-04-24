package Model.Tile;

import Model.Enums.Animals;
import Model.Item.Item;

import java.util.ArrayList;

public class Animal extends Tile{
    private String PetName;
    private int FriendShip = 0;
    private Animals animalType;
    private ArrayList<Item> NoneHarvestingItems = new ArrayList<>();
    private boolean IsFed = true;

    public Animal(String name, String petName, Animals animalType, ArrayList<Item> noneHarvestingItems) {
        super(name);
        PetName = petName;
        this.animalType = animalType;
        NoneHarvestingItems = noneHarvestingItems;
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
