package com.Stradew.Model.Enums;

import com.badlogic.gdx.graphics.Texture;

public enum Ingredients {
    honey(new Texture("Artisan_good/Honey.png")),
    CowMilk(null),
    GoatMilk(null),
    SheepCotton(null),
    Hay(null),
    Sugar(null),
    Wheat_Flour(null),
    Rice(null),
    Oil(null),
    Vinegar(null),
    Basic_Retaining_Oil(null),
    Quality_Retaining_Oil(null),
    Deluxe_Retaining_Oil(null),
    Egg(null),
    LargeEgg(null),
    DuckEgg(null),
    DuckFeather(null),
    RabbitWool(null),
    RabbitLeg(null),
    DinosaurEgg(null),
    LargeCowMilk(null),
    LargeGoatMilk(null),
    Truffle(null);

    public final Texture Image;

    Ingredients(Texture image) {
        Image = image;
    }
}
