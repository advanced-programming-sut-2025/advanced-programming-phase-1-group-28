package View.MainMenu;

import Controller.MainMenuController.GameMenuController;
import Controller.SignUpController;
import Model.App;
import View.Appview;

import java.util.ArrayList;

public class GameMenu {
    SignUpController signUpController = App.signUpController;
    GameMenuController gameMenuController = App.gameMenuController;
    public void StartGame(ArrayList<String> PlayersInGame)
    {
        //if successfully Add players then Input Map
        InputMapValid();
    }
    public boolean InputMapValid()
    {
        //TO DO
        return false;
    }
    public void LoadGame()
    {
        //TO DO
    }
    public void ExitGame()
    {
        //Update Files if we were Main
    }
    public void Voting()
    {
        //print Each turn
    }

}
