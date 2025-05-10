package com.example.View.MainMenu;

import com.example.Controller.MainMenuController.GameMenuController;
import com.example.Controller.SignUpController;
import com.example.Model.App;
import com.example.Model.Enums.MenuName;
import com.example.Model.Enums.Rejex.GameMenuRejex;
import com.example.Model.User;
import com.example.View.Appview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameMenu {
    SignUpController signUpController = App.signUpController;
    GameMenuController gameMenuController = App.gameMenuController;
    ShowFigures showFigures = App.showFigures;
    CheatCodes cheatCodes = App.cheatCodes;

    public void Input(String command){
        Matcher matcher;
        if ((matcher = GameMenuRejex.EnergyShow.getMatcher(command)) != null){
            showFigures.ShowEnergy();
        } else if ((matcher = GameMenuRejex.EnergySet.getMatcher(command)) != null) {
            cheatCodes.SetEnergy(Integer.parseInt(matcher.group(1)));
        } else if ((matcher = GameMenuRejex.EnergyUnlimited.getMatcher(command)) != null) {
            cheatCodes.SetUnlimitedEnergy();
        } else if ((matcher = GameMenuRejex.InventoryShow.getMatcher(command)) != null) {
            showFigures.ShowInventory();
        } else if ((matcher = GameMenuRejex.CheatWeatherSet.getMatcher(command)) != null) {
            cheatCodes.SetWeather(matcher.group(1));
        } else if ((matcher = GameMenuRejex.ShowWeather.getMatcher(command)) != null) {
            showFigures.ShowWeather();
        } else if ((matcher = GameMenuRejex.WeatherForecast.getMatcher(command)) != null) {
            showFigures.PredictWeather();
        } else if ((matcher = GameMenuRejex.CheatThor.getMatcher(command)) != null) {
            cheatCodes.Thor(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));// This is incomplete
        } else if ((matcher = GameMenuRejex.ShowSeason.getMatcher(command)) != null) {
            showFigures.ShowSeason();
        } else if ((matcher = GameMenuRejex.CheatAdvanceDate.getMatcher(command)) != null) {
            cheatCodes.ChangeDay(Integer.parseInt(matcher.group(1)));
        } else if ((matcher = GameMenuRejex.CheatAdvanceTime.getMatcher(command)) != null) {
            cheatCodes.ChangeHour(Integer.parseInt(matcher.group(1)));
        } else if ((matcher = GameMenuRejex.ShowDayOfWeek.getMatcher(command)) != null) {
            showFigures.ShowDayOfWeek();
        } else if ((matcher = GameMenuRejex.ShowDateTime.getMatcher(command)) != null) {
            showFigures.ShowDateTime();
        } else if ((matcher = GameMenuRejex.ShowDate.getMatcher(command)) != null) {
            showFigures.ShowDate();
        } else if ((matcher = GameMenuRejex.ShowTime.getMatcher(command)) != null) {
            showFigures.ShowTime();
        } else if((matcher = GameMenuRejex.StartGame.getMatcher(command)) != null) {
            ArrayList<String> Usernames = new ArrayList<>();
            String PlayerRejex = "\\w+";
            Pattern Playerpattern = Pattern.compile(PlayerRejex);
            Matcher playerMatcher = Playerpattern.matcher(command.substring(12));
            while (playerMatcher.find()) {
                Usernames.add(playerMatcher.group().trim());
            }
            StartGame(Usernames);
        } else if((matcher = GameMenuRejex.ExitGame.getMatcher(command)) != null)
        {
            Appview.Situation = MenuName.LoginMenu;
        } else if((matcher = GameMenuRejex.BuildGreenhouse.getMatcher(command)) != null)
        {
            App.mechanicGame.BuildGreenHouse();
        } else if((matcher = GameMenuRejex.Walk.getMatcher(command)) != null)
        {
            App.mechanicGame.walk(App.ReturnCurrentPlayer().getX() , App.ReturnCurrentPlayer().getY() , Integer.parseInt(matcher.group(1)) , Integer.parseInt(matcher.group(2)));
        }
    }
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
        System.out.println("i am zende");
        for(int i = 0;i < PlayersInGame.size();i++) {
            System.out.println(PlayersInGame.get(i));
        }
        PlayersInGame.add(0, App.getCurrentUser().getUsername());
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
                else {
                    System.out.println("please Enter valid map ID");
                }
            }
        }
        System.out.println("Welcome to the game");
        //InputMapValid();
        //call start game commands
    }

    public void NextTurn()
    {
        App.gameMenuController.ApplyNextTurn();
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
