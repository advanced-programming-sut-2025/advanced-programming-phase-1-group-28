package com.Stradew.Model.Tools;

import com.Stradew.Model.Enums.Skills;
import com.Stradew.Model.Enums.Tools.FishingPoles;
import com.badlogic.gdx.graphics.Texture;

public class FishingPole extends Tools{
    FishingPoles fishingPole;
    public FishingPole(FishingPoles fishingPole){
        Image = new Texture("Fishing_Pole/Bamboo_Pole.png");
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
