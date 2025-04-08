package Model.Enums;

import Model.Skill;

import java.util.ArrayList;
import java.util.Arrays;

public enum Crafts {
    apple("mamad" , "mamad" , new ArrayList<>(Arrays.asList("mamad")) , Skills.Farming , 1 , 1);
    public final String Name;
    public final String Descritionas;
    public final ArrayList<String> Ingredients;
    public final Skills skill;
    public final int level;
    public final int SellPrice;

    Crafts(String name, String descritionas, ArrayList<String> ingredients, Skills skill, int level, int sellPrice) {
        Name = name;
        Descritionas = descritionas;
        Ingredients = ingredients;
        this.skill = skill;
        this.level = level;
        SellPrice = sellPrice;
    }
}
