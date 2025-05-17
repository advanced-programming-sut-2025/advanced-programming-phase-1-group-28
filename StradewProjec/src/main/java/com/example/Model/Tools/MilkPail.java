package com.example.Model.Tools;

import com.example.Model.Enums.Skills;
import com.example.Model.Enums.Tools.MilkPails;

public class MilkPail extends Tools{
    MilkPails milkPailType;
    public MilkPail(MilkPails milkPailType) {
        name = "MilkPail";
        count = 1;
        IsExist = true;
        Id = 7;
        skillRelated = Skills.Farming;
        EnergyCost = milkPailType.EnergyCost;
        this.milkPailType = milkPailType;
    }

    public MilkPails getMilkPailType() {
        return milkPailType;
    }

    public void setMilkPailType(MilkPails milkPailType) {
        this.milkPailType = milkPailType;
        EnergyCost = milkPailType.EnergyCost;
    }
}