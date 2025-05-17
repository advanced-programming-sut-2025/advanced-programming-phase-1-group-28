package com.example.Model.Enums;

public enum StarDropSaloonItems {
    Beer("Beer" , -1 , 400),
    Salad("Salad" , -1 , 220),
    Bread("Bread" , -1 , 120),
    Spaghetti("Spaghetti" , -1 , 240),
    Pizza("Pizza" , -1 , 600),
    Coffee("Coffee" , -1 , 300),
    Hashbrowns_Recipe("Hashbrowns Recipe" , 0 , 50),
    Omlete_Recipe("Omlete Recipe" , 1 , 100),
    Pancake_Recipe("Pancakes Recipe" , 2 , 100),
    Bread_Recipe("Bread Recipe" , 3 , 100),
    Tortilla_Recipe("Tortilla Recipe" , 4 , 100),
    Pizza_Recipe("Pizza Recipe" , 5 , 150),
    Maki_Roll_Recipe("Maki Roll Recipe" , 6 , 300),
    Triple_Shot_Espresso_Recipe("Triple Shot Espresso Recipe" , 7 , 5000),
    Cookie_Recipe("Cookie Recipe" , 8 , 300)
    ;

    public final String name;
    public final int limitIndex;
    public final int Price;

    StarDropSaloonItems(String name, int limitIndex, int price) {
        this.name = name;
        this.limitIndex = limitIndex;
        Price = price;
    }
}
