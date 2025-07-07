package com.Stradew.View.MainMenu.MechanicGame;

import com.Stradew.Model.App;
import com.Stradew.Model.Enums.Seeds;

public class Greenhouseview {
    public void Planting(int index , Seeds seed)
    {
        if(App.ReturnCurrentPlayer().getFarm().getGreenHouse().getLocked())
        {
            System.out.println("Greenhouse is locked");
        }
        else {
            App.ReturnCurrentPlayer().getFarm().getGreenHouse().Addplant(seed.Plant);
        }
    }
    public void Watering(int index)
    {
        if(App.ReturnCurrentPlayer().getFarm().getGreenHouse().getLocked())
        {
            System.out.println("Greenhouse is locked");
        }
        else {
            App.ReturnCurrentPlayer().getFarm().getGreenHouse().plants.get(index).setLastTimeWatering(App.getCurrentGame().getTime());
        }
    }
    public void cooding(int index)
    {
        if(App.ReturnCurrentPlayer().getFarm().getGreenHouse().getLocked())
        {
            System.out.println("Greenhouse is locked");
        }
        else {
            App.ReturnCurrentPlayer().getFarm().getGreenHouse().plants.get(index).setISCooded(true);
        }
    }

}
