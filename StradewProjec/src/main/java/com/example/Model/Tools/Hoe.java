package com.example.Model.Tools;

import com.example.Model.Enums.Skills;

public class Hoe extends Tools {
    public Hoe() {
        name = "Hoe";
        count = 1;
        Id = 1;
        IsExist = true;
        EnergyCost = 5;
        skillRelated = Skills.Farming;
    }
}
