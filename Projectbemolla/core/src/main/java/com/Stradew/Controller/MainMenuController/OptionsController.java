package com.Stradew.Controller.MainMenuController;

import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.Game;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.PairChanges;
import com.Stradew.View.MainMenu.GameMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

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

    public void BuyGreenhouse(TextButton textButton , GameMenu menu)
    {
        if(menu.getBuyGreenhouseTable().isVisible()) {
            if (textButton.isChecked()) {
                if (App.ReturnCurrentPlayer().getCoin() > 100 || true) {
                    App.ReturnCurrentPlayer().getFarm().getGreenHouse().setLocked(false);
                    App.ReturnCurrentPlayer().setCoin(App.ReturnCurrentPlayer().getCoin() - 100);
                    for (int X = -5; X < 20; X++) {
                        for (int Y = -5; Y < 20; Y++) {
                            App.ReturnCurrentPlayer().getFarm().getChanges().add(new PairChanges(App.ReturnCurrentPlayer().getFarm().getGreenHouse().getX_Coordinate() + X, App.ReturnCurrentPlayer().getFarm().getGreenHouse().getY_Coordinate() + Y));
                        }
                    }
                }
                textButton.remove();
            }
            textButton.setChecked(false);
        }
    }

    public void InventoeyBuuton(GameMenu menu)
    {
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
        {
            menu.getMainTable().setVisible(false);
            menu.getInventoryTable().setVisible(true);
            menu.getSwitchTable().setVisible(true);
        }
    }

    public void SetEnergyBar(GameMenu menu)
    {
        if(App.ReturnCurrentPlayer().getEnergy() > menu.getEnergyBar().getMaxValue())
        {
            App.ReturnCurrentPlayer().setEnergy((int) menu.getEnergyBar().getMaxValue());
        }
        menu.getEnergyBar().setValue(App.ReturnCurrentPlayer().getEnergy());
    }


    public void SwitchBeetweenOptions(GameMenu menu)
    {
        if(menu.getInventoryButton().isChecked())
        {
            menu.getInventoryTable().setVisible(true);
            menu.getSwitchTable().setVisible(true);
            menu.getSocialTable().setVisible(false);
            menu.getMapTable().setVisible(false);
            menu.getSkillTable().setVisible(false);
            menu.getMainTable().setVisible(false);
        }
        if(menu.getSkillButton().isChecked())
        {
            menu.getInventoryTable().setVisible(false);
            menu.getSwitchTable().setVisible(true);
            menu.getSocialTable().setVisible(false);
            menu.getMapTable().setVisible(false);
            menu.getSkillTable().setVisible(true);
            menu.getMainTable().setVisible(false);
        }
        if(menu.getSocialButton().isChecked())
        {
            menu.getInventoryTable().setVisible(false);
            menu.getSwitchTable().setVisible(true);
            menu.getSocialTable().setVisible(true);
            menu.getMapTable().setVisible(false);
            menu.getSkillTable().setVisible(false);
            menu.getMainTable().setVisible(false);
        }
        if(menu.getMapButton().isChecked())
        {
            menu.getInventoryTable().setVisible(false);
            menu.getSwitchTable().setVisible(true);
            menu.getSocialTable().setVisible(false);
            menu.getMapTable().setVisible(true);
            menu.getSkillTable().setVisible(false);
            menu.getMainTable().setVisible(false);
        }
        if(menu.getBackbutton().isChecked())
        {
            menu.getInventoryTable().setVisible(false);
            menu.getSwitchTable().setVisible(false);
            menu.getSocialTable().setVisible(false);
            menu.getMapTable().setVisible(false);
            menu.getSkillTable().setVisible(false);
            menu.getMainTable().setVisible(true);
        }
        menu.getInventoryButton().setChecked(false);
        menu.getSkillButton().setChecked(false);
        menu.getMapButton().setChecked(false);
        menu.getSocialButton().setChecked(false);
        menu.getBackbutton().setChecked(false);
    }

    public void Update(TextButton textButton , GameMenu menu)
    {
        SetEnergyBar(menu);
        PrintClock();
        BuyGreenhouse(textButton , menu);
        InventoeyBuuton(menu);
    }


}
