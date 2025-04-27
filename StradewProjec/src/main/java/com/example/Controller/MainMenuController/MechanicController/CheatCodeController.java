package com.example.Controller.MainMenuController.MechanicController;

import com.example.Controller.MainMenuController.GameMenuController;
import com.example.Model.App;
import com.example.Model.Enums.Weathers;
import com.example.Model.Game;
import com.example.Model.Time;
import com.example.Model.Tools.Pepolee;
import com.example.View.Appview;

public class CheatCodeController {
    GameMenuController gameMenuController = new GameMenuController();

    public void ChangeHour(int Hour)
    {
        Game currentGame = App.returnGame(Appview.CurrentGameID);
        Time gameTime = currentGame.getTime();
        for (int i=0; i<Hour; i++){
            gameTime.jumpAheadOneHour();
            if (gameTime.isDayChanged()){
                gameMenuController.ApplyChangeDay();
            }
        }
    }

    public void ChangeDay(int Day)
    {
        Game currentGame = App.returnGame(Appview.CurrentGameID);
        Time gameTime = currentGame.getTime();
        for (int i = 0; i<Day; i++){
            gameTime.jumpAheadOneDay();
            gameMenuController.ApplyChangeDay();
        }
    }

    public void Thor(int x , int y)
    {

    }

    public void SetWeather(String Weather)
    {
        Game currentGame = App.getCurrentGame();
        if (Weather.equals(Weathers.SUNNY.name())){
            currentGame.setWeather(Weathers.SUNNY);
        } else if (Weather.equals(Weathers.SNOW.name())) {
            currentGame.setWeather(Weathers.SNOW);
        } else if (Weather.equals(Weathers.RAIN.name())) {
            currentGame.setWeather(Weathers.RAIN);
        } else if (Weather.equals(Weathers.STORM.name())) {
            currentGame.setWeather(Weathers.STORM);
        }
    }

    public void SetEnergy(int energy)
    {
        Pepolee player = App.ReturnCurrentPlayer();
        player.setEnergy(energy);
    }

    public void SetUnlimitedEnergy()
    {
        Pepolee player = App.ReturnCurrentPlayer();
        player.setEnergy(100000000);
    }

    public void AddCraftCheatCode(String ItemName , int Count)
    {

    }

    public void SetFreindShip(String PetName , int Amount)
    {

    }

    public void SetMoney()
    {

    }
}
