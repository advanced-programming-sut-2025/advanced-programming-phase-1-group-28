package com.Stradew.Model.Enums;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Arrays;

public enum Foods {
    GrapeWine(
            "GrapeWine",
            new ArrayList<>(Arrays.asList("Grape")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Plants.GRAPE.energy * 1.75),
            null,
            "Keg Artisan",
            3 * Fruits.APRICOT.baseCellPrice,
            "Foraging/Purple_Wine.png"
    ),
    ApricotWine(
            "ApricotWine",
            new ArrayList<>(Arrays.asList("Apricot")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Fruits.APRICOT.Energy * 1.75),
            null,
            "Keg Artisan",
            3 * Fruits.APRICOT.baseCellPrice,
        "Artisan_good/Yellow_Juice.png"
    ),
    CherryWine(
            "CherryWine",
            new ArrayList<>(Arrays.asList("Cherry")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Fruits.CHERRY.Energy * 1.75),
            null,
            "Keg Artisan",
            3 * Fruits.CHERRY.baseCellPrice,
            "Artisan_good/Dark_Pink_Wine.png"
    ),
    BananaWine(
            "BananaWine",
            new ArrayList<>(Arrays.asList("Banana")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Fruits.BANANA.Energy * 1.75),
            null,
            "Keg Artisan",
            3 * Fruits.BANANA.baseCellPrice,
            "Artisan_good/Yellow_Wine.png"
    ),
    MangoWine(
            "MangoWine",
            new ArrayList<>(Arrays.asList("Mango")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Fruits.MANGO.Energy * 1.75),
            null,
            "Keg Artisan",
            3 * Fruits.MANGO.baseCellPrice,
            "Artisan_good/Brown_Wine.png"
    ),
    OrangeWine(
            "OrangeWine",
            new ArrayList<>(Arrays.asList("Orange")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Fruits.ORANGE.Energy * 1.75),
            null,
            "Keg Artisan",
            3 * Fruits.ORANGE.baseCellPrice,
            "Artisan_good/Orange_Wine.png"
    ),

    PeachWine(
            "PeachWine",
            new ArrayList<>(Arrays.asList("Peach")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Fruits.PEACH.Energy * 1.75),
            null,
            "Keg Artisan",
            3 * Fruits.PEACH.baseCellPrice,
            "Artisan_good/Wine.png"
    ),

    AppleWine(
            "AppleWine",
            new ArrayList<>(Arrays.asList("Apple")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Fruits.APPLE.Energy * 1.75),
            null,
            "Keg Artisan",
            3 * Fruits.APPLE.baseCellPrice,
            "Artisan_good/Light_Blue_Wine.png"
    ),

    PomegranateWine(
            "PomegranateWine",
            new ArrayList<>(Arrays.asList("Pomegranate")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Fruits.POMEGRANATE.Energy * 1.75),
            null,
            "Keg Artisan",
            3 * Fruits.POMEGRANATE.baseCellPrice,
            "Artisan_good/Dark_Purple_Wine.png"
    ),

    MahoganyWine(
            "MahoganyWine",
            new ArrayList<>(Arrays.asList("Sap")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Fruits.MAHOGANY.Energy * 1.75),
            null,
            "Keg Artisan",
            3 * Fruits.MAHOGANY.baseCellPrice,
            "Artisan_good/Green_Wine.png"
    ),

