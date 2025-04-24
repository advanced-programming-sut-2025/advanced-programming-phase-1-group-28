package com.example.Model.Item;

public class Item {
    private int count = 0;
    private String Quality;

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
}
