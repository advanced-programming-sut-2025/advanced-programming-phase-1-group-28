package com.Stradew.View.MainMenu.MechanicGame;

import com.Stradew.Controller.MainMenuController.MechanicController.FriendShipController;
import com.Stradew.Model.App;
import com.Stradew.Model.Gift;
import com.Stradew.View.MainMenu.MechanicGame.Friendship;
import com.Stradew.View.MainMenu.ShowFigures;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;


public class NotificationDialog extends Dialog {

    private Friendship friendship;
    private ShowFigures showFigures;

    public NotificationDialog(Skin skin) {
        super("Notifications", skin);

        initializeUI(skin);

        button("Close");
        pad(25);
        // setSize(600, 400);
    }

    private void initializeUI(Skin skin) {
        Table contentTable = getContentTable();

        TextButton upcomingGiftsPanelButton = new TextButton("Upcoming Gifts", skin);
        TextButton historyPanelButton = new TextButton("History Panel", skin);
        Table navTable = new Table();
        navTable.add(upcomingGiftsPanelButton).pad(5);
        navTable.add(historyPanelButton).pad(5);

        Table upcomingGiftsTable = new Table();
        upcomingGiftsTable.top();

        Table historyTable = new Table();
        historyTable.top();
        historyTable.setVisible(false);

        Label giftFeedbackLabel = new Label("", skin);
        int giftId = 0;
        for (Gift gift : App.ReturnCurrentPlayer().getUpcomingGifts()) {
            Image image = new Image(gift.getItem().getImage());
            Label count = new Label(String.format("%d", gift.getCount()), skin);
            SelectBox<Integer> rateSelectBox = new SelectBox<>(skin);
            Array<Integer> numbers = new Array<>();
            for (int j = 1; j <= 5; j++) {
                numbers.add(j);
            }
            rateSelectBox.setItems(numbers);
            TextButton rateGiftButton = new TextButton("Rate Gift", skin);
            int finalGiftId = giftId;

            rateGiftButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    friendship = new Friendship(new FriendShipController(), App.ReturnCurrentPlayer());
                    giftFeedbackLabel.setText(friendship.rateGift(finalGiftId, rateSelectBox.getSelected()));
                }
            });

            upcomingGiftsTable.add(image).pad(5);
            upcomingGiftsTable.add(count).pad(5);
            upcomingGiftsTable.add(rateSelectBox).pad(5);
            upcomingGiftsTable.add(rateGiftButton).pad(5).row();
            giftId++;
        }
        upcomingGiftsTable.row();
        upcomingGiftsTable.add(giftFeedbackLabel).colspan(4).expandX().fillX().padTop(15);


        Label historyFeedbackLabel = new Label("", skin);
        TextField whichPlayerField = new TextField("Which Player", skin);
        SelectBox<String> giftOrTalkSelectBox = new SelectBox<>(skin);
        Array<String> options = new Array<>();
        options.add("Gifts");
        options.add("Talks");
        giftOrTalkSelectBox.setItems(options);
        TextButton showHistoryButton = new TextButton("Show History", skin);

        showHistoryButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showFigures = new ShowFigures();
                if (giftOrTalkSelectBox.getSelected().equals("Gifts")) {
                    historyFeedbackLabel.setText(showFigures.ShowGiftsFromDreamMan(whichPlayerField.getText()));
                } else {
                    historyFeedbackLabel.setText(showFigures.ShowTalkHistory(whichPlayerField.getText()));
                }
            }
        });

        historyTable.add(whichPlayerField).pad(5);
        historyTable.add(giftOrTalkSelectBox).pad(5);
        historyTable.add(showHistoryButton).pad(5).row();
        historyTable.row();
        historyTable.add(historyFeedbackLabel).colspan(3).expandX().fillX().padTop(15);


        upcomingGiftsPanelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                upcomingGiftsTable.setVisible(true);
                historyTable.setVisible(false);
            }
        });

        historyPanelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                upcomingGiftsTable.setVisible(false);
                historyTable.setVisible(true);
            }
        });

        Stack contentStack = new Stack();
        contentStack.add(upcomingGiftsTable);
        contentStack.add(historyTable);

        contentTable.add(navTable).row();
        contentTable.add(contentStack).expand().fill();
    }
}
