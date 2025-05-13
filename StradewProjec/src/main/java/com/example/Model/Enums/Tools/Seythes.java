package com.example.Model.Enums.Tools;

public enum Seythes {
    Normal(1, "Defualt" , 5),
    Copper(2, "Copper" , 4),
    Iron(3 , "Iron" , 3),
    Gold(4 , "Gold", 2),
    Iridium(5 , "Iridium", 1);
    public final int Level;
    public final String name;
    public final int EnergyCost;
    Seythes(int Level , String name, int energyCost) {
        this.Level = Level;
        this.name = name;
        EnergyCost = energyCost;
    }
}
