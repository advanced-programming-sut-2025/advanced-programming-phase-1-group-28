package com.example.Model;

public class Skill {
    private int Xp = 0;
    private int Level = 1;
    private String Name ;

    public void UpdateLevel()
    {
        if((Level + 1) * 100 + 50 < Xp)
        {
            Level++;
        }
    }

    public Skill(String Name) {
        this.Name = Name;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
