package Model;

import Model.Enums.Stores;

import java.util.ArrayList;
import java.util.Arrays;

public class Store {
    private Stores store;
    private ArrayList<Integer> Quantity;

    public Store(Stores store, ArrayList<Integer> quantity) {
        this.store = store;
        Quantity = quantity;
    }

    public Stores getStore() {
        return store;
    }

    public void setStore(Stores store) {
        this.store = store;
    }

    public ArrayList<Integer> getQuantity() {
        return Quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        Quantity = quantity;
    }
}
