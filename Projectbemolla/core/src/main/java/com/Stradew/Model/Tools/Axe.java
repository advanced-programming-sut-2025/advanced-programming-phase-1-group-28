package com.Stradew.Model.Tools;

import com.Stradew.Model.Enums.Skills;
import com.Stradew.Model.Enums.Tools.Axes;
import com.badlogic.gdx.graphics.Texture;

public class Axe extends Tools{
    public Axes axeType = Axes.Normal;
    public Axe() {
        Image = new Texture("Tools/Axe/Axe.png");
        name = "Axe";
        count = 1;
        Id = 3;
        EnergyCost = 5;
        IsExist = true;
        skillRelated = Skills.Foraging;
    }

    public Axes getAxeType() {
        return axeType;
    }

    public void setAxeType(Axes axeType) {
        this.axeType = axeType;
        EnergyCost = axeType.EnergyCost;
    }
}
