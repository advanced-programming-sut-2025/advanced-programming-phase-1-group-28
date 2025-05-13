package com.example.Model.Tools;

import com.example.Model.Enums.Skills;
import com.example.Model.Enums.Tools.Pickaxes;

public class Pickaxe extends Tools {
    private Pickaxes PickaxeType;
    public Pickaxe(Pickaxes PickaxeType) {
        name = "Pickaxe";
        count = 1;
        Id = 2;
        IsExist = true;
        EnergyCost = 5;
        skillRelated = Skills.Mining;
        this.PickaxeType = PickaxeType;
    }

    public Pickaxes getPickaxeType() {
        return PickaxeType;
    }

    public void setPickaxeType(Pickaxes pickaxeType) {
        EnergyCost = pickaxeType.EnergyCost;
        PickaxeType = pickaxeType;
    }
}
