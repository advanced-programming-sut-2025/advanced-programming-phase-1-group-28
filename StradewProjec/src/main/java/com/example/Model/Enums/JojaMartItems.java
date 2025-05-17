package com.example.Model.Enums;

public enum JojaMartItems {
    JojaCola(null , -1 , 75 , "Joja Cola"),
    GrassStarter(null , -1 , 125 , "Grass Starter"),
    Sugar(null , -1 , 125 , "Sugar"),
    WheatFlour(null , -1 , 125 , "Wheat Flour"),
    Rice(null , -1 , 250 , "Rice"),
    JazzSeeds(Seeds.JazzSeeds , 0 , 37 , null),
    CarrotSeeds(Seeds.CarrotSeeds , 1 , 5, null),
    CauliflowerSeeds(Seeds.CauliflowerSeeds  , 2 , 100, null),
    CoffeeBean(Seeds.CoffeeBean , 3 , 200, null),
    GarlicSeeds(Seeds.GarlicSeeds , 4 , -1, null),
    BeanStarter(Seeds.BeanStarter , 5 , 75, null),
    KaleSeeds(Seeds.KaleSeeds , 6 , 87, null),
    ParsnipSeeds(Seeds.ParsnipSeeds , 7 , 25, null),
    PotatoSeeds(Seeds.PotatoSeeds , 8 , 62, null),
    RhubarbSeeds(Seeds.RhubarbSeeds , 9 , 100, null),
    StrawberrySeeds(Seeds.StrawberrySeeds , 10 , 100, null),
    TulipBulb(Seeds.TulipBulb , 10 , 25, null),
    RiceShoot(Seeds.RiceShoot , 11 , -1, null),
    BlueberrySeeds(Seeds.BlueberrySeeds , 12 , -1, null),
    CornSeeds(Seeds.CornSeeds , 13 , 187, null),
    HopsStarter(Seeds.HopsStarter , 14 , 75, null),
    PepperSeeds(Seeds.PepperSeeds , 15 , 50, null),
    MelonSeeds(Seeds.MelonSeeds , 16 , 100, null),
    PoppySeeds(Seeds.PoppySeeds , 17 , 125, null),
    RadishSeeds(Seeds.RadishSeeds , 18 , 50, null),
    RedCabbageSeeds(Seeds.RedCabbageSeeds , 19 , -1, null),
    StarfruitSeeds(Seeds.StarfruitSeeds , 20 , 400, null),
    SpangleSeeds(Seeds.SpangleSeeds , 21 , 62, null),
    SummerSquashSeeds(Seeds.SummerSquashSeeds , 22 , 10, null),
    SunflowerSeeds(Seeds.SunflowerSeeds , 23 , 125, null),
    TomatoSeeds(Seeds.TomatoSeeds , 24 , 62, null),
    WheatSeeds(Seeds.WheatSeeds , 25 , 12, null),
    AmaranthSeeds(Seeds.AmaranthSeeds , 26 , 87, null),
    ArtichokeSeeds(Seeds.ArtichokeSeeds , 27 , -1, null),
    BeetSeeds(Seeds.BeetSeeds , 28 , 20, null),
    BokChoySeeds(Seeds.BokChoySeeds , 29 , 62, null),
    BroccoliSeeds(Seeds.BroccoliSeeds , 30 , 15, null),
    CranberrySeeds(Seeds.CranberrySeeds , 31 , 300, null),
    EggplantSeeds(Seeds.EggplantSeeds , 31 , 25, null),
    FairySeeds(Seeds.FairySeeds , 32 , 250, null),
    GrapeStarter(Seeds.GrapeStarter , 33 , 75, null),
    PumpkinSeeds(Seeds.PumpkinSeeds , 34 , 125, null),
    YamSeeds(Seeds.YamSeeds , 35 , 75, null),
    RareSeed(Seeds.RareSeed , 36 , 1000, null),
    PowdermelonSeeds(Seeds.PowdermelonSeeds , 37 , 20, null),
    AncientSeeds(Seeds.AncientSeeds , 38 , 500, null),
    MixedSeeds(null , 39 , -1, null);

    public final Seeds Seed;
    public final int Price;
    public final int LimitIndex;
    public final String Name;

    JojaMartItems(Seeds seed, int limitIndex, int price , String name) {
        Seed = seed;
        Price = price;
        LimitIndex = limitIndex;
        Name = name;
    }
}
