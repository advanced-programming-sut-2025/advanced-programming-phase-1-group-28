package Model.Tile;

import Model.Enums.Animals;
import Model.Item.Item;

import java.util.ArrayList;

public class Animal extends Tile{
    public String PetName;
    public int FriendShip = 0;
    public Animals animalType;
    public ArrayList<Item> NoneHarvestingItems = new ArrayList<>();
    public boolean IsFed = true;
}
