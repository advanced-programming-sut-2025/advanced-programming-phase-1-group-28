package com.example.Model.Enums;

public enum MapColors {
    Reset("\u001B[0m"),
    RED("\u001B[31m"),
    Green("\u001B[32m"),
    Blue("\u001B[34m");
    public final String Colorname;
    MapColors(String colorname) {
        Colorname = colorname;
    }
}
