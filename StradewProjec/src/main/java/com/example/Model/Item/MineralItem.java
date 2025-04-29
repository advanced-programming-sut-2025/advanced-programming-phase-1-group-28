package com.example.Model.Item;

import com.example.Model.Enums.Minerals;

public class MineralItem extends Item{
    private Minerals mineral;

    public Minerals getMineral() {
        return mineral;
    }

    public void setMineral(Minerals mineral) {
        this.mineral = mineral;
    }

    public MineralItem(int count, String name) {
        super(count, name);
    }
}
