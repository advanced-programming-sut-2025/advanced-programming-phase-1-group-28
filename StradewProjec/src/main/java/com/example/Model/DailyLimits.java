package com.example.Model;

public class DailyLimits {
    private int BlackSmithLimits[] = new int[]{1 , 1 , 1 , 1 , 1 , 1 , 1 , 1};
    // Copper , Steel , Gold , Iridium Tool
    // Copper , Steel , Gold , Iridium Trash Can
    private int MarineRanch[] = new int[]{1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2};
    // Milk Pail , Shears
    // Chicken , Cow , Goat , Duck , Sheep , Rabbit , Dinosaur , Pig
    private int StarDropSaloon[] = new int[]{1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1};
    // Hashbrowns , Omlete , Pancakes , Bread , Tortilla , Pizza , Maki Roll , Triple Shot Espresso , Cookie
    private int CarpenterShop[] = new int[]{1 , 1 , 1 , 1 , 1 , 1 , 1};
    // Barn , Big , Deluxe
    // Coop , Big , Deluxe
    // well

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

    public int[] getStarDropSaloon() {
        return StarDropSaloon;
    }

    public void setStarDropSaloon(int starDropSaloon[]) {
        StarDropSaloon = starDropSaloon;
    }

    public int[] getCarpenterShop() {
        return CarpenterShop;
    }

    public void setCarpenterShop(int carpenterShop[]) {
        CarpenterShop = carpenterShop;
    }
}
