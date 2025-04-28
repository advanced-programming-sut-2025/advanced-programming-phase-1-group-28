package com.example.Controller.MainMenuController.MechanicController;

import com.example.Model.App;
import com.example.Model.Enums.Animals;
import com.example.Model.Item.Item;
import com.example.Model.Places.Coop;
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
            // price is 75
            // you can buy unlimited amount as long as you have enough money
            if(count * 75 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
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
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 75);
            System.out.println("Copper Ore purchased");
        }
        else if(ProductName.equals("Iron Ore"))
        {
            // price is 150
            // you can buy unlimited amount as long as you have enough money
            if(count * 150 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
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
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 150);
            System.out.println("Iron Ore purchased");
        }
        else if(ProductName.equals("Gold Ore"))
        {
            // price is 400
            // you can buy unlimited amount as long as you have enough money
            if(count * 400 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
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
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 400);
            System.out.println("Gold Ore purchased");
        }
        else if(ProductName.equals("Coal"))
        {
            // price is 150
            // you can buy unlimited amount as long as you have enough money
            if(count * 150 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
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
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 150);
            System.out.println("Coal purchased");
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
            // price is 50
            // you can buy unlimited amount as long as you have enough money
            if(count * 50 > App.ReturnCurrentPlayer().getCoin())
            {
                System.out.println("Not enough money bro");
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
            App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - count * 50);
            System.out.println("Hay purchased");
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
            for(Coop coop : App.ReturnCurrentPlayer().getFarm().getCoops())
            {
                if(coop.getCoopType().equals("Coop") && coop.getCapacity() > 0)
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
    }
}
