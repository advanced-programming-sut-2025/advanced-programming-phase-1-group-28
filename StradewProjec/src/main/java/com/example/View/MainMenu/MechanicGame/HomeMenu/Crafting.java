package com.example.View.MainMenu.MechanicGame.HomeMenu;

import com.example.Model.App;
import com.example.Model.Enums.Crafts;
import com.example.Model.Tools.Pepolee;

import java.util.Objects;

public class Crafting {
    public void ShowCraftHelp()
    {
        for(Crafts c : Crafts.values())
        {
            System.out.println(App.craftingController.ShowCraft(c));
        }
    }
    public void CraftItem(String ItemName) {
        if (App.craftingController.ReturnCraft(ItemName) == null) {
            System.out.println("There is no such Craft");
            return;
        }
        Crafts craft = App.craftingController.ReturnCraft(ItemName);
        if (Objects.equals(App.craftingController.ShowCraft(craft), craft.toString() + ":" + "Locked" + "\n")) {
            System.out.println("It is Locked my friend");
            return;
        }
        if (!App.craftingController.EnoughSource(craft)) {
            System.out.println("There is not enough source");
            return;
        }
        App.craftingController.ApplyCrafting(craft);
        System.out.println("Craft created successfully");
    }

    public void ShowRecipes()
    {
        Pepolee Currentpeople = App.ReturnCurrentPlayer();
        for(int i = 0;i < Currentpeople.getInventory().getItems().size();i++)
        {
            String Names = Currentpeople.getInventory().getItems().get(i).getName();
            if(Names.equals("DEHYDRATOR_RECIPE") || Names.equals("FISH_SMOKER_RECIPE") || Names.equals("GRASS_STARTER_RECIPE"))
            {
                System.out.println(Names);
            }
        }
    }
}
