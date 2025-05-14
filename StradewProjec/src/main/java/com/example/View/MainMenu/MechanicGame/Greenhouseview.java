package com.example.View.MainMenu.MechanicGame;

import com.example.Model.App;
import com.example.Model.Enums.Plants;
import com.example.Model.Enums.Season;
import com.example.Model.Enums.Seeds;

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
