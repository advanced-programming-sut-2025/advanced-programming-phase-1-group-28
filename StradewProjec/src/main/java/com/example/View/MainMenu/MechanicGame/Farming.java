package com.example.View.MainMenu.MechanicGame;

import com.example.Model.App;
import com.example.Model.Enums.Seeds;

public class Farming {
    public void Planting(int x ,int y)
    {
        if(!App.farmingController.CanPlant(x , y))
        {
            System.out.println("You can't plant here");
        }
        App.farmingController.ApplyPlanting(Seeds.RareSeed , x , y);
    }

    public void Cood(int x , int y)
    {
        if(!App.farmingController.CanCood(x , y))
        {
            System.out.println("You can't cood here");
        }
        App.farmingController.ApplyCooding(x , y);
    }

    public void Watering()
    {

    }

}
