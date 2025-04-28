package com.example.Model.Tools;

import com.example.Model.Enums.Tools.Trashcans;

public class TrashCan extends Tools{
    public Trashcans trashcan = Trashcans.Normal;
    public TrashCan() {
        name = "TrashCan";
        count = 1;
        IsExist = true;
        Id = 9;
        EnergyCost = 0;
    }
}
