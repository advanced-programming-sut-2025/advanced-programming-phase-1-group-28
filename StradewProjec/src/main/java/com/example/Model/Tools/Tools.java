package com.example.Model.Tools;

import com.example.Model.App;
import com.example.Model.Enums.Season;
import com.example.Model.Enums.Skills;
import com.example.Model.Enums.Weathers;

public class Tools {
    protected String name;
    protected int count;
    protected int Id;
    protected boolean IsExist;
    protected int EnergyCost;
    protected Skills skillRelated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public boolean isExist() {
        return IsExist;
    }

    public void setExist(boolean exist) {
        IsExist = exist;
    }

    public int getEnergyCost() {
        if(App.getCurrentGame().getWeather() == Weathers.SNOW)
        {
            return EnergyCost * 2;
        }
        if(App.getCurrentGame().getWeather() == Weathers.RAIN)
        {
            return EnergyCost * 3 / 2;
        }
        return EnergyCost;
    }

    public void setEnergyCost(int energyCost) {
        EnergyCost = energyCost;
    }

    public Skills getSkillRelated() {
        return skillRelated;
    }

    public void setSkillRelated(Skills skillRelated) {
        this.skillRelated = skillRelated;
    }
}
