package com.Stradew.Controller.MainMenuController;

import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.Fishes;
import com.Stradew.Model.Game;
import com.Stradew.Model.Item.FishItem;
import com.Stradew.View.MainMenu.GameMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import org.w3c.dom.Text;

import java.awt.image.CropImageFilter;
import java.util.Random;

public class MinigameController {

    private boolean Started = false;
    private Texture MinigameTexturebar = new Texture("Fishing_Pole/MinigameBar.png");
    private Texture GreenBar =  new Texture("Fishing_Pole/GreenBar.png");
    private float YPos = 0;
    private float FishYPos = 0;
    private Texture FishImage = new Texture("Fish/Blobfish.png");
    private int RandomFish;
    private Boolean PerfectFish = false;
    private Boolean Finish  = true;
    private Texture RealFishImage;
    private Texture Crwon =  new Texture("Hat/Infinity_Crown.png");
    private int Move = 1;


    public boolean isStarted() {
        return Started;
    }

    BitmapFont font = new BitmapFont();

    public void HandleMove()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.U))
        {
            YPos += 5;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.J))
        {
            YPos -= 5;
        }
    }

    public void HandleFishMove()
    {
        if(RandomFish % 5 == 0)
        {
            int A = App.random.nextInt()%2;
            if(A == 0)
            {
                if(Move != 10 && Move != -10)
                {
                    Move = 10;
                }
                Move *= -1;
            }
        }
        if(RandomFish % 5 == 1)
        {
            int A = App.random.nextInt() % 3;
            if(Move != 10 && Move != -10)
            {
                Move = 10;
            }
            if(A == 0)
            {
                Move *= -1;
            }
        }
        if(RandomFish % 5 == 2)
        {
            if(Move != 50 && Move != -50)
            {
                Move = 50;
            }
            int A = App.random.nextInt() % 10;
            if(A == 0)
            {
                int B = App.random.nextInt() % 3;
                if(B == 0)
                {
                    Move = 50;
                }
                else
                {
                    Move = -50;
                }
            }
            else
            {
                Move = 0;
            }
        }
        if(RandomFish % 5 == 3)
        {
            if(Move != 50 && Move != -50)
            {
                Move = 50;
            }
            int A = App.random.nextInt() % 5;
            if(A == 0)
            {
                int B = App.random.nextInt() % 3;
                if(B == 0)
                {
                    Move = -50;
                }
                else
                {
                    Move = 50;
                }
            }
            else
            {
                Move = 0;
            }
        }
        if(RandomFish % 5 == 4)
        {
            int A = App.random.nextInt()%2;
            if(A == 0)
            {
                if(Move != 30 && Move != -30)
                {
                    Move = 30;
                }
                Move *= -1;
            }
        }
        if(FishYPos + Move >= App.ReturnCurrentPlayer().getY() - 300 && FishYPos + Move <= App.ReturnCurrentPlayer().getY() + 200) {
            FishYPos += Move;
        }
    }

    public void setStarted(boolean started) {
        Started = started;
    }

    public void update(GameMenu menu , float v)
    {
        if(Started == false)
        {
            Move = 1;
            Finish = false;
            PerfectFish = true;
            Started = true;
            menu.getMinigameProgress().setValue(100);
            YPos = App.ReturnCurrentPlayer().getY();
            FishYPos = App.ReturnCurrentPlayer().getY() + 100;
            RandomFish = App.random.nextInt()%5;
            if(RandomFish < 0 )
            {
                RandomFish += 5;
            }
        }
        if(!Finish) {
            Main.getMain().getBatch().draw(MinigameTexturebar, App.ReturnCurrentPlayer().getX() - 700, App.ReturnCurrentPlayer().getY() - 300, MinigameTexturebar.getWidth(), MinigameTexturebar.getHeight());
            HandleFishMove();
            HandleMove();
            Main.getMain().getBatch().draw(GreenBar, App.ReturnCurrentPlayer().getX() - 400, YPos, 620, 250);
            Main.getMain().getBatch().draw(FishImage, App.ReturnCurrentPlayer().getX() - 100, FishYPos, FishImage.getWidth(), FishImage.getHeight());
            if(RandomFish %5 == 4)
            {
                Main.getMain().getBatch().draw(Crwon , App.ReturnCurrentPlayer().getX() - 100, FishYPos + 30, Crwon.getWidth(), Crwon.getHeight());
            }
            ApplyCoincidence(menu, v);
            font.draw(Main.getMain().getBatch(), String.valueOf(RandomFish),App.ReturnCurrentPlayer().getX() + 500 , App.ReturnCurrentPlayer().getY());
            if (menu.getMinigameProgress().getValue() == menu.getMinigameProgress().getMaxValue()) {
                SuccssesFishing(menu);
            }
            if(menu.getQuitFromMiniGame().isChecked())
            {
                menu.getQuitFromMiniGame().setChecked(false);
                Finish = false;
                Started = false;
                menu.getMinigame().setVisible(false);
                menu.getMainTable().setVisible(true);
            }
        }
        else
        {
            if(PerfectFish) {
                font.setColor(Color.GOLD);
                font.draw(Main.getMain().getBatch(), "WOW Perfect Fish" , App.ReturnCurrentPlayer().getX(), App.ReturnCurrentPlayer().getY() + 400);
            }
            else
            {
                font.setColor(Color.GOLD);
                font.draw(Main.getMain().getBatch(), "You Catch the Fish" , App.ReturnCurrentPlayer().getX(), App.ReturnCurrentPlayer().getY() + 400);
            }
            if(menu.getQuitFromMiniGame().isChecked())
            {
                menu.getQuitFromMiniGame().setChecked(false);
                Finish = false;
                Started = false;
                menu.getMinigame().setVisible(false);
                menu.getMainTable().setVisible(true);
            }
        }
    }


    public void ApplyCoincidence(GameMenu menu , float v)
    {
        if(YPos <= FishYPos && YPos +150 >= FishYPos)
        {
            menu.getMinigameProgress().setValue(menu.getMinigameProgress().getValue() + v*100);
        }
        else
        {
            PerfectFish = false;
            menu.getMinigameProgress().setValue(menu.getMinigameProgress().getValue() - v*100);
        }
    }


    public void setFishImage(Texture fishImage) {

    }

    public void SuccssesFishing(GameMenu menu)
    {
        int Count = 0;
        for(Fishes fish : Fishes.values())
        {
            if(fish.season == App.getCurrentGame().getTime().getSeason()) {
                if(Count == RandomFish) {
                    int num = (App.ReturnCurrentPlayer().getSkills()[1].getLevel() + 2) * App.getCurrentGame().getWeather().FishCofficent;
                    FishItem newfish = new FishItem(num , fish);
                    App.ReturnCurrentPlayer().getInventory().AddItem(newfish);
                    App.ReturnCurrentPlayer().getSkills()[1].setXp(App.ReturnCurrentPlayer().getSkills()[1].getXp() + 100);
                }
                Count++;
            }
        }
        if(PerfectFish)
        {
            App.ReturnCurrentPlayer().getSkills()[1].setXp(App.ReturnCurrentPlayer().getSkills()[1].getXp() + 200);
        }
        Finish = true;
    }

}
