package com.example.Model;

import com.example.Model.Enums.Foods;
import com.example.Model.Item.Item;
import com.example.Model.Places.AnimalHouse;
import com.example.Model.Tools.Tools;

import java.util.ArrayList;

public class Reward {
    private int Coins;
    private Item item;
    private int FriendShip;
    private Tools tool;
    private Foods foodRecipe;

    public Reward(int coins, Item item, int friendShip, Tools tool, Foods foodRecipe) {
        Coins = coins;
        this.item = item;
        FriendShip = friendShip;
        this.tool = tool;
        this.foodRecipe = foodRecipe;
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

    public Tools getTool() {
        return tool;
    }

    public Foods getFoodRecipe() {
        return foodRecipe;
    }

//    public ArrayList<AnimalHouse> getBeeHouses() {
//        return BeeHouses;
//    }
}
