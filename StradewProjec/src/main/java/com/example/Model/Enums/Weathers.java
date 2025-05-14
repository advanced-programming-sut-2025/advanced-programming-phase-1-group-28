package com.example.Model.Enums;

public enum Weathers {
    SUNNY(3) , RAIN(2) , STORM(1) , SNOW(1);
    public final int FishCofficent;
    Weathers(int fishCofficent) {
        FishCofficent = fishCofficent;
    }
}


