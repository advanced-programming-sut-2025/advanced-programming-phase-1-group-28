package Model.Tile;

public class Plants extends Tile{
    private Model.Enums.Plants plant;
    private int Stage = 0;
    private int HowOldAreYou = 0;

    public Plants(String name, Model.Enums.Plants plant, int stage, int howOldAreYou) {
        super(name);
        this.plant = plant;
        Stage = stage;
        HowOldAreYou = howOldAreYou;
    }

    public Model.Enums.Plants getPlant() {
        return plant;
    }

    public void setPlant(Model.Enums.Plants plant) {
        this.plant = plant;
    }

    public int getStage() {
        return Stage;
    }

    public void setStage(int stage) {
        Stage = stage;
    }

    public int getHowOldAreYou() {
        return HowOldAreYou;
    }

    public void setHowOldAreYou(int howOldAreYou) {
        HowOldAreYou = howOldAreYou;
    }
}
