package com.Stradew.Controller.MainMenuController.MechanicController;

import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.Npc;
import com.Stradew.Model.Tools.Pepolee;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class SocialPannelController {
    Texture oneHeart = new Texture("Heart/One_Hearts.png");
    Texture threeHeart = new Texture("Heart/Three_Hearts.png");
    Texture fiveHeart = new Texture("Heart/Five_Hearts.png");
    Texture sevenHeart = new Texture("Heart/Seven_Hearts.png");
    Texture nineHeart = new Texture("Heart/Nine_Hearts.png");
    public void rebuild(Table socialTable){
        socialTable.clear();
        Skin skin = GameAssetsManager.getInstance().getSkin();

        Label otherPepolee = new Label("Pepolees", skin);
        Label npc = new Label("npcs", skin);

        socialTable.add(otherPepolee).row();
        int i = 0;
        int playerID = App.ReturnUserIndex(App.getCurrentUser().getUsername());
        for (Pepolee pepolee: App.getCurrentGame().getCharactersInGame()){
            Image profile = new Image(pepolee.getPlayerTexture());
            Label nickname = new Label(pepolee.getCharacterUser().getNickname(), skin);
            socialTable.add(profile);
            socialTable.add(nickname);
            Image love = new Image(oneHeart);
            int friendshipLevel = App.getCurrentGame().getFriendShips()[playerID][i].getLevel();
            switch (friendshipLevel){
                case 0:
                    love = new Image(oneHeart);
                    break;
                case 1:
                    love = new Image(threeHeart);
                    break;
                case 2:
                    love = new Image(fiveHeart);
                    break;
                case 3:
                    love = new Image(sevenHeart);
                    break;
                case 4:
                    love = new Image(nineHeart);
                    break;
            }
            socialTable.add(love).row();
            i++;
        }

        socialTable.add(npc).row();
        i=4;
        for (Npc npc1 : App.getCurrentGame().getGameNPCs()){
            Image profile = new Image(npc1.getNpcTexture());
            Label nickname = new Label(npc1.getName(), skin);
            socialTable.add(profile);
            socialTable.add(nickname);
            Image love = new Image(oneHeart);
            int friendshipLevel = App.getCurrentGame().getFriendShips()[playerID][i].getLevel();
            switch (friendshipLevel){
                case 0:
                    love = new Image(oneHeart);
                    break;
                case 1:
                    love = new Image(threeHeart);
                    break;
                case 2:
                    love = new Image(fiveHeart);
                    break;
                case 3:
                    love = new Image(sevenHeart);
                    break;
                case 4:
                    love = new Image(nineHeart);
                    break;
            }
            socialTable.add(love).row();
            i++;
        }
    }

    public void update(){

    }
}
