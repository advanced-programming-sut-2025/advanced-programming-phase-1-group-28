package com.example.Controller.MainMenuController.MechanicController;

import com.example.Model.App;
import com.example.Model.Enums.Terrain;
import com.example.Model.Tile.Tile;
import com.example.Model.Tools.Hoe;
import com.example.Model.Tools.Pepolee;

import javax.tools.Tool;

public class UseToolController {
    public boolean EnoughEnergy()
    {
        return false;
    }
    public void ApplyUsing()
    {
        //everything
    }
    public String ApplyHoe(int x , int y , Hoe hoe)
    {
        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
        int NewX = App.ReturnCurrentPlayer().getX() + x;
        int NewY = App.ReturnCurrentPlayer().getY() + y;
        if(CurrentPepolee.getFarm().getGround()[NewX][NewY].getTerrain() == Terrain.DIRT)
        {
            Tile[][] TempGround = App.ReturnCurrentPlayer().getFarm().getGround();
            TempGround[NewX][NewY].setHow(true);
            CurrentPepolee.getFarm().setGround(TempGround);
            CurrentPepolee.setEnergy(CurrentPepolee.getEnergy() - hoe.getEnergyCost());
            return "Success Shokhm";
        }
        else
        {
            return "You Cant Use How in that Place";
        }
    }
    public void ApplyPickaxe()
    {

    }
    public void ApplyAxe()
    {

    }
    public void ApplyWaterCan()
    {

    }
    public void ApplyFishingPole()
    {

    }
    public void ApplySeythe()
    {

    }
    public void ApplyMilkPail()
    {

    }
    public void ApplyShear()
    {

    }
    public void ApplyTRashCan()
    {

    }
}
