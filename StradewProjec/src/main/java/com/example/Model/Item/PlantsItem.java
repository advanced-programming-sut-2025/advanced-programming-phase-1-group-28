package com.example.Model.Item;

import com.example.Model.Enums.Plants;

public class PlantsItem extends Item{
    private Plants plant;

    public PlantsItem(int count, Plants plant) {
        super(count, plant.toString());
        this.plant = plant;
    }

    public Plants getPlant() {
        return plant;
    }

    public void setPlant(Plants plant) {
        this.plant = plant;
        this.name = plant.toString();
    }

    @Override
    public PlantsItem getCopy(){
        return new PlantsItem(count, plant);
    }
}
