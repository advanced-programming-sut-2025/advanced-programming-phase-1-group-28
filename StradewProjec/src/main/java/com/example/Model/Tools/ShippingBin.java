package com.example.Model.Tools;

import com.example.Model.Enums.Tools.ShippingBins;
import com.example.Model.Item.Item;

import java.util.ArrayList;

public class ShippingBin extends Tools{
    public int X_Coordinate , Y_Coordinate ;
    public ShippingBins ShippingBinType;
    public ArrayList<Item> ShippingBinItem;
    public ArrayList<Integer> ItemPrice;

    public ShippingBin(int x_Coordinate, int y_Coordinate, ShippingBins shippingBinType) {
        count = 1;
        name = "Shipping Bin";
        Id = 10;
        IsExist = true;
        EnergyCost = 0;
        skillRelated = null;
        X_Coordinate = x_Coordinate;
        Y_Coordinate = y_Coordinate;
        ShippingBinType = shippingBinType;
    }

    public int getX_Coordinate() {
        return X_Coordinate;
    }

    public int getY_Coordinate() {
        return Y_Coordinate;
    }

    public ShippingBins getShippingBinType() {
        return ShippingBinType;
    }

    public void setShippingBinType(ShippingBins shippingBinType) {
        ShippingBinType = shippingBinType;
    }

    public ArrayList<Item> getShippingBinItem() {
        return ShippingBinItem;
    }

    public ArrayList<Integer> getItemPrice() {
        return ItemPrice;
    }

    public void AddItem(Item item , Integer price)
    {
        ShippingBinItem.add(item);
        ItemPrice.add(price);
    }
    public void RemoveLast()
    {
        ShippingBinItem.remove(ShippingBinItem.size() - 1);
        ItemPrice.remove(ShippingBinItem.size() - 1);
    }
}
