package Model.Enums;

public enum Tree {
    Afra("mamad" , "mamad" , "mamad" , 1 , "mamad" , 1 , 1 , true , 1 , "mamad");
    public final String Name;
    public final String Source;
    public final String stage;
    public final int TotalTimeHarvest;
    public final String Fruit;
    public final int HarvestCycle;
    public final int BaseSellPrice;
    public final boolean IsFruitEdible;
    public final int energy;
    public final String season;
    Tree(String name, String source, String stage, int totalTimeHarvest, String fruit, int harvestCycle, int baseSellPrice, boolean isFruitEdible, int energy, String season) {
        Name = name;
        Source = source;
        this.stage = stage;
        TotalTimeHarvest = totalTimeHarvest;
        Fruit = fruit;
        HarvestCycle = harvestCycle;
        BaseSellPrice = baseSellPrice;
        IsFruitEdible = isFruitEdible;
        this.energy = energy;
        this.season = season;
    }
}
