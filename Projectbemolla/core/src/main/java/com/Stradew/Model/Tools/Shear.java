package com.Stradew.Model.Tools;

import com.Stradew.Model.Enums.Skills;
import com.Stradew.Model.Enums.Tools.Shears;
import com.badlogic.gdx.graphics.Texture;

public class Shear extends Tools{
    private Shears shearType;
    public Shear(Shears shearType) {
        Image = new Texture("Tools/Shears.png");
        name = "Shear";
        count = 0;
        IsExist = false;
        skillRelated = Skills.Farming;
        Id = 8;
        EnergyCost = shearType.EnergyCost;
        this.shearType = shearType;
    }

    public Shears getShearType() {
        return shearType;
    }

    public void setShearType(Shears shearType) {
        EnergyCost = shearType.EnergyCost;
        this.shearType = shearType;
    }
}
