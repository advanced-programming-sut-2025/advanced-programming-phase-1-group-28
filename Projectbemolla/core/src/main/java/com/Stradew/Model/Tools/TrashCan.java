package com.Stradew.Model.Tools;

import com.Stradew.Model.Enums.Tools.Trashcans;

public class TrashCan extends Tools{
    private Trashcans trashcan = Trashcans.Normal;
    public TrashCan() {
        name = "TrashCan";
        count = 1;
        IsExist = true;
        Id = 9;
        EnergyCost = 0;
    }

    public Trashcans getTrashcan() {
        return trashcan;
    }

    public void setTrashcan(Trashcans trashcan) {
        this.trashcan = trashcan;
    }
}
