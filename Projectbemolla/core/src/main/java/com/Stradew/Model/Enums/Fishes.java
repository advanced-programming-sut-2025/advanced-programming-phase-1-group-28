package com.Stradew.Model.Enums;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public enum Fishes {
    SALMON(Season.FALL, 75, false , new Texture(Gdx.files.internal("Fish/Salmon.png")) ),
    SARDINE(Season.FALL, 40, false , new Texture(Gdx.files.internal("Fish/Sardine.png"))),
    SHAD(Season.FALL, 60, false , new Texture(Gdx.files.internal("Fish/Shad.png"))),
    BLUE_DISCUS(Season.FALL, 120, false , new Texture(Gdx.files.internal("Fish/Blue_Discus.png"))),

    MIDNIGHT_CARP(Season.WINTER, 150, false, new Texture(Gdx.files.internal("Fish/Midnight_Carp.png"))),
    SQUID(Season.WINTER, 80, false , new Texture(Gdx.files.internal("Fish/Squid.png"))),
    TUNA(Season.WINTER, 100, false , new Texture(Gdx.files.internal("Fish/Tuna.png"))),
    PERCH(Season.WINTER, 55, false , new Texture(Gdx.files.internal("Fish/Perch.png"))),

    FLOUNDER(Season.SPRING, 100, false ,new Texture(Gdx.files.internal("Fish/Flounder.png")) ),
    LIONFISH(Season.SPRING, 100, false , new Texture(Gdx.files.internal("Fish/Lionfish.png"))),
    HERRING(Season.SPRING, 30, false , new Texture(Gdx.files.internal("Fish/Herring.png"))),
    GHOSTFISH(Season.SPRING, 45, false , new Texture(Gdx.files.internal("Fish/Ghostfish.png"))),

    TILAPIA(Season.SUMMER, 75, false  , new Texture(Gdx.files.internal("Fish/Tilapia.png"))),
    DORADO(Season.SUMMER, 100, false , new Texture(Gdx.files.internal("Fish/Dorado.png"))),
    SUNFISH(Season.SUMMER, 30, false , new Texture(Gdx.files.internal("Fish/Sunfish.png"))),
    RAINBOW_TROUT(Season.SUMMER, 65, false , new Texture(Gdx.files.internal("Fish/Blobfish.png"))),

    LEGEND(Season.SPRING , 5000 , true ,new Texture(Gdx.files.internal("Fish/Legend.png"))),
    GLACIERFISH(Season.WINTER, 1000, true , new Texture(Gdx.files.internal("Fish/Glacierfish.png"))),
    ANGLER(Season.FALL, 900, true , new Texture(Gdx.files.internal("Fish/Angler.png"))),
    CRIMSONFISH(Season.SUMMER, 1500, true , new Texture(Gdx.files.internal("Fish/Crimsonfish.png"))),;


    public final Season season;
    public final int price;
    public final boolean legendary;
    public final Texture Image;


    Fishes(Season season, int price, boolean legendary , Texture Image) {
        this.season = season;
        this.price = price;
        this.legendary = legendary;
        this.Image = Image;
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
