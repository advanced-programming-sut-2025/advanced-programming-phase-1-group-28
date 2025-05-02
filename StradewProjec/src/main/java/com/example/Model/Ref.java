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

    public Item findItem(Item item){
        for (Item item1: items){
            if (item1.getName().equals(item.getName())){
                return item1;
            }
        }
        return null;
    }

    public void AddItem(Item item){
        Item newItem = findItem(item);
        if (newItem != null){
            newItem.addCount(1);
            return;
        }
        newItem = item.getCopy();
        newItem.setCount(1);
        items.add(newItem);
    }

    public Item pickItemByName(String name){
        for (Item item: items){
            if (item.getName().equals(name)){
                item.addCount(-1);
                return item.getCopy();
            }
        }
        return null;
    }
}
