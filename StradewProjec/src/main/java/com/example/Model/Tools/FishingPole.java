package com.example.Model.Tools;

import com.example.Model.Enums.Skills;
import com.example.Model.Enums.Tools.FishingPoles;

public class FishingPole extends Tools{
    FishingPoles fishingPole;
    public FishingPole(FishingPoles fishingPole){
        name = "FishingPole";
        count = 1;
        IsExist = true;
        Id = 5;
        skillRelated = Skills.Fishing;
        this.fishingPole = fishingPole;
        EnergyCost = fishingPole.Energycost;
    }

    public FishingPoles getFishingPole() {
        return fishingPole;
    }

    public void setFishingPole(FishingPoles fishingPole) {
        this.fishingPole = fishingPole;
    }
}
