package Model;

import Model.Item.Item;
import Model.Tools.Tools;
import java.util.ArrayList;

public class Inventory {
    //Fill the Inventory with our Tools
    private int WhichTool;
    private ArrayList<Tools> tools = new ArrayList<>();

    public Inventory() {
        WhichTool = 0;
    }

    private ArrayList<Item> items = new ArrayList<>();

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
}
