package com.example.Model.Enums;

public enum Plants {
    BlueJazz("a" , "a" , "a" , 1 , false , 1 ,1 , true , 1 , "mamad" , true);
    public final String Name;
    public final String Source;
    public final String stage;
    public final int TotalTimeHarvest;
    public final boolean OnTime;
    public final int RegrowthTime;
    public final int BasePrice;
    public final boolean IsEdible;
    public final int energy;
    public final String season;
    public final boolean CanBecomeGiant;
    Plants(String name, String source, String stage, int totalTimeHarvest, boolean onTime, int regrowthTime, int basePrice, boolean isEdible, int energy, String season, boolean canBecomeGiant) {
        Name = name;
        Source = source;
        this.stage = stage;
        TotalTimeHarvest = totalTimeHarvest;
        OnTime = onTime;
        RegrowthTime = regrowthTime;
        BasePrice = basePrice;
        IsEdible = isEdible;
        this.energy = energy;
        this.season = season;
        CanBecomeGiant = canBecomeGiant;
    }
}
