package com.Stradew.Controller;

import com.Stradew.Main;
import com.Stradew.View.SignUpMenu;
import com.Stradew.View.StartMenu;
import com.badlogic.gdx.Gdx;

public class StartmenuController {

    private StartMenu menu;

    public void setMenu(StartMenu menu) {
        this.menu = menu;
    }

    public void Update()
    {
        if(menu.getExit().isChecked())
        {
            Gdx.app.exit();
        }
        if(menu.getSignUp().isChecked())
        {
            Main.getMain().setScreen(new SignUpMenu(new SignUpController()));
        }
        if(menu.getLogin().isChecked())
        {

        }
    }

}
