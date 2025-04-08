package Model.Tools;

import Model.Enums.Skills;

public class Shear extends Tools{
    public Shear() {
        name = "Shear";
        count = 0;
        IsExist = false;
        skillRelated = Skills.Farming;
        Id = 8;
        EnergyCost = 4;
    }
}
