package com.Stradew.Model;

import com.Stradew.Model.Enums.Foods;
import com.Stradew.Model.Item.Item;
import com.Stradew.Model.Tools.Tools;

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
