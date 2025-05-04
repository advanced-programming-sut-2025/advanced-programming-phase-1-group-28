package com.example.View.MainMenu.MechanicGame.HomeMenu;

import com.example.Controller.MainMenuController.HomeMenucontroller.PokhtOPazController;
import com.example.Model.App;
import com.example.Model.Item.Food;
import com.example.Model.Item.Item;
import com.example.Model.Ref;
import com.example.Model.Tools.Pepolee;

public class PokhtOPaz {
    PokhtOPazController pokhtOPazController = new PokhtOPazController();
    public void PickFromRef(String itemName)
    {
        Ref ref = App.ReturnCurrentPlayer().getFarm().getCabin().getRefrigerator();
        if (!ref.isItemAvailable(itemName)){
            System.out.println("Looks likes that item isn't in the fridge anymore!");
        }
        pokhtOPazController.ApplyPickFromRef(itemName);
        System.out.println("Item liberated from the cold, now in your inventory!");
    }
    public void putInRef(String itemName)
    {
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        if (!currentPlayer.getInventory().isItemAvailable(itemName)){
            System.out.println("Nope! That item seems to have vanished into thin air... or maybe it's just not in your inventory?");
            return;
        }
        pokhtOPazController.ApplyPut(itemName);
        System.out.println("Item successfully transferred to refrigeration.");
    }
    public void PokhtingOPazing(String ItemName)
    {
        if (!pokhtOPazController.EnoughSkill(ItemName)){
            System.out.println("Failed to cook: Requires higher Pokht O Paz proficiency.");
            return;
        }
        if (!pokhtOPazController.EnoughItemsFromInventory(ItemName) &&
                !pokhtOPazController.EnoughItemsFromRef(ItemName)){
            System.out.println("Looks like you're missing some key ingredients for that recipe!");
            return;
        }
        pokhtOPazController.ApplyPokhtingOPazing(ItemName);
        System.out.println("You Pokhted and Pazed " + ItemName + " successfully.");
    }
    public void Eating(String ItemName)
    {
        Item item = App.ReturnCurrentPlayer().getInventory().getItemByName(ItemName);
        if (item == null){
            System.out.println("Unfortunately you don't have this one.");
            return;
        }
        if (!(item instanceof Food)){
            System.out.println("Your stomach will thank if you skip that.");
            return;
        }
        pokhtOPazController.ApplyEatingFood(ItemName);
        System.out.println("You ate some food.");
    }
}
