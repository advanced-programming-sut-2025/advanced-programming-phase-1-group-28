package com.Stradew.Controller.MainMenuController;

import com.Stradew.Controller.MainMenuController.HomeMenucontroller.CraftingController;
import com.Stradew.Controller.MainMenuController.HomeMenucontroller.PokhtOPazController;
import com.Stradew.Controller.MainMenuController.MechanicController.FriendShipController;
import com.Stradew.Controller.MainMenuController.MechanicController.MechanicController;
import com.Stradew.Controller.MainMenuController.MechanicController.NPC_Controller;
import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.Npc;
import com.Stradew.Model.Tile.Animal;
import com.Stradew.Model.Tools.Pepolee;
import com.Stradew.Server.Lobby;
import com.Stradew.View.MainMenu.GameMenu;
import com.Stradew.View.MainMenu.MechanicGame.AnimalInteractionDialog;
import com.Stradew.View.MainMenu.MechanicGame.FriendshipDialog;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.CookingDialog;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.CraftingDialog;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.PokhtOPaz;
import com.Stradew.View.MainMenu.MechanicGame.NpcDialog;
import com.Stradew.View.MainMenu.NPCVillage;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class SwitchMenuController {
    public void openPokhMenu(Stage stage){
        CookingDialog cookingDialog = new CookingDialog(new PokhtOPazController(), GameAssetsManager.getInstance().getSkin());
        cookingDialog.show(stage);
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
        Main.getMain().setScreen(new GameMenu(new GameMenuController() , new Lobby(null ,null ,null , null)));
    }

    public void openNpcMenu(Npc npc, Stage stage){
        NpcDialog npcDialog = new NpcDialog(npc, new NPC_Controller(), GameAssetsManager.getInstance().getSkin());
        npcDialog.show(stage);
    }

    public void openFriendshipMenu(Pepolee otherPlayer, Stage stage){
        FriendshipDialog friendshipDialog = new FriendshipDialog(otherPlayer, new FriendShipController(), GameAssetsManager.getInstance().getSkin());
        friendshipDialog.show(stage);
    }

    public void openAnimalMenu(Animal animal, Stage stage){
        AnimalInteractionDialog dialog = new AnimalInteractionDialog(animal, new MechanicController(), GameAssetsManager.getInstance().getSkin());
        dialog.show(stage);
    }

    public void openCraftMenu(Stage stage){
        CraftingDialog craftingDialog = new CraftingDialog(new CraftingController(), GameAssetsManager.getInstance().getSkin());
        craftingDialog.show(stage);
    }

    public void openBlackSmith(){

    }

    public void openCarpenterShop(){

    }

    public void openFishShop(){

    }

    public void openJojaMart(){

    }

    public void openMarineRanch(){

    }

    public void openPerrieGeneralStore(){

    }

    public void openStarDropSaloon(){

    }

}