    MushroomWine(
            "MushroomWine",
            new ArrayList<>(Arrays.asList("Common Mushroom")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Fruits.MUSHROOM.Energy * 1.75),
            null,
            "Keg Artisan",
            3 * Fruits.MUSHROOM.baseCellPrice,
            "Artisan_good/Red_Wine.png"
    ),
    MysticWine(
            "MysticWine",
            new ArrayList<>(Arrays.asList("Mystic Syrup")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Fruits.MYSTIC.Energy * 1.75),
            null,
            "Keg Artisan",
            3 * Fruits.MYSTIC.baseCellPrice,
            "Artisan_good/White_Wine.png"
    ),
    BlueJazzPickle(
            "BlueJazzPickle",
            new ArrayList<>(Arrays.asList("BlueJazz")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Plants.BLUE_JAZZ.energy * 1.75),
            null,
            "Preserves Jar",
            2 * Plants.BLUE_JAZZ.BasePrice + 50,
            "Artisan_good/Purple_Pickles.png"
    ),
    CarrotPickle(
            "CarrotPickle",
            new ArrayList<>(Arrays.asList("Carrot")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Plants.CARROT.energy * 1.75),
            null,
            "Preserves Jar",
            2 * Plants.CARROT.BasePrice + 50,
            "Artisan_good/Orange_Pickles.png"
    ),
    CauliflowerPickle(
            "CauliflowerPickle",
            new ArrayList<>(Arrays.asList("Cauliflower")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Plants.CAULIFLOWER.energy * 1.75),
            null,
            "Preserves Jar",
            2 * Plants.CAULIFLOWER.BasePrice + 50,
            "Artisan_good/Green_Pickles.png"
    ),
    GarlicPickle(
            "GarlicPickle",
            new ArrayList<>(Arrays.asList("Garlic")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Plants.GARLIC.energy * 1.75),
            null,
            "Preserves Jar",
            2 * Plants.GARLIC.BasePrice + 50,
            "Artisan_good/White_Pickles.png"
    ),
    GreenBeanPickle(
            "GreenBeanPickle",
            new ArrayList<>(Arrays.asList("GreenBean")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Plants.GREEN_BEAN.energy * 1.75),
            null,
            "Preserves Jar",
            2 * Plants.GREEN_BEAN.BasePrice + 50,
        "Artisan_good/Dark_Pink_Pickles.png"
    ),
    KalePickle(
            "KalePickle",
            new ArrayList<>(Arrays.asList("Kale")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Plants.KALE.energy * 1.75),
            null,
            "Preserves Jar",
            2 * Plants.KALE.BasePrice + 50,
            "Artisan_good/Dark_Purple_Pickles.png"
    ),
    ParsnipPickle(
            "ParsnipPickle",
            new ArrayList<>(Arrays.asList("Parsnip")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Plants.PARSNIP.energy * 1.75),
            null,
            "Preserves Jar",
            2 * Plants.PARSNIP.BasePrice + 50,
            "Artisan_good/Brown_Pickles.png"
    ),
    PotatoPickle(
            "PotatoPickle",
            new ArrayList<>(Arrays.asList("Potato")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Plants.POTATO.energy * 1.75),
            null,
            "Preserves Jar",
            2 * Plants.POTATO.BasePrice + 50,
            "Artisan_good/Brown_Pickles.png"
    ),
    RhubarbPickle(
            "RhubarbPickle",
            new ArrayList<>(Arrays.asList("Rhubarb")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Plants.RHUBARB.energy * 1.75),
            null,
            "Preserves Jar",
            2 * Plants.RHUBARB.BasePrice + 50,
            "Artisan_good/Red_Pickles.png"
    ),
    TomatoPickle(
            "TomatoPickle",
            new ArrayList<>(Arrays.asList("Tomato")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Plants.TOMATO.energy * 1.75),
            null,
            "Preserves Jar",
            2 * Plants.TOMATO.BasePrice + 50,
        "Artisan_good/Red_Pickles.png"
    ),
    CranberriesPickle(
            "CranberriesPickle",
            new ArrayList<>(Arrays.asList("Cranberries")),
            new ArrayList<>(Arrays.asList(1)),
            (int)(Plants.CRANBERRIES.energy * 1.75),
            null,
            "Preserves Jar",
            2 * Plants.CRANBERRIES.BasePrice + 50,
        "Artisan_good/Pink_Pickles.png"
    ),
    Beer(
            "Beer",
            null,
            null,
            50,
            null,
            "Stardrop Saloon",
            200,
        "Artisan_good/Beer.png"
    ),
    TroutSoup(
            "Trout Soup",
            null,
            null,
            50,
            null,
            "Fish Shop",
            125,
        "Recipe/Tom_Kha_Soup.png"
    ),
    FriedEgg(
            "Fried Egg",
            new ArrayList<>(Arrays.asList("egg")),
            new ArrayList<>(Arrays.asList(1)),
            50,
            null,
            "Starter",
            35,
        "Recipe/Fried_Egg.png"
    ),
    BakedFish(
            "Baked Fish",
            new ArrayList<>(Arrays.asList("Sardine", "Salmon", "wheat")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            75,
            null,
            "Starter",
            100,
        "Recipe/Baked_Fish.png"
    ),
    Salad(
            "Salad",
            new ArrayList<>(Arrays.asList("leek", "dandelion")),
            new ArrayList<>(Arrays.asList(1, 1)),
            113,
            null,
            "Starter",
            110,
        "Recipe/Salad.png"
    ),
    Olmelet(
            "Olmelet",
            new ArrayList<>(Arrays.asList("egg", "milk")),
            new ArrayList<>(Arrays.asList(1, 1)),
            100,
            null,
            "Stardrop Saloon",
            125,
        "Recipe/Omelet.png"
    ),
    PumpkinPie(
            "pumpkin pie",
            new ArrayList<>(Arrays.asList("pumpking", "wheat flour", "milk", "sugar")),
            new ArrayList<>(Arrays.asList(1, 1, 1, 1)),
            225,
            null,
            "Stardrop Saloon",
            385,
        "Recipe/Pumpkin_Pie.png"
    ),
    Spaghetti(
            "spaghetti",
            new ArrayList<>(Arrays.asList("wheat flour", "tomato")),
            new ArrayList<>(Arrays.asList(1, 1)),
            75,
            null,
            "Stardrop Saloon",
            120,
        "Recipe/Spaghetti.png"
    ),
    Pizza(
            "pizza",
            new ArrayList<>(Arrays.asList("wheat flour", "tomato", "cheese")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            150,
            null,
            "Stardrop Saloon",
            300,
        "Recipe/Pizza.png"
    ),
    Tortilla(
            "Tortilla",
            new ArrayList<>(Arrays.asList("corn")),
            new ArrayList<>(Arrays.asList(1)),
            50,
            null,
            "Stardrop Saloon",
            50,
        "Recipe/Tortilla.png"
    ),
    MakiRoll(
            "Maki Roll",
            new ArrayList<>(Arrays.asList("any fish", "rice", "fiber")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            100,
            null,
            "Stardrop Saloon",
            220,
        "Recipe/Maki_Roll.png"
    ),
    TripleShotEspresso(
            "Triple Shot Espresso",
            new ArrayList<>(Arrays.asList("coffee")),
            new ArrayList<>(Arrays.asList(3)),
            200,
            "Max Energy + 100 (5 hours)",
            "Stardrop Saloon",
            450,
        "Recipe/Triple_Shot_Espresso.png"
    ),
    Cookie(
            "Cookie",
            new ArrayList<>(Arrays.asList("wheat flour", "sugar", "egg")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            90,
            null,
            "Stardrop Saloon",
            140,
        "Recipe/Cookie.png"
    ),
    HashBrowns(
            "hash browns",
            new ArrayList<>(Arrays.asList("potato", "oil")),
            new ArrayList<>(Arrays.asList(1, 1)),
            90,
            "Farming (5 hours)",
            "Stardrop Saloon",
            120,
        "Recipe/Hashbrowns.png"
    ),
    Pancakes(
            "pancakes",
            new ArrayList<>(Arrays.asList("wheat flour", "egg")),
            new ArrayList<>(Arrays.asList(1, 1)),
            90,
            "Foraging (11 hours)",
            "Stardrop Saloon",
            80,
        "Recipe/Pancakes.png"
    ),
    FruitSalad(
            "fruit salad",
            new ArrayList<>(Arrays.asList("blueberry", "melon", "apricot")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            263,
            null,
            "Stardrop Saloon",
            450,
        "Recipe/Fruit_Salad.png"
    ),
    RedPlate(
            "red plate",
            new ArrayList<>(Arrays.asList("red cabbage", "radish")),
            new ArrayList<>(Arrays.asList(1, 1)),
            240,
            "Max Energy +50 (3 hours)",
            "Stardrop Saloon",
            400,
        "Recipe/Red_Plate.png"
    ),
    Bread(
            "bread",
            new ArrayList<>(Arrays.asList("wheat flour")),
            new ArrayList<>(Arrays.asList(1)),
            50,
            null,
            "Stardrop Saloon",
            60,
        "Recipe/Bread.png"
    ),
    SalmonDinner(
            "salmon dinner",
            new ArrayList<>(Arrays.asList("salmon", "Amaranth", "Kale")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            125,
            null,
            "Leah reward",
            300,
        "Recipe/Salmon_Dinner.png"
    ),
    VegetableMedley(
            "vegetable medley",
            new ArrayList<>(Arrays.asList("tomato", "beet")),
            new ArrayList<>(Arrays.asList(1, 1)),
            165,
            "Foraging Level 2",
            null,
            120,
        "Recipe/Vegetable_Medley.png"
    ),
    FarmersLunch(
            "farmer's lunch",
            new ArrayList<>(Arrays.asList("omelet", "parsnip")),
            new ArrayList<>(Arrays.asList(1, 1)),
            200,
            "Farming (5 hours)",
            "Farming level 1",
            150,
        "Recipe/Farmer%27s_Lunch.png"
    ),
    SurvivalBurger(
            "survival burger",
            new ArrayList<>(Arrays.asList("bread", "carrot", "eggplant")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            125,
            "Foraging (5 hours)",
            "Foraging level 3",
            180,
        "Recipe/Survival_Burger.png"
    ),
    DishOTheSea(
            "dish O' the Sea",
            new ArrayList<>(Arrays.asList("sardine", "hash browns")),
            new ArrayList<>(Arrays.asList(2, 1)),
            150,
            "Fishing (5 hours)",
            "Fishing level 2",
            220,
        "Recipe/Dish_O%27_The_Sea.png"
    ),
    SeaformPudding(
            "seaform Pudding",
            new ArrayList<>(Arrays.asList("Flounder", "midnight carp")),
            new ArrayList<>(Arrays.asList(1, 1)),
            175,
            "Fishing (10 hours)",
            "Fishing level 3",
            300,
        "Recipe/Seafoam_Pudding.png"
    ),
    MinersTreat(
            "miner's treat",
            new ArrayList<>(Arrays.asList("carrot", "sugar", "milk")),
            new ArrayList<>(Arrays.asList(2, 1, 1)),
            125,
            "Mining (5 hours)",
            "Mining level 1",
            200,
        "Recipe/Miner%27s_Treat.png"
    );

    public final String Name;
    public final ArrayList<String> Ingredient;
    public final ArrayList<Integer> IngredientCount;
    public final int Energy;
    public final String Buff;
    public final String Source;
    public final int SellPrice;
    public final Texture texture;

    Foods(
            String Name,
            ArrayList<String> ingredient,
            ArrayList<Integer> ingredientCount,
            int energy,
            String buff,
            String source,
            int sellPrice,
            String texture
    ) {
        this.Name = Name;
        this.Ingredient = ingredient;
        this.IngredientCount = ingredientCount;
        this.Energy = energy;
        this.Buff = buff;
        this.Source = source;
        this.SellPrice = sellPrice;
        this.texture = new Texture(texture);
    }
}
