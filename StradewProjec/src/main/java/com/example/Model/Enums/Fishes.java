package com.example.Model.Enums;

public enum Fishes {
    SALMON("Fall", 75, false),
    SARDINE("Fall", 40, false),
    SHAD("Fall", 60, false),
    BLUE_DISCUS("Fall", 120, false),

    MIDNIGHT_CARP("Winter", 150, false),
    SQUID("Winter", 80, false),
    TUNA("Winter", 100, false),
    PERCH("Winter", 55, false),

    FLOUNDER("Spring", 100, false),
    LIONFISH("Spring", 100, false),
    HERRING("Spring", 30, false),
    GHOSTFISH("Spring", 45, false),

    TILAPIA("Summer", 75, false),
    DORADO("Summer", 100, false),
    SUNFISH("Summer", 30, false),
    RAINBOW_TROUT("Summer", 65, false),

    LEGEND("Spring" , 5000 , true),
    GLACIERFISH("Winter", 1000, true),
    ANGLER("Fall", 900, true),
    CRIMSONFISH("Summer", 1500, true);

    public final String season;
    public final int price;
    public final boolean legendary;

    Fishes(String season, int price, boolean legendary) {
        this.season = season;
        this.price = price;
        this.legendary = legendary;
    }

    public String getSeason() {
        return season;
    }

    public int getPrice() {
        return price;
    }

    public boolean isLegendary() {
        return legendary;
    }

}
