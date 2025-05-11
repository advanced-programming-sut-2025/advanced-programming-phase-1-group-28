package com.example.View.MainMenu.MechanicGame;

import com.example.Controller.MainMenuController.MechanicController.FriendShipController;
import com.example.Model.*;
import com.example.Model.Enums.Plants;
import com.example.Model.Item.Item;
import com.example.Model.Tools.Pepolee;

import java.util.ArrayList;

public class Friendship {
    FriendShipController friendShipController = App.friendShipController;
    public void Talk(String Username , String Message)
    {
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(Username);
        if (usernameID == -1){
            System.out.println("User not found");
            return;
        }
        Pepolee otherPlayer = App.getCurrentGame().getPlayerByID(usernameID);
        if (!friendShipController.arePlayersCloseEnough(App.ReturnCurrentPlayer(), otherPlayer)){
            System.out.println(Username + " is too far away!");
        }
        friendShipController.ApplyTalk(Username, Message);
        System.out.println(Username + " received your message successfully.");
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

    public void Gifting(String Username , String itemName , int Count)
    {
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(Username);
        if (usernameID == -1){
            System.out.println("User not found");
            return;
        }
        if (!friendShipController.haveEnoughFriendShipLevel(Username, 1)){
            System.out.println("This action requires a deeper connection.");
            return;
        }
        friendShipController.ApplyGifting(Username, itemName, Count);
        System.out.println(Username + " received your gift successfully.");
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
            System.out.println("User not found");
            return;
        }
        Pepolee otherPlayer = App.getCurrentGame().getPlayerByID(usernameID);
        if (!friendShipController.arePlayersCloseEnough(App.ReturnCurrentPlayer(), otherPlayer)){
            System.out.println(username + " is too far away!");
        }
        if (!friendShipController.haveEnoughFriendShipLevel(username, 2)){
            System.out.println("This action requires a deeper connection.");
            return;
        }
        friendShipController.ApplyHug(username);
        System.out.println("You hugged " + username + " successfully.");
    }
    public void Flowering(String username)
    {
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(username);
        if (usernameID == -1){
            System.out.println("User not found");
            return;
        }
        Pepolee otherPlayer = App.getCurrentGame().getPlayerByID(usernameID);
        if (!friendShipController.arePlayersCloseEnough(App.ReturnCurrentPlayer(), otherPlayer)){
            System.out.println(username + " is too far away!");
        }
        if (!friendShipController.haveEnoughFriendShipLevel(username, 2)){
            System.out.println("This action requires a deeper connection.");
            return;
        }if (!friendShipController.isItemAvailable(Plants.FAIRY_ROSE.toString())){
            System.out.println("Looks like this person only accepts the " + Plants.FAIRY_ROSE.toString() + "! You'll have to find that one!");
            return;
        }
        friendShipController.ApplyFlower(username);
        System.out.println(username + " received your flower successfully.");
    }

    public void marriageRequest(String username, String ringName){
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(username);
        if (usernameID == -1){
            System.out.println("User not found");
            return;
        }
        Pepolee otherPlayer = App.getCurrentGame().getPlayerByID(usernameID);
        if (!friendShipController.arePlayersCloseEnough(App.ReturnCurrentPlayer(), otherPlayer)){
            System.out.println(username + " is too far away!");
        }
        if (!friendShipController.haveEnoughFriendShipLevel(username, 3)){
            System.out.println("This action requires a deeper connection.");
            return;
        }
        if (App.getCurrentUser().getGender().equals(otherPlayer.getCharacterUser().getGender())){
            System.out.println("No lgbt!");
            return;
        }
        if (!friendShipController.isItemAvailable(ringName)){
            System.out.println("You can't give away what you don't have.");
            return;
        }
        friendShipController.sentMarriageRequest(username, ringName);
        System.out.println("your marriage request sent successfully.");
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
}