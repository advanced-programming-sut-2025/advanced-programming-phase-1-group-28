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
}
