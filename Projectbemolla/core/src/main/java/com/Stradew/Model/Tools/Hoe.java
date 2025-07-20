package com.Stradew.Model.Tools;

import com.Stradew.Model.Enums.Skills;
import com.Stradew.Model.Enums.Tools.Hoes;
import com.badlogic.gdx.graphics.Texture;

public class Hoe extends Tools {
    public Hoes hoeType = Hoes.Normal;
    public Hoe() {
        this.Image = new Texture("Hoe/Hoe.png");
        name = "Hoe";
        count = 1;
        Id = 1;
        IsExist = true;
        EnergyCost = 5;
        skillRelated = Skills.Farming;
    }

    public Hoes getHoeType() {
        return hoeType;
    }

    public void setHoeType(Hoes hoeType) {
        this.hoeType = hoeType;
        EnergyCost = hoeType.EnergyCost;
    }
}
