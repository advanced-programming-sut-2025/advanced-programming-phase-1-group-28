package com.Stradew.Controller;

import com.Stradew.Model.Enums.MenuName;
import com.Stradew.View.Appview;
//import com.google.gson.Gson;


public class AllMenuCommandsController {
    public String ShowCurrentMenu()
    {
        return Appview.getSituation().Name;
    }
    public MenuName Returnmenuname(String menu)
    {
        for(MenuName menuName : MenuName.values())
        {
            if(menu.equals(menuName.name()))
            {
                return menuName;
            }
        }
        return null;
    }
    public String GoToMenu(MenuName menuName)
    {
        if(menuName.equals(MenuName.ProfileMenu))
        {
            if(Appview.getSituation() != MenuName.MainMenu)
            {
                return "IF You want to go to Profile Menu first enter the Main Menu";
            }
        }
        if(menuName.equals(MenuName.GameMenu))
        {
            if(Appview.getSituation() != MenuName.MainMenu)
            {
                return "If You want to go to the Game Menu first enter the Main Menu";
            }
        }
        if(menuName.equals(MenuName.MainMenu))
        {
            if(Appview.getUserLoggedInId() == -1)
            {
                return "Login First Please";
            }
        }
        return "You Going to" + menuName.Name + "successfully";
    }
    /*public void ExitApp()
    {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("Users.json")) {
            for(User user : App.Users)
            {
                gson.toJson(user, writer);
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }*/
}
