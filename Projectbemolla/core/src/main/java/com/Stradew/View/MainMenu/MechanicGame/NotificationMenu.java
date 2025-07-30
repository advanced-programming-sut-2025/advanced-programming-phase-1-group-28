package com.Stradew.View.MainMenu.MechanicGame;

import com.Stradew.Controller.MainMenuController.MechanicController.FriendShipController;
import com.Stradew.Controller.MainMenuController.MechanicController.NotificationController;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.Gift;
import com.Stradew.View.MainMenu.ShowFigures;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class NotificationMenu implements Screen {
    Stage stage;
    NotificationController notificationController;
    Skin skin;
    Friendship friendship;
    ShowFigures showFigures;

    Label feedback;

    Table history;

    Table upcomingGifts;

    public NotificationMenu(NotificationController notificationController) {
        this.notificationController = notificationController;
        stage = new Stage();
        skin = GameAssetsManager.getInstance().getSkin();

        Table mainTable = new Table();
        mainTable.setFillParent(true);
        stage.addActor(mainTable);

        TextButton upcomingGiftsPanel = new TextButton("Upcoming Gifts", skin);
        TextButton historyPanel = new TextButton("History Panel", skin);

        Table navTable = new Table();
        navTable.add(upcomingGiftsPanel).pad(5);
        navTable.add(historyPanel).pad(5);
        mainTable.add(navTable).top().row();

        upcomingGifts = new Table();
        upcomingGifts.top();

        history = new Table();
        history.top();
        history.setVisible(false);

        Label giftFeedback = new Label("", skin); // <<<<<<< لیبل فیدبک مخصوص این پنل
        int giftId = 0;
        for (Gift gift : App.ReturnCurrentPlayer().getUpcomingGifts()) {
            Image image = new Image(gift.getItem().getImage());
            Label count = new Label(String.format("%d", gift.getCount()), skin);
            SelectBox<Integer> rate = new SelectBox<>(skin);
            Array<Integer> numbers = new Array<>();
            for (int j = 1; j <= 5; j++) {
                numbers.add(j);
            }
            rate.setItems(numbers);
            TextButton rateGift = new TextButton("Rate Gift", skin);
            int finalGiftId = giftId;
            rateGift.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    friendship = new Friendship(new FriendShipController(), App.ReturnCurrentPlayer());
                    giftFeedback.setText(friendship.rateGift(finalGiftId, rate.getSelected()));
                }
            });
            upcomingGifts.add(image);
            upcomingGifts.add(count);
            upcomingGifts.add(rate);
            upcomingGifts.add(rateGift).row();
            giftId++;
        }
        upcomingGifts.row();
        upcomingGifts.add(giftFeedback).colspan(4).padTop(10);


        Label historyFeedback = new Label("", skin); // <<<<<<< لیبل فیدبک مخصوص این پنل
        TextField whichPlayer = new TextField("Which Player", skin);
        SelectBox<String> giftOrTalk = new SelectBox<>(skin);
        Array<String> options = new Array<>();
        options.add("Gifts");
        options.add("Talks");
        giftOrTalk.setItems(options);

        TextButton showHistory = new TextButton("Show History", skin);
        showHistory.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showFigures = new ShowFigures();
                if (giftOrTalk.getSelected().equals("Gifts")) {
                    historyFeedback.setText(showFigures.ShowGiftsFromDreamMan(whichPlayer.getText()));
                } else {
                    historyFeedback.setText(showFigures.ShowTalkHistory(whichPlayer.getText()));
                }
            }
        });
        history.add(whichPlayer);
        history.add(giftOrTalk);
        history.add(showHistory).row();
        history.row();
        history.add(historyFeedback).colspan(3).padTop(10);


        Stack contentStack = new Stack();
        contentStack.add(upcomingGifts);
        contentStack.add(history);
        mainTable.add(contentStack).expand().fill();


        upcomingGiftsPanel.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                upcomingGifts.setVisible(true);
                history.setVisible(false);
            }
        });

        historyPanel.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                upcomingGifts.setVisible(false);
                history.setVisible(true);
            }
        });
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
