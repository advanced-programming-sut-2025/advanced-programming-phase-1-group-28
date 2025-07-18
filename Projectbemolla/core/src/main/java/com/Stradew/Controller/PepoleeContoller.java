package com.Stradew.Controller;

import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.Tools.Pepolee;
import com.Stradew.View.MainMenu.CheatCodes;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PepoleeContoller {
    CheatCodes cheatCodes = new CheatCodes();
    public void HandleWalk(Pepolee player , float v)
    {
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            player.setY(player.getY() + (v * 500f));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S))
        {
            player.setY(player.getY() - (v * 500f));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D))
        {
            player.setX(player.getX() + (v * 500f));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            player.setX(player.getX() - (v * 500f));
        }
    }

    public void CheatCodes()
    {
        if(App.getCurrentGame().getTimeControlPannel().getCheatCodeUse() > 1) {
            if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)) {
                cheatCodes.ChangeHour(7);
                App.getCurrentGame().getTimeControlPannel().setCheatCodeUse(0);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
                cheatCodes.ChangeDay(10);
                App.getCurrentGame().getTimeControlPannel().setCheatCodeUse(0);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.NUM_3)) {
                cheatCodes.SetEnergy(App.ReturnCurrentPlayer().getEnergy() + 50);
                App.getCurrentGame().getTimeControlPannel().setCheatCodeUse(0);
            }
        }
    }

    public void Update(Pepolee player , float v)
    {
        HandleWalk(player , v);
        CheatCodes();
        player.getPlayerSprite().setPosition(player.getX(), player.getY());
        player.getPlayerSprite().draw(Main.getMain().getBatch());
        player.getPlayerSprite().setSize(50 , 50);
    }
}
