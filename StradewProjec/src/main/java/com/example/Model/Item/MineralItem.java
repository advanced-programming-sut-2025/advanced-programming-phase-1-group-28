package com.example.Model.Item;

import com.example.Model.Enums.Minerals;

public class MineralItem extends Item{
    private Minerals mineral;

    public Minerals getMineral() {
        return mineral;
    }

    public void setMineral(Minerals mineral) {
        this.mineral = mineral;
        this.name = mineral.toString();
    }

    //public MineralItem(int count, String name) {
      //  super(count, name);
    //}

    public MineralItem(int count , Minerals mineral) {
        super(count, mineral.name());
        this.mineral = mineral;
    }

    @Override
    public MineralItem getCopy(){
        MineralItem result = new MineralItem(count, mineral);
        result.setMineral(mineral);
        return result;
    }
}
