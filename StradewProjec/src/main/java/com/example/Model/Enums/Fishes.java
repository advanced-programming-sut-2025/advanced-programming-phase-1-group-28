package com.example.Model.Enums;

public enum Fishes {
    SALMON(Season.FALL, 75, false),
    SARDINE(Season.FALL, 40, false),
    SHAD(Season.FALL, 60, false),
    BLUE_DISCUS(Season.FALL, 120, false),

    MIDNIGHT_CARP(Season.WINTER, 150, false),
    SQUID(Season.WINTER, 80, false),
    TUNA(Season.WINTER, 100, false),
    PERCH(Season.WINTER, 55, false),

    FLOUNDER(Season.SPRING, 100, false),
    LIONFISH(Season.SPRING, 100, false),
    HERRING(Season.SPRING, 30, false),
    GHOSTFISH(Season.SPRING, 45, false),

    TILAPIA(Season.SUMMER, 75, false),
    DORADO(Season.SUMMER, 100, false),
    SUNFISH(Season.SUMMER, 30, false),
    RAINBOW_TROUT(Season.SUMMER, 65, false),

    LEGEND(Season.SPRING , 5000 , true),
    GLACIERFISH(Season.WINTER, 1000, true),
    ANGLER(Season.FALL, 900, true),
    CRIMSONFISH(Season.SUMMER, 1500, true);

    public final Season season;
    public final int price;
    public final boolean legendary;

    Fishes(Season season, int price, boolean legendary) {
        this.season = season;
        this.price = price;
        this.legendary = legendary;
    }

    public Season getSeason() {
        return season;
    }

    public int getPrice() {
        return price;
    }

    public boolean isLegendary() {
        return legendary;
    }

}
