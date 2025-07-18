package com.Stradew.Controller.MainMenuController;

import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.badlogic.gdx.graphics.Texture;

public class SkillPannelController {
    private Texture BackGround = GameAssetsManager.getInstance().getSkillPannel();
    public void update()
    {
        Main.getMain().getBatch().draw(BackGround , App.ReturnCurrentPlayer().getX() - 800 , App.ReturnCurrentPlayer().getY() - 400 , 1000 , 1000);
    }
}
