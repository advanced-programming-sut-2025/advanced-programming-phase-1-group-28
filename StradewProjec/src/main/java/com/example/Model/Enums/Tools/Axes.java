package com.example.Model.Enums.Tools;

public enum Axes {
    Normal(5 , 0),
    Copper(4 , 1),
    Iron(3 , 2),
    Gold(2 , 3),
    Iridium(1 , 4);
    public final int EnergyCost;
    public final int Level;
    Axes(int energyCost , int level) {
        EnergyCost = energyCost;
        Level = level;
    }
}