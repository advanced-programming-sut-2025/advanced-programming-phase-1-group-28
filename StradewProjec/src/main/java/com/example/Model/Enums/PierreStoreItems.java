package com.example.Model.Enums;

public enum PierreStoreItems {
    RICE(200 , -1, null, null, Ingredients.Rice),
    WHEAT_FLOUR(100 , -1, null, null, Ingredients.Wheat_Flour),
    SUGAR(100, -1, null, null, Ingredients.Sugar),
    OIL(200, -1, null, null, Ingredients.Oil),
    VINEGAR(200, -1, null, null, Ingredients.Vinegar),
    BASIC_RETAINING_SOIL(100, -1, null, null, Ingredients.Basic_Retaining_Oil),
    QUALITY_RETAINING_SOIL(150, -1, null, null, Ingredients.Quality_Retaining_Oil),
    DELUXE_RETAINING_SOIL(150, -1, null, null, Ingredients.Deluxe_Retaining_Oil),
    GRASS_STARTER(100, -1, null, null, null),
    SPEED_GRO(100, -1, null, null, null),
    APPLE_SAPLING(4000, -1, null, null, null),
    APRICOT_SAPLING(2000, -1, null, null, null),
    CHERRY_SAPLING(3400, -1, null, null, null),
    ORANGE_SAPLING(4000, -1, null, null, null),
    PEACH_SAPLING(6000, -1, null, null, null),
    POMEGRANATE_SAPLING(6000, -1, null, null, null),
    BOUQUET(1000 , 0 , null, null, null),
    WEDDING_RING(10000 , 1 , null, null, null),
    DEHYDRATOR_RECIPE(10000 , 2 , null, null, null),
    GRASS_STARTER_RECIPE(1000 , 3 , null, null, null),
    LARGE_PACK(2000 , 4 , null, null, null),
    DELUXE_PACK(10000 , 5 , null, null, null),
    PARSNIP_SEEDS(20, 6, Season.SPRING , Seeds.ParsnipSeeds, null),
    BEAN_STARTER(60, 7, Season.SPRING, Seeds.BeanStarter, null),
    CAULIFLOWER_SEEDS(80, 8, Season.SPRING, Seeds.CauliflowerSeeds, null),
    POTATO_SEEDS(50, 9, Season.SPRING, Seeds.PotatoSeeds, null),
    TULIP_BULB(20, 10, Season.SPRING, Seeds.TulipBulb, null),
    KALE_SEEDS(70, 11, Season.SPRING, Seeds.KaleSeeds, null),
    JAZZ_SEEDS(30, 12, Season.SPRING, Seeds.JazzSeeds, null),
    GARLIC_SEEDS(40, 13, Season.SPRING, Seeds.GarlicSeeds, null),
    RICE_SHOOT(40, 14, Season.SPRING, Seeds.RiceShoot, null),
    MELON_SEEDS(80, 15, Season.SUMMER, Seeds.MelonSeeds, null),
    TOMATO_SEEDS(50, 16, Season.SUMMER, Seeds.TomatoSeeds, null),
    BLUEBERRY_SEEDS(80, 17, Season.SUMMER, Seeds.BlueberrySeeds, null),
    PEPPER_SEEDS(40, 18, Season.SUMMER, Seeds.PepperSeeds, null),
    WHEAT_SEEDS_SUMMER(10, 19, Season.SUMMER, Seeds.WheatSeeds, null),
    RADISH_SEEDS(40, 20, Season.SUMMER, Seeds.RadishSeeds, null),
    POPPY_SEEDS(100, 21, Season.SUMMER, Seeds.PoppySeeds, null),
    SPANGLE_SEEDS(50, 22, Season.SUMMER, Seeds.SpangleSeeds, null),
    HOPS_STARTER(60, 23, Season.SUMMER, Seeds.HopsStarter, null),
    CORN_SEEDS_SUMMER(150, 24, Season.SUMMER, Seeds.CornSeeds, null),
    SUNFLOWER_SEEDS_SUMMER(200, 25, Season.SUMMER, Seeds.SunflowerSeeds, null),
    RED_CABBAGE_SEEDS(100, 26, Season.SUMMER, Seeds.RedCabbageSeeds, null),
    EGGPLANT_SEEDS(20, 27, Season.FALL, Seeds.EggplantSeeds, null),
    CORN_SEEDS_FALL(150, 28, Season.FALL, Seeds.CornSeeds, null),
    PUMPKIN_SEEDS(100, 29, Season.FALL, Seeds.PumpkinSeeds, null),
    BOK_CHOY_SEEDS(50, 30, Season.FALL, Seeds.BokChoySeeds, null),
    YAM_SEEDS(60, 31, Season.FALL, Seeds.YamSeeds, null),
    CRANBERRY_SEEDS(240, 32, Season.FALL, Seeds.CranberrySeeds, null),
    SUNFLOWER_SEEDS_FALL(200, 33, Season.FALL, Seeds.SunflowerSeeds, null),
    FAIRY_SEEDS(200, 34, Season.FALL, Seeds.FairySeeds, null),
    AMARANTH_SEEDS(70, 35, Season.FALL, Seeds.AmaranthSeeds, null),
    GRAPE_STARTER(60, 36, Season.FALL, Seeds.GrapeStarter, null),
    WHEAT_SEEDS_FALL(10, 37, Season.FALL, Seeds.WheatSeeds, null),
    ARTICHOKE_SEEDS(30, 38, Season.FALL, Seeds.ArtichokeSeeds, null);

    public final int Price;
    public final int LimitIndex;
    public  final Season season;
    public final Seeds Seed;
    public final Ingredients Ingredient;

    PierreStoreItems(int price, int limitIndex , Season season , Seeds seed , Ingredients ingredient) {
        Price = price;
        LimitIndex = limitIndex;
        this.season = season;
        Seed = seed;
        Ingredient = ingredient;
    }
}
