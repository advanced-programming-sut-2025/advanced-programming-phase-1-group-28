package com.Stradew.Model.Enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum MixedSeeds {
    Spring(Season.SPRING , new ArrayList<>(Arrays.asList(com.Stradew.Model.Enums.Plants.PARSNIP , com.Stradew.Model.Enums.Plants.CAULIFLOWER , com.Stradew.Model.Enums.Plants.POTATO, com.Stradew.Model.Enums.Plants.BLUE_JAZZ , com.Stradew.Model.Enums.Plants.TULIP))),
    Summer(Season.SUMMER , new ArrayList<>(Arrays.asList(com.Stradew.Model.Enums.Plants.CORN , com.Stradew.Model.Enums.Plants.HOT_PEPPER , com.Stradew.Model.Enums.Plants.RADISH , com.Stradew.Model.Enums.Plants.WHEAT , com.Stradew.Model.Enums.Plants.POPPY , com.Stradew.Model.Enums.Plants.SUNFLOWER , com.Stradew.Model.Enums.Plants.SUMMER_SPANGLE))),
    Fall(Season.FALL , new ArrayList<>(Arrays.asList(com.Stradew.Model.Enums.Plants.ARTICHOKE , com.Stradew.Model.Enums.Plants.CORN , com.Stradew.Model.Enums.Plants.EGGPLANT , com.Stradew.Model.Enums.Plants.PUMPKIN , com.Stradew.Model.Enums.Plants.SUNFLOWER , com.Stradew.Model.Enums.Plants.FAIRY_ROSE))),
    Winter(Season.WINTER ,new ArrayList<>(Arrays.asList(com.Stradew.Model.Enums.Plants.POWDERMELON)));

    public final Season season;
    public final ArrayList<Plants> Plants;

    MixedSeeds(Season season , ArrayList<com.Stradew.Model.Enums.Plants> plants) {
        this.season = season;
        Plants = plants;
    }

}
