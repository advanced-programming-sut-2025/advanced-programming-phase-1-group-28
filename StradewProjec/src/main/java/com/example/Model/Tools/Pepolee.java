package com.example.Model.Tools;

import com.example.Model.Inventory;
import com.example.Model.Places.Farm;
import com.example.Model.Skill;

public class Pepolee {
    private int x;
    private int y;
    private Farm Farm;
    private int Energy = 200;
    private int Id;
    private int Wood = 0;
    private int Coin = 0;
    private Inventory inventory = new Inventory();
    private Skill[] Skills = new Skill[4];

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public com.example.Model.Places.Farm getFarm() {
        return Farm;
    }

    public void setFarm(com.example.Model.Places.Farm farm) {
        Farm = farm;
    }

    public int getEnergy() {
        return Energy;
    }

    public void setEnergy(int energy) {
        Energy = energy;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getWood() {
        return Wood;
    }

    public void setWood(int wood) {
        Wood = wood;
    }

    public int getCoin() {
        return Coin;
    }

    public void setCoin(int coin) {
        Coin = coin;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Skill[] getSkills() {
        return Skills;
    }

    public void setSkills(Skill[] skills) {
        Skills = skills;
    }
//Set Energy
}
