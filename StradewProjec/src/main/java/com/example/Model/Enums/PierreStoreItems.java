package com.example.Model.Enums;

public enum PierreStoreItems {
    RICE(200 , -1, null, null, Ingredients.Rice, null, null),
    WHEAT_FLOUR(100 , -1, null, null, Ingredients.Wheat_Flour, null, null),
    SUGAR(100, -1, null, null, Ingredients.Sugar, null, null),
    OIL(200, -1, null, null, Ingredients.Oil, null, null),
    VINEGAR(200, -1, null, null, Ingredients.Vinegar, null, null),
    BASIC_RETAINING_SOIL(100, -1, null, null, Ingredients.Basic_Retaining_Oil, null, null),
    QUALITY_RETAINING_SOIL(150, -1, null, null, Ingredients.Quality_Retaining_Oil, null, null),
    DELUXE_RETAINING_SOIL(150, -1, null, null, Ingredients.Deluxe_Retaining_Oil, null, null),
    GRASS_STARTER(100, -1, null, null, null, null, Crafts.GrassStarter),
    SPEED_GRO(100, -1, null, null, null, null, Crafts.SpeedGro),
    APPLE_SAPLING(4000, -1, null, null, null, Saplings.APPLE_SAPLING, null),
    APRICOT_SAPLING(2000, -1, null, null, null, Saplings.APRICOT_SAPLING, null),
    CHERRY_SAPLING(3400, -1, null, null, null, Saplings.CHERRY_SAPLING, null),
    ORANGE_SAPLING(4000, -1, null, null, null, Saplings.ORANGE_SAPLING, null),
    PEACH_SAPLING(6000, -1, null, null, null, Saplings.PEACH_SAPLING, null),
    POMEGRANATE_SAPLING(6000, -1, null, null, null, Saplings.POMEGRANATE_SAPLING, null),
    BOUQUET(1000 , 0 , null, null, null, null, null),
    WEDDING_RING(10000 , 1 , null, null, null, null, null),
    DEHYDRATOR_RECIPE(10000 , 2 , null, null, null, null, null),
    GRASS_STARTER_RECIPE(1000 , 3 , null, null, null, null, null),
    LARGE_PACK(2000 , 4 , null, null, null, null, null),
    DELUXE_PACK(10000 , 5 , null, null, null, null, null),
    PARSNIP_SEEDS(20, 6, Season.SPRING , Seeds.ParsnipSeeds, null, null, null),
    BEAN_STARTER(60, 7, Season.SPRING, Seeds.BeanStarter, null, null, null),
    CAULIFLOWER_SEEDS(80, 8, Season.SPRING, Seeds.CauliflowerSeeds, null, null, null),
    POTATO_SEEDS(50, 9, Season.SPRING, Seeds.PotatoSeeds, null, null, null),
    TULIP_BULB(20, 10, Season.SPRING, Seeds.TulipBulb, null, null, null),
    KALE_SEEDS(70, 11, Season.SPRING, Seeds.KaleSeeds, null, null, null),
    JAZZ_SEEDS(30, 12, Season.SPRING, Seeds.JazzSeeds, null, null, null),
    GARLIC_SEEDS(40, 13, Season.SPRING, Seeds.GarlicSeeds, null, null, null),
    RICE_SHOOT(40, 14, Season.SPRING, Seeds.RiceShoot, null, null, null),
    MELON_SEEDS(80, 15, Season.SUMMER, Seeds.MelonSeeds, null, null, null),
    TOMATO_SEEDS(50, 16, Season.SUMMER, Seeds.TomatoSeeds, null, null, null),
    BLUEBERRY_SEEDS(80, 17, Season.SUMMER, Seeds.BlueberrySeeds, null, null, null),
    PEPPER_SEEDS(40, 18, Season.SUMMER, Seeds.PepperSeeds, null, null, null),
    WHEAT_SEEDS_SUMMER(10, 19, Season.SUMMER, Seeds.WheatSeeds, null, null, null),
    RADISH_SEEDS(40, 20, Season.SUMMER, Seeds.RadishSeeds, null, null, null),
    POPPY_SEEDS(100, 21, Season.SUMMER, Seeds.PoppySeeds, null, null, null),
    SPANGLE_SEEDS(50, 22, Season.SUMMER, Seeds.SpangleSeeds, null, null, null),
    HOPS_STARTER(60, 23, Season.SUMMER, Seeds.HopsStarter, null, null, null),
    CORN_SEEDS_SUMMER(150, 24, Season.SUMMER, Seeds.CornSeeds, null, null, null),
    SUNFLOWER_SEEDS_SUMMER(200, 25, Season.SUMMER, Seeds.SunflowerSeeds, null, null, null),
    RED_CABBAGE_SEEDS(100, 26, Season.SUMMER, Seeds.RedCabbageSeeds, null, null, null),
    EGGPLANT_SEEDS(20, 27, Season.FALL, Seeds.EggplantSeeds, null, null, null),
    CORN_SEEDS_FALL(150, 28, Season.FALL, Seeds.CornSeeds, null, null, null),
    PUMPKIN_SEEDS(100, 29, Season.FALL, Seeds.PumpkinSeeds, null, null, null),
    BOK_CHOY_SEEDS(50, 30, Season.FALL, Seeds.BokChoySeeds, null, null, null),
    YAM_SEEDS(60, 31, Season.FALL, Seeds.YamSeeds, null, null, null),
    CRANBERRY_SEEDS(240, 32, Season.FALL, Seeds.CranberrySeeds, null, null, null),
    SUNFLOWER_SEEDS_FALL(200, 33, Season.FALL, Seeds.SunflowerSeeds, null, null, null),
    FAIRY_SEEDS(200, 34, Season.FALL, Seeds.FairySeeds, null, null, null),
    AMARANTH_SEEDS(70, 35, Season.FALL, Seeds.AmaranthSeeds, null, null, null),
    GRAPE_STARTER(60, 36, Season.FALL, Seeds.GrapeStarter, null, null, null),
    WHEAT_SEEDS_FALL(10, 37, Season.FALL, Seeds.WheatSeeds, null, null, null),
    ARTICHOKE_SEEDS(30, 38, Season.FALL, Seeds.ArtichokeSeeds, null, null, null);

    public final int Price;
    public final int LimitIndex;
    public  final Season season;
    public final Seeds Seed;
    public final Ingredients Ingredient;
    public final Saplings saplings;
    public final Crafts crafts;

    PierreStoreItems(int price, int limitIndex , Season season , Seeds seed , Ingredients ingredient , Saplings saplings , Crafts crafts) {
        Price = price;
        LimitIndex = limitIndex;
        this.season = season;
        Seed = seed;
        Ingredient = ingredient;
        this.saplings = saplings;
        this.crafts = crafts;
    }
}
