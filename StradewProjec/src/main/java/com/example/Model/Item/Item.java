package com.example.Model.Item;

import com.example.Model.Inventory;

public class Item {
    protected String name;
    protected int count = 0;

    public Item(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public int ReturnCost()
    {
        int Cost = 0;
        Item item = this;
        if(item instanceof PlantsItem)
        {
            PlantsItem tempPlantsItem = (PlantsItem)item;
            Cost = tempPlantsItem.getPlant().BasePrice;
        }
        if(item instanceof MineralItem)
        {
            MineralItem tempMineralItem = (MineralItem)item;
            Cost = tempMineralItem.getMineral().Cost;
        }
        if(item instanceof FishItem)
        {
            FishItem tempFishItem = (FishItem)item;
            Cost = tempFishItem.getFish().price;
        }
        if(item instanceof Food)
        {
            Food tempFoodItem = (Food)item;
            Cost = tempFoodItem.getFood().SellPrice;
        }
        return Cost;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCount(int amount){
        count += amount;
    }

    public Item getCopy(){
        return new Item(count, name);
    }
}
