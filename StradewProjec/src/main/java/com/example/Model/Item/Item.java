package com.example.Model.Item;

public class Item {
    protected String name;
    protected int count = 0;

    public Item(int count, String name) {
        this.count = count;
        this.name = name;
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
