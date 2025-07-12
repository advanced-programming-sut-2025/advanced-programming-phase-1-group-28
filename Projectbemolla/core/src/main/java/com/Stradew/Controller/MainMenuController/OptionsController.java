package com.Stradew.Controller.MainMenuController;

import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class OptionsController {
    private BitmapFont font = new BitmapFont();

    public void PrintClock()
    {
        Texture Clock = GameAssetsManager.getInstance().getClock();
        float PlayerXPos = App.ReturnCurrentPlayer().getX();
        float PlayerYPos = App.ReturnCurrentPlayer().getY();
        Main.getMain().getBatch().draw(Clock, PlayerXPos + Gdx.graphics.getWidth()/2 - 380 ,PlayerYPos + Gdx.graphics.getHeight()/2 - 380, 300 , 300);
        String Date = App.getCurrentGame().getTime().showDate();
        String Time = App.getCurrentGame().getTime().showHour();
        String Gold = String.valueOf(App.ReturnCurrentPlayer().getCoin());
        font.setColor(0 , 0 , 0 , 1);
        font.draw(Main.getMain().getBatch(), Gold , PlayerXPos + Gdx.graphics.getWidth() / 2 - 300 , PlayerYPos + Gdx.graphics.getHeight() / 2 - 280);
        font.draw(Main.getMain().getBatch(), Date , PlayerXPos + Gdx.graphics.getWidth() / 2 - 230 , PlayerYPos + Gdx.graphics.getHeight() / 2 - 100);
        font.draw(Main.getMain().getBatch(), Time , PlayerXPos + Gdx.graphics.getWidth() / 2 - 230 , PlayerYPos + Gdx.graphics.getHeight() / 2 - 210);
    }

    public void Update()
    {
        PrintClock();
    }


}
