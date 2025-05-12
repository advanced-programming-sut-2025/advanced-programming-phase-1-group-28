package com.example.Model.Item;

import com.example.Model.Enums.Fishes;

public class FishItem extends Item{
    private Fishes fish;

    public FishItem(int count, Fishes fish) {
        super(count, fish.name());
        this.fish = fish;
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
        FishItem result = new FishItem(count, fish);
        result.setFish(fish);
        return result;
    }
}
