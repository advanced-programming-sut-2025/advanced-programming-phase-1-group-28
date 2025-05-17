package com.example.Model;

public class Buff {
    private int[] hoursLeft; // maxEnergy, farming, foraging, fishing, mining
    private int maxEnergy;
    private boolean farming;
    private boolean foraging;
    private boolean fishing;
    private boolean mining;

    public Buff() {
        hoursLeft = new int[]{0, 0, 0, 0, 0};
        maxEnergy = 0;
        farming = false;
        foraging = false;
        fishing = false;
        mining = false;
    }

    public int[] getHoursLeft() {
        return hoursLeft;
    }

    public void setHoursLeft(int[] hoursLeft) {
        this.hoursLeft = hoursLeft;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public boolean isFarming() {
        return farming;
    }

    public void setFarming(boolean farming) {
        this.farming = farming;
    }

    public boolean isForaging() {
        return foraging;
    }

    public void setForaging(boolean foraging) {
        this.foraging = foraging;
    }

    public boolean isFishing() {
        return fishing;
    }

    public void setFishing(boolean fishing) {
        this.fishing = fishing;
    }

    public boolean isMining() {
        return mining;
    }

    public void setMining(boolean mining) {
        this.mining = mining;
    }
}
