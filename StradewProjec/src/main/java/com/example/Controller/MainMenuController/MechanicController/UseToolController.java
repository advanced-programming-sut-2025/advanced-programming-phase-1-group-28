package com.example.Controller.MainMenuController.MechanicController;

import com.example.Model.App;
import com.example.Model.Enums.Animals;
import com.example.Model.Enums.Entitity;
import com.example.Model.Enums.Fishes;
import com.example.Model.Enums.Terrain;
import com.example.Model.Item.*;
import com.example.Model.Tile.*;
import com.example.Model.Tools.Hoe;
import com.example.Model.Tools.Pepolee;
import com.example.Model.Tools.WaterCan;

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
            CurrentPepolee.getInventory().AddItem(newitem);
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
                int Randomfish = App.random.nextInt() % Fishes.values().length;
                int count = 0;
                for(Fishes f : Fishes.values())
                {
                    if(count == Randomfish)
                    {
                        FishItem fishitem = new FishItem(count, f.toString());
                        CurrentPepolee.getInventory().AddItem(fishitem);
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

    public String ApplySeythe()
    {
        int NewX = App.ReturnCurrentPlayer().getX();
        int NewY = App.ReturnCurrentPlayer().getY();
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
                    System.out.println("Plant Added to your inventory");
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

    public String ApplyMilkPail()
    {
        int NewX = App.ReturnCurrentPlayer().getX();
        int NewY = App.ReturnCurrentPlayer().getY();
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
