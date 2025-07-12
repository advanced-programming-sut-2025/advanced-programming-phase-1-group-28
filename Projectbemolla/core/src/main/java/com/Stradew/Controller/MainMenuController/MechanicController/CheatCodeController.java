package com.Stradew.Controller.MainMenuController.MechanicController;

import com.Stradew.Controller.MainMenuController.GameMenuController;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.Weathers;
import com.Stradew.Model.Game;
import com.Stradew.Model.Tile.Animal;
import com.Stradew.Model.Tools.Pepolee;

public class CheatCodeController {

    public void ChangeHour(int Hour)
    {
        for (int i=0; i<Hour; i++){
            GameMenuController.ApplyChangeHour();
        }
    }

    public void ChangeDay(int Day)
    {
        for (int i = 0; i<Day; i++){
            for (int j = 0; j<24; j++){
                GameMenuController.ApplyChangeHour();
            }
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

    public void SetFriendShip(Animal animal, int amount)
    {
        animal.setFriendShip(amount);
    }

    public void addMoney(int amount)
    {
        App.ReturnCurrentPlayer().addCoin(amount);
    }
}
