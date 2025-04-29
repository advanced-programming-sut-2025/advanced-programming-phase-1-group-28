package com.example.Model;

import com.example.Model.Item.Item;
import com.example.Model.Tools.Tools;
import java.util.ArrayList;

public class Inventory {
    //Fill the Inventory with our Tools
    private int WhichTool;
    private ArrayList<Tools> tools = new ArrayList<>();
    private Tools CurrentTool;
    private Item CurrentItem;

    public Inventory() {
        WhichTool = 0;
    }

    private ArrayList<Item> items = new ArrayList<>();

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
}