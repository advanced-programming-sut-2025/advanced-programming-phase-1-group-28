package com.example.Model;

import com.example.Model.Enums.Foods;
import com.example.Model.Item.Item;
import com.example.Model.Places.AnimalHouse;

import javax.tools.Tool;
import java.util.ArrayList;

public class Reward {
    private int Coins;
    private Item item;
    private int FriendShip;
    private Tool tool;
    private Foods foodRecipe;
    private ArrayList<AnimalHouse> BeeHouses;

    public Reward(int coins, Item item, int friendShip, Tool tool, Foods foodRecipe, ArrayList<AnimalHouse> beeHouses) {
        Coins = coins;
        this.item = item;
        FriendShip = friendShip;
        this.tool = tool;
        this.foodRecipe = foodRecipe;
        BeeHouses = beeHouses;
    }

    public int getCoins() {
        return Coins;
    }

    public Item getItem() {
        return item;
    }

    public int getFriendShip() {
        return FriendShip;
    }

    public Tool getTool() {
        return tool;
    }

    public Foods getFoodRecipe() {
        return foodRecipe;
    }

    public ArrayList<AnimalHouse> getBeeHouses() {
        return BeeHouses;
    }
}
