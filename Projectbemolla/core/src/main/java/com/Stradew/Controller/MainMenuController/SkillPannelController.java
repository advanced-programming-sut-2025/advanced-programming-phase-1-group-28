package com.Stradew.Controller.MainMenuController;

import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.View.MainMenu.GameMenu;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.awt.*;

public class SkillPannelController {
    private Texture BackGround = GameAssetsManager.getInstance().getSkillPannel();


    private Texture FarmAchivment = GameAssetsManager.getInstance().FarmAchivment();
    private Texture FishAchivment = GameAssetsManager.getInstance().FishAchivment();
    private Texture MineAchivment = GameAssetsManager.getInstance().mineAchivment();
    private Texture NatureAchivment = GameAssetsManager.getInstance().NatureAchivment();

    public void FirstTouch(GameMenu gameMenu)
    {

    }


    private BitmapFont font = new BitmapFont();

    public void update()
    {
        //Main.getMain().getBatch().draw(BackGround , App.ReturnCurrentPlayer().getX() - 800 , App.ReturnCurrentPlayer().getY() - 400 , 1000 , 1000);
        font.draw(Main.getMain().getBatch() , "Farm Achivment", App.ReturnCurrentPlayer().getX() - 500 , App.ReturnCurrentPlayer().getY() + 200);
        font.draw(Main.getMain().getBatch() , "Fish Achivment", App.ReturnCurrentPlayer().getX() - 500 , App.ReturnCurrentPlayer().getY() );
        font.draw(Main.getMain().getBatch() , "Mine Achivment", App.ReturnCurrentPlayer().getX() - 500 , App.ReturnCurrentPlayer().getY() - 200);
        font.draw(Main.getMain().getBatch() , "Nature Achivment", App.ReturnCurrentPlayer().getX() - 500 , App.ReturnCurrentPlayer().getY() - 400);

        Main.getMain().getBatch().draw(FarmAchivment , App.ReturnCurrentPlayer().getX() - 400 , App.ReturnCurrentPlayer().getY() + 200);
        Main.getMain().getBatch().draw(FishAchivment , App.ReturnCurrentPlayer().getX() - 400 , App.ReturnCurrentPlayer().getY() );
        Main.getMain().getBatch().draw(MineAchivment , App.ReturnCurrentPlayer().getX() - 400 , App.ReturnCurrentPlayer().getY() - 200);
        Main.getMain().getBatch().draw(NatureAchivment , App.ReturnCurrentPlayer().getX() - 400 , App.ReturnCurrentPlayer().getY() - 400);

        Main.getMain().getBatch().draw(GameAssetsManager.getInstance().Stars[App.ReturnCurrentPlayer().getSkills()[2].getLevel()] , App.ReturnCurrentPlayer().getX() - 200, App.ReturnCurrentPlayer().getY() + 200);
        Main.getMain().getBatch().draw(GameAssetsManager.getInstance().Stars[App.ReturnCurrentPlayer().getSkills()[1].getLevel()] , App.ReturnCurrentPlayer().getX() - 200, App.ReturnCurrentPlayer().getY() );
        Main.getMain().getBatch().draw(GameAssetsManager.getInstance().Stars[App.ReturnCurrentPlayer().getSkills()[3].getLevel()] , App.ReturnCurrentPlayer().getX() - 200, App.ReturnCurrentPlayer().getY() - 200);
        Main.getMain().getBatch().draw(GameAssetsManager.getInstance().Stars[App.ReturnCurrentPlayer().getSkills()[0].getLevel()] , App.ReturnCurrentPlayer().getX() - 200, App.ReturnCurrentPlayer().getY() - 400);

    }
}
