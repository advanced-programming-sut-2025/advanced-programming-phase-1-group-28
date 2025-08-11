package com.Stradew.Model.Enums;

import com.badlogic.gdx.graphics.Texture;

public enum Minerals {
    Quartz(25 , new Texture("Mineral/Quartz.png")),
    EarthCrystal(50 , new Texture("Mineral/Earth_Crystal.png")),
    FrozenTear(75 , new Texture("Mineral/Frozen_Tear.png")),
    FireQuartz(100 , new Texture("Mineral/Fire_Quartz.png")),
    Emerald(250 , new Texture("Mineral/Fire_Quartz.png")),
    AquaMarine(180 , new Texture("Mineral/Fire_Quartz.png")),
    Ruby(250 , new Texture("Mineral/Fire_Quartz.png")),
    Amethyst(100 , new Texture("Mineral/Fire_Quartz.png")),
    Topaz(80 ,new Texture("Mineral/Fire_Quartz.png")),
    Jade(200 , new Texture("Mineral/Fire_Quartz.png")),
    Diamond(750 , new Texture("Mineral/Fire_Quartz.png")),
    PrismaticShine(2000 , new Texture("Mineral/Fire_Quartz.png")),
    Cooper(5 , new Texture("Crafting/Copper_Bar.png")),
    Iron(10 , new Texture("Crafting/Iron_Bar.png")),
    Gold(25 , new Texture("Crafting/Gold.png")),
    Iridium(100 , new Texture("Crafting/Iridium_Bar.png")),
    Coal(15 , new Texture("Crafting/Coal.png"));
    public final int Cost;

    public final Texture image;
    //public final String MineralPicture;
    Minerals(int cost , Texture image ) {
        Cost = cost;
        //this.MineralPicture = mineralPicture;
        this.image = image;
    }
}
