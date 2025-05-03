package com.example.Model.Enums.Tools;

public enum Watercans {
    Normal(40 , 5),
    Copper(55 , 4),
    Iron(70 , 3),
    Gold(85 , 2),
    Iridium(100 , 1);
    public final int Limit;
    public final int EnergyCost;

    Watercans(int limit, int energyCost) {
        Limit = limit;
        EnergyCost = energyCost;
    }
}
