package com.Stradew.View.MainMenu.MechanicGame;

import com.Stradew.Controller.MainMenuController.MechanicController.FriendShipController;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.Plants;
import com.Stradew.Model.Tools.Pepolee;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class FriendshipDialog extends Dialog {

    private final FriendShipController friendShipController;
    private final Pepolee otherPlayer;
    private final Label feedbackLabel;

    public FriendshipDialog(Pepolee otherPlayer, FriendShipController friendShipController, Skin skin) {
        super("Interact with " + otherPlayer.getCharacterUser().getUsername(), skin);
        this.otherPlayer = otherPlayer;
        this.friendShipController = friendShipController;

        setModal(true);
        setMovable(true);

        Table contentTable = new Table(skin);
        contentTable.defaults().pad(5);

        TextField talkMessage = new TextField("", skin);
        talkMessage.setMessageText("Your message...");
        TextButton talkButton = new TextButton("Talk", skin);

        TextField ringName = new TextField("", skin);
        ringName.setMessageText("Ring Name");
        TextButton marriageButton = new TextButton("Propose", skin);

        TextButton hugButton = new TextButton("Hug", skin);
        TextButton flowerButton = new TextButton("Give Flower", skin);

        feedbackLabel = new Label("", skin);
        feedbackLabel.setWrap(true);

        contentTable.add(talkMessage).width(200).fillX();
        contentTable.add(talkButton).width(100).row();
        contentTable.add(ringName).width(200).fillX();
        contentTable.add(marriageButton).width(100).row();

        Table actionTable = new Table();
        actionTable.add(hugButton).width(150).pad(5);
        actionTable.add(flowerButton).width(150).pad(5);
        contentTable.add(actionTable).colspan(2).row();

        contentTable.add(feedbackLabel).colspan(2).width(350).padTop(10);

        getContentTable().add(contentTable);
        button("Close");

        talkButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                talk(talkMessage.getText());
            }
        });

        marriageButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                proposeMarriage(ringName.getText());
            }
        });

        hugButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hug();
            }
        });

        flowerButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                giveFlower();
            }
        });
    }

    private void talk(String message) {
        if (!friendShipController.arePlayersCloseEnough(App.ReturnCurrentPlayer(), otherPlayer)) {
            feedbackLabel.setText(otherPlayer.getCharacterUser().getUsername() + " is too far away!");
            return;
        }
        friendShipController.ApplyTalk(otherPlayer.getCharacterUser().getUsername(), message);
        feedbackLabel.setText("Message sent to " + otherPlayer.getCharacterUser().getUsername());
    }

    private void hug() {
        if (!friendShipController.arePlayersCloseEnough(App.ReturnCurrentPlayer(), otherPlayer)) {
            feedbackLabel.setText(otherPlayer.getCharacterUser().getUsername() + " is too far away!");
            return;
        }
        if (!friendShipController.haveEnoughFriendShipLevel(otherPlayer.getCharacterUser().getUsername(), 2)) {
            feedbackLabel.setText("This action requires a deeper connection (Friendship Level 2).");
            return;
        }
        friendShipController.ApplyHug(otherPlayer.getCharacterUser().getUsername());
        feedbackLabel.setText("You hugged " + otherPlayer.getCharacterUser().getUsername() + ".");
    }

    private void giveFlower() {
        if (!friendShipController.arePlayersCloseEnough(App.ReturnCurrentPlayer(), otherPlayer)) {
            feedbackLabel.setText(otherPlayer.getCharacterUser().getUsername() + " is too far away!");
            return;
        }
        if (!friendShipController.haveEnoughFriendShipLevel(otherPlayer.getCharacterUser().getUsername(), 2)) {
            feedbackLabel.setText("This action requires a deeper connection (Friendship Level 2).");
            return;
        }
        if (!friendShipController.isItemAvailable(Plants.FAIRY_ROSE.toString())) {
            feedbackLabel.setText("You need a " + Plants.FAIRY_ROSE + " to give!");
            return;
        }
        friendShipController.ApplyFlower(otherPlayer.getCharacterUser().getUsername());
        feedbackLabel.setText(otherPlayer.getCharacterUser().getUsername() + " received your flower.");
    }

    private void proposeMarriage(String ringName) {
        if (!friendShipController.arePlayersCloseEnough(App.ReturnCurrentPlayer(), otherPlayer)) {
            feedbackLabel.setText(otherPlayer.getCharacterUser().getUsername() + " is too far away!");
            return;
        }
        if (!friendShipController.haveEnoughFriendShipLevel(otherPlayer.getCharacterUser().getUsername(), 3)) {
            feedbackLabel.setText("This action requires a much deeper connection (Friendship Level 3).");
            return;
        }
        if (App.getCurrentUser().getGender().equals(otherPlayer.getCharacterUser().getGender())) {
            feedbackLabel.setText("Marriage is only possible between different genders in this world.");
            return;
        }
        if (!friendShipController.isItemAvailable(ringName)) {
            feedbackLabel.setText("You don't have a ring named '" + ringName + "'.");
            return;
        }
        friendShipController.sentMarriageRequest(otherPlayer.getCharacterUser().getUsername(), ringName);
        feedbackLabel.setText("Your marriage proposal has been sent!");
    }
}
