package com.example.Model.Enums.Tools;

public enum Trashcans {
    Normal(0),
    Bronze(15),
    Iron(30),
    Gold(45),
    Iridium(60);
    public final int ReturnPercentage;
    Trashcans(int returnPercentage) {
        ReturnPercentage = returnPercentage;
    }
}
