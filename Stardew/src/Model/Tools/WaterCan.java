package Model.Tools;

import Model.Enums.Skills;

public class WaterCan extends Tools{
    public WaterCan()
    {
        EnergyCost = 5;
        name = "WaterCan";
        count = 1;
        IsExist = true;
        Id = 4;
        skillRelated = Skills.Farming;
    }
}
