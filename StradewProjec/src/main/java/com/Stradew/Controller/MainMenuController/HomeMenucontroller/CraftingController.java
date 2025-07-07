package com.Stradew.Controller.MainMenuController.HomeMenucontroller;

import com.Stradew.Model.App;
import com.Stradew.Model.Enums.Crafts;
import com.Stradew.Model.Enums.PlaceType;
import com.Stradew.Model.Enums.Skills;
import com.Stradew.Model.Enums.Terrain;
import com.Stradew.Model.Item.Craft;
import com.Stradew.Model.Item.Item;
import com.Stradew.Model.Tile.PlantedCrafts;
import com.Stradew.Model.Tile.Tile;
import com.Stradew.Model.Tools.Pepolee;

public class CraftingController {


    public String ShowCraft(Crafts craft)
    {
        Pepolee currentPepolee = App.ReturnCurrentPlayer();
        if (craft == Crafts.Dehydrator)
        {
            for(int i = 0;i < currentPepolee.getOverflowItems().size() ; i++)
            {
                if(currentPepolee.getOverflowItems().get(i).getName().equals("DEHYDRATOR_RECIPE"))
                {
                    return craft.toString() + ":" + "Unlocked" + "\n";
                }
            }
            return craft.toString() + ":"  + "Locked" + "\n";
        }
        if(craft == Crafts.FishSmoker)
        {
            for(int i = 0;i < currentPepolee.getOverflowItems().size() ; i++)
            {
                if(currentPepolee.getOverflowItems().get(i).getName().equals("FISH_SMOKER_RECIPE"))
                {
                    return craft.toString() + ":" + "Unlocked" + "\n";
                }
            }
            return craft.toString() + ":"  + "Locked"  + "\n";
        }
        if(craft == Crafts.GrassStarter)
        {
            for(int i = 0;i < currentPepolee.getOverflowItems().size() ; i++)
            {
                if(currentPepolee.getOverflowItems().get(i).getName().equals("GRASS_STARTER_RECIPE"))
                {
                    return craft.toString() + ":" + "Unlocked" + "\n";
                }
            }
            return craft.toString() + ":"  + "Locked"  + "\n";
        }
        if(craft.skill == null)
        {
            return craft.toString() + ":" + "Unlocked" + "\n";
        }
        else
        {
            Skills craftskill  = craft.skill;
            for(int i = 0;i  < 4 ; i++)
            {
                if(currentPepolee.getSkills()[i].getSkill() == craftskill)
                {
                    if(currentPepolee.getSkills()[i].getLevel() >= craft.level)
                    {
                        return craft.toString() + ":" + "Unlocked" + "\n";
                    }
                    else
                    {
                        return craft.toString() + ":"  + "Locked"  + "\n";
                    }
                }
            }
        }
        return craft.toString() + ":"  + "Locked"  + "\n";
    }

    public Crafts ReturnCraft(String craftname)
    {
        for(Crafts c : Crafts.values())
        {
            if(c.Name.equalsIgnoreCase(craftname))
            {
                return c;
            }
        }
        return null;
    }

    public boolean CanPlantCraft(int x, int y)
    {
        Pepolee Currentpeople = App.ReturnCurrentPlayer();
        int Newx = Currentpeople.getX() + x;
        int Newy = Currentpeople.getY() + y;
        Tile[][] Tempground = Currentpeople.getFarm().getGround();
        if(Tempground[Newx][Newy].getTerrain() == Terrain.DIRT && Tempground[Newx][Newy].getEntitity() == null && Tempground[Newx][Newy].getPlaceType() == null){
            return true;
        }
        return false;
    }

    public boolean EnoughSource(Crafts craft)
    {
        Pepolee currentPepolee = App.ReturnCurrentPlayer();
        for(int i = 0;i < craft.Ingredients.size();i++)
        {
            boolean ok = false;
            for(int j = 0;j < currentPepolee.getInventory().getItems().size();j++)
            {
                if(currentPepolee.getInventory().getItems().get(j).getName().equals(craft.Ingredients.get(i)))
                {
                    if(currentPepolee.getInventory().getItems().get(j).getCount() > craft.Count.get(i))
                    {
                        ok = true;
                    }
                }
            }
            if(!ok)
            {
                return false;
            }
        }
        return true;
    }

    public boolean IsInInventory(String Itemname)
    {
        Item item = App.ReturnCurrentPlayer().getInventory().getItemByName(Itemname);
        return item instanceof Craft;
    }

    public void ApplyCrafting(Crafts craft)
    {
        Pepolee currentPepolee = App.ReturnCurrentPlayer();
        for(int i = 0;i < craft.Ingredients.size();i++)
        {
            for(int j = 0;j < currentPepolee.getInventory().getItems().size();j++)
            {
                if(currentPepolee.getInventory().getItems().get(j).getName().equals(craft.Ingredients.get(i)))
                {
                    currentPepolee.getInventory().getItems().get(j).setCount(currentPepolee.getInventory().getItems().get(j).getCount() - craft.Count.get(i));
                }
            }
        }
        currentPepolee.setCoin(currentPepolee.getCoin() - craft.SellPrice);
        currentPepolee.setEnergy(currentPepolee.getEnergy() - 2);
        Craft newcraft = new Craft(1 , craft);
        currentPepolee.getInventory().AddItem(newcraft);
    }
    public void ApplyPlantCraft(String ItemName , int x , int y)
    {
        Pepolee Currentpeople = App.ReturnCurrentPlayer();
        int Newx = Currentpeople.getX() + x;
        int Newy = Currentpeople.getY() + y;
        Tile[][] Tempground = Currentpeople.getFarm().getGround();
        Item item = App.ReturnCurrentPlayer().getInventory().getItemByName(ItemName);
        Craft ourcraft = (Craft) item;
        PlantedCrafts newplantedCraft = new PlantedCrafts(null , PlaceType.Craft , null , ourcraft.getCrafts());
        Tempground[Newx][Newy] = newplantedCraft;
        Currentpeople.getFarm().setGround(Tempground);
    }


}
