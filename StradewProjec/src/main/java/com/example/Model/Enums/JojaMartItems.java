package com.example.Model.Enums;

public enum JojaMartItems {
    JazzSeeds(Seeds.JazzSeeds , 0 , 37),
    CarrotSeeds(Seeds.CarrotSeeds , 1 , 5),
    CauliflowerSeeds(Seeds.CauliflowerSeeds  , 2 , 100),
    CoffeeBean(Seeds.CoffeeBean , 3 , 200),
    GarlicSeeds(Seeds.GarlicSeeds , 4 , -1),
    BeanStarter(Seeds.BeanStarter , 5 , 75),
    KaleSeeds(Seeds.KaleSeeds , 6 , 87),
    ParsnipSeeds(Seeds.ParsnipSeeds , 7 , 25),
    PotatoSeeds(Seeds.PotatoSeeds , 8 , 62),
    RhubarbSeeds(Seeds.RhubarbSeeds , 9 , 100),
    StrawberrySeeds(Seeds.StrawberrySeeds , 10 , 100),
    TulipBulb(Seeds.TulipBulb , 10 , 25),
    RiceShoot(Seeds.RiceShoot , 11 , -1),
    BlueberrySeeds(Seeds.BlueberrySeeds , 12 , -1),
    CornSeeds(Seeds.CornSeeds , 13 , 187),
    HopsStarter(Seeds.HopsStarter , 14 , 75),
    PepperSeeds(Seeds.PepperSeeds , 15 , 50),
    MelonSeeds(Seeds.MelonSeeds , 16 , 100),
    PoppySeeds(Seeds.PoppySeeds , 17 , 125),
    RadishSeeds(Seeds.RadishSeeds , 18 , 50),
    RedCabbageSeeds(Seeds.RedCabbageSeeds , 19 , -1),
    StarfruitSeeds(Seeds.StarfruitSeeds , 20 , 400),
    SpangleSeeds(Seeds.SpangleSeeds , 21 , 62),
    SummerSquashSeeds(Seeds.SummerSquashSeeds , 22 , 10),
    SunflowerSeeds(Seeds.SunflowerSeeds , 23 , 125),
    TomatoSeeds(Seeds.TomatoSeeds , 24 , 62),
    WheatSeeds(Seeds.WheatSeeds , 25 , 12),
    AmaranthSeeds(Seeds.AmaranthSeeds , 26 , 87),
    ArtichokeSeeds(Seeds.ArtichokeSeeds , 27 , -1),
    BeetSeeds(Seeds.BeetSeeds , 28 , 20),
    BokChoySeeds(Seeds.BokChoySeeds , 29 , 62),
    BroccoliSeeds(Seeds.BroccoliSeeds , 30 , 15),
    CranberrySeeds(Seeds.CranberrySeeds , 31 , 300),
    EggplantSeeds(Seeds.EggplantSeeds , 31 , 25),
    FairySeeds(Seeds.FairySeeds , 32 , 250),
    GrapeStarter(Seeds.GrapeStarter , 33 , 75),
    PumpkinSeeds(Seeds.PumpkinSeeds , 34 , 125),
    YamSeeds(Seeds.YamSeeds , 35 , 75),
    RareSeed(Seeds.RareSeed , 36 , 1000),
    PowdermelonSeeds(Seeds.PowdermelonSeeds , 37 , 20),
    AncientSeeds(Seeds.AncientSeeds , 38 , 500),
    MixedSeeds(null , 39 , -1);

    public final Seeds Seed;
    public final int Price;
    public final int LimitIndex;

    JojaMartItems(Seeds seed, int price, int limitIndex) {
        Seed = seed;
        Price = price;
        LimitIndex = limitIndex;
    }
}
