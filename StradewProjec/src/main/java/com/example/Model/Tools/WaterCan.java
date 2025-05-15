package com.example.Model.Tools;

import com.example.Model.Enums.Skills;
import com.example.Model.Enums.Tools.Watercans;

public class WaterCan extends Tools{
    private int Water = 0;
    private Watercans watercan;

    public Watercans getWatercan() {
        return watercan;
    }

    public void setWatercan(Watercans watercan) {
        this.watercan = watercan;
    }

    public int getWater() {
        return Water;
    }

    public void setWater(int water) {
        Water = water;
    }

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
