package com.example.Model.Item;

import com.example.Model.Enums.Fishes;

public class FishItem extends Item{
    private Fishes fish;

    public FishItem(int count, String name) {
        super(count, name);
    }

    public Fishes getFish() {
        return fish;
    }

    public void setFish(Fishes fish) {
        this.fish = fish;
        this.name = fish.toString();
    }

    @Override
    public FishItem getCopy(){
        FishItem result = new FishItem(count, name);
        result.setFish(fish);
        return result;
    }
}
