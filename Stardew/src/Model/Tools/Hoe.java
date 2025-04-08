package Model.Tools;

import Model.Enums.Skills;

import javax.tools.Tool;

public class Hoe extends Tools {
    public Hoe() {
        name = "Hoe";
        count = 1;
        Id = 1;
        IsExist = true;
        EnergyCost = 5;
        skillRelated = Skills.Farming;
    }
}
