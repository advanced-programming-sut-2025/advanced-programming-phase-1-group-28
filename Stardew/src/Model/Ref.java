package Model;

import Model.Enums.Foods;
import Model.Item.Item;

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
