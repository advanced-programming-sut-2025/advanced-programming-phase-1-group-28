package com.example.Controller.MainMenuController.MechanicController;

import com.example.Model.App;
import com.example.Model.Enums.Entitity;
import com.example.Model.Enums.Fishes;
import com.example.Model.Enums.Terrain;
import com.example.Model.Item.FishItem;
import com.example.Model.Item.Item;
import com.example.Model.Item.MineralItem;
import com.example.Model.Tile.Minreal;
import com.example.Model.Tile.Tile;
import com.example.Model.Tile.Trees;
import com.example.Model.Tools.Hoe;
import com.example.Model.Tools.Pepolee;
import com.example.Model.Tools.WaterCan;

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

    public String ApplyPickaxe(int x , int y)
    {
        int NewX = App.ReturnCurrentPlayer().getX() + x;
        int NewY = App.ReturnCurrentPlayer().getY() + y;
        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
        Tile[][] TempGround = App.ReturnCurrentPlayer().getFarm().getGround();
        if(CurrentPepolee.getFarm().getGround()[NewX][NewY].getEntitity() == Entitity.STONE)
        {
            TempGround[NewX][NewY].setEntitity(null);
            TempGround[NewX][NewY].setTerrain(Terrain.DIRT);
            Minreal ourmineral = (Minreal) TempGround[NewX][NewY];
            Item newitem = new MineralItem(20 , ourmineral.getMineral().name());
            boolean IsHere = false;
            for(int i = 0 ;i < CurrentPepolee.getInventory().getItems().size() ; i++)
            {
                if(CurrentPepolee.getInventory().getItems().get(i).getName().equals(newitem.getName()))
                {
                    CurrentPepolee.getInventory().getItems().get(i).setCount(newitem.getCount() + CurrentPepolee.getInventory().getItems().get(i).getCount());
                    IsHere = true;
                }
            }
            if(!IsHere)
            {
                CurrentPepolee.getInventory().getItems().add(newitem);
            }
            CurrentPepolee.getFarm().setGround(TempGround);
            return "Mineral Collected";
        }
        else
        {
            if(CurrentPepolee.getFarm().getGround()[NewX][NewY].getTerrain() == Terrain.DIRT)
            {
                TempGround[NewX][NewY].setHow(false);
                CurrentPepolee.getFarm().setGround(TempGround);
                return "Success UnShokhm";
            }
            else
            {
                return "You Cant Use Pickaxe in that Place";
            }
        }
    }

    public String ApplyAxe(int x , int y)
    {
        int NewX = App.ReturnCurrentPlayer().getX() + x;
        int NewY = App.ReturnCurrentPlayer().getY() + y;
        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
        Tile[][] TempGround = App.ReturnCurrentPlayer().getFarm().getGround();
        if(TempGround[NewX][NewY].getEntitity() == Entitity.TREE)
        {
            Trees tree = (Trees) TempGround[NewX][NewY];
            CurrentPepolee.setWood(CurrentPepolee.getWood() + 100);
            TempGround[NewX][NewY].setEntitity(null);
            TempGround[NewX][NewY].setTerrain(Terrain.DIRT);
            CurrentPepolee.setEnergy(CurrentPepolee.getEnergy() - CurrentPepolee.getInventory().getCurrentTool().getEnergyCost());
            return "Success Using Axe";
        }
        else
        {
            return "You Cant Use Axe in that Place";
        }
    }

    public String ApplyWaterCan(int x , int y)
    {
        int NewX = App.ReturnCurrentPlayer().getX() + x;
        int NewY = App.ReturnCurrentPlayer().getY() + y;
        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
        Tile[][] TempGround = App.ReturnCurrentPlayer().getFarm().getGround();
        if(CurrentPepolee.getFarm().getGround()[NewX][NewY].getTerrain() == Terrain.WATER)
        {
            WaterCan ourwatercan = (WaterCan) CurrentPepolee.getInventory().getCurrentTool();
            ourwatercan.setWater(Math.min(ourwatercan.getWater() + 50 , ourwatercan.getWatercan().Limit));
            CurrentPepolee.setEnergy(CurrentPepolee.getEnergy() - ourwatercan.getEnergyCost());
            return "Watercan filled";
        }
        else
        {
            return "You Cant Use Water in that Place";
        }
    }

    public String ApplyFishingPole(int x ,int y)
    {
        int NewX = App.ReturnCurrentPlayer().getX() + x;
        int NewY = App.ReturnCurrentPlayer().getY() + y;
        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
        Tile[][] TempGround = App.ReturnCurrentPlayer().getFarm().getGround();
        if(TempGround[NewX][NewY].getTerrain() == Terrain.WATER)
        {
            int RandomSucsses = App.random.nextInt() % 3;
            if(RandomSucsses != 0)
            {
                int Randomfish = App.random.nextInt() % Fishes.values().length;
                int count = 0;
                for(Fishes f : Fishes.values())
                {
                    if(count == Randomfish)
                    {
                        FishItem fishitem = new FishItem(count, f.toString());
                        boolean ISHere = false;
                        for(int i = 0 ;i < CurrentPepolee.getInventory().getItems().size() ; i++)
                        {
                            if(CurrentPepolee.getInventory().getItems().get(i).getName().equals(fishitem.getName()))
                            {
                                CurrentPepolee.getInventory().getItems().get(i).setCount(CurrentPepolee.getInventory().getItems().get(i).getCount() + 1);
                                ISHere = true;
                            }
                        }
                        if(!ISHere) {
                            CurrentPepolee.getInventory().getItems().add(fishitem);
                        }
                    }
                    count++;
                }
                return "Fish Added To your inventory";
            }
            else
            {
                return "Fishing Pole failed to catch fish";
            }
        }
        else
        {
            return "You Cant Use Fishing Pole in that Place";
        }
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
