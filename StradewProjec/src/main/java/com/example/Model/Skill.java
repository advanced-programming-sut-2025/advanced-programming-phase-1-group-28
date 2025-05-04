package com.example.Model;

import com.example.Model.Enums.Skills;

public class Skill {
    private int Xp = 0;
    private int Level = 1;
    private Skills skill;

    public void UpdateLevel()
    {
        if((Level + 1) * 100 + 50 < Xp)
        {
            Level++;
        }
    }

    public Skill(Skills Name) {
        this.skill = Name;
    }

    public Skills getSkill() {
        return skill;
    }

    public void setSkill(Skills skill) {
        this.skill = skill;
    }

    public int getXp() {
        return Xp;
    }

    public void setXp(int xp) {
        Xp = xp;
        UpdateLevel();
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

}
