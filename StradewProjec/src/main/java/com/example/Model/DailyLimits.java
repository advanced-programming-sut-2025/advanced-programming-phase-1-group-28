package com.example.Model;

public class DailyLimits {
    private int BlackSmithLimits[] = new int[]{1 , 1 , 1 , 1 , 1 , 1 , 1 , 1};
    // Copper , Steel , Gold , Iridium Tool
    // Copper , Steel , Gold , Iridium Trash Can
    private int MarineRanch[] = new int[]{1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2};

    public int[] getBlackSmithLimits() {
        return BlackSmithLimits;
    }

    public void setBlackSmithLimits(int blackSmithLimits[]) {
        BlackSmithLimits = blackSmithLimits;
    }

    public int[] getMarineRanch() {
        return MarineRanch;
    }

    public void setMarineRanch(int marineRanch[]) {
        MarineRanch = marineRanch;
    }
}
