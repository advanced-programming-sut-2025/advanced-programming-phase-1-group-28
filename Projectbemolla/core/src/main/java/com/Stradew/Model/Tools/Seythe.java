package com.Stradew.Model.Tools;

import com.Stradew.Model.Enums.Skills;
import com.Stradew.Model.Enums.Tools.Seythes;
import com.badlogic.gdx.graphics.Texture;

public class Seythe extends Tools{
    private Seythes SeythesType;
    public Seythe(Seythes SeythesType) {
        Image  = new Texture("Tools/Scythe.png");
        this.SeythesType = SeythesType;
        name = "Seythe";
        count = 1;
        IsExist = true;
        EnergyCost = SeythesType.EnergyCost;
        Id = 6;
        skillRelated = Skills.Farming;
    }

    public Seythes getSeythesType() {
        return SeythesType;
    }

    public void setSeythesType(Seythes seythesType) {
        EnergyCost = seythesType.EnergyCost;
        SeythesType = seythesType;
    }
}
