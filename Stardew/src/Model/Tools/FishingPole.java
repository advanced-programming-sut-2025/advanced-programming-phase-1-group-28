package Model.Tools;

import Model.Enums.Skills;

public class FishingPole extends Tools{
    public FishingPole(){
        name = "FishingPole";
        count = 0;
        IsExist = false;
        Id = 5;
        skillRelated = Skills.Fishing;
        EnergyCost = 8;
    }
}
