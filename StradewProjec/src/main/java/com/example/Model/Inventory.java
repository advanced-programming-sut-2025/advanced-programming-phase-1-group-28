package com.example.Model;

import com.example.Model.Enums.Saplings;
import com.example.Model.Enums.Seeds;
import com.example.Model.Item.Item;
import com.example.Model.Tools.Tools;

import java.util.ArrayList;

public class Inventory {
    //Fill the Inventory with our Tools
    private int inventoryCapacity = 12;
    private int WhichTool;
    private ArrayList<Tools> tools = new ArrayList<>();
    private Tools CurrentTool;
    private Item CurrentItem;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Seeds> seeds = new ArrayList<>();
    private ArrayList<Saplings> saplings = new ArrayList<>();

    public Inventory() {
        WhichTool = 0;
    }

    public void AddItem(Item item) {
        boolean IsHere = false;
        for(int i = 0;i < this.items.size();i++) {
            if(item.getName().equals(this.items.get(i).getName())) {
                this.items.get(i).setCount(this.items.get(i).getCount() + item.getCount());
                IsHere = true;
            }
        }
        //Check Limit of Items Count
        //ToDo
        if(!IsHere) {
            this.items.add(item);
        }
    }

    public ArrayList<Seeds> getSeeds() {
        return seeds;
    }

    public void setSeeds(ArrayList<Seeds> seeds) {
        this.seeds = seeds;
    }

    public void setCurrentTool(Tools currentTool) {
        CurrentTool = currentTool;
    }

    public void setCurrentItem(Item currentItem) {
        CurrentItem = currentItem;
    }

    public Item getCurrentItem() {
        return CurrentItem;
    }

    public Tools getCurrentTool() {
        return CurrentTool;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getInventoryCapacity() {
        return inventoryCapacity;
    }

    public void setInventoryCapacity(int inventoryCapacity) {
        this.inventoryCapacity = inventoryCapacity;
    }

    public int getWhichTool() {
        return WhichTool;
    }

    public void setWhichTool(int whichTool) {
        WhichTool = whichTool;
    }

    public ArrayList<Tools> getTools() {
        return tools;
    }

    public void setTools(ArrayList<Tools> tools) {
        this.tools = tools;
    }

    public Item getItemByName(String name){
        for (Item item: items){
            if (item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public boolean canAddNewItem(){
        return items.size() + tools.size() + seeds.size() + saplings.size() < inventoryCapacity;
    }

    public boolean isItemAvailable(String itemName){
        if (this.getItemByName(itemName) == null){
            return false;
        }
        return true;
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public void increaseItemQuantity(Item item, int count){
        Item myItem = getItemByName(item.getName());
        myItem.addCount(count);
    }

    public void addTool(Tools tool){
        this.tools.add(tool);
    }

    public ArrayList<Saplings> getSaplings() {
        return saplings;
    }

    public void setSaplings(ArrayList<Saplings> saplings) {
        this.saplings = saplings;
    }
}