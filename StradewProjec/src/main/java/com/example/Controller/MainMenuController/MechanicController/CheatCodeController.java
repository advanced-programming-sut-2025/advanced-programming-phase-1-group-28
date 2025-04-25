package com.example.Controller.MainMenuController.MechanicController;

import com.example.Controller.MainMenuController.GameMenuController;
import com.example.Model.App;
import com.example.Model.Game;
import com.example.Model.Time;
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
}
