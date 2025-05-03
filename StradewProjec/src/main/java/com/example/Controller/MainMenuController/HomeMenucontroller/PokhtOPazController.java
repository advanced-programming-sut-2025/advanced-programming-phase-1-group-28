package com.example.Controller.MainMenuController.HomeMenucontroller;

import com.example.Model.App;
import com.example.Model.Enums.Foods;
import com.example.Model.Inventory;
import com.example.Model.Item.Food;
import com.example.Model.Item.Item;
import com.example.Model.Ref;
import com.example.Model.Tools.Pepolee;

public class PokhtOPazController {
    public void ApplyPickFromRef(String ItemName)
    {
        Ref ref = App.ReturnCurrentPlayer().getFarm().getCabin().getRefrigerator();
        Item myItem = ref.pickItemByName(ItemName);
        App.ReturnCurrentPlayer().getInventory().addItem(myItem);
    }
    public void ApplyPut(String ItemName)
    {
        Ref ref = App.ReturnCurrentPlayer().getFarm().getCabin().getRefrigerator();
        Inventory inventory = App.ReturnCurrentPlayer().getInventory();
        Item item = inventory.getItemByName(ItemName);
        ref.AddItem(item);
        inventory.removeItem(item);
    }
    public boolean EnoughItemsFromRef(String ItemName)
    {
        Ref ref = App.ReturnCurrentPlayer().getFarm().getCabin().getRefrigerator();
        Foods foods = getFoodByName(ItemName);
        int i = 0;
        for (String ingredient: foods.Ingredient){
            Item item = ref.getItem(ingredient);
            if (item == null){
                return false;
            }
            if (item.getCount() < foods.IngredientCount.get(i)){
                return false;
            }
            i++;
        }
        return true;
    }
    public boolean EnoughItemsFromInventory(String ItemName)
    {
        Inventory inventory = App.ReturnCurrentPlayer().getInventory();
        Foods foods = getFoodByName(ItemName);
        int i = 0;
        for (String ingredient: foods.Ingredient){
            Item item = inventory.getItemByName(ingredient);
            if (item == null){
                return false;
            }
            if (item.getCount() < foods.IngredientCount.get(i)){
                return false;
            }
            i++;
        }
        return true;
    }
    public boolean EnoughSkill(String ItemName)
    {
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        for (Foods foods: currentPlayer.getKnownRecipes()){
            if (foods.Name.equals(ItemName)){
                return true;
            }
        }
        return false;
    }

    public Foods getFoodByName(String foodName){
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        for (Foods foods: currentPlayer.getKnownRecipes()){
            if (foods.Name.equals(foodName)){
                return foods;
            }
        }
        return null;
    }
    public void removeIngredientsFromInventory(String ingredientName, int count){
        Inventory inventory = App.ReturnCurrentPlayer().getInventory();
        Item item = inventory.getItemByName(ingredientName);
        item.addCount(-1 * count);
    }
    public void removeIngredientsFromRef(String ingredientName, int count){
        Ref ref = App.ReturnCurrentPlayer().getFarm().getCabin().getRefrigerator();
        Item item = ref.getItem(ingredientName);
        item.addCount(-1 * count);
    }
    public void ApplyPokhtingOPazing(String ItemName)
    {
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        Foods myFood = getFoodByName(ItemName);
        if (EnoughItemsFromInventory(ItemName)){
            int i = 0;
            for (String ingredient: myFood.Ingredient){
                removeIngredientsFromInventory(ingredient, myFood.IngredientCount.get(i));
                i++;
            }
        } else if (EnoughItemsFromRef(ItemName)) {
            int i = 0;
            for (String ingredient: myFood.Ingredient){
                removeIngredientsFromRef(ingredient, myFood.IngredientCount.get(i));
                i++;
            }
        }
        Inventory inventory = currentPlayer.getInventory();
        Food food = new Food(1, myFood);
        inventory.addItem(food);
        currentPlayer.addEnergy(-3);
    }
    public void ApplyEatingFood(String ItemName)
    {

    }
}
