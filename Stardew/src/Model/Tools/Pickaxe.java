package Model.Tools;

import Model.Enums.Skills;

public class Pickaxe extends Tools {
    public Pickaxe() {
        name = "Pickaxe";
        count = 1;
        Id = 2;
        IsExist = true;
        EnergyCost = 5;
        skillRelated = Skills.Mining;
    }
}
