package com.example.Model.Enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum MixedSeeds {
    Spring(Season.SPRING , new ArrayList<>(Arrays.asList(com.example.Model.Enums.Plants.PARSNIP , com.example.Model.Enums.Plants.CAULIFLOWER , com.example.Model.Enums.Plants.POTATO, com.example.Model.Enums.Plants.BLUE_JAZZ , com.example.Model.Enums.Plants.TULIP))),
    Summer(Season.SUMMER , new ArrayList<>(Arrays.asList(com.example.Model.Enums.Plants.CORN , com.example.Model.Enums.Plants.HOT_PEPPER , com.example.Model.Enums.Plants.RADISH , com.example.Model.Enums.Plants.WHEAT , com.example.Model.Enums.Plants.POPPY , com.example.Model.Enums.Plants.SUNFLOWER , com.example.Model.Enums.Plants.SUMMER_SPANGLE))),
    Fall(Season.FALL , new ArrayList<>(Arrays.asList(com.example.Model.Enums.Plants.ARTICHOKE , com.example.Model.Enums.Plants.CORN , com.example.Model.Enums.Plants.EGGPLANT , com.example.Model.Enums.Plants.PUMPKIN , com.example.Model.Enums.Plants.SUNFLOWER , com.example.Model.Enums.Plants.FAIRY_ROSE))),
    Winter(Season.WINTER ,new ArrayList<>(Arrays.asList(com.example.Model.Enums.Plants.POWDERMELON)));

    public final Season season;
    public final ArrayList<Plants> Plants;

    MixedSeeds(Season season , ArrayList<com.example.Model.Enums.Plants> plants) {
        this.season = season;
        Plants = plants;
    }

}
