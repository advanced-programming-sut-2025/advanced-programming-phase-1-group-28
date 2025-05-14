package com.example.Controller.MainMenuController.MechanicController;

import com.example.Model.App;
import com.example.Model.Enums.*;
import com.example.Model.Enums.Tools.*;
import com.example.Model.Item.Craft;
import com.example.Model.Item.Food;
import com.example.Model.Item.Ingredient;
import com.example.Model.Item.Item;
import com.example.Model.Places.AnimalHouse;
import com.example.Model.Tile.Animal;
import com.example.Model.Tools.*;

import java.util.ArrayList;

public class ShoppingController {
    public void ApplyBlackSmithPurchase(String ProductName , int count)
    {
        if(App.getCurrentGame().getTime().getHour() < 9 || App.getCurrentGame().getTime().getHour() > 16)
        {
            System.out.println("Store is closed");
            return;
        }
        // from 9 am to 4 pm
        // for mining
        // upgrading tools
        if(ProductName.equals("Copper Ore"))
        {
            UnlimitedBuying(ProductName , count , 75);
        }
        else if(ProductName.equals("Iron Ore"))
        {
            UnlimitedBuying(ProductName , count , 150);
        }
        else if(ProductName.equals("Gold Ore"))
        {
            UnlimitedBuying(ProductName , count , 400);
        }
        else if(ProductName.equals("Coal"))
        {
            UnlimitedBuying(ProductName , count , 150);
        }
        else if(ProductName.equals("Copper Axe"))
        {
            Axe newAxe = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Axe)
                {
                    newAxe = (Axe) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[0] = UpgradeAxe(newAxe , "Copper Bar" , count , 2000 , newLimits[0] , Axes.Normal , Axes.Copper);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Steel Axe"))
        {
            Axe newAxe = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Axe)
                {
                    newAxe = (Axe) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[1] = UpgradeAxe(newAxe , "Iron Bar" , count , 5000 , newLimits[1] , Axes.Copper , Axes.Iron);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Gold Axe"))
        {
            Axe newAxe = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Axe)
                {
                    newAxe = (Axe) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[2] = UpgradeAxe(newAxe , "Gold Bar" , count , 10000 , newLimits[2] , Axes.Iron , Axes.Gold);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Copper Hoe"))
        {
            Hoe newHoe = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Hoe)
                {
                    newHoe = (Hoe) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[0] = UpgradeHoe(newHoe , "Copper Bar" , count , 2000 , newLimits[0] , Hoes.Normal , Hoes.Copper);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Steel Hoe"))
        {
            Hoe newHoe = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Hoe)
                {
                    newHoe = (Hoe) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[1] = UpgradeHoe(newHoe , "Iron Bar" , count , 5000 , newLimits[1] , Hoes.Copper , Hoes.Iron);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Gold Hoe"))
        {
            Hoe newHoe = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Hoe)
                {
                    newHoe = (Hoe) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[2] = UpgradeHoe(newHoe , "Gold Bar" , count , 10000 , newLimits[2] , Hoes.Iron , Hoes.Gold);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Copper MilkPail"))
        {
            MilkPail newMilkPail = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof MilkPail)
                {
                    newMilkPail = (MilkPail) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[0] = UpgradeMilkPail(newMilkPail , "Copper Bar" , count , 2000 , newLimits[0] , MilkPails.Normal , MilkPails.Copper);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Steel MilkPail"))
        {
            MilkPail newMilkPail = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof MilkPail)
                {
                    newMilkPail = (MilkPail) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[1] = UpgradeMilkPail(newMilkPail , "Iron Bar" , count , 5000 , newLimits[1] , MilkPails.Copper , MilkPails.Iron);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Gold MilkPail"))
        {
            MilkPail newMilkPail = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof MilkPail)
                {
                    newMilkPail = (MilkPail) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[2] = UpgradeMilkPail(newMilkPail , "Gold Bar" , count , 10000 , newLimits[2] , MilkPails.Iron , MilkPails.Gold);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Copper WaterCan"))
        {
            WaterCan newWaterCan = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof WaterCan)
                {
                    newWaterCan = (WaterCan) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[0] = UpgradeWaterCan(newWaterCan , "Copper Bar" , count , 2000 , newLimits[0] , Watercans.Normal , Watercans.Copper);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Steel WaterCan"))
        {
            WaterCan newWaterCan = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof WaterCan)
                {
                    newWaterCan = (WaterCan) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[1] = UpgradeWaterCan(newWaterCan , "Iron Bar" , count , 5000 , newLimits[1] , Watercans.Copper , Watercans.Iron);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Gold WaterCan"))
        {
            WaterCan newWaterCan = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof WaterCan)
                {
                    newWaterCan = (WaterCan) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[2] = UpgradeWaterCan(newWaterCan , "Gold Bar" , count , 10000 , newLimits[2] , Watercans.Iron , Watercans.Gold);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Copper Shear"))
        {
            Shear newShear = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Shear)
                {
                    newShear = (Shear) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[0] = UpgradeShear(newShear , "Copper Bar" , count , 2000 , newLimits[0] , Shears.Normal , Shears.Copper);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Steel Shear"))
        {
            Shear newShear = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Shear)
                {
                    newShear = (Shear) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[1] = UpgradeShear(newShear , "Iron Bar" , count , 5000 , newLimits[1] , Shears.Copper , Shears.Iron);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Gold Shear"))
        {
            Shear newShear = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Shear)
                {
                    newShear = (Shear) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[2] = UpgradeShear(newShear , "Gold Bar" , count , 10000 , newLimits[2] , Shears.Iron , Shears.Gold);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Copper Pickaxe"))
        {
            Pickaxe newPickaxe = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Pickaxe)
                {
                    newPickaxe = (Pickaxe) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[0] = UpgradePickaxe(newPickaxe , "Copper Bar" , count , 2000 , newLimits[0] , Pickaxes.Normal , Pickaxes.Copper);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Steel Pickaxe"))
        {
            Pickaxe newPickaxe = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Pickaxe)
                {
                    newPickaxe = (Pickaxe) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[1] = UpgradePickaxe(newPickaxe , "Iron Bar" , count , 5000 , newLimits[1] , Pickaxes.Copper , Pickaxes.Iron);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Gold Pickaxe"))
        {
            Pickaxe newPickaxe = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Pickaxe)
                {
                    newPickaxe = (Pickaxe) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[2] = UpgradePickaxe(newPickaxe , "Gold Bar" , count , 10000 , newLimits[2] , Pickaxes.Iron , Pickaxes.Gold);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Copper Seythe"))
        {
            Seythe newSeythe = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Seythe)
                {
                    newSeythe = (Seythe) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[0] = UpgradeSeythe(newSeythe , "Copper Bar" , count , 2000 , newLimits[0] , Seythes.Normal , Seythes.Copper);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Steel Seythe"))
        {
            Seythe newSeythe = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Seythe)
                {
                    newSeythe = (Seythe) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[1] = UpgradeSeythe(newSeythe , "Iron Bar" , count , 5000 , newLimits[1] , Seythes.Copper , Seythes.Iron);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Gold Seythe"))
        {
            Seythe newSeythe = null;
            for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tools instanceof Seythe)
                {
                    newSeythe = (Seythe) tools;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[2] = UpgradeSeythe(newSeythe , "Gold Bar" , count , 10000 , newLimits[2] , Seythes.Iron , Seythes.Gold);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Copper Trash Can"))
        {
            TrashCan newTrashCan = null;
            for(Tools tool : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tool instanceof TrashCan)
                {
                    newTrashCan = (TrashCan) tool;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[3] = UpgradeTrashCan(newTrashCan , "Copper Bar" , count , 1000 , newLimits[3] , Trashcans.Copper , Trashcans.Normal);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Steel Trash Can"))
        {
            TrashCan newTrashCan = null;
            for(Tools tool : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tool instanceof TrashCan)
                {
                    newTrashCan = (TrashCan) tool;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[4] = UpgradeTrashCan(newTrashCan , "Iron Bar" , count , 2000 , newLimits[4] , Trashcans.Iron , Trashcans.Copper);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Gold Trash Can"))
        {
            TrashCan newTrashCan = null;
            for(Tools tool : App.ReturnCurrentPlayer().getInventory().getTools())
            {
                if(tool instanceof TrashCan)
                {
                    newTrashCan = (TrashCan) tool;
                }
            }
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[5] = UpgradeTrashCan(newTrashCan , "Gold Bar" , count , 5000 , newLimits[5] , Trashcans.Gold , Trashcans.Iron);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else
        {
            System.out.println("Item not found");
        }
    }
    public void ApplyMarineRanchPurchase(String ProductName , String CountOrName)
    {
        if(App.getCurrentGame().getTime().getHour() < 9 || App.getCurrentGame().getTime().getHour() > 16)
        {
            System.out.println("Store is closed");
            return;
        }
        if(ProductName.equals("Hay"))
        {
            int count = Integer.parseInt(CountOrName);
            UnlimitedBuying(ProductName , count , 50);
        }
        else if(ProductName.equals("Milk Pail"))
        {
            int count = Integer.parseInt(CountOrName);
            int newLimits[] = App.dailyLimits.getMarineRanch();
            MilkPail newMilkPail = new MilkPail(MilkPails.Normal);
            newMilkPail.setCount(count);
            newMilkPail.setExist(true);
            newLimits[0] = BuyTool(newMilkPail , count , 1000 , newLimits[0]);
            App.dailyLimits.setMarineRanch(newLimits);
        }
        else if(ProductName.equals("Shears"))
        {
            int count = Integer.parseInt(CountOrName);
            int newLimits[] = App.dailyLimits.getMarineRanch();
            Shear newShear = new Shear(Shears.Normal);
            newShear.setCount(count);
            newShear.setExist(true);
            newLimits[1] = BuyTool(newShear , count , 1000 , newLimits[1]);
            App.dailyLimits.setMarineRanch(newLimits);
        }
        else if(ProductName.equals("Chicken"))
        {
            int newLimits[] = App.dailyLimits.getMarineRanch();
            newLimits[2] = BuyCoopAnimal(CountOrName , "Coop" , Animals.Chicken , newLimits[2] , 800);
            App.dailyLimits.setMarineRanch(newLimits);
        }
        else if(ProductName.equals("Duck"))
        {
            int newLimits[] = App.dailyLimits.getMarineRanch();
            newLimits[5] = BuyCoopAnimal(CountOrName , "Big Coop" , Animals.Duck , newLimits[5] , 1200);
            App.dailyLimits.setMarineRanch(newLimits);
        }
        else if(ProductName.equals("Rabbit"))
        {
            int newLimits[] = App.dailyLimits.getMarineRanch();
            newLimits[7] = BuyCoopAnimal(CountOrName , "Deluxe Coop" , Animals.Rabbit , newLimits[7] , 8000);
            App.dailyLimits.setMarineRanch(newLimits);
        }
        else if(ProductName.equals("Dinosaur"))
        {
            int newLimits[] = App.dailyLimits.getMarineRanch();
            newLimits[8] = BuyCoopAnimal(CountOrName , "Big Coop" , Animals.Dinosaur , newLimits[8] , 14000);
            App.dailyLimits.setMarineRanch(newLimits);
        }
        else if(ProductName.equals("Cow"))
        {
            int newLimits[] = App.dailyLimits.getMarineRanch();
            newLimits[3] = BuyBarnAnimal(CountOrName , "Barn" , Animals.Cow , newLimits[3] , 1500);
            App.dailyLimits.setMarineRanch(newLimits);
        }
        else if(ProductName.equals("Goat"))
        {
            int newLimits[] = App.dailyLimits.getMarineRanch();
            newLimits[4] = BuyBarnAnimal(CountOrName , "Big Barn" , Animals.Duck , newLimits[4] , 4000);
            App.dailyLimits.setMarineRanch(newLimits);
        }
        else if(ProductName.equals("Sheep"))
        {
            int newLimits[] = App.dailyLimits.getMarineRanch();
            newLimits[6] = BuyBarnAnimal(CountOrName , "Deluxe Barn" , Animals.Sheep , newLimits[6] , 8000);
            App.dailyLimits.setMarineRanch(newLimits);
        }
        else if(ProductName.equals("Pig"))
        {
            int newLimits[] = App.dailyLimits.getMarineRanch();
            newLimits[9] = BuyBarnAnimal(CountOrName , "Deluxe Barn" , Animals.Pig , newLimits[9] , 16000);
            App.dailyLimits.setMarineRanch(newLimits);
        }
        else
        {
            System.out.println("Item not found");
        }
    }
    public void ApplyStarDropSaloon(String ProductName , int count)
    {
        if(App.getCurrentGame().getTime().getHour() < 12 || App.getCurrentGame().getTime().getHour() > 24)
        {
            System.out.println("Store is closed");
            return;
        }
        if(ProductName.equals("Beer"))
        {
            UnlimitedFoodBuying(new Food(count , Foods.Beer) , count , 400);
        }
        else if(ProductName.equals("Salad"))
        {
            UnlimitedFoodBuying(new Food(count , Foods.Salad) , count , 220);
        }
        else if(ProductName.equals("Bread"))
        {
            UnlimitedFoodBuying(new Food(count , Foods.Bread) , count , 120);
        }
        else if(ProductName.equals("Spaghetti"))
        {
            UnlimitedFoodBuying(new Food(count , Foods.Spaghetti) , count , 240);
        }
        else if(ProductName.equals("Pizza"))
        {
            UnlimitedFoodBuying(new Food(count , Foods.Pizza) , count , 600);
        }
        else if(ProductName.equals("Coffee"))
        {
            UnlimitedFoodBuying(new Food(count , Foods.TripleShotEspresso) , count , 300);
        }
        else if(ProductName.equals("Hashbrowns Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[0] = BuyRecipe(Foods.HashBrowns , count , 50 , newLimits[0]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Omlete Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[1] = BuyRecipe(Foods.Olmelet , count , 100 , newLimits[1]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Pancakes Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[2] = BuyRecipe(Foods.Pancakes , count , 100 , newLimits[2]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Bread Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[3] = BuyRecipe(Foods.Bread , count , 100 , newLimits[3]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Tortilla Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[4] = BuyRecipe(Foods.Tortilla , count , 100 , newLimits[4]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Pizza Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[5] = BuyRecipe(Foods.Pizza , count , 150 , newLimits[5]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Maki Roll Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[6] = BuyRecipe(Foods.MakiRoll , count , 300 , newLimits[6]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Triple Shot Espresso Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[7] = BuyRecipe(Foods.TripleShotEspresso , count , 5000 , newLimits[7]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Cookie Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[8] = BuyRecipe(Foods.Cookie , count , 300 , newLimits[8]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else
        {
            System.out.println("Item not found");
        }
    }
    public void ApplyCarpenterShop(String ProductName , String CountOrCoordinate)
    {
        if(App.getCurrentGame().getTime().getHour() < 9 || App.getCurrentGame().getTime().getHour() > 20)
        {
            System.out.println("Store is closed");
            return;
        }
        if(ProductName.equals("Wood"))
        {
            UnlimitedBuying(ProductName , Integer.parseInt(CountOrCoordinate), 10);
        }
        else if(ProductName.equals("Stone"))
        {
            UnlimitedBuying(ProductName , Integer.parseInt(CountOrCoordinate), 20);
        }
        else if(ProductName.equals("Barn"))
        {
            String parts[] = CountOrCoordinate.trim().split("\\s+");
            int newLimits[] = App.dailyLimits.getCarpenterShop();
            newLimits[0] = BuildBarn(ProductName , 4 , Integer.parseInt(parts[0]) , Integer.parseInt(parts[1]) , 6000 , 350 , 150 , newLimits[0]);
            App.dailyLimits.setCarpenterShop(newLimits);
        }
        else if(ProductName.equals("Big Barn"))
        {
            String parts[] = CountOrCoordinate.trim().split("\\s+");
            int newLimits[] = App.dailyLimits.getCarpenterShop();
            newLimits[1] = BuildBarn(ProductName , 8 , Integer.parseInt(parts[0]) , Integer.parseInt(parts[1]) , 12000 , 450 , 200 , newLimits[1]);
            App.dailyLimits.setCarpenterShop(newLimits);
        }
        else if(ProductName.equals("Deluxe Barn"))
        {
            String parts[] = CountOrCoordinate.trim().split("\\s+");
            int newLimits[] = App.dailyLimits.getCarpenterShop();
            newLimits[2] = BuildBarn(ProductName , 12 , Integer.parseInt(parts[0]) , Integer.parseInt(parts[1]) , 25000 , 550 , 300 , newLimits[2]);
            App.dailyLimits.setCarpenterShop(newLimits);
        }
        else if(ProductName.equals("Coop"))
        {
            String parts[] = CountOrCoordinate.trim().split("\\s+");
            int newLimits[] = App.dailyLimits.getCarpenterShop();
            newLimits[3] = BuildCoop(ProductName , 4 , Integer.parseInt(parts[0]) , Integer.parseInt(parts[1]) , 4000 , 300 , 100 , newLimits[3]);
            App.dailyLimits.setCarpenterShop(newLimits);
        }
        else if(ProductName.equals("Big Coop"))
        {
            String parts[] = CountOrCoordinate.trim().split("\\s+");
            int newLimits[] = App.dailyLimits.getCarpenterShop();
            newLimits[4] = BuildCoop(ProductName , 8 , Integer.parseInt(parts[0]) , Integer.parseInt(parts[1]) , 10000 , 400 , 150 , newLimits[4]);
            App.dailyLimits.setCarpenterShop(newLimits);
        }
        else if(ProductName.equals("Deluxe Coop"))
        {
            String parts[] = CountOrCoordinate.trim().split("\\s+");
            int newLimits[] = App.dailyLimits.getCarpenterShop();
            newLimits[5] = BuildCoop(ProductName , 12 , Integer.parseInt(parts[0]) , Integer.parseInt(parts[1]) , 20000 , 500 , 200 , newLimits[5]);
            App.dailyLimits.setCarpenterShop(newLimits);
        }
        else if(ProductName.equals("Well"))
        {

        }
        else if(ProductName.equals("Shipping Been"))
        {
            //String parts[] = CountOrCoordinate.trim().split("\\s+");
        }
        else
        {
            System.out.println("Item not found");
        }
    }
    public void ApplyJojaMart(String ProductName , int count)
    {
        if(App.getCurrentGame().getTime().getHour() < 9 || App.getCurrentGame().getTime().getHour() > 23)
        {
            System.out.println("Store is closed");
            return;
        }
        if(ProductName.equals("Joja Cola"))
        {
            UnlimitedBuying(ProductName , count, 75);
        }
        else if(ProductName.equals("Grass Starter"))
        {
            UnlimitedCraftBuying(Crafts.GrassStarter , count , 125);
        }
        else if(ProductName.equals("Sugar"))
        {
            UnlimitedIngredientBuying(Ingredients.Sugar , count , 125);
        }
        else if(ProductName.equals("Wheat Flour"))
        {
            UnlimitedIngredientBuying(Ingredients.Wheat_Flour , count , 125);
        }
        else if(ProductName.equals("Rice"))
        {
            UnlimitedIngredientBuying(Ingredients.Rice , count , 250);
        }
        else
        {
            boolean seedExists = false;
            for(JojaMartItems mySeed : JojaMartItems.values())
            {
                if(mySeed.name().equals(ProductName) && mySeed.Price >= 0)
                {
                    seedExists = true;
                    int newLimits[] = App.dailyLimits.getJojaMart();
                    if(newLimits[mySeed.LimitIndex] - count < 0)
                    {
                        System.out.println("You have reached the daily limit for this item");
                        return;
                    }
                    if(count * mySeed.Price > App.ReturnCurrentPlayer().getCoin())
                    {
                        System.out.println("Not enough money bro");
                        return;
                    }
                    newLimits[mySeed.LimitIndex] -= count;
                    App.dailyLimits.setJojaMart(newLimits);
                    App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * mySeed.Price);
                    ArrayList<Seeds> newSeeds = App.ReturnCurrentPlayer().getInventory().getSeeds();
                    boolean found = false;
                    for(Seeds seed : newSeeds)
                    {
                        if(seed.equals(mySeed.Seed))
                        {
                            found = true;
                        }
                    }
                    if(!found)
                    {
                        if(!App.ReturnCurrentPlayer().getInventory().canAddNewItem())
                        {
                            System.out.println("Inventory is full");
                            return;
                        }
                    }
                    while(count > 0)
                    {
                        newSeeds.add(mySeed.Seed);
                        count--;
                    }
                    App.ReturnCurrentPlayer().getInventory().setSeeds(newSeeds);
                    System.out.println("Seed added");
                    break;
                }
            }
            if(!seedExists)
            {
                System.out.println("Item not found");
            }
        }
    }
    public void ApplyPierreStore(String ProductName , int count)
    {
        if(App.getCurrentGame().getTime().getHour() < 9 || App.getCurrentGame().getTime().getHour() > 17)
        {
            System.out.println("Store is closed");
            return;
        }
        boolean itemExists = false;
        for(PierreStoreItems myItem : PierreStoreItems.values())
        {
            if(myItem.name().equals(ProductName))
            {
                itemExists = true;
                if(myItem.LimitIndex < 0)
                {
                    if(myItem.Ingredient != null)
                    {
                        UnlimitedIngredientBuying(myItem.Ingredient , count , myItem.Price);
                    }
                    else if(myItem.saplings != null)
                    {
                        UnlimitedSaplingBuying(myItem.saplings , count , myItem.Price);
                    }
                    else if(myItem.crafts != null)
                    {
                        UnlimitedCraftBuying(myItem.crafts , count , myItem.Price);
                    }
                }
                else if(myItem.LimitIndex < 2)
                {
                    int newLimits[] = App.dailyLimits.getPierreStore();
                    newLimits[myItem.LimitIndex] = LimitedBuying(ProductName , count , myItem.Price , newLimits[myItem.LimitIndex]);
                    App.dailyLimits.setPierreStore(newLimits);
                }
                else if(myItem.LimitIndex == 2 || myItem.LimitIndex == 3)
                {
                    // check for limit
                    int newLimits[] = App.dailyLimits.getPierreStore();
                    if(newLimits[myItem.LimitIndex] - count < 0)
                    {
                        System.out.println("You have reached the daily limit for this item");
                        return;
                    }
                    // check for price
                    if(count * myItem.Price > App.ReturnCurrentPlayer().getCoin())
                    {
                        System.out.println("Not enough money bro");
                        return;
                    }
                    // set new limits
                    newLimits[myItem.LimitIndex] -= count;
                    App.dailyLimits.setPierreStore(newLimits);
                    // pay the price
                    App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * myItem.Price);
                    // adding the overflowing item
                    for(Item item : App.ReturnCurrentPlayer().getOverflowItems())
                    {
                        if(item.getName().equals(ProductName))
                        {
                            item.setCount(item.getCount() + count);
                            System.out.println(ProductName + " purchased");
                            return;
                        }
                    }
                    App.ReturnCurrentPlayer().addOverflowItem(new Item(count , ProductName));
                    System.out.println(ProductName + " purchased");
                    return;
                }
                else if(myItem.LimitIndex == 4)
                {
                    // make the pack/inventory large
                    // check for limit
                    int newLimits[] = App.dailyLimits.getPierreStore();
                    if(newLimits[myItem.LimitIndex] - count < 0)
                    {
                        System.out.println("You have reached the daily limit for this item");
                        return;
                    }
                    // check for enough money
                    if(count * myItem.Price > App.ReturnCurrentPlayer().getCoin())
                    {
                        System.out.println("Not enough money bro");
                        return;
                    }
                    // set new limits
                    newLimits[myItem.LimitIndex] -= count;
                    App.dailyLimits.setPierreStore(newLimits);
                    // pay the price
                    App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * myItem.Price);
                    // add capacity
                    App.ReturnCurrentPlayer().getInventory().setInventoryCapacity(App.ReturnCurrentPlayer().getInventory().getInventoryCapacity() + 12);
                    System.out.println("Pack Upgraded");
                }
                else if(myItem.LimitIndex == 5)
                {
                    // make the pack/inventory large
                    // check for limit
                    int newLimits[] = App.dailyLimits.getPierreStore();
                    if(newLimits[myItem.LimitIndex] - count < 0)
                    {
                        System.out.println("You have reached the daily limit for this item");
                        return;
                    }
                    // check for enough money
                    if(count * myItem.Price > App.ReturnCurrentPlayer().getCoin())
                    {
                        System.out.println("Not enough money bro");
                        return;
                    }
                    // set new limits
                    newLimits[myItem.LimitIndex] -= count;
                    App.dailyLimits.setPierreStore(newLimits);
                    // pay the price
                    App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * myItem.Price);
                    // add capacity
                    App.ReturnCurrentPlayer().getInventory().setInventoryCapacity(App.ReturnCurrentPlayer().getInventory().getInventoryCapacity() + 100000);
                    System.out.println("Pack Upgraded");
                }
                else
                {
                    // check for limits
                    int newLimtis[] = App.dailyLimits.getPierreStore();
                    if(newLimtis[myItem.LimitIndex] - count < 0)
                    {
                        System.out.println("You have reached the daily limit for this item");
                        return;
                    }
                    double coefficient = 1;
                    if(App.getCurrentGame().getTime().getSeason() != myItem.season)
                    {
                        coefficient = 1.5;
                    }
                    // check for money
                    if(count * myItem.Price * coefficient > App.ReturnCurrentPlayer().getCoin())
                    {
                        System.out.println("Not enough money bro");
                        return;
                    }
                    // apply the buying
                    newLimtis[myItem.LimitIndex] -= count;
                    App.dailyLimits.setPierreStore(newLimtis);
                    App.ReturnCurrentPlayer().setCoin((int) (App.ReturnCurrentPlayer().getCoin() - (count * myItem.Price * coefficient)));
                    ArrayList<Seeds> newSeeds = App.ReturnCurrentPlayer().getInventory().getSeeds();
                    boolean found = false;
                    for(Seeds seed : newSeeds)
                    {
                        if(seed.equals(myItem.Seed))
                        {
                            found = true;
                        }
                    }
                    if(!found)
                    {
                        if(!App.ReturnCurrentPlayer().getInventory().canAddNewItem())
                        {
                            System.out.println("Inventory is full");
                            return;
                        }
                    }
                    while(count > 0)
                    {
                        newSeeds.add(myItem.Seed);
                        count--;
                    }
                    App.ReturnCurrentPlayer().getInventory().setSeeds(newSeeds);
                    System.out.println("Seed added");
                    return;
                }
                break;
            }
        }
        if(!itemExists)
        {
            System.out.println("Item not found");
        }
    }
    public void ApplyFishShop(String ProductName , int count)
    {
        if(App.getCurrentGame().getTime().getHour() < 9 || App.getCurrentGame().getTime().getHour() > 17)
        {
            System.out.println("Store is closed");
            return;
        }
        if(ProductName.equals("FISH_SMOKER_RECIPE"))
        {
            // check for limit
            int newLimits[] = App.dailyLimits.getFishShop();
            if(newLimits[0] - count < 0)
            {
                System.out.println("You have reached the daily limit for this item");
                return;
            }
            // check for price
            if(count * 10000 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            // set new limits
            newLimits[0] -= count;
            App.dailyLimits.setFishShop(newLimits);
            // pay the price
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 10000);
            // adding the overflowing item
            for(Item item : App.ReturnCurrentPlayer().getOverflowItems())
            {
                if(item.getName().equals(ProductName))
                {
                    item.setCount(item.getCount() + count);
                    System.out.println(ProductName + " purchased");
                    return;
                }
            }
            App.ReturnCurrentPlayer().addOverflowItem(new Item(count , ProductName));
            System.out.println(ProductName + " purchased");
        }
        else if(ProductName.equals("TROUT_SOUP"))
        {
            // check for limit
            int newLimits[] = App.dailyLimits.getFishShop();
            if(newLimits[1] - count < 0)
            {
                System.out.println("You have reached the daily limit for this item");
                return;
            }
            if(UnlimitedFoodBuying(new Food(count , Foods.TroutSoup) , count , 250))
            {
                newLimits[1] -= count;
            }
            App.dailyLimits.setFishShop(newLimits);
        }
        else if(ProductName.equals("TRAINING_ROD"))
        {
            int newLimits[] = App.dailyLimits.getFishShop();
            if(count > 1)
            {
                System.out.println("You can do it once");
                return;
            }
            if(newLimits[2] - count < 0)
            {
                System.out.println("You have reached the daily limit for this item");
                return;
            }
            if(count * 25 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            if(!App.ReturnCurrentPlayer().getInventory().canAddNewItem())
            {
                System.out.println("Inventory is full");
                return;
            }
            newLimits[2] -= count;
            App.dailyLimits.setFishShop(newLimits);
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 25);
            App.ReturnCurrentPlayer().getInventory().getTools().add(new FishingPole(FishingPoles.Normal));
            System.out.println("Fishing pole added");
        }
        else if(ProductName.equals("BAMBOO_POLE"))
        {
            int newLimits[] = App.dailyLimits.getFishShop();
            newLimits[3] = UpgradePole(FishingPoles.Normal , FishingPoles.Bamboo , count , 500 , 0 , newLimits[3]);
            App.dailyLimits.setFishShop(newLimits);
        }
        else if(ProductName.equals("FIBERGLASS_ROD"))
        {
            int newLimits[] = App.dailyLimits.getFishShop();
            newLimits[4] = UpgradePole(FishingPoles.Bamboo , FishingPoles.FiberGlass , count , 1800 , 2 , newLimits[4]);
            App.dailyLimits.setFishShop(newLimits);
        }
        else if(ProductName.equals("IRIDIUM_ROD"))
        {
            int newLimits[] = App.dailyLimits.getFishShop();
            newLimits[5] = UpgradePole(FishingPoles.FiberGlass , FishingPoles.Iridium , count , 7500 , 4 , newLimits[5]);
            App.dailyLimits.setFishShop(newLimits);
        }
        else
        {
            System.out.println("Unrecognized product name");
        }
    }
    public void UnlimitedBuying(String ProductName , int count , int Price)
    {
        // unlimited amount
        // check for price
        if(Price * count > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return;
        }
        // Check if Item exists
        boolean FoodExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals(ProductName))
            {
                FoodExists = true;
                item.setCount(item.getCount() + count);
                break;
            }
        }
        if(!FoodExists)
        {
            if(!App.ReturnCurrentPlayer().getInventory().canAddNewItem())
            {
                System.out.println("Inventory is full");
                return;
            }
            ArrayList<Item> newItems = App.ReturnCurrentPlayer().getInventory().getItems();
            newItems.add(new Item(count , ProductName));
            App.ReturnCurrentPlayer().getInventory().setItems(newItems);
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price * count);
        System.out.println(ProductName + " purchased");
    }
    public int LimitedBuying(String ProductName , int count , int Price , int limit)
    {
        // check for limit
        if(limit - count < 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for price
        if(Price * count > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        // pay the price
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price * count);
        // check if item exists
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals(ProductName))
            {
                item.setCount(item.getCount() + count);
                System.out.println(ProductName + " purchased");
                return limit - count;
            }
        }
        if(!App.ReturnCurrentPlayer().getInventory().canAddNewItem())
        {
            System.out.println("Inventory is full");
            return limit;
        }
        ArrayList<Item> newItems = App.ReturnCurrentPlayer().getInventory().getItems();
        newItems.add(new Item(count , ProductName));
        App.ReturnCurrentPlayer().getInventory().setItems(newItems);
        System.out.println(ProductName + " purchased");
        return limit - count;
    }
    public int BuildBarn(String BarnType , int Capacity , int x , int y , int Price , int NeededWood , int NeededStone , int limit)
    {
        // check for limit
        if(limit == 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for price
        if(Price > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        // check if we have enough wood and stone
        boolean EnoughWood = false , EnoughStone = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals("Wood") && NeededWood <= item.getCount())
            {
                EnoughWood = true;
            }
            if(item.getName().equals("Stone") && NeededStone <= item.getCount())
            {
                EnoughStone = true;
            }
        }
        if(!EnoughWood || !EnoughStone)
        {
            System.out.println("Not enough wood or stone bro");
            return limit;
        }
        // check if x , y is empty for build
        boolean Empty = true;
        for(int i = x ; i < x + 7 ; i++)
        {
            for(int j = y ; j < y + 4 ; j++)
            {
                if(App.getCurrentGame().getEntireMap()[i][j].getEntitity() != Entitity.EMPTY ||
                App.getCurrentGame().getEntireMap()[i][j].getPlaceType() != PlaceType.FARM)
                {
                    Empty = false;
                    break;
                }
            }
        }
        if(!Empty)
        {
            System.out.println("Given position is filled. You can't place here");
            return limit;
        }
        // building the barn
        // paying the price
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price);
        // paying the wood and stone
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals("Stone"))
            {
                item.setCount(item.getCount() - NeededStone);
            }
            if(item.getName().equals("Wood"))
            {
                item.setCount(item.getCount() - NeededWood);
            }
        }
        // adding the barn to the farm barn list
        ArrayList<AnimalHouse> newBarns = App.ReturnCurrentPlayer().getFarm().getBarns();
        newBarns.add(new AnimalHouse(x , y , BarnType , Capacity));
        App.ReturnCurrentPlayer().getFarm().setBarns(newBarns);
        // updating barn tiles
        for(int i = x ; i < x + 7 ; i++)
        {
            for(int j = y ; j < y + 4 ; j++)
            {
                App.getCurrentGame().getEntireMap()[i][j].setEntitity(null);
                App.getCurrentGame().getEntireMap()[i][j].setPlaceType(PlaceType.BARN);
                App.getCurrentGame().getEntireMap()[i][j].setTerrain(null);
            }
        }

        System.out.println(BarnType + " has been built");
        return limit - 1;

    }
    public int BuildCoop(String CoopType , int Capacity , int x , int y , int Price , int NeededWood , int NeededStone , int limit)
    {
        // check for limit
        if(limit == 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for price
        if(Price > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        // check if we have enough wood and stone
        boolean EnoughWood = false , EnoughStone = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals("Wood") && NeededWood <= item.getCount())
            {
                EnoughWood = true;
            }
            if(item.getName().equals("Stone") && NeededStone <= item.getCount())
            {
                EnoughStone = true;
            }
        }
        if(!EnoughWood || !EnoughStone)
        {
            System.out.println("Not enough wood or stone bro");
            return limit;
        }
        // check if x , y is empty for build
        boolean Empty = true;
        for(int i = x ; i < x + 6 ; i++)
        {
            for(int j = y ; j < y + 3 ; j++)
            {
                if(App.getCurrentGame().getEntireMap()[i][j].getEntitity() != Entitity.EMPTY ||
                        App.getCurrentGame().getEntireMap()[i][j].getPlaceType() != PlaceType.FARM)
                {
                    Empty = false;
                    break;
                }
            }
        }
        if(!Empty)
        {
            System.out.println("Given position is filled. You can't place here");
            return limit;
        }
        // building the coop
        // paying the price
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price);
        // paying the wood and stone
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals("Stone"))
            {
                item.setCount(item.getCount() - NeededStone);
            }
            if(item.getName().equals("Wood"))
            {
                item.setCount(item.getCount() - NeededWood);
            }
        }
        // adding the barn to the farm barn list
        ArrayList<AnimalHouse> newCoops = App.ReturnCurrentPlayer().getFarm().getCoops();
        newCoops.add(new AnimalHouse(x , y , CoopType , Capacity));
        App.ReturnCurrentPlayer().getFarm().setCoops(newCoops);
        // updating barn tiles
        for(int i = x ; i < x + 6 ; i++)
        {
            for(int j = y ; j < y + 3 ; j++)
            {
                App.getCurrentGame().getEntireMap()[i][j].setEntitity(null);
                App.getCurrentGame().getEntireMap()[i][j].setPlaceType(PlaceType.COOP);
                App.getCurrentGame().getEntireMap()[i][j].setTerrain(null);
            }
        }

        System.out.println(CoopType + " has been built");
        return limit - 1;

    }
    public int UpgradeAxe(Axe newAxe , String Ingredient , int count , int Price , int limit , Axes newAxeType , Axes oldAxeType)
    {
        if(count > 1)
        {
            System.out.println("You can do it once");
            return limit;
        }
        if(newAxe.getAxeType() != oldAxeType)
        {
            System.out.println("Axe level doesn't match the upgrade");
            return limit;
        }
        // check for limit
        if(limit - count < 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for price
        if(Price > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        boolean IngredientExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals(Ingredient))
            {
                if(item.getCount() < 5)
                {
                    System.out.println("Not enough ingredients");
                    return limit;
                }
                else
                {
                    IngredientExists = true;
                    item.setCount(item.getCount() - 5);
                }
            }
        }
        if(!IngredientExists)
        {
            System.out.println("Not enough ingredients");
            return limit;
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price);
        newAxe.setAxeType(newAxeType);
        System.out.println("Axe has been upgraded");
        return limit - count;
    }
    public int UpgradeHoe(Hoe newHoe , String Ingredient , int count , int Price , int limit , Hoes newHoeType , Hoes oldHoeType)
    {
        if(count > 1)
        {
            System.out.println("You can do it once");
            return limit;
        }
        if(newHoe.getHoeType() != oldHoeType)
        {
            System.out.println("Hoe level doesn't match the upgrade");
            return limit;
        }
        // check for limit
        if(limit - count < 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for price
        if(Price > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        boolean IngredientExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals(Ingredient))
            {
                if(item.getCount() < 5)
                {
                    System.out.println("Not enough ingredients");
                    return limit;
                }
                else
                {
                    IngredientExists = true;
                    item.setCount(item.getCount() - 5);
                }
            }
        }
        if(!IngredientExists)
        {
            System.out.println("Not enough ingredients");
            return limit;
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price);
        newHoe.setHoeType(newHoeType);
        System.out.println("Hoe has been upgraded");
        return limit - count;
    }
    public int UpgradeMilkPail(MilkPail newMilkPail , String Ingredient , int count , int Price , int limit , MilkPails newmilkPail , MilkPails oldmilkPail)
    {
        if(newMilkPail == null)
        {
            System.out.println("You don't have a milk pail");
            return limit;
        }
        if(count > 1)
        {
            System.out.println("You can do it once");
            return limit;
        }
        if(newMilkPail.getMilkPailType() != oldmilkPail)
        {
            System.out.println("MilkPail level doesn't match the upgrade");
            return limit;
        }
        // check for limit
        if(limit - count < 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for price
        if(Price > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        boolean IngredientExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals(Ingredient))
            {
                if(item.getCount() < 5)
                {
                    System.out.println("Not enough ingredients");
                    return limit;
                }
                else
                {
                    IngredientExists = true;
                    item.setCount(item.getCount() - 5);
                }
            }
        }
        if(!IngredientExists)
        {
            System.out.println("Not enough ingredients");
            return limit;
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price);
        newMilkPail.setMilkPailType(newmilkPail);
        System.out.println("MilkPail has been upgraded");
        return limit - count;
    }
    public int UpgradeWaterCan(WaterCan newWaterCan , String Ingredient , int count , int Price , int limit , Watercans newWaterCanType , Watercans oldWaterCanType)
    {
        if(count > 1)
        {
            System.out.println("You can do it once");
            return limit;
        }
        if(newWaterCan.getWatercan() != oldWaterCanType)
        {
            System.out.println("WaterCan level doesn't match the upgrade");
            return limit;
        }
        // check for limit
        if(limit - count < 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for price
        if(Price > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        boolean IngredientExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals(Ingredient))
            {
                if(item.getCount() < 5)
                {
                    System.out.println("Not enough ingredients");
                    return limit;
                }
                else
                {
                    IngredientExists = true;
                    item.setCount(item.getCount() - 5);
                }
            }
        }
        if(!IngredientExists)
        {
            System.out.println("Not enough ingredients");
            return limit;
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price);
        newWaterCan.setWatercan(newWaterCanType);
        System.out.println("WaterCan has been upgraded");
        return limit - count;
    }
    public int UpgradeShear(Shear newShear , String Ingredient , int count , int Price , int limit , Shears newShearType , Shears oldShearType)
    {
        if(count > 1)
        {
            System.out.println("You can do it once");
            return limit;
        }
        if(newShear.getShearType() != oldShearType)
        {
            System.out.println("Shear level doesn't match the upgrade");
            return limit;
        }
        // check for limit
        if(limit - count < 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for price
        if(Price > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        boolean IngredientExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals(Ingredient))
            {
                if(item.getCount() < 5)
                {
                    System.out.println("Not enough ingredients");
                    return limit;
                }
                else
                {
                    IngredientExists = true;
                    item.setCount(item.getCount() - 5);
                }
            }
        }
        if(!IngredientExists)
        {
            System.out.println("Not enough ingredients");
            return limit;
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price);
        newShear.setShearType(newShearType);
        System.out.println("Shear has been upgraded");
        return limit - count;
    }
    public int UpgradePickaxe(Pickaxe newPickaxe , String Ingredient , int count , int Price , int limit , Pickaxes newPickaxeType , Pickaxes oldPickaxeType)
    {
        if(newPickaxe == null)
        {
            System.out.println("You don't have a pickaxe");
            return limit;
        }
        if(count > 1)
        {
            System.out.println("You can do it once");
            return limit;
        }
        if(newPickaxe.getPickaxeType() != oldPickaxeType)
        {
            System.out.println("Hoe level doesn't match the upgrade");
            return limit;
        }
        // check for limit
        if(limit - count < 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for price
        if(Price > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        boolean IngredientExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals(Ingredient))
            {
                if(item.getCount() < 5)
                {
                    System.out.println("Not enough ingredients");
                    return limit;
                }
                else
                {
                    IngredientExists = true;
                    item.setCount(item.getCount() - 5);
                }
            }
        }
        if(!IngredientExists)
        {
            System.out.println("Not enough ingredients");
            return limit;
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price);
        newPickaxe.setPickaxeType(newPickaxeType);
        System.out.println("Pickaxe has been upgraded");
        return limit - count;
    }
    public int UpgradeSeythe(Seythe newSeythe , String Ingredient , int count , int Price , int limit , Seythes newSeytheType , Seythes oldSeytheType)
    {
        if(count > 1)
        {
            System.out.println("You can do it once");
            return limit;
        }
        if(newSeythe.getSeythesType() != oldSeytheType)
        {
            System.out.println("Hoe level doesn't match the upgrade");
            return limit;
        }
        // check for limit
        if(limit - count < 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for price
        if(Price > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        boolean IngredientExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals(Ingredient))
            {
                if(item.getCount() < 5)
                {
                    System.out.println("Not enough ingredients");
                    return limit;
                }
                else
                {
                    IngredientExists = true;
                    item.setCount(item.getCount() - 5);
                }
            }
        }
        if(!IngredientExists)
        {
            System.out.println("Not enough ingredients");
            return limit;
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price);
        newSeythe.setSeythesType(newSeytheType);
        System.out.println("Seythe has been upgraded");
        return limit - count;
    }
    public int UpgradeTrashCan(TrashCan trashCan , String Ingredient , int count , int Price , int limit , Trashcans NewTrashType , Trashcans OldTrashType)
    {
        if(count > 1)
        {
            System.out.println("You can do it once");
            return limit;
        }
        if(trashCan.getTrashcan() != OldTrashType)
        {
            System.out.println("Trash can level doesn't match the upgrade");
            return limit;
        }
        // check for limit
        if(limit - count < 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for price
        if(Price > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        boolean IngredientExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals(Ingredient))
            {
                if(item.getCount() < 5)
                {
                    System.out.println("Not enough ingredients");
                    return limit;
                }
                else
                {
                    IngredientExists = true;
                    item.setCount(item.getCount() - 5);
                }
            }
        }
        if(!IngredientExists)
        {
            System.out.println("Not enough ingredients");
            return limit;
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price);
        trashCan.setTrashcan(NewTrashType);
        System.out.println("Trashcan has been upgraded");
        return limit - count;
    }
    public int BuyCoopAnimal(String AnimalName , String CoopType , Animals AnimalType , int limit , int Price)
    {
        // check for enough money
        if(Price > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        // check for daily limit
        if(limit == 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for proper coop
        for(AnimalHouse coop : App.ReturnCurrentPlayer().getFarm().getCoops())
        {
            if(coop.getAnimalHouse().equals(CoopType) && coop.getCapacity() > 0)
            {
                // Add animals
                // lessen limit
                // lessen capacity
                // price
                ArrayList<Animal> newAnimals = App.ReturnCurrentPlayer().getFarm().getAnimals();
                newAnimals.add(new Animal(AnimalName , AnimalType));
                App.ReturnCurrentPlayer().getFarm().setAnimals(newAnimals);
                limit--;
                coop.setCapacity(coop.getCapacity() - 1);
                App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price);
                System.out.println(AnimalType.name() + " purchased");
                return limit;
            }
        }
        System.out.println("You don't own a proper coop");
        return limit;
    }
    public int BuyBarnAnimal(String AnimalName , String CoopType , Animals AnimalType , int limit , int Price)
    {
        // check for enough money
        if(Price > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        // check for daily limit
        if(limit == 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for proper coop
        for(AnimalHouse barn : App.ReturnCurrentPlayer().getFarm().getBarns())
        {
            if(barn.getAnimalHouse().equals(CoopType) && barn.getCapacity() > 0)
            {
                // Add animals
                // lessen limit
                // lessen capacity
                // price
                ArrayList<Animal> newAnimals = App.ReturnCurrentPlayer().getFarm().getAnimals();
                newAnimals.add(new Animal(AnimalName , AnimalType));
                App.ReturnCurrentPlayer().getFarm().setAnimals(newAnimals);
                limit--;
                barn.setCapacity(barn.getCapacity() - 1);
                App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price);
                System.out.println(AnimalType.name() + " purchased");
                return limit;
            }
        }
        System.out.println("You don't own a proper coop");
        return limit;
    }
    public int BuyTool(Tools Tool , int count , int Price , int limit)
    {
        // check for limit
        if(limit - count < 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for price
        if(Price * count > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        if(!App.ReturnCurrentPlayer().getInventory().canAddNewItem())
        {
            System.out.println("Inventory is full");
            return limit;
        }
        // pay the price
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price * count);
        // add the tool to the inventory
        App.ReturnCurrentPlayer().getInventory().addTool(Tool);
        System.out.println("Tool has been added");
        return limit - count;
    }
    public int BuyRecipe(Foods newFood , int count , int Price , int limit)
    {
        // check for limit
        if(limit - count < 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        // check for price
        if(Price * count > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        // pay the price
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price * count);
        // add the recipe
        App.ReturnCurrentPlayer().addRecipe(newFood);
        System.out.println("Recipe has been added");
        return limit - count;
    }
    public void UnlimitedIngredientBuying(Ingredients newIngredient , int count , int Price)
    {
        // unlimited amount
        // check for price
        if(Price * count > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return;
        }
        // Check if Item exists
        boolean FoodExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item instanceof Ingredient && ((Ingredient) item).getIngredient().equals(newIngredient))
            {
                FoodExists = true;
                item.setCount(item.getCount() + count);
                break;
            }
        }
        if(!FoodExists)
        {
            if(!App.ReturnCurrentPlayer().getInventory().canAddNewItem())
            {
                System.out.println("Inventory is full");
                return;
            }
            ArrayList<Item> newItems = App.ReturnCurrentPlayer().getInventory().getItems();
            newItems.add(new Ingredient(count , newIngredient));
            App.ReturnCurrentPlayer().getInventory().setItems(newItems);
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price * count);
        System.out.println(newIngredient.name() + " purchased");
    }
    public void UnlimitedSaplingBuying(Saplings newSapling , int count , int Price)
    {
        // check for price
        if(Price * count > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return;
        }
        // pay the price
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price * count);
        // add saplings
        ArrayList<Saplings> newSaplings = App.ReturnCurrentPlayer().getInventory().getSaplings();
        boolean found = false;
        for(Saplings sapling : newSaplings)
        {
            if(newSapling.equals(sapling))
            {
                found = true;
            }
        }
        if(!found)
        {
            if(!App.ReturnCurrentPlayer().getInventory().canAddNewItem())
            {
                System.out.println("Inventory is full");
                return;
            }
        }
        while(count > 0)
        {
            newSaplings.add(newSapling);
            count--;
        }
        App.ReturnCurrentPlayer().getInventory().setSaplings(newSaplings);
        System.out.println(newSapling.name() + " purchased");
    }
    public void UnlimitedCraftBuying(Crafts newCraft , int count , int Price)
    {
        // check for price
        if(Price * count > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return;
        }
        // pay the price
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price * count);
        boolean CraftExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item instanceof Craft && ((Craft) item).getCrafts().equals(newCraft))
            {
                CraftExists = true;
                item.setCount(item.getCount() + count);
                break;
            }
        }
        if(!CraftExists)
        {
            App.ReturnCurrentPlayer().getInventory().addItem(new Craft(count , newCraft));
        }
        System.out.println(newCraft.name() + " purchased");
    }
    public boolean UnlimitedFoodBuying(Food newFood , int count , int Price)
    {
        // check for price
        if(Price * count > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return false;
        }
        boolean FoodExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item instanceof Food && ((Food) item).getFood().equals(newFood))
            {
                FoodExists = true;
                item.setCount(item.getCount() + count);
                break;
            }
        }
        if(!FoodExists)
        {
            if(!App.ReturnCurrentPlayer().getInventory().canAddNewItem())
            {
                System.out.println("Inventory is full");
                return false;
            }
            ArrayList<Item> newItems = App.ReturnCurrentPlayer().getInventory().getItems();
            newItems.add(newFood);
            App.ReturnCurrentPlayer().getInventory().setItems(newItems);
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price * count);
        System.out.println("Food has been added");
        return true;
    }
    public int UpgradePole(FishingPoles oldPole , FishingPoles newPole , int count , int Price , int NeededSkill , int limit)
    {
        if(count > 1)
        {
            System.out.println("You can do it once");
            return limit;
        }
        FishingPole newFishingPole = null;
        for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
        {
            if(tools instanceof FishingPole)
            {
                newFishingPole = (FishingPole) tools;
                break;
            }
        }
        if(newFishingPole == null || newFishingPole.getFishingPole() != oldPole)
        {
            System.out.println("Fishing pole level doesn't match the upgrade");
            return limit;
        }
        // check for limit
        if(limit - count < 0)
        {
            System.out.println("You have reached the daily limit for this item");
            return limit;
        }
        if(Price > App.ReturnCurrentPlayer().getCoin())
        {
            System.out.println("Not enough money bro");
            return limit;
        }
        if(App.ReturnCurrentPlayer().getSkills()[1].getLevel() < NeededSkill)
        {
            System.out.println("Skill issue bro");
            return limit;
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price);
        newFishingPole.setFishingPole(newPole);
        newFishingPole.setEnergyCost(newPole.Energycost);
        limit -= count;
        System.out.println("Fishing pole has been upgraded");
        return limit;
    }
}