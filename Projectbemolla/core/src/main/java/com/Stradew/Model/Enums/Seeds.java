package com.Stradew.Model.Enums;

import com.badlogic.gdx.graphics.Texture;

public enum Seeds {
    JazzSeeds(Plants.BLUE_JAZZ , new Texture("Crops/Blueberry_Seeds.png")),
    CarrotSeeds(Plants.CARROT , new Texture("Crops/Blueberry_Seeds.png")),
    CauliflowerSeeds(Plants.CAULIFLOWER , new Texture("Crops/Blueberry_Seeds.png")),
    CoffeeBean(Plants.COFFEE_BEAN , new Texture("Crops/Blueberry_Seeds.png")),
    GarlicSeeds(Plants.GARLIC , new Texture("Crops/Blueberry_Seeds.png")),
    BeanStarter(Plants.GREEN_BEAN , new Texture("Crops/Blueberry_Seeds.png")),
    KaleSeeds(Plants.KALE ,new Texture("Crops/Blueberry_Seeds.png") ),
    ParsnipSeeds(Plants.PARSNIP , new Texture("Crops/Blueberry_Seeds.png")),
    PotatoSeeds(Plants.POTATO , new Texture("Crops/Blueberry_Seeds.png")),
    RhubarbSeeds(Plants.RHUBARB , new Texture("Crops/Blueberry_Seeds.png")),
    StrawberrySeeds(Plants.STRAWBERRY , new Texture("Crops/Blueberry_Seeds.png")),
    TulipBulb(Plants.TULIP , new Texture("Crops/Blueberry_Seeds.png")),
    RiceShoot(Plants.UNMILLED_RICE , new Texture("Crops/Blueberry_Seeds.png")),
    BlueberrySeeds(Plants.BLUEBERRY , new Texture("Crops/Blueberry_Seeds.png")),
    CornSeeds(Plants.CORN , new Texture("Crops/Blueberry_Seeds.png")),
    HopsStarter(Plants.HOPS , new Texture("Crops/Blueberry_Seeds.png")),
    PepperSeeds(Plants.HOT_PEPPER , new Texture("Crops/Blueberry_Seeds.png")),
    MelonSeeds(Plants.MELON , new Texture("Crops/Blueberry_Seeds.png")),
    PoppySeeds(Plants.POPPY , new Texture("Crops/Blueberry_Seeds.png")),
    RadishSeeds(Plants.RADISH ,new Texture("Crops/Blueberry_Seeds.png")),
    RedCabbageSeeds(Plants.RED_CABBAGE ,new Texture("Crops/Blueberry_Seeds.png")),
    StarfruitSeeds(Plants.STARFRUIT ,new Texture("Crops/Blueberry_Seeds.png")),
    SpangleSeeds(Plants.SUMMER_SPANGLE , new Texture("Crops/Blueberry_Seeds.png")),
    SummerSquashSeeds(Plants.SUMMER_SQUASH , new Texture("Crops/Blueberry_Seeds.png")),
    SunflowerSeeds(Plants.SUNFLOWER , new Texture("Crops/Blueberry_Seeds.png")),
    TomatoSeeds(Plants.TOMATO , new Texture("Crops/Blueberry_Seeds.png")),
    WheatSeeds(Plants.WHEAT , new Texture("Crops/Blueberry_Seeds.png")),
    AmaranthSeeds(Plants.AMARANTH , new Texture("Crops/Blueberry_Seeds.png")),
    ArtichokeSeeds(Plants.ARTICHOKE , new Texture("Crops/Blueberry_Seeds.png")),
    BeetSeeds(Plants.BEET , new Texture("Crops/Blueberry_Seeds.png")),
    BokChoySeeds(Plants.BOK_CHOY , new Texture("Crops/Blueberry_Seeds.png")),
    BroccoliSeeds(Plants.BROCCOLI , new Texture("Crops/Blueberry_Seeds.png")),
    CranberrySeeds(Plants.CRANBERRIES , new Texture("Crops/Blueberry_Seeds.png")),
    EggplantSeeds(Plants.EGGPLANT ,new Texture("Crops/Blueberry_Seeds.png")),
    FairySeeds(Plants.FAIRY_ROSE ,new Texture("Crops/Blueberry_Seeds.png")),
    GrapeStarter(Plants.GRAPE , new Texture("Crops/Blueberry_Seeds.png")),
    PumpkinSeeds(Plants.PUMPKIN , new Texture("Crops/Blueberry_Seeds.png")),
    YamSeeds(Plants.YAM , new Texture("Crops/Blueberry_Seeds.png")),
    RareSeed(Plants.SWEET_GEM_BERRY , new Texture("Crops/Blueberry_Seeds.png")),
    PowdermelonSeeds(Plants.POWDERMELON , new Texture("Crops/Blueberry_Seeds.png")),
    AncientSeeds(Plants.ANCIENT_FRUIT , new Texture("Crops/Blueberry_Seeds.png")),
    MixedSeeds(null , new Texture("Crops/Blueberry_Seeds.png"));

    public final Plants Plant;
    public final Texture SeedTexture;


    Seeds(Plants plant , Texture seedTexture)
    {
        Plant = plant;
        this.SeedTexture = seedTexture;
    }
}
