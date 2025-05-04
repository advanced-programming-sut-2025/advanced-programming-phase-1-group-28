package com.example.Model.Item;

import com.example.Model.Enums.Crafts;

public class Craft extends Item{
    private Crafts crafts;
    public Craft(int count , Crafts crafts ) {
        super(count , crafts.toString());
        this.crafts = crafts;
    }

    public Crafts getCrafts() {
        return crafts;
    }

    public void setCrafts(Crafts crafts) {
        this.crafts = crafts;
    }
}
