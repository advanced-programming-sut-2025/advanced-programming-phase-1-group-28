package Model.Tools;

import Model.Enums.Skills;

public class MilkPail extends Tools{
    public MilkPail() {
        name = "MilkPail";
        count = 0;
        IsExist = false;
        Id = 7;
        skillRelated = Skills.Farming;
        EnergyCost = 4;
    }
}
