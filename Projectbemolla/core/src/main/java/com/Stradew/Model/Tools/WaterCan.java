package com.Stradew.Model.Tools;

import com.Stradew.Model.Enums.Skills;
import com.Stradew.Model.Enums.Tools.Watercans;
import com.badlogic.gdx.graphics.Texture;

public class WaterCan extends Tools{
    private int Water = 5;
    private Watercans watercan;

    public Watercans getWatercan() {
        return watercan;
    }

    public void setWatercan(Watercans watercan) {
        this.watercan = watercan;
        EnergyCost = watercan.EnergyCost;
    }

    public int getWater() {
        return Water;
    }

    public void setWater(int water) {
        Water = water;
    }

    public WaterCan(Watercans watercan , int count)
    {
        this.watercan = watercan;
        EnergyCost = watercan.EnergyCost;
        name = "WaterCan";
        Image = new Texture("Watering_Can/Watering_Can.png");
        this.count = count;
        IsExist = true;
        Id = 4;
        skillRelated = Skills.Farming;
    }
}
