package com.Stradew.Model;

import com.Stradew.Model.Item.Item;

public class Trade {
    String sender;
    String type;
    int amount;
    Item offerItem;
    int price;
    String targetItemName;
    int targetAmount;
    boolean accept;
    String GiverName;
    String ItemName;

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getGiverName() {
        return GiverName;
    }

    public void setGiverName(String giverName) {
        GiverName = giverName;
    }

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

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}
