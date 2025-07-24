package com.Stradew.View.MainMenu.MechanicGame;

import com.Stradew.Controller.MainMenuController.MechanicController.NPC_Controller;
import com.Stradew.Model.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


public class NPCMenu implements Screen {
    Stage stage;
    NPC_Controller npcController;

    Label feedback;
    Label givenItem;
    Label reward;
    Label lockSituation;

    TextField giftName;

    TextButton giveGift;
    TextButton showQuests;
    TextButton backToNpcMenu;



    Table mainTable;
    Table questsList;

    public NPCMenu(NPC_Controller npcController, Npc npc) {
        this.npcController = npcController;
        npcController.setNpcMenu(this);

        feedback = new Label("", GameAssetsManager.getInstance().getSkin());


        giftName = new TextField("Gift Name", GameAssetsManager.getInstance().getSkin());

        giveGift = new TextButton("Send Gift", GameAssetsManager.getInstance().getSkin());
        showQuests = new TextButton("Show Quest", GameAssetsManager.getInstance().getSkin());
        backToNpcMenu = new TextButton("Back", GameAssetsManager.getInstance().getSkin());

        mainTable = new Table();
        questsList = new Table();

        mainTable.add(giftName);
        mainTable.add(giveGift).row();
        mainTable.add(showQuests).row();

        questsList.add(givenItem);
        questsList.add(reward);
        questsList.add(lockSituation);
        questsList.add(backToNpcMenu);

        int i = 0;
        for (Quest quest: npc.getQuests()){
            Image neededItem = new Image(quest.getGivenItems().getImage());
            questsList.add(neededItem);
            Reward reward1 = quest.getRewards();
            if (reward1.getCoins() != 0){
                Image coin = new Image(new Texture("Resource/Gold_Bar.png"));
                questsList.add(coin);
            } else if (reward1.getItem() != null) {
                Image item = new Image(reward1.getItem().getImage());
                questsList.add(item);
            } else if (reward1.getTool() != null) {
                Image tool = new Image(reward1.getItem().getImage());
                questsList.add(tool);
            }


            boolean isLocked = false;
            if (quest.isQuestCompleted()){
                Image lock = new Image(new Texture("Emoji/Emojis139.png"));
                questsList.add(lock);
                isLocked = true;
            } else if (quest.getQuestLocked()[App.getCurrentGame().getWhoseTurn()]) {
                Image lock = new Image(new Texture("Emoji/Emojis131.png"));
                questsList.add(lock);
                isLocked = true;
            } else if (quest.getQuestLockedForever()[App.getCurrentGame().getWhoseTurn()]) {
                Image lock = new Image(new Texture("Emoji/Emojis119.png"));
                questsList.add(lock);
            }

            if (!isLocked) {
                TextButton completeQuest = new TextButton("Do quest", GameAssetsManager.getInstance().getSkin());
                int finalI = i;
                completeQuest.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        finishQuest(npc.getId(), finalI);
                    }
                });
                i++;
                questsList.add(completeQuest);
            }
        }


        stage.addActor(mainTable);
        questsList.setVisible(false);
        stage.addActor(questsList);


        giveGift.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                giftNPC(npc.getName(), giftName.getText());
            }
        });

        showQuests.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                questsList.setVisible(true);
                mainTable.setVisible(false);
            }
        });

        backToNpcMenu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                questsList.setVisible(false);
                mainTable.setVisible(true);
            }
        });


    }

    public void meetNPC(String npcName){
        Npc npc = App.getCurrentGame().getNPCWithName(npcName);
        if (npc == null){
            System.out.println("there is no npc with this name.");
            return;
        }
        if (!App.npcController.isNpcCloseEnough(npc)){
            System.out.println("You are too far away!");
            return;
        }
        System.out.println("Npc said: ");
        System.out.println(App.npcController.meetNpc(npc));
    }

    public void giftNPC(String npcName, String itemName){
        Npc npc = App.getCurrentGame().getNPCWithName(npcName);
        if (npc == null){
            System.out.println("there is no npc with this name.");
            return;
        }
        if (!App.friendShipController.isItemAvailable(itemName)){
            System.out.println("as kiseye khalife nabakhsh");
            return;
        }
        App.npcController.giftNpc(npc, itemName);
        System.out.println("dast shoma mercy");
    }

    public void finishQuest(int questID, int npcId){
        Npc npc = App.getCurrentGame().getGameNPCs().get(npcId);
        if (npc == null){
            System.out.println("there is no npc with this name.");
            return;
        }
        Quest quest = npc.getQuests().get(questID);
        if (quest == null){
            System.out.println("quest not found.");
            return;
        }
        if (quest.getQuestLocked()[App.getCurrentGame().getPlayerIDByUsername(App.getCurrentUser().getUsername())]){
            System.out.println("quest is locked.");
            return;
        }
        System.out.println(App.npcController.finishQuest(npc, quest));
    }

    public void sayHello(){
        System.out.println("hello");
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
