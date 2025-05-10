package com.example.Model;

import com.example.Model.Item.Item;

import java.util.ArrayList;

public class Ref {
    private ArrayList<Item> items = new ArrayList<>();

    public Ref() {
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


    public Item getItem(String itemName){
        for (Item item1: items){
            if (item1.getName().equals(itemName)){
                return item1;
            }
        }
        return null;
    }

    public void AddItem(Item item){
        Item newItem = getItem(item.getName());
        if (newItem != null){
            newItem.addCount(item.getCount());
            return;
        }
        newItem = item.getCopy();
        items.add(newItem);
    }

    public Item pickItemByName(String name){
        for (Item item: items){
            if (item.getName().equals(name)){
                Item copy = item.getCopy();
                items.remove(item);
                return copy;
            }
        }
        return null;
    }

    public boolean isItemAvailable(String itemName){
        if (this.pickItemByName(itemName) == null){
            return false;
        }
        return true;
    }
}
