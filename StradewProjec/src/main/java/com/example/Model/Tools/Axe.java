package com.example.Model.Tools;

import com.example.Model.Enums.Skills;
import com.example.Model.Enums.Tools.Axes;

public class Axe extends Tools{
    public Axes axeType = Axes.Normal;
    public Axe() {
        name = "Axe";
        count = 1;
        Id = 3;
        EnergyCost = 5;
        IsExist = true;
        skillRelated = Skills.Foraging;
    }

    public Axes getAxeType() {
        return axeType;
    }

    public void setAxeType(Axes axeType) {
        this.axeType = axeType;
        EnergyCost = axeType.EnergyCost;
    }
}
