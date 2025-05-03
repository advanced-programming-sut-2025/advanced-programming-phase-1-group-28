package com.example.Model.Enums;

public enum PierreStoreItems {
    RICE(200 , -1, null),
    WHEAT_FLOUR(100 , -1, null),
    SUGAR(100, -1, null),
    OIL(200, -1, null),
    VINEGAR(200, -1, null),
    DELUXE_RETAINING_SOIL(150, -1, null),
    GRASS_STARTER(100, -1, null),
    SPEED_GRO(100, -1, null),
    APPLE_SAPLING(4000, -1, null),
    APRICOT_SAPLING(2000, -1, null),
    CHERRY_SAPLING(3400, -1, null),
    ORANGE_SAPLING(4000, -1, null),
    PEACH_SAPLING(6000, -1, null),
    POMEGRANATE_SAPLING(6000, -1, null),
    BASIC_RETAINING_SOIL(100, -1, null),
    QUALITY_RETAINING_SOIL(150, -1, null),
    BOUQUET(1000 , 0 , null),
    WEDDING_RING(10000 , 1 , null),
    DEHYDRATOR_RECIPE(10000 , 2 , null),
    GRASS_STARTER_RECIPE(1000 , 3 , null),
    LARGE_PACK(2000 , 4 , null),
    DELUXE_PACK(10000 , 5 , null),
    PARSNIP_SEEDS(20, 6, "SPRING"),
    BEAN_STARTER(60, 7, "SPRING"),
    CAULIFLOWER_SEEDS(80, 8, "SPRING"),
    POTATO_SEEDS(50, 9, "SPRING"),
    TULIP_BULB(20, 10, "SPRING"),
    KALE_SEEDS(70, 11, "SPRING"),
    JAZZ_SEEDS(30, 12, "SPRING"),
    GARLIC_SEEDS(40, 13, "SPRING"),
    RICE_SHOOT(40, 14, "SPRING"),
    MELON_SEEDS(80, 15, "Summer"),
    TOMATO_SEEDS(50, 16, "Summer"),
    BLUEBERRY_SEEDS(80, 17, "Summer"),
    PEPPER_SEEDS(40, 18, "Summer"),
    WHEAT_SEEDS_SUMMER(10, 19, "Summer"),
    RADISH_SEEDS(40, 20, "Summer"),
    POPPY_SEEDS(100, 21, "Summer"),
    SPANGLE_SEEDS(50, 22, "Summer"),
    HOPS_STARTER(60, 23, "Summer"),
    CORN_SEEDS_SUMMER(150, 24, "Summer"),
    SUNFLOWER_SEEDS_SUMMER(200, 25, "Summer"),
    RED_CABBAGE_SEEDS(100, 26, "Summer"),
    EGGPLANT_SEEDS(20, 27, "Fall"),
    CORN_SEEDS_FALL(150, 28, "Fall"),
    PUMPKIN_SEEDS(100, 29, "Fall"),
    BOK_CHOY_SEEDS(50, 30, "Fall"),
    YAM_SEEDS(60, 31, "Fall"),
    CRANBERRY_SEEDS(240, 32, "Fall"),
    SUNFLOWER_SEEDS_FALL(200, 33, "Fall"),
    FAIRY_SEEDS(200, 34, "Fall"),
    AMARANTH_SEEDS(70, 35, "Fall"),
    GRAPE_STARTER(60, 36, "Fall"),
    WHEAT_SEEDS_FALL(10, 37, "Fall"),
    ARTICHOKE_SEEDS(30, 38, "Fall");


    public final int Price;
    public final int LimitIndex;
    public final String Season;


    PierreStoreItems(int price, int limitIndex , String season) {
        Price = price;
        LimitIndex = limitIndex;
        Season = season;
    }
}
