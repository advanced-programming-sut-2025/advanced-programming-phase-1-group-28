package com.example.Model.Enums;

public enum Seeds {
    JazzSeeds(Plants.BLUE_JAZZ),
    CarrotSeeds(Plants.CARROT),
    CauliflowerSeeds(Plants.CAULIFLOWER),
    CoffeeBean(Plants.COFFEE_BEAN),
    GarlicSeeds(Plants.GARLIC),
    BeanStarter(Plants.GREEN_BEAN),
    KaleSeeds(Plants.KALE),
    ParsnipSeeds(Plants.PARSNIP),
    PotatoSeeds(Plants.POTATO),
    RhubarbSeeds(Plants.RHUBARB),
    StrawberrySeeds(Plants.STRAWBERRY),
    TulipBulb(Plants.TULIP),
    RiceShoot(Plants.UNMILLED_RICE),
    BlueberrySeeds(Plants.BLUEBERRY),
    CornSeeds(Plants.CORN),
    HopsStarter(Plants.HOPS),
    PepperSeeds(Plants.HOT_PEPPER),
    MelonSeeds(Plants.MELON),
    PoppySeeds(Plants.POPPY),
    RadishSeeds(Plants.RADISH),
    RedCabbageSeeds(Plants.RED_CABBAGE),
    StarfruitSeeds(Plants.STARFRUIT),
    SpangleSeeds(Plants.SUMMER_SPANGLE),
    SummerSquashSeeds(Plants.SUMMER_SQUASH),
    SunflowerSeeds(Plants.SUNFLOWER),
    TomatoSeeds(Plants.TOMATO),
    WheatSeeds(Plants.WHEAT),
    AmaranthSeeds(Plants.AMARANTH),
    ArtichokeSeeds(Plants.ARTICHOKE),
    BeetSeeds(Plants.BEET),
    BokChoySeeds(Plants.BOK_CHOY),
    BroccoliSeeds(Plants.BROCCOLI),
    CranberrySeeds(Plants.CRANBERRIES),
    EggplantSeeds(Plants.EGGPLANT),
    FairySeeds(Plants.FAIRY_ROSE),
    GrapeStarter(Plants.GRAPE),
    PumpkinSeeds(Plants.PUMPKIN),
    YamSeeds(Plants.YAM),
    RareSeed(Plants.SWEET_GEM_BERRY),
    PowdermelonSeeds(Plants.POWDERMELON),
    AncientSeeds(Plants.ANCIENT_FRUIT),
    MixedSeeds(null);

    public final Plants Plant;

    Seeds(Plants plant) {
        Plant = plant;
    }
}
