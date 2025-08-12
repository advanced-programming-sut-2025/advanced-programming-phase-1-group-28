package com.Stradew.View.MainMenu.MechanicGame;

import com.Stradew.Controller.MainMenuController.MechanicController.NPC_Controller;
import com.Stradew.Model.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class NpcDialog extends Dialog {

    private final NPC_Controller npcController;
    private final Npc npc;

    private final Table mainView;
    private final Table questsView;
    private final Table container;


    public NpcDialog(Npc npc, NPC_Controller npcController, Skin skin) {
        super(npc.getName(), skin);
        this.npc = npc;
        this.npcController = npcController;
        setModal(true);
        setMovable(true);

        mainView = buildMainView(skin);
        questsView = buildQuestsView(skin);

        container = new Table();
        container.add(mainView);

        getContentTable().add(container).pad(20);

        button("Close", true);
    }

    private Table buildMainView(Skin skin) {
        Table table = new Table();

        Label giftLabel = new Label("Give a gift:", skin);
        TextField giftName = new TextField("", skin, "default");
        giftName.setMessageText("Item Name");

        TextButton giveGiftButton = new TextButton("Send Gift", skin);
        TextButton showQuestsButton = new TextButton("Show Quests", skin);

        table.add(giftLabel).colspan(2).padBottom(10).row();
        table.add(giftName).width(200).padRight(10);
        table.add(giveGiftButton);
        table.row();
        table.add(showQuestsButton).colspan(2).padTop(20).width(250);

        giveGiftButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                giftNPC(npc, giftName.getText());
            }
        });

        showQuestsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                container.clear();
                container.add(questsView);
            }
        });

        return table;
    }

    private Table buildQuestsView(Skin skin) {
        Table table = new Table();
        table.defaults().pad(5);

        Table questsList = new Table();
        ScrollPane scrollPane = new ScrollPane(questsList, skin);
        scrollPane.setFadeScrollBars(false);
        scrollPane.setScrollingDisabled(true, false);

        if (npc != null && npc.getQuests() != null) {
            int questIndex = 0;
            for (Quest quest : npc.getQuests()) {
                questsList.add(new Label("Need:", skin));
                questsList.add(new Image(new Texture("Crops/Ancient_Fruit_Stage_1.png"))).size(48, 48);

                questsList.add(new Label("Reward:", skin)).padLeft(20);
                Reward reward = quest.getRewards();
                if (reward.getCoins() != 0) {
                    questsList.add(new Image(new Texture("Resource/Gold_Bar.png"))).size(48, 48);
                } else if (reward.getItem() != null) {
                    questsList.add(new Image(new Texture("Crops/Magma_Cap.png"))).size(48, 48);
                } else if (reward.getTool() != null) {
                    questsList.add(new Image(reward.getTool().getImage())).size(48, 48);
                } else {
                    questsList.add(new Label("N/A", skin));
                }

                boolean isLocked = false;
                int playerIndex = App.getCurrentGame().getWhoseTurn();

                if (quest.isQuestCompleted()) {
                    questsList.add(new Image(new Texture("Emoji/Emojis139.png"))).size(48, 48).padLeft(20);
                } else if (quest.getQuestLocked()[playerIndex]) {
                    questsList.add(new Image(new Texture("Emoji/Emojis131.png"))).size(48, 48).padLeft(20);
                } else if (quest.getQuestLockedForever()[playerIndex]) {
                    questsList.add(new Image(new Texture("Emoji/Emojis119.png"))).size(48, 48).padLeft(20);
                } else {
                    TextButton completeQuestButton = new TextButton("Do Quest", skin);
                    final int finalQuestIndex = questIndex;
                    completeQuestButton.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            finishQuest(npc, finalQuestIndex);
                            hide();
                        }
                    });
                    questsList.add(completeQuestButton).padLeft(20);
                }

                questsList.row();
                questIndex++;
            }
        }

        table.add(scrollPane).height(200).width(450).colspan(2).row();

        TextButton backButton = new TextButton("Back", skin);
        table.add(backButton).padTop(10);

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                container.clear();
                container.add(mainView);
            }
        });

        return table;
    }


    private void giftNPC(Npc npc, String itemName) {
        if (itemName == null || itemName.trim().isEmpty()) {
            System.out.println("Please enter an item name.");
            return;
        }
        if (!App.friendShipController.isItemAvailable(itemName)) {
            System.out.println("You don't have this item!");
            return;
        }
        App.npcController.giftNpc(npc, itemName);
        System.out.println("Gift sent successfully!");
    }

    private void finishQuest(Npc npc, int questIndex) {
        Quest quest = npc.getQuests().get(questIndex);
        if (quest == null) {
            System.out.println("Quest not found.");
            return;
        }
        int playerIndex = App.getCurrentGame().getPlayerIDByUsername(App.getCurrentUser().getUsername());
        if (quest.getQuestLocked()[playerIndex]) {
            System.out.println("Quest is locked.");
            return;
        }
        System.out.println(App.npcController.finishQuest(npc, quest));
    }
}
