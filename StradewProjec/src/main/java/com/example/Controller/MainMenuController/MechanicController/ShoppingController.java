package com.example.Controller.MainMenuController.MechanicController;

import com.example.Model.App;
import com.example.Model.Enums.Animals;
import com.example.Model.Enums.Entitity;
import com.example.Model.Enums.PlaceType;
import com.example.Model.Game;
import com.example.Model.Item.Item;
import com.example.Model.Places.AnimalHouse;
import com.example.Model.Tile.Animal;

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
            // check if you used the daily limit or not
            if(App.dailyLimits.getBlackSmithLimits()[0] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check if you have enough ingredients and money
            if(2000 * count > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            boolean IngredientExists = false;
            for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
            {
                if(item.getName().equals("Copper Bar"))
                {
                    if(item.getCount() < 5 * count)
                    {
                        System.out.println("Not enough ingredients");
                        return;
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
                return;
            }
            // Apply purchase and other logic
            boolean ItemExists = false;
            for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
            {
                if(item.getName().equals("Copper Tool"))
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
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[0]--;
            App.dailyLimits.setBlackSmithLimits(newLimits);
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 2000);
            System.out.println("Copper Tool purchased");
        }
        else if(ProductName.equals("Steel Tool"))
        {
            // check if you used the daily limit or not
            if(App.dailyLimits.getBlackSmithLimits()[1] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check if you have enough ingredients and money
            if(5000 * count > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            boolean IngredientExists = false;
            for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
            {
                if(item.getName().equals("Iron Bar"))
                {
                    if(item.getCount() < 5 * count)
                    {
                        System.out.println("Not enough ingredients");
                        return;
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
                return;
            }
            // Apply purchase and other logic
            boolean ItemExists = false;
            for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
            {
                if(item.getName().equals("Steel Tool"))
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
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[1]--;
            App.dailyLimits.setBlackSmithLimits(newLimits);
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 5000);
            System.out.println("Steel Tool purchased");
        }
        else if(ProductName.equals("Gold Tool"))
        {
            // check if you used the daily limit or not
            if(App.dailyLimits.getBlackSmithLimits()[2] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check if you have enough ingredients and money
            if(10000 * count > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            boolean IngredientExists = false;
            for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
            {
                if(item.getName().equals("Gold Bar"))
                {
                    if(item.getCount() < 5 * count)
                    {
                        System.out.println("Not enough ingredients");
                        return;
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
                return;
            }
            // Apply purchase and other logic
            boolean ItemExists = false;
            for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
            {
                if(item.getName().equals("Gold Tool"))
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
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[2]--;
            App.dailyLimits.setBlackSmithLimits(newLimits);
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 10000);
            System.out.println("Gold Tool purchased");
        }
        else if(ProductName.equals("Copper Trash Can"))
        {
            // check if you used the daily limit or not
            if(App.dailyLimits.getBlackSmithLimits()[4] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check if you have enough ingredients and money
            if(1000 * count > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            boolean IngredientExists = false;
            for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
            {
                if(item.getName().equals("Copper Bar"))
                {
                    if(item.getCount() < 5 * count)
                    {
                        System.out.println("Not enough ingredients");
                        return;
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
                return;
            }
            // Apply purchase and other logic
            boolean ItemExists = false;
            for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
            {
                if(item.getName().equals("Copper Trash Can"))
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
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[4]--;
            App.dailyLimits.setBlackSmithLimits(newLimits);
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 1000);
            System.out.println("Copper Trash Can purchased");
        }
        else if(ProductName.equals("Steel Trash Can"))
        {
            // check if you used the daily limit or not
            if(App.dailyLimits.getBlackSmithLimits()[5] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check if you have enough ingredients and money
            if(2500 * count > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            boolean IngredientExists = false;
            for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
            {
                if(item.getName().equals("Iron Bar"))
                {
                    if(item.getCount() < 5 * count)
                    {
                        System.out.println("Not enough ingredients");
                        return;
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
                return;
            }
            // Apply purchase and other logic
            boolean ItemExists = false;
            for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
            {
                if(item.getName().equals("Steel Trash Can"))
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
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[5]--;
            App.dailyLimits.setBlackSmithLimits(newLimits);
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 2500);
            System.out.println("Steel Trash Can purchased");
        }
        else if(ProductName.equals("Gold Trash Can"))
        {
            // check if you used the daily limit or not
            if(App.dailyLimits.getBlackSmithLimits()[6] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check if you have enough ingredients and money
            if(5000 * count > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            boolean IngredientExists = false;
            for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
            {
                if(item.getName().equals("Gold Bar"))
                {
                    if(item.getCount() < 5 * count)
                    {
                        System.out.println("Not enough ingredients");
                        return;
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
                return;
            }
            // Apply purchase and other logic
            boolean ItemExists = false;
            for(Item item : App.ReturnCurrentPlayer().getInventory().getItems())
            {
                if(item.getName().equals("Gold Trash Can"))
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
            int newLimits[] = App.dailyLimits.getBlackSmithLimits();
            newLimits[6]--;
            App.dailyLimits.setBlackSmithLimits(newLimits);
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 5000);
            System.out.println("Gold Trash Can purchased");
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
            // price is 1000
            if(count * 1000 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            if(App.dailyLimits.getMarineRanch()[0] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // list of items:
            // check if the item already exists
            // if it does just add the count
            // if not add the item, put the count 0 then add
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
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 1000);
            int newLimits[] = App.dailyLimits.getMarineRanch();
            newLimits[0]--;
            App.dailyLimits.setMarineRanch(newLimits);
            System.out.println("Milk Pail purchased");
        }
        else if(ProductName.equals("Shears"))
        {
            int count = Integer.parseInt(CountOrName);
            // price is 1000
            if(count * 1000 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            if(App.dailyLimits.getMarineRanch()[1] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // list of items:
            // check if the item already exists
            // if it does just add the count
            // if not add the item, put the count 0 then add
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
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 1000);
            int newLimits[] = App.dailyLimits.getMarineRanch();
            newLimits[1]--;
            App.dailyLimits.setMarineRanch(newLimits);
            System.out.println("Shears purchased");
        }
        else if(ProductName.equals("Chicken"))
        {
            // check for enough money
            if(800 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            // check for daily limit
            if(App.dailyLimits.getMarineRanch()[2] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check for proper coop
            for(AnimalHouse coop : App.ReturnCurrentPlayer().getFarm().getCoops())
            {
                if(coop.getAnimalHouse().equals("Coop") && coop.getCapacity() > 0)
                {
                    // Add animals
                    // lessen limit
                    // lessen capacity
                    // price
                    ArrayList<Animal> newAnimals = App.ReturnCurrentPlayer().getFarm().getAnimals();
                    newAnimals.add(new Animal(CountOrName , Animals.Chicken));
                    App.ReturnCurrentPlayer().getFarm().setAnimals(newAnimals);
                    App.dailyLimits.getMarineRanch()[2]--;
                    coop.setCapacity(coop.getCapacity() - 1);
                    App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - 800);
                    System.out.println("Chicken purchased");
                    return;
                }
            }
            System.out.println("You don't own a proper coop");
        }
        else if(ProductName.equals("Duck"))
        {
            // check for enough money
            if(1200 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            // check for daily limit
            if(App.dailyLimits.getMarineRanch()[5] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check for proper coop
            for(AnimalHouse coop : App.ReturnCurrentPlayer().getFarm().getCoops())
            {
                if(coop.getAnimalHouse().equals("Big Coop") && coop.getCapacity() > 0)
                {
                    // Add animals
                    // lessen limit
                    // lessen capacity
                    // price
                    ArrayList<Animal> newAnimals = App.ReturnCurrentPlayer().getFarm().getAnimals();
                    newAnimals.add(new Animal(CountOrName , Animals.Duck));
                    App.ReturnCurrentPlayer().getFarm().setAnimals(newAnimals);
                    App.dailyLimits.getMarineRanch()[5]--;
                    coop.setCapacity(coop.getCapacity() - 1);
                    App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - 1200);
                    System.out.println("Duck purchased");
                    return;
                }
            }
            System.out.println("You don't own a proper coop");
        }
        else if(ProductName.equals("Rabbit"))
        {
            // check for enough money
            if(8000 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            // check for daily limit
            if(App.dailyLimits.getMarineRanch()[7] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check for proper coop
            for(AnimalHouse coop : App.ReturnCurrentPlayer().getFarm().getCoops())
            {
                if(coop.getAnimalHouse().equals("Deluxe Coop") && coop.getCapacity() > 0)
                {
                    // Add animals
                    // lessen limit
                    // lessen capacity
                    // price
                    ArrayList<Animal> newAnimals = App.ReturnCurrentPlayer().getFarm().getAnimals();
                    newAnimals.add(new Animal(CountOrName , Animals.Rabbit));
                    App.ReturnCurrentPlayer().getFarm().setAnimals(newAnimals);
                    App.dailyLimits.getMarineRanch()[7]--;
                    coop.setCapacity(coop.getCapacity() - 1);
                    App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - 8000);
                    System.out.println("Rabbit purchased");
                    return;
                }
            }
            System.out.println("You don't own a proper coop");
        }
        else if(ProductName.equals("Dinosaur"))
        {
            // check for enough money
            if(14000 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            // check for daily limit
            if(App.dailyLimits.getMarineRanch()[8] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check for proper coop
            for(AnimalHouse coop : App.ReturnCurrentPlayer().getFarm().getCoops())
            {
                if(coop.getAnimalHouse().equals("Big Coop") && coop.getCapacity() > 0)
                {
                    // Add animals
                    // lessen limit
                    // lessen capacity
                    // price
                    ArrayList<Animal> newAnimals = App.ReturnCurrentPlayer().getFarm().getAnimals();
                    newAnimals.add(new Animal(CountOrName , Animals.Dinosaur));
                    App.ReturnCurrentPlayer().getFarm().setAnimals(newAnimals);
                    App.dailyLimits.getMarineRanch()[8]--;
                    coop.setCapacity(coop.getCapacity() - 1);
                    App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - 14000);
                    System.out.println("Dinosaur purchased");
                    return;
                }
            }
            System.out.println("You don't own a proper coop");
        }
        else if(ProductName.equals("Cow"))
        {
            // check for enough money
            if(1500 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            // check for daily limit
            if(App.dailyLimits.getMarineRanch()[3] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check for proper coop
            for(AnimalHouse barn : App.ReturnCurrentPlayer().getFarm().getBarns())
            {
                if(barn.getAnimalHouse().equals("Barn") && barn.getCapacity() > 0)
                {
                    // Add animals
                    // lessen limit
                    // lessen capacity
                    // price
                    ArrayList<Animal> newAnimals = App.ReturnCurrentPlayer().getFarm().getAnimals();
                    newAnimals.add(new Animal(CountOrName , Animals.Cow));
                    App.ReturnCurrentPlayer().getFarm().setAnimals(newAnimals);
                    App.dailyLimits.getMarineRanch()[3]--;
                    barn.setCapacity(barn.getCapacity() - 1);
                    App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - 1500);
                    System.out.println("Cow purchased");
                    return;
                }
            }
            System.out.println("You don't own a proper barn");
        }
        else if(ProductName.equals("Goat"))
        {
            // check for enough money
            if(4000 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            // check for daily limit
            if(App.dailyLimits.getMarineRanch()[4] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check for proper coop
            for(AnimalHouse barn : App.ReturnCurrentPlayer().getFarm().getBarns())
            {
                if(barn.getAnimalHouse().equals("Big Barn") && barn.getCapacity() > 0)
                {
                    // Add animals
                    // lessen limit
                    // lessen capacity
                    // price
                    ArrayList<Animal> newAnimals = App.ReturnCurrentPlayer().getFarm().getAnimals();
                    newAnimals.add(new Animal(CountOrName , Animals.Goat));
                    App.ReturnCurrentPlayer().getFarm().setAnimals(newAnimals);
                    App.dailyLimits.getMarineRanch()[4]--;
                    barn.setCapacity(barn.getCapacity() - 1);
                    App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - 4000);
                    System.out.println("Goat purchased");
                    return;
                }
            }
            System.out.println("You don't own a proper barn");
        }
        else if(ProductName.equals("Sheep"))
        {
            // check for enough money
            if(8000 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            // check for daily limit
            if(App.dailyLimits.getMarineRanch()[6] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check for proper coop
            for(AnimalHouse barn : App.ReturnCurrentPlayer().getFarm().getBarns())
            {
                if(barn.getAnimalHouse().equals("Deluxe Barn") && barn.getCapacity() > 0)
                {
                    // Add animals
                    // lessen limit
                    // lessen capacity
                    // price
                    ArrayList<Animal> newAnimals = App.ReturnCurrentPlayer().getFarm().getAnimals();
                    newAnimals.add(new Animal(CountOrName , Animals.Sheep));
                    App.ReturnCurrentPlayer().getFarm().setAnimals(newAnimals);
                    App.dailyLimits.getMarineRanch()[6]--;
                    barn.setCapacity(barn.getCapacity() - 1);
                    App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - 8000);
                    System.out.println("Sheep purchased");
                    return;
                }
            }
            System.out.println("You don't own a proper barn");
        }
        else if(ProductName.equals("Sheep"))
        {
            // check for enough money
            if(16000 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
                return;
            }
            // check for daily limit
            if(App.dailyLimits.getMarineRanch()[9] == 0)
            {
                System.out.println("You have used your daily limit for this item");
                return;
            }
            // check for proper coop
            for(AnimalHouse barn : App.ReturnCurrentPlayer().getFarm().getBarns())
            {
                if(barn.getAnimalHouse().equals("Deluxe Barn") && barn.getCapacity() > 0)
                {
                    // Add animals
                    // lessen limit
                    // lessen capacity
                    // price
                    ArrayList<Animal> newAnimals = App.ReturnCurrentPlayer().getFarm().getAnimals();
                    newAnimals.add(new Animal(CountOrName , Animals.Pig));
                    App.ReturnCurrentPlayer().getFarm().setAnimals(newAnimals);
                    App.dailyLimits.getMarineRanch()[9]--;
                    barn.setCapacity(barn.getCapacity() - 1);
                    App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - 16000);
                    System.out.println("Pig purchased");
                    return;
                }
            }
            System.out.println("You don't own a proper barn");
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
            newLimits[0] = LimitedBuying(ProductName , count , 50 , newLimits[0]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Omlete Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[1] = LimitedBuying(ProductName , count , 100 , newLimits[1]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Pancakes Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[2] = LimitedBuying(ProductName , count , 100 , newLimits[2]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Bread Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[3] = LimitedBuying(ProductName , count , 100 , newLimits[3]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Tortilla Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[4] = LimitedBuying(ProductName , count , 100 , newLimits[4]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Pizza Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[5] = LimitedBuying(ProductName , count , 150 , newLimits[5]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Maki Roll Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[6] = LimitedBuying(ProductName , count , 300 , newLimits[6]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Triple Shot Espresso Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[7] = LimitedBuying(ProductName , count , 5000 , newLimits[7]);
            App.dailyLimits.setStarDropSaloon(newLimits);
        }
        else if(ProductName.equals("Cookie Recipe"))
        {
            int newLimits[] = App.dailyLimits.getStarDropSaloon();
            newLimits[8] = LimitedBuying(ProductName , count , 300 , newLimits[8]);
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
        else if(ProductName.equals("Shipping Been"))
        {
            String parts[] = CountOrCoordinate.trim().split("\\s+");

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
        if(limit == 0)
        {
            System.out.println("You have used your daily limit for this item");
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
                return limit - 1;
            }
        }
        ArrayList<Item> newItems = App.ReturnCurrentPlayer().getInventory().getItems();
        newItems.add(new Item(count , ProductName));
        App.ReturnCurrentPlayer().getInventory().setItems(newItems);
        System.out.println(ProductName + " purchased");
        return limit - 1;
    }
    public int BuildBarn(String BarnType , int Capacity , int x , int y , int Price , int NeededWood , int NeededStone , int limit)
    {
        // check for limit
        if(limit == 0)
        {
            System.out.println("You have used your daily limit for this item");
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
            System.out.println("You have used your daily limit for this item");
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
}