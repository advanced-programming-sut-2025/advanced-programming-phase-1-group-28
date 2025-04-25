package com.example.Model.Item;

public class Item {
    protected String name;
    protected int count = 0;
    protected String Quality;

    public Item(int count, String quality) {
        this.count = count;
        Quality = quality;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getQuality() {
        return Quality;
    }

    public void setQuality(String quality) {
        Quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
