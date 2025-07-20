package com.Stradew.Model;

public class TimeControlPannel {
    private float CheatCodeUse = 0;
    private float TimeWalkForENetgy = 0;

    public float getTimeWalkForENetgy() {
        return TimeWalkForENetgy;
    }

    public void setTimeWalkForENetgy(float timeWalkForENetgy) {
        TimeWalkForENetgy = timeWalkForENetgy;
    }

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
