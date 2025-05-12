package com.example.Model.Tile;

import com.example.Model.App;
import com.example.Model.Enums.Entitity;
import com.example.Model.Enums.PlaceType;
import com.example.Model.Enums.Terrain;
import com.example.Model.Time;

public class Plants extends Tile{
    private com.example.Model.Enums.Plants plant;
    private int Stage = 0;
    private int[] daysNeededForStage = new int[6];
    private Time BornTime;
    private boolean ISCooded = false;
    private Time LastTimeWatering;
    public boolean CanHarvest(){
        Time PassesTime = this.BornTime.DifreenceTime(App.getCurrentGame().getTime());
        //TODO check with the plant.totalharvesttime
        return true;
    }

    public Time getLastTimeWatering() {
        return LastTimeWatering;
    }

    public void setLastTimeWatering(Time lastTimeWatering) {
        LastTimeWatering = lastTimeWatering;
    }

    public Time getBornTime() {
        return BornTime;
    }

    public void setBornTime(Time bornTime) {
        BornTime = bornTime;
    }

    public boolean isISCooded() {
        return ISCooded;
    }

    public void setISCooded(boolean ISCooded) {
        this.ISCooded = ISCooded;
    }

    public Plants(com.example.Model.Enums.Plants plant) {
        super(Terrain.GRASS , PlaceType.NORMAL , Entitity.PLANTS);
        this.plant = plant;
        if (plant.stage == null){
            return;
        }
        int i = 0;
        int count = 0;
        for (String s: plant.stage.split("-")){
            count += Integer.parseInt(s);
            daysNeededForStage[i] = count;
            i++;
        }
        daysNeededForStage[i] = -1;
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

    public int getCurrentStage(){
        return daysNeededForStage[Stage];
    }

}
