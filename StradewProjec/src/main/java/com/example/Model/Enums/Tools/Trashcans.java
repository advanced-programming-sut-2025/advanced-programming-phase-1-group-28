package com.example.Model.Enums.Tools;

public enum Trashcans {
    Normal(0 , 0),
    Copper(15 , 1),
    Iron(30 , 2),
    Gold(45 , 3),
    Iridium(60 , 4);
    public final int ReturnPercentage;
    public final int Level;
    Trashcans(int returnPercentage , int level) {
        ReturnPercentage = returnPercentage;
        Level = level;
    }
}
