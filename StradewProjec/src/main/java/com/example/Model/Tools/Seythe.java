package com.example.Model.Tools;

import com.example.Model.Enums.Skills;
import com.example.Model.Enums.Tools.Seythes;

public class Seythe extends Tools{
    private Seythes SeythesType;
    public Seythe(Seythes SeythesType) {
        this.SeythesType = SeythesType;
        name = "Seythe";
        count = 1;
        IsExist = true;
        EnergyCost = SeythesType.EnergyCost;
        Id = 6;
        skillRelated = Skills.Farming;
    }

    public Seythes getSeythesType() {
        return SeythesType;
    }

    public void setSeythesType(Seythes seythesType) {
        EnergyCost = seythesType.EnergyCost;
        SeythesType = seythesType;
    }
}