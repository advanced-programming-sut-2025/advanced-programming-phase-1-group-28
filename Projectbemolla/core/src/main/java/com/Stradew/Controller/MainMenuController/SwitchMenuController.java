package com.Stradew.Controller.MainMenuController;

import com.Stradew.Controller.MainMenuController.HomeMenucontroller.PokhtOPazController;
import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.Npc;
import com.Stradew.Model.Tools.Pepolee;
import com.Stradew.View.MainMenu.GameMenu;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.PokhtOPaz;
import com.Stradew.View.MainMenu.NPCVillage;

public class SwitchMenuController {
    public void openPokhMenu(){
        PokhtOPaz pokhtOPaz = new PokhtOPaz(new PokhtOPazController());
        Main.getMain().setScreen(pokhtOPaz);
    }
    public void openNpcVillage(){
        App.ReturnCurrentPlayer().setInNpcVillage(true);
        if (Main.getMain().getBatch().isDrawing()){
            Main.getMain().getBatch().end();
        }
        Main.getMain().setScreen(new NPCVillage(new NPCVillageController()));
    }

    public void openGameMenu(){
        App.ReturnCurrentPlayer().setInNpcVillage(false);
        if (Main.getMain().getBatch().isDrawing()){
            Main.getMain().getBatch().end();
        }
        Main.getMain().setScreen(new GameMenu(new GameMenuController()));
    }

    public void openNpcMenu(Npc npc){

    }

    public void openFriendshipMenu(Pepolee otherPlayer){

    }

}
