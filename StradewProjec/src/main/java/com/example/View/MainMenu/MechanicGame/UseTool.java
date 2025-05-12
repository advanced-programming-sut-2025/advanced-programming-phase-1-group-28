package com.example.View.MainMenu.MechanicGame;

import com.example.Model.App;

public class UseTool {
    public void UsingTool(int X , int Y)
    {

    }
    public void UseHoe()
    {

    }
    public void UsePickaxe()
    {

    }
    public void UseAxe()
    {

    }
    public void UseWaterCan()
    {

    }
    public void UseFishingPole()
    {

    }
    public void UseSeythe()
    {

    }
    public void UseMilkPail()
    {

    }
    public void UseShear()
    {

    }
    public void UseTRashCan()
    {

    }

    public void Equiptool(String Toolname)
    {
        App.useToolController.EquipTool(Toolname);
    }

    public void Usetool(int x , int y)
    {
        System.out.println(App.useToolController.ApplyUsing(x , y));
    }
}
