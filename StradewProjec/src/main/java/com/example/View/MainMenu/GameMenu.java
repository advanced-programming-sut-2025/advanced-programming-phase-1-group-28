package com.example.View.MainMenu;

import com.example.Controller.MainMenuController.GameMenuController;
import com.example.Controller.SignUpController;
import com.example.Model.App;
import com.example.View.Appview;

import java.util.ArrayList;

public class GameMenu {
    SignUpController signUpController = App.signUpController;
    GameMenuController gameMenuController = App.gameMenuController;
    public void StartGame(ArrayList<String> PlayersInGame)
    {
        for(int i = 0 ;i < PlayersInGame.size();i++) {
            if (!signUpController.IsUsernameTaken(PlayersInGame.get(i))) {
                System.out.println(PlayersInGame.get(i) + " is not a valid username");
                return;
            }
        }
        if(!gameMenuController.IsInAnotherGame(PlayersInGame)) {
            System.out.println("Your Friend are in the game");
            return;
        }
        gameMenuController.ApplyPlayersToGame(PlayersInGame);
        for(int i = 0 ;i < PlayersInGame.size();i++) {
            while (true)
            {
                System.out.println("please Enter the Farm Map for Player" + PlayersInGame.get(i));
                int Mapindex = App.scanner.nextInt();
                if(gameMenuController.CheckMapIDValid(Mapindex)) {
                    gameMenuController.SetFarm(i , Mapindex);
                    break;
                }
                else
                {
                    System.out.println("please Enter valid map ID");
                }
            }
        }
        //InputMapValid();
    }

    /*public boolean InputMapValid(ArrayList<String> PlayersInGame)
    {

    }*/
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
