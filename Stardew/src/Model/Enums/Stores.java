package Model.Enums;

import Model.Item.Item;

import java.util.ArrayList;
import java.util.Arrays;

public enum Stores {
    FishShop("mamad" , "mamad" , new ArrayList<Item>(Arrays.asList(new Item(1,"mamad"))) , 1 , 1);
    public final String name;
    public final String OwnerName;
    public final ArrayList<Item> Products;
    public final int StartDayHour;
    public final int EndDayHour;

    Stores(String name, String ownerName,ArrayList<Item> Products,int startDayHour, int endDayHour) {
        this.name = name;
        this.Products = Products;
        OwnerName = ownerName;
        StartDayHour = startDayHour;
        EndDayHour = endDayHour;
    }
}
