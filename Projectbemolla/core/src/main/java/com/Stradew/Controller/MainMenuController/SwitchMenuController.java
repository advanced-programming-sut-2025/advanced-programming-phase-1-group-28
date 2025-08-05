package com.Stradew.Controller.MainMenuController;

import com.Stradew.Controller.MainMenuController.HomeMenucontroller.PokhtOPazController;
import com.Stradew.Main;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.PokhtOPaz;

public class SwitchMenuController {
    public void openPokhMenu(){
        PokhtOPaz pokhtOPaz = new PokhtOPaz(new PokhtOPazController());
        Main.getMain().setScreen(pokhtOPaz);
    }
}
