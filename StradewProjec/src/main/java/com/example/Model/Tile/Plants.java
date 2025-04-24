package com.example.Model.Tile;

public class Plants extends Tile{
    private com.example.Model.Enums.Plants plant;
    private int Stage = 0;
    private int HowOldAreYou = 0;

    public Plants(String name, com.example.Model.Enums.Plants plant, int stage, int howOldAreYou) {
        super(name);
        this.plant = plant;
        Stage = stage;
        HowOldAreYou = howOldAreYou;
    }

    public com.example.Model.Enums.Plants getPlant() {
        return plant;
    }

    public void setPlant(com.example.Model.Enums.Plants plant) {
        this.plant = plant;
    }

    public int getStage() {
        return Stage;
    }

    public void setStage(int stage) {
        Stage = stage;
    }

    public int getHowOldAreYou() {
        return HowOldAreYou;
    }

    public void setHowOldAreYou(int howOldAreYou) {
        HowOldAreYou = howOldAreYou;
    }
}
