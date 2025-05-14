package com.example.View.MainMenu.MechanicGame;

import com.example.Model.App;
import com.example.Model.Enums.Seeds;

public class Farming {
    public void Planting(String Seedname , int x ,int y)
    {
        if(!App.farmingController.CanPlant(x , y))
        {
            System.out.println("You can't plant here");
            return;
        }
        if(App.farmingController.returnseed(Seedname) == null)
        {
            System.out.println("There is no such seed");
            return;
        }
        if(!App.farmingController.IsSeedininventory(Seedname))
        {
            System.out.println("This seed is not in your inventory");
        }
        App.farmingController.ApplyPlanting(Seedname , x , y);
        System.out.println("planted sucssesfully");

    }

    public void Cood(String Coodname , int x , int y)
    {
        if(!App.farmingController.CanCood(x , y))
        {
            System.out.println("You can't cood here");
        }
        App.farmingController.ApplyCooding(Coodname ,x , y);
    }

    public void Watering()
    {

    }

}
