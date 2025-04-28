package com.example.Model;

import com.example.Model.Item.Item;
import com.example.Model.Tools.Pepolee;

public class Gift {
    int count;
    Pepolee sender;
    Item item;
    boolean isMarriageRing = false;

    public Gift(int count, Pepolee sender, Item item) {
        this.count = count;
        this.sender = sender;
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Pepolee getSender() {
        return sender;
    }

    public void setSender(Pepolee sender) {
        this.sender = sender;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isMarriageRing() {
        return isMarriageRing;
    }

    public void setMarriageRing(boolean marriageRing) {
        isMarriageRing = marriageRing;
    }
}
