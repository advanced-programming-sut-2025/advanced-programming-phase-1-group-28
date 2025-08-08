package com.Stradew.Controller.MainMenuController;

import com.Stradew.Main;
import com.Stradew.Model.App;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.ArrayList;

public class OnlinePlayersController {

    public ArrayList<String> OnlinePlayers = new ArrayList<>();
    BitmapFont font = new BitmapFont();

    public void Update()
    {
        font.setColor(Color.WHITE);
        if(OnlinePlayers.isEmpty())
        {
            App.networkClient.sendMessage("SEND_PLAYERS");
        }
        for(int i = 0;i < OnlinePlayers.size();i++)
        {
            font.draw(Main.getMain().getBatch(), OnlinePlayers.get(i) , App.ReturnCurrentPlayer().getX() - 500 , App.ReturnCurrentPlayer().getY() + 300 - (100 * i));
        }
    }

}
