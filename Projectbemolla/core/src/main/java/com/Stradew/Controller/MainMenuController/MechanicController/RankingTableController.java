package com.Stradew.Controller.MainMenuController.MechanicController;

import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.UserForRank;
import com.Stradew.View.MainMenu.GameMenu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class RankingTableController {

    private SelectBox<String> SortMode;
    private List<UserForRank> USers  = new ArrayList<>();
    private List<UserForRank> Ranking  = new ArrayList<>();
    private TextButton Back;

    public void FirstTouch(GameMenu gameMenu)
    {
        for(int i = 0;i < gameMenu.getCurrntLobby().getUsernames().size();i++)
        {
            UserForRank newUser = new UserForRank();
            newUser.setUSername(gameMenu.getCurrntLobby().getUsernames().get(i));
        }
        SortMode = new SelectBox<>(GameAssetsManager.getInstance().getSkin());
        SortMode.setItems("BY Coin" , "BY Quest" , "By Level");
        gameMenu.getRankingTable2().add(SortMode);
        Back = new TextButton("Back" , GameAssetsManager.getInstance().getSkin());
        gameMenu.getRankingTable2().add(Back);
    }


    public void Update(GameMenu gameMenu)
    {
        Ranking.clear();
        for(int i =0;i < gameMenu.getCurrntLobby().getUsernames().size();i++)
        {
            UserForRank newUser = new UserForRank();
            newUser.setUSername(gameMenu.getCurrntLobby().getUsernames().get(i));
            newUser.setCoin(gameMenu.getCurrntLobby().getCoins().get(i));
            newUser.setNumberOfQuests(gameMenu.getCurrntLobby().getNumOfQuests().get(i));
            newUser.setSumofLevels(gameMenu.getCurrntLobby().getSumLevelSkills().get(i));
            Ranking.add(newUser);
        }
        switch (SortMode.getSelected()){
            case "BY Coin" :
                Ranking.sort(Comparator.comparing(UserForRank::getCoin).reversed());
                break;
            case "By Quest" :
                Ranking.sort(Comparator.comparing(UserForRank::getNumberOfQuests).reversed());
                break;
            case "By Level" :
                Ranking.sort(Comparator.comparing(UserForRank::getSumofLevels).reversed());
                break;
        }

        gameMenu.getRankingTable().clearChildren();
        gameMenu.getRankingTable().add(new Label("Username           " , GameAssetsManager.getInstance().getSkin()));
        gameMenu.getRankingTable().add(new Label("Coins              " , GameAssetsManager.getInstance().getSkin()));
        gameMenu.getRankingTable().add(new Label("SumSkill           " , GameAssetsManager.getInstance().getSkin()));
        gameMenu.getRankingTable().add(new Label("NumQuest           " , GameAssetsManager.getInstance().getSkin()));
        gameMenu.getRankingTable().row();
        for (int i = 0; i < Ranking.size(); i++) {
            Color GOLD   = new Color(1f, 0.84f, 0f, 1f);
            Color SILVER = new Color(0.75f, 0.75f, 0.75f, 1f);
            Color BRONZE = new Color(0.8f, 0.5f, 0.2f, 1f);
            Color color = new Color(1f , 1f  , 1f , 1f);
            if(i == 0)
            {
                color = GOLD;
            }
            if(i == 1)
            {
                color = SILVER;
            }
            if(i == 2)
            {
                color = BRONZE;
            }
            UserForRank user = Ranking.get(i);
            gameMenu.getRankingTable().add(new Label(user.getUSername() , new Label.LabelStyle(new BitmapFont(), color))).pad(20);
            gameMenu.getRankingTable().add(new Label(String.valueOf(user.getCoin()) , new Label.LabelStyle(new BitmapFont() , color))).pad(20);
            gameMenu.getRankingTable().add(new Label(String.valueOf(user.getSumofLevels()) ,new Label.LabelStyle(new BitmapFont(), color))).pad(20);
            gameMenu.getRankingTable().add(new Label(String.valueOf(user.getNumberOfQuests()) , new Label.LabelStyle(new BitmapFont(), color))).pad(20);
            gameMenu.getRankingTable().row();
        }

        if(Back.isChecked())
        {
            gameMenu.getRankingTable2().setVisible(false);
            gameMenu.getRankingTable().setVisible(false);
            gameMenu.getMainTable().setVisible(true);
            Back.setChecked(false);
        }
    }


}
