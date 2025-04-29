package com.example.Model;

import com.example.Model.Item.Item;

public class Trade {
    String sender;
    String type;
    int amount;
    Item offerItem;
    int price;
    String targetItemName;
    int targetAmount;

    public Trade(String sender, String type, int amount, Item offerItem, int price, String targetItemName, int targetAmount) {
        this.sender = sender;
        this.type = type;
        this.amount = amount;
        this.offerItem = offerItem;
        this.price = price;
        this.targetItemName = targetItemName;
        this.targetAmount = targetAmount;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Item getOfferItem() {
        return offerItem;
    }

    public void setOfferItem(Item offerItem) {
        this.offerItem = offerItem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(int targetAmount) {
        this.targetAmount = targetAmount;
    }

    public String getTargetItemName() {
        return targetItemName;
    }

    public void setTargetItemName(String targetItemName) {
        this.targetItemName = targetItemName;
    }
}
