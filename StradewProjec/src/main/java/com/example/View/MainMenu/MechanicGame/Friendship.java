package com.example.View.MainMenu.MechanicGame;

import com.example.Controller.MainMenuController.MechanicController.FriendShipController;
import com.example.Model.*;
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

    public void Exchange(Item item , String UsernameSeller , String UsernameBuyer)
    {

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
        }
        friendShipController.ApplyFlower(username);
        System.out.println(username + " received your flower successfully.");
    }

    public void marriage(String username, String ringName){
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
        if (!friendShipController.isGiftAvailable(ringName)){
            System.out.println("You can't give away what you don't have.");
            return;
        }
        friendShipController.sentMarriageRequest(username, ringName);
        System.out.println("your marriage request sent successfully.");
    }
}