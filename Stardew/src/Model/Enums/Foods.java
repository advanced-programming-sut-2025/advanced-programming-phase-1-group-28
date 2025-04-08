package Model.Enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum Foods {
    Pizza("mamad" , new ArrayList<>(Arrays.asList("mamad")) , 1 , "mamad" , 1);
    public final String Name;
    public final ArrayList<String> Ingredient;
    public final int Energy;
    //public final int Buff;
    public final String Source;
    public final int SellPrice;

    Foods(String Name , ArrayList<java.lang.String> ingredient, int energy, java.lang.String source, int sellPrice) {
        this.Name = Name;
        Ingredient = ingredient;
        Energy = energy;
        Source = source;
        SellPrice = sellPrice;
    }
}
