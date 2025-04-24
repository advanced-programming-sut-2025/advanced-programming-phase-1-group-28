package com.example.Model.Tools;

import com.example.Model.Enums.Skills;

public class Axe extends Tools{
    public Axe() {
        name = "Axe";
        count = 1;
        Id = 3;
        EnergyCost = 5;
        IsExist = true;
        skillRelated = Skills.Foraging;
    }
}
