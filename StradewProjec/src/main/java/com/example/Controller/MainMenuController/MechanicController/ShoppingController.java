package com.example.Controller.MainMenuController.MechanicController;

import com.example.Model.App;
import com.example.Model.Enums.*;
import com.example.Model.Enums.Tools.Trashcans;
import com.example.Model.Item.Ingredient;
import com.example.Model.Item.Item;
import com.example.Model.Places.AnimalHouse;
import com.example.Model.Tile.Animal;
import com.example.Model.Tools.MilkPail;
import com.example.Model.Tools.Shear;
import com.example.Model.Tools.Tools;
import com.example.Model.Tools.TrashCan;

import java.util.ArrayList;

public class ShoppingController {
    public void ApplyPurchase(){
        //App.getCurrentUser().

    }
    public void ApplyBlackSmithPurchase(String ProductName , int count)
    {
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
        else if(ProductName.equals("Copper Tool"))
        {
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[0] = UpgradeTool(ProductName , "Copper Bar" , count , 2000 , newLimits[0]);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Steel Tool"))
        {
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[1] = UpgradeTool(ProductName , "Iron Bar" , count , 5000 , newLimits[1]);
            App.dailyLimits.setBlackSmithLimits(newLimits);
        }
        else if(ProductName.equals("Gold Tool"))
        {
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[2] = UpgradeTool(ProductName , "Gold Bar" , count , 10000 , newLimits[2]);
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
        if(ProductName.equals("Hay"))
        {
            int count = Integer.parseInt(CountOrName);
            UnlimitedBuying(ProductName , count , 50);
        }
        else if(ProductName.equals("Milk Pail"))
        {
            int count = Integer.parseInt(CountOrName);
            int newLimits[] = App.dailyLimits.getMarineRanch();
            MilkPail newMilkPail = new MilkPail();
            newMilkPail.setCount(count);
            newMilkPail.setExist(true);
            newLimits[0] = BuyTool(newMilkPail , count , 1000 , newLimits[0]);
            App.dailyLimits.setMarineRanch(newLimits);
        }
        else if(ProductName.equals("Shears"))
        {
            int count = Integer.parseInt(CountOrName);
            int newLimits[] = App.dailyLimits.getMarineRanch();
            Shear newShear = new Shear();
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
        if(ProductName.equals("Beer"))
        {
            UnlimitedBuying(ProductName , count , 400);
        }
        else if(ProductName.equals("Salad"))
        {
            UnlimitedBuying(ProductName , count , 220);
        }
        else if(ProductName.equals("Bread"))
        {
            UnlimitedBuying(ProductName , count , 120);
        }
        else if(ProductName.equals("Spaghetti"))
        {
            UnlimitedBuying(ProductName , count , 240);
        }
        else if(ProductName.equals("Pizza"))
        {
            UnlimitedBuying(ProductName , count , 600);
        }
        else if(ProductName.equals("Coffee"))
        {
            UnlimitedBuying(ProductName , count , 300);
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
        if(ProductName.equals("Joja Cola"))
        {
            UnlimitedBuying(ProductName , count, 75);
        }
        else if(ProductName.equals("Grass Starter"))
        {
            UnlimitedBuying(ProductName , count, 125);
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
                    // set new limtis
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
                App.getCurrentGame().getEntireMap()[i][j].setEntitity(Entitity.EMPTY);
                App.getCurrentGame().getEntireMap()[i][j].setPlaceType(PlaceType.BARN);
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
                App.getCurrentGame().getEntireMap()[i][j].setEntitity(Entitity.EMPTY);
                App.getCurrentGame().getEntireMap()[i][j].setPlaceType(PlaceType.COOP);
            }
        }

        System.out.println(CoopType + " has been built");
        return limit - 1;

    }
    public int UpgradeTool(String ProductName , String Ingredient , int count , int Price , int limit)
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
        boolean IngredientExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals(Ingredient))
            {
                if(item.getCount() < 5 * count)
                {
                    System.out.println("Not enough ingredients");
                    return limit;
                }
                else
                {
                    IngredientExists = true;
                    item.setCount(item.getCount() - 5 * count);
                }
            }
        }
        if(!IngredientExists)
        {
            System.out.println("Not enough ingredients");
            return limit;
        }
        boolean ItemExists = false;
        for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
        {
            if(item.getName().equals(ProductName))
            {
                item.setCount(item.getCount() + count);
                ItemExists = true;
                break;
            }
        }
        if(!ItemExists)
        {
            ArrayList<Item> newItems = App.ReturnCurrentPlayer().getInventory().getItems();
            newItems.add(new Item(count, ProductName));
            App.ReturnCurrentPlayer().getInventory().setItems(newItems);
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price * count);
        System.out.println(ProductName + " has been upgraded");
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
        App.ReturnCurrentPlayer().addFoodRecipe(newFood);
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
            ArrayList<Item> newItems = App.ReturnCurrentPlayer().getInventory().getItems();
            newItems.add(new Ingredient(count , newIngredient));
            App.ReturnCurrentPlayer().getInventory().setItems(newItems);
        }
        App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - Price * count);
        System.out.println(newIngredient.name() + " purchased");
    }
}