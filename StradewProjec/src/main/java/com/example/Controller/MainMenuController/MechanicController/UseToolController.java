package com.example.Controller.MainMenuController.MechanicController;

import com.example.Model.App;
import com.example.Model.Enums.Animals;
import com.example.Model.Enums.Entitity;
import com.example.Model.Enums.Fishes;
import com.example.Model.Enums.Terrain;
import com.example.Model.Item.*;
import com.example.Model.Tile.*;
import com.example.Model.Tools.*;

import javax.tools.Tool;

public class UseToolController {
    public boolean EnoughEnergy()
    {
        return false;
    }

    public void EquipTool(String ToolName)
    {
        Pepolee currentPepolee = App.ReturnCurrentPlayer();
        Tools OurTool = currentPepolee.getInventory().getToolbyname(ToolName);
        if(OurTool!=null)
        {
            currentPepolee.getInventory().setCurrentTool(OurTool);
        }
        else
        {
            System.out.println("Tool not found");
        }
    }

    public String ApplyUsing(int x, int y)
    {
        Pepolee currentPepolee = App.ReturnCurrentPlayer();
        Tools ourtool = currentPepolee.getInventory().getCurrentTool();
        if(ourtool instanceof Hoe)
        {
            return ApplyHoe(x , y);
        }
        if(ourtool instanceof Axe)
        {
            return ApplyAxe(x , y);
        }
        if(ourtool instanceof FishingPole)
        {
            return ApplyFishingPole(x , y);
        }
        if(ourtool instanceof MilkPail)
        {
            return ApplyMilkPail(x , y);
        }
        if(ourtool instanceof Pickaxe)
        {
            return ApplyPickaxe(x , y);
        }
        if(ourtool instanceof Seythe)
        {
            return ApplySeythe(x , y);
        }
        if(ourtool instanceof Shear)
        {
            return ApplyShear(x , y);
        }
        if(ourtool instanceof TrashCan)
        {
            ApplyTRashCan();
        }
        if(ourtool instanceof WaterCan)
        {
            return ApplyWaterCan(x , y);
        }
        return null;
    }

    public String ApplyHoe(int x , int y )
    {
        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
        int NewX = App.ReturnCurrentPlayer().getX() + x;
        int NewY = App.ReturnCurrentPlayer().getY() + y;
        System.out.println(NewX + " " + NewY);
        Hoe hoe = (Hoe) CurrentPepolee.getInventory().getCurrentTool();
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
        if(CurrentPepolee.getFarm().getGround()[NewX][NewY].getEntitity() == Entitity.Minreal)
        {
            TempGround[NewX][NewY].setEntitity(null);
            TempGround[NewX][NewY].setTerrain(Terrain.DIRT);
            Minreal ourmineral = (Minreal) TempGround[NewX][NewY];
            Item newitem = new MineralItem(CurrentPepolee.getSkills()[3].getLevel() * 20 , ourmineral.getMineral());
            CurrentPepolee.getSkills()[3].setXp(CurrentPepolee.getSkills()[3].getXp() + 10);
            CurrentPepolee.getInventory().AddItem(newitem);
            CurrentPepolee.getFarm().setGround(TempGround);
            return "Mineral Collected";
        }
        else
        {
            if(CurrentPepolee.getFarm().getGround()[NewX][NewY].getEntitity() == Entitity.STONE)
            {
                TempGround[NewX][NewY].setEntitity(null);
                TempGround[NewX][NewY].setTerrain(Terrain.DIRT);
                CurrentPepolee.getFarm().setGround(TempGround);
                return "Stone Removed";
            }
            else {
                if (CurrentPepolee.getFarm().getGround()[NewX][NewY].getTerrain() == Terrain.DIRT) {
                    TempGround[NewX][NewY].setHow(false);
                    CurrentPepolee.getFarm().setGround(TempGround);
                    return "Success UnShokhm";
                } else {
                    return "You Cant Use Pickaxe in that Place";
                }
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
            CurrentPepolee.getFarm().setGround(TempGround);
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
            if(CurrentPepolee.getFarm().getGround()[NewX][NewY].getEntitity() == Entitity.PLANTS)
            {
                WaterCan ourwatercan = (WaterCan) CurrentPepolee.getInventory().getCurrentTool();
                if(ourwatercan.getWater() > 1) {
                    com.example.Model.Tile.Plants ourPlant = (Plants) TempGround[NewX][NewY];
                    ourPlant.setLastTimeWatering(App.getCurrentGame().getTime());
                    ourwatercan.setWater(ourwatercan.getWater() - 2);
                    return "Watered sucssecfully";
                }
                else
                {
                    return "Not Enough Water";
                }
            }
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
                int Randomfish = App.random.nextInt() % 5;
                int Count = 0;
                for(Fishes fish : Fishes.values())
                {
                    if(fish.season == App.getCurrentGame().getTime().getSeason()) {
                        if(Count == Randomfish) {
                            int num = (App.ReturnCurrentPlayer().getSkills()[1].getLevel() + 2) * App.getCurrentGame().getWeather().FishCofficent;
                            FishItem newfish = new FishItem(num , fish);
                            App.ReturnCurrentPlayer().getInventory().AddItem(newfish);
                            App.ReturnCurrentPlayer().getSkills()[1].setXp(App.ReturnCurrentPlayer().getSkills()[1].getXp() + 10);
                        }
                        Count++;
                    }
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

    public String ApplySeythe(int x , int y)
    {
        int NewX = App.ReturnCurrentPlayer().getX() + x;
        int NewY = App.ReturnCurrentPlayer().getY() + y;
        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
        Tile[][] TempGround = App.ReturnCurrentPlayer().getFarm().getGround();
        CurrentPepolee.setEnergy(CurrentPepolee.getEnergy() - 2);
        if(TempGround[NewX][NewY].getTerrain() == Terrain.GRASS)
        {
            TempGround[NewX][NewY].setTerrain(Terrain.DIRT);
            CurrentPepolee.getFarm().setGround(TempGround);
            return "Success Cutting Grass";
        }
        else {
            if (TempGround[NewX][NewY].getEntitity() == Entitity.PLANTS) {
                Plants ourplant = (Plants) TempGround[NewX][NewY];
                if(ourplant.CanHarvest()) {
                    CurrentPepolee.getInventory().AddItem(new PlantsItem(1, ourplant.getPlant()));
                    if(ourplant.getPlant().Source != null) {
                        CurrentPepolee.getSkills()[2].setXp(CurrentPepolee.getSkills()[2].getXp() + 5);
                    }
                    else {
                        CurrentPepolee.getSkills()[0].setXp(CurrentPepolee.getSkills()[0].getXp() + 10);
                    }
                    System.out.println("Plant Added to your inventory");
                    if(ourplant.getPlant().RegrowthTime == 0)
                    {
                        TempGround[NewX][NewY].setPlaceType(null);
                        TempGround[NewX][NewY].setTerrain(Terrain.DIRT);
                        TempGround[NewX][NewY].setEntitity(null);
                    }
                }
                else
                {
                    System.out.println("Your Item dont grow completely");
                }
            }
            else
            {

            }

        }
        return null;
    }

    public String ApplyMilkPail(int x , int y)
    {
        int NewX = App.ReturnCurrentPlayer().getX() + x;
        int NewY = App.ReturnCurrentPlayer().getY() + y;
        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
        Tile[][] TempGround = App.ReturnCurrentPlayer().getFarm().getGround();
        Ingredient newingredient = new Ingredient(0  , null);
        if(TempGround[NewX][NewY].getEntitity() == Entitity.ANIMAL)
        {
            Animal OurAnimal = (Animal) TempGround[NewX][NewY];
            //TO Check If it has Milk
            if(OurAnimal.getAnimalType() == Animals.Cow)
            {
                newingredient = new Ingredient(1 ,  com.example.Model.Enums.Ingredients.CowMilk);
            }
            if(OurAnimal.getAnimalType() == Animals.Goat)
            {
                newingredient = new Ingredient(1 , com.example.Model.Enums.Ingredients.GoatMilk);
            }
            CurrentPepolee.getInventory().AddItem(newingredient);
            return "Success Milking";
        }
        else
        {
            return "You Cant Use Milk Pail in that Place";
        }
    }

    public String ApplyShear(int x , int y)
    {
        int NewX = App.ReturnCurrentPlayer().getX();
        int NewY = App.ReturnCurrentPlayer().getY();
        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
        Tile[][] TempGround = App.ReturnCurrentPlayer().getFarm().getGround();
        if(TempGround[NewX][NewY].getEntitity() == Entitity.ANIMAL)
        {
            Animal ourAnimal = (Animal) TempGround[NewX][NewY];
            if(ourAnimal.getAnimalType() == Animals.Sheep)
            {
                //To check If HAs Pashm
                Ingredient newingrdient = new Ingredient(5  , com.example.Model.Enums.Ingredients.SheepCotton);
                CurrentPepolee.getInventory().AddItem(newingrdient);
                return "Success CuttinPashm";
            }
            return "You Cant Use Sheep Pail in this Animal";
        }
        else
        {
            return "cut Pashm please";
        }
    }

    public void ApplyTRashCan()
    {

    }

}
