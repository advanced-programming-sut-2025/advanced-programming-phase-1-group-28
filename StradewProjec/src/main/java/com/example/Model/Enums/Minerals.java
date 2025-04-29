package com.example.Model.Enums;

public enum Minerals {
    Quartz(25),
    EarthCrystal(50),
    FrozenTear(75),
    FireQuartz(100),
    Emerald(250),
    AquaMarine(180),
    Ruby(250),
    Amethyst(100),
    Topaz(80),
    Jade(200),
    Diamond(750),
    PrismaticShine(2000),
    Cooper(5),
    Iron(10),
    Gold(25),
    Iridium(100),
    Coal(15);
    public final int Cost;

    Minerals(int cost) {
        Cost = cost;
    }
}
