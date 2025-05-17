package com.example.Model.Enums.Tools;

public enum ShippingBins {
    Regular(1 , 1),
    Silver(2 , 1.25),
    Gold(3 , 1.5),
    Iridium(4 , 2);
    public final int level;
    public final double coefficient;
    ShippingBins(int level, double coefficient) {
        this.level = level;
        this.coefficient = coefficient;
    }
}
