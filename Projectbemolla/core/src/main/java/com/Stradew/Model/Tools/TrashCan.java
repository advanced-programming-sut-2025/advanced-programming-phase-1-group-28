package com.Stradew.Model.Tools;

import com.Stradew.Model.Enums.Tools.Trashcans;
import com.badlogic.gdx.graphics.Texture;

public class TrashCan extends Tools{
    private Trashcans trashcan = Trashcans.Normal;
    public TrashCan() {
        Image = new Texture("Tools/Trash_Can_Steel.png");
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
