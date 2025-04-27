package com.example.View.MainMenu;

import com.example.Controller.MainMenuController.GameMenuController;
import com.example.Controller.MainMenuController.MechanicController.CheatCodeController;
import com.example.Model.App;
import com.example.Model.Enums.Weathers;
import com.example.Model.Game;
import com.example.Model.Time;
import com.example.Model.Tools.Pepolee;
import com.example.View.Appview;

public class CheatCodes {
    CheatCodeController cheatCodeController = new CheatCodeController();

    public void ChangeHour(int Hour)
    {
        if (Hour < 0){
            System.out.println("Time can only move forward! Please enter a positive number!");
        }
        cheatCodeController.ChangeHour(Hour);
        Game currentGame = App.returnGame(Appview.CurrentGameID);
        Time gameTime = currentGame.getTime();
        System.out.println("Time advanced by " + Hour + " hours. The current datetime is now " + gameTime.showDateTime() + ".");
    }
    public void ChangeDay(int Day)
    {
        if (Day < 0){
            System.out.println("Time can only move forward! Please enter a positive number!");
        }
        cheatCodeController.ChangeDay(Day);
        Game currentGame = App.returnGame(Appview.CurrentGameID);
        Time gameTime = currentGame.getTime();
        System.out.println("Time advanced by " + Day + " days. The current date is now " + gameTime.showDate() + ".");
    }
    public void Thor(int x , int y)
    {

    }
    public void SetWeather(String Weather)
    {
        if (!Weather.equals(Weathers.SUNNY.name()) && !Weather.equals(Weathers.RAIN.name()) &&
        !Weather.equals(Weathers.SNOW.name()) && !Weather.equals(Weathers.STORM.name())){
            System.out.println("Please choose " + Weathers.SUNNY.name() +  " or" + Weathers.RAIN.name() +  " or" +
                    Weathers.SNOW.name() +  " or" + Weathers.STORM.name() +  " for weather.");
            return;
        }
        cheatCodeController.SetWeather(Weather);
        Game game = App.getCurrentGame();
        System.out.println("Now weather is " + game.getWeather());
    }
    public void SetEnergy(int energy)
    {
        cheatCodeController.SetEnergy(energy);
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        System.out.println("Your energy is " + currentPlayer.getEnergy());
    }
    public void SetUnlimitedEnergy()
    {
        cheatCodeController.SetUnlimitedEnergy();
        System.out.println("Your energy is unlimited");
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
