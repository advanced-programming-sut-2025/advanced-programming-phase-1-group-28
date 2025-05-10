package com.example.Model.Tile;

import com.example.Model.Enums.*;
import com.example.Model.Item.Ingredient;
import com.example.Model.Item.Item;

import java.util.ArrayList;

public class Animal extends Tile{
    private String PetName;
    private int FriendShip = 0;
    private Animals animalType;
    private ArrayList<Item> NoneHarvestingItems = new ArrayList<>();
    private boolean IsFed = true;
    private boolean pettedToday = false;
    private ArrayList<Ingredient> products = new ArrayList<>();
    private boolean isInside = true;

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

    public boolean isPettedToday() {
        return pettedToday;
    }

    public void setPettedToday(boolean pettedToday) {
        this.pettedToday = pettedToday;
    }

    public boolean isInside() {
        return isInside;
    }

    public void setInside(boolean inside) {
        isInside = inside;
    }

    public ArrayList<Ingredient> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Ingredient> products) {
        this.products = products;
    }

    public void addFriendship(int amount){
        FriendShip += amount;
        if (FriendShip > 1000){
            FriendShip = 1000;
        }
    }

    //call end of every day
    public void makeProduct() {
        // at least 100 friendship needed to get product and check is fed
        if (this.getFriendShip() < 100) {
            return;
        }if (!this.isFed()){
            return;
        }

        // which product will make
        int whichProduct = 1;
        double randomNumber = 0.5 + Math.random();
        double secondProductChance = (this.getFriendShip() + (150 * randomNumber)) / 1500;
        if (Math.random() <= secondProductChance) {
            whichProduct = 2;
        }

        Ingredient ingredient = new Ingredient(1, null);

        switch (this.getAnimalType()) {
            case Chicken:
                ingredient.setNonPlantingIngredients(
                        whichProduct == 1 ? NonPlantingIngredients.ChickenEgg : NonPlantingIngredients.LargeChickenEgg);
                break;

            case Duck:
                ingredient.setNonPlantingIngredients(
                        whichProduct == 1 ? NonPlantingIngredients.DuckEgg : NonPlantingIngredients.DuckFeather);
                break;

            case Rabbit:
                ingredient.setNonPlantingIngredients(
                        whichProduct == 1 ? NonPlantingIngredients.RabbitWool : NonPlantingIngredients.RabbitFoot);
                break;

            case Dinosaur:
                ingredient.setNonPlantingIngredients(NonPlantingIngredients.DinosaurEgg);
                break;

            case Cow:
                ingredient.setNonPlantingIngredients(
                        whichProduct == 1 ? NonPlantingIngredients.CowMilk : NonPlantingIngredients.LargeCowMilk);
                break;

            case Goat:
                ingredient.setNonPlantingIngredients(
                        whichProduct == 1 ? NonPlantingIngredients.GoatMilk : NonPlantingIngredients.LargeGoatMilk);
                break;

            case Sheep:
                ingredient.setNonPlantingIngredients(
                        whichProduct == 1 ? NonPlantingIngredients.SheepMilk : NonPlantingIngredients.SheepWool);
                break;

            case Pig:
                ingredient.setNonPlantingIngredients(NonPlantingIngredients.Truffle);
                break;
        }

        // set quality
        double quality = (double) this.getFriendShip() /1000 * (0.5 + 0.5 * Math.random());
        if (quality <= 0.5){
            ingredient.setQuality(Quality.Regular);
        } else if (quality <= 0.7) {
            ingredient.setQuality(Quality.Silver);
        } else if (quality <= 0.9) {
            ingredient.setQuality(Quality.Gold);
        }else {
            ingredient.setQuality(Quality.Iridium);
        }

        products.add(ingredient);
    }

    public int getSellPrice(){
        double price = this.getAnimalType().Price * ((double) this.getFriendShip() /1000 + 0.3);
        return (int) price;
    }

}
