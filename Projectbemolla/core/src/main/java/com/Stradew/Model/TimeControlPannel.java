package com.Stradew.Model;

public class TimeControlPannel {
    private float CheatCodeUse = 0;

    public void UpdateTimes(float Delta)
    {
        CheatCodeUse = CheatCodeUse + Delta;
    }

    public void setCheatCodeUse(float cheatCodeUse) {
        CheatCodeUse = cheatCodeUse;
    }

    public float getCheatCodeUse() {
        return CheatCodeUse;
    }
}
