package com.Stradew.Model.Tools;

import com.Stradew.Model.Enums.Skills;
import com.Stradew.Model.Enums.Tools.Watercans;

public class WaterCan extends Tools{
    private int Water = 0;
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
        this.count = count;
        IsExist = true;
        Id = 4;
        skillRelated = Skills.Farming;
    }
}