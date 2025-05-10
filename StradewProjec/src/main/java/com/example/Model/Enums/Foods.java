package com.example.Model.Enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum Foods {
    Beer(
            "Beer",
            null,
            null,
            50,
            null,
            "Stardrop Saloon",
            200
    ),
    TroutSoup(
            "Trout Soup",
            null,
            null,
            50,
            null,
            "Fish Shop",
            125
    ),
    FriedEgg(
            "Fried Egg",
            new ArrayList<>(Arrays.asList("egg")),
            new ArrayList<>(Arrays.asList(1)),
            50,
            null,
            "Starter",
            35
    ),
    BakedFish(
            "Baked Fish",
            new ArrayList<>(Arrays.asList("Sardine", "Salmon", "wheat")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            75,
            null,
            "Starter",
            100
    ),
    Salad(
            "Salad",
            new ArrayList<>(Arrays.asList("leek", "dandelion")),
            new ArrayList<>(Arrays.asList(1, 1)),
            113,
            null,
            "Starter",
            110
    ),
    Olmelet(
            "Olmelet",
            new ArrayList<>(Arrays.asList("egg", "milk")),
            new ArrayList<>(Arrays.asList(1, 1)),
            100,
            null,
            "Stardrop Saloon",
            125
    ),
    PumpkinPie(
            "pumpkin pie",
            new ArrayList<>(Arrays.asList("pumpking", "wheat flour", "milk", "sugar")),
            new ArrayList<>(Arrays.asList(1, 1, 1, 1)),
            225,
            null,
            "Stardrop Saloon",
            385
    ),
    Spaghetti(
            "spaghetti",
            new ArrayList<>(Arrays.asList("wheat flour", "tomato")),
            new ArrayList<>(Arrays.asList(1, 1)),
            75,
            null,
            "Stardrop Saloon",
            120
    ),
    Pizza(
            "pizza",
            new ArrayList<>(Arrays.asList("wheat flour", "tomato", "cheese")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            150,
            null,
            "Stardrop Saloon",
            300
    ),
    Tortilla(
            "Tortilla",
            new ArrayList<>(Arrays.asList("corn")),
            new ArrayList<>(Arrays.asList(1)),
            50,
            null,
            "Stardrop Saloon",
            50
    ),
    MakiRoll(
            "Maki Roll",
            new ArrayList<>(Arrays.asList("any fish", "rice", "fiber")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            100,
            null,
            "Stardrop Saloon",
            220
    ),
    TripleShotEspresso(
            "Triple Shot Espresso",
            new ArrayList<>(Arrays.asList("coffee")),
            new ArrayList<>(Arrays.asList(3)),
            200,
            "Max Energy + 100 (5 hours)",
            "Stardrop Saloon",
            450
    ),
    Cookie(
            "Cookie",
            new ArrayList<>(Arrays.asList("wheat flour", "sugar", "egg")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            90,
            null,
            "Stardrop Saloon",
            140
    ),
    HashBrowns(
            "hash browns",
            new ArrayList<>(Arrays.asList("potato", "oil")),
            new ArrayList<>(Arrays.asList(1, 1)),
            90,
            "Farming (5 hours)",
            "Stardrop Saloon",
            120
    ),
    Pancakes(
            "pancakes",
            new ArrayList<>(Arrays.asList("wheat flour", "egg")),
            new ArrayList<>(Arrays.asList(1, 1)),
            90,
            "Foraging (11 hours)",
            "Stardrop Saloon",
            80
    ),
    FruitSalad(
            "fruit salad",
            new ArrayList<>(Arrays.asList("blueberry", "melon", "apricot")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            263,
            null,
            "Stardrop Saloon",
            450
    ),
    RedPlate(
            "red plate",
            new ArrayList<>(Arrays.asList("red cabbage", "radish")),
            new ArrayList<>(Arrays.asList(1, 1)),
            240,
            "Max Energy +50 (3 hours)",
            "Stardrop Saloon",
            400
    ),
    Bread(
            "bread",
            new ArrayList<>(Arrays.asList("wheat flour")),
            new ArrayList<>(Arrays.asList(1)),
            50,
            null,
            "Stardrop Saloon",
            60
    ),
    SalmonDinner(
            "salmon dinner",
            new ArrayList<>(Arrays.asList("salmon", "Amaranth", "Kale")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            125,
            null,
            "Leah reward",
            300
    ),
    VegetableMedley(
            "vegetable medley",
            new ArrayList<>(Arrays.asList("tomato", "beet")),
            new ArrayList<>(Arrays.asList(1, 1)),
            165,
            "Foraging Level 2",
            null,
            120
    ),
    FarmersLunch(
            "farmer's lunch",
            new ArrayList<>(Arrays.asList("omelet", "parsnip")),
            new ArrayList<>(Arrays.asList(1, 1)),
            200,
            "Farming (5 hours)",
            "Farming level 1",
            150
    ),
    SurvivalBurger(
            "survival burger",
            new ArrayList<>(Arrays.asList("bread", "carrot", "eggplant")),
            new ArrayList<>(Arrays.asList(1, 1, 1)),
            125,
            "Foraging (5 hours)",
            "Foraging level 3",
            180
    ),
    DishOTheSea(
            "dish O' the Sea",
            new ArrayList<>(Arrays.asList("sardine", "hash browns")),
            new ArrayList<>(Arrays.asList(2, 1)),
            150,
            "Fishing (5 hours)",
            "Fishing level 2",
            220
    ),
    SeaformPudding(
            "seaform Pudding",
            new ArrayList<>(Arrays.asList("Flounder", "midnight carp")),
            new ArrayList<>(Arrays.asList(1, 1)),
            175,
            "Fishing (10 hours)",
            "Fishing level 3",
            300
    ),
    MinersTreat(
            "miner's treat",
            new ArrayList<>(Arrays.asList("carrot", "sugar", "milk")),
            new ArrayList<>(Arrays.asList(2, 1, 1)),
            125,
            "Mining (5 hours)",
            "Mining level 1",
            200
    );

    public final String Name;
    public final ArrayList<String> Ingredient;
    public final ArrayList<Integer> IngredientCount;
    public final int Energy;
    public final String Buff;
    public final String Source;
    public final int SellPrice;

    Foods(
            String Name,
            ArrayList<String> ingredient,
            ArrayList<Integer> ingredientCount,
            int energy,
            String buff,
            String source,
            int sellPrice
    ) {
        this.Name = Name;
        this.Ingredient = ingredient;
        this.IngredientCount = ingredientCount;
        this.Energy = energy;
        this.Buff = buff;
        this.Source = source;
        this.SellPrice = sellPrice;
    }
}
