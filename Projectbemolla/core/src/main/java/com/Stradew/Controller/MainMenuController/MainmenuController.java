package com.Stradew.Controller.MainMenuController;

import com.Stradew.View.MainMenu.MainMenu;

public class MainmenuController {
    MainMenu menu;

    public void setMenu(MainMenu menu) {
        this.menu = menu;
    }

    public void Update()
    {
        if(menu.getGameMenu().isChecked())
        {

        }
        if(menu.getProfileMenu().isChecked())
        {

        }
        if(menu.getLogoutButton().isChecked())
        {

        }
    }

}
