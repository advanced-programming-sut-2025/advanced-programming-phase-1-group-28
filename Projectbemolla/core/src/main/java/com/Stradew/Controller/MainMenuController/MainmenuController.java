package com.Stradew.Controller.MainMenuController;

import com.Stradew.Main;
import com.Stradew.View.MainMenu.GameMenu;
import com.Stradew.View.MainMenu.MainMenu;

import java.util.ArrayList;
import java.util.Arrays;

public class MainmenuController {
    MainMenu menu;

    public void setMenu(MainMenu menu) {
        this.menu = menu;
    }

    public void Update()
    {
        if(menu.getGameMenu().isChecked())
        {
            GameMenuController.StartGame(new ArrayList<>());
            //menu.dispose();
            menu.setGoToGameMenu(true);
        }
        if(menu.getProfileMenu().isChecked())
        {

        }
        if(menu.getLogoutButton().isChecked())
        {

        }
    }

}
