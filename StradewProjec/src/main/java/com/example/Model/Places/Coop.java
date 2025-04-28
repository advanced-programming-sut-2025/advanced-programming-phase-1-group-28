package com.example.Model.Places;

public class Coop extends Place{
    private String CoopType;
    private int Capacity;
    public Coop(int x , int y , String CoopType , int Capacity) {
        X_Coordinate = x;
        Y_Coordinate = y;
        this.CoopType = CoopType;
        this.Capacity = Capacity;
    }

    public String getCoopType() {
        return CoopType;
    }

    public void setCoopType(String coopType) {
        CoopType = coopType;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }
}
