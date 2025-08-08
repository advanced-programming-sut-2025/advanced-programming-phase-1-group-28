package com.Stradew.Controller.MainMenuController;

import com.Stradew.Controller.StartmenuController;
import com.Stradew.Main;
import com.Stradew.View.Appview;
import com.Stradew.View.MainMenu.MainMenu;
import com.Stradew.View.MainMenu.ProfileMenu;
import com.Stradew.View.StartMenu;

import java.util.ArrayList;

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
        if(menu.getProfileMenu().isChecked()) {
            Main.getMain().setScreen(new ProfileMenu(new ProfileMenuController()));
        }

        if(menu.getGotoLobbyBotton().isChecked())
        {
            menu.setCreateLobbyTable(true);
        }
        if(menu.getLogoutButton().isChecked())
        {
            Appview.UserLoggedInId = -1;
            Main.getMain().setScreen(new StartMenu(new StartmenuController()));
        }
    }

}
