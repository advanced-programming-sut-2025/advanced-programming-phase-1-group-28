package com.Stradew.View.MainMenu.MechanicGame;

import com.Stradew.Controller.MainMenuController.MechanicController.FriendShipController;
import com.Stradew.Model.*;
import com.Stradew.Model.Enums.Plants;
import com.Stradew.Model.Item.Item;
import com.Stradew.Model.Tools.Pepolee;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;

public class Friendship implements Screen {
    FriendShipController friendShipController;
    Stage stage;
    Pepolee otherPlayer;

    Label feedback;

    TextField talkMessage;
    TextField ringName;

    TextButton talk;
    TextButton flower;
    TextButton hug;
    TextButton marriageRequest;



    public Friendship(FriendShipController friendShipController, Pepolee otherPlayer) {
        this.friendShipController = friendShipController;
        friendShipController.setFriendship(this);
        this.otherPlayer = otherPlayer;
        stage = new Stage();

        feedback = new Label("", GameAssetsManager.getInstance().getSkin());

        talkMessage = new TextField("Message", GameAssetsManager.getInstance().getSkin());
        ringName = new TextField("Ring Name", GameAssetsManager.getInstance().getSkin());

        talk = new TextButton("Talk", GameAssetsManager.getInstance().getSkin());
        hug = new TextButton("Hug", GameAssetsManager.getInstance().getSkin());
        flower = new TextButton("Give Flower", GameAssetsManager.getInstance().getSkin());
        marriageRequest = new TextButton("Send Marriage Request", GameAssetsManager.getInstance().getSkin());

        Table table = new Table();

        table.add(talkMessage);
        table.add(talk).row();

        table.add(ringName);
        table.add(marriageRequest);

        table.add(hug);
        table.add(flower);

        stage.addActor(table);


        talk.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Talk(otherPlayer.getCharacterUser().getUsername(), talkMessage.getText());
            }
        });

        marriageRequest.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                marriageRequest(otherPlayer.getCharacterUser().getUsername(), ringName.getText());
            }
        });

        hug.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Hug(otherPlayer.getCharacterUser().getUsername());
            }
        });

        flower.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Flowering(otherPlayer.getCharacterUser().getUsername());
            }
        });
    }

    public void Talk(String Username , String Message)
    {
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(Username);
        if (usernameID == -1){
            feedback.setText("User not found");
            return;
        }
        Pepolee otherPlayer = App.getCurrentGame().getPlayerByID(usernameID);
        if (!friendShipController.arePlayersCloseEnough(App.ReturnCurrentPlayer(), otherPlayer)){
            feedback.setText(Username + " is too far away!");
        }
        friendShipController.ApplyTalk(Username, Message);
        feedback.setText(Username + " received your message successfully.");
    }

    public void showTalkHistory(String username){
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(username);
        if (usernameID == -1){
            System.out.println("User not found");
            return;
        }
        Game game = App.getCurrentGame();
        User currentUser = App.getCurrentUser();
        FriendShip friendShip = game.getFriedShipBetweenPlayers(currentUser.getUsername(), username);
        ArrayList<String> talkHistory = friendShip.getTalkHistory();
        System.out.println("Your talk history with " + username);
        for (String talk: talkHistory){
            System.out.println(talk);
        }
    }

    public String Gifting(String Username , String itemName , int Count)
    {
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(Username);
        if (usernameID == -1){
            return ("User not found");
//            return;
        }
        if (!friendShipController.haveEnoughFriendShipLevel(Username, 1)){
            return ("This action requires a deeper connection.");
//            return;
        }
        friendShipController.ApplyGifting(Username, itemName, Count);
        return (Username + " received your gift successfully.");
    }

    public void rateGift(int giftID, int rate){
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        ArrayList<Gift> upcomingGifts = currentPlayer.getUpcomingGifts();
        Gift gift = upcomingGifts.get(giftID);
        if (gift == null){
            System.out.println("Item not found.");
            return;
        }
        if (gift.isMarriageRing()){
            System.out.println("You can't rate a marriage ring.");
        }
        friendShipController.ApplyRateGift(gift, rate);
    }

    public void Hug(String username)
    {
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(username);
        if (usernameID == -1){
            feedback.setText("User not found");
            return;
        }
        Pepolee otherPlayer = App.getCurrentGame().getPlayerByID(usernameID);
        if (!friendShipController.arePlayersCloseEnough(App.ReturnCurrentPlayer(), otherPlayer)){
            feedback.setText(username + " is too far away!");
        }
        if (!friendShipController.haveEnoughFriendShipLevel(username, 2)){
            feedback.setText("This action requires a deeper connection.");
            return;
        }
        friendShipController.ApplyHug(username);
        feedback.setText("You hugged " + username + " successfully.");
    }
    public void Flowering(String username)
    {
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(username);
        if (usernameID == -1){
            feedback.setText("User not found");
            return;
        }
        Pepolee otherPlayer = App.getCurrentGame().getPlayerByID(usernameID);
        if (!friendShipController.arePlayersCloseEnough(App.ReturnCurrentPlayer(), otherPlayer)){
            feedback.setText(username + " is too far away!");
        }
        if (!friendShipController.haveEnoughFriendShipLevel(username, 2)){
            feedback.setText("This action requires a deeper connection.");
            return;
        }if (!friendShipController.isItemAvailable(Plants.FAIRY_ROSE.toString())){
            feedback.setText("Looks like this person only accepts the " + Plants.FAIRY_ROSE.toString() + "! You'll have to find that one!");
            return;
        }
        friendShipController.ApplyFlower(username);
        feedback.setText(username + " received your flower successfully.");
    }

    public void marriageRequest(String username, String ringName){
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(username);
        if (usernameID == -1){
            feedback.setText("User not found");
            return;
        }
        Pepolee otherPlayer = App.getCurrentGame().getPlayerByID(usernameID);
        if (!friendShipController.arePlayersCloseEnough(App.ReturnCurrentPlayer(), otherPlayer)){
            feedback.setText(username + " is too far away!");
        }
        if (!friendShipController.haveEnoughFriendShipLevel(username, 3)){
            feedback.setText("This action requires a deeper connection.");
            return;
        }
        if (App.getCurrentUser().getGender().equals(otherPlayer.getCharacterUser().getGender())){
            feedback.setText("No lgbt!");
            return;
        }
        if (!friendShipController.isItemAvailable(ringName)){
            feedback.setText("You can't give away what you don't have.");
            return;
        }
        friendShipController.sentMarriageRequest(username, ringName);
        feedback.setText("your marriage request sent successfully.");
    }

    public void responseMarriageRequest(String accept, String username){
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(username);
        if (usernameID == -1){
            System.out.println("User not found");
            return;
        }
        if (!friendShipController.isThereAnyMarriageRequest(username)){
            System.out.println("akhe ki mikhad toro begire???");
            return;
        }
        if (accept.equals("-accept")){
            friendShipController.ApplyMarriage(username);
            System.out.println("Single status: GONE! You are now married to " + username + "!");
        } else if (accept.equals("-reject")) {
            friendShipController.rejectMarriage(username);
            System.out.println("A wolf is always alone.");
        }
    }

    public void tradeRequest(String username, String type, String offerItemName,
                             int offerAmount, int price, String targetItemName, int targetAmount){
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(username);
        if (usernameID == -1){
            System.out.println("User not found");
            return;
        }
        if (offerAmount <= 0){
            System.out.println("Amount must be positive.");
            return;
        }
        if (friendShipController.isItemAvailable(offerItemName)){
            System.out.println("You can't trade what you don't have!");
            return;
        }
        Item offerItem = App.ReturnCurrentPlayer().getInventory().getItemByName(offerItemName);
        if (offerItem.getCount() < offerAmount){
            System.out.println("You don't have enough " + offerItemName);
            return;
        }
        if (!type.equals("offer") && !type.equals("request")){
            System.out.println("Trade type must be offer or request.");
            return;
        }
        if (type.equals("offer") && price > App.ReturnCurrentPlayer().getCoin()){
            System.out.println("You don't have enough money.");
            return;
        }
        friendShipController.tradeRequest(username,type,offerItemName,offerAmount, price, targetItemName, targetAmount);
        System.out.println("Your trade request sent successfully.");
    }

    public void tradeResponse(boolean accept, int id){
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        if (currentPlayer.getUpcomingTrade().get(id) == null){
            System.out.println("Trade not found!");
        }
        Trade trade = currentPlayer.getUpcomingTrade().get(id);
        trade.setAccept(accept);
        if (accept){
            if (trade.getType().equals("request")){
                if (!friendShipController.isItemAvailable(trade.getTargetItemName())){
                    System.out.println("You don't have target item.");
                    return;
                }
                if (currentPlayer.getInventory().getItemByName(trade.getTargetItemName()).getCount() < trade.getTargetAmount()){
                    System.out.println("You don't have enough items.");
                    return;
                }
            } else if (trade.getType().equals("offer")) {
                if (currentPlayer.getCoin() < trade.getPrice()){
                    System.out.println("You don't have enough money.");
                    return;
                }
            }
            friendShipController.acceptTrade(trade);
            friendShipController.removeTrade(id);
            System.out.println("Trade completed!");
        }else {
            friendShipController.removeTrade(id);
            friendShipController.rejectTrade(trade);
            System.out.println("You rejected the trade successfully.");
        }
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
