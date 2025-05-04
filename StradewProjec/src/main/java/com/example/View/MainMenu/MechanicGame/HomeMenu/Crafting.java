package com.example.View.MainMenu.MechanicGame.HomeMenu;

import com.example.Model.App;
import com.example.Model.Enums.Crafts;

public class Crafting {
    public void ShowCraftHelp()
    {
        for(Crafts c : Crafts.values())
        {
            System.out.println(App.craftingController.ShowCraft(c));
        }
    }
    public void CraftItem(String ItemName)
    {
        if(App.craftingController.ReturnCraft(ItemName) == null)
        {
            System.out.println("There is no such Craft");
            return;
        }
        Crafts craft = App.craftingController.ReturnCraft(ItemName);
        if(App.craftingController.ShowCraft(craft) == craft.toString() + ":"  + "Locked" + "\n")
        {
            System.out.println("It is Locked my friend");
            return;
        }
        if(!App.craftingController.EnoughSource(craft))
        {
            System.out.println("There is not enough source");
            return;
        }

    }


}
