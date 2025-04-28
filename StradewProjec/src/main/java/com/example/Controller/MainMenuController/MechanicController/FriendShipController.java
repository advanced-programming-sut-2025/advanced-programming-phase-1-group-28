package com.example.Controller.MainMenuController.MechanicController;

import com.example.Model.*;
import com.example.Model.Item.Item;
import com.example.Model.Tools.Pepolee;

public class FriendShipController {
    public boolean arePlayersCloseEnough(Pepolee playerOne, Pepolee playerTwo){
        if (Math.abs(playerOne.getX() - playerTwo.getX()) > 2){
            return false;
        }if (Math.abs(playerOne.getY() - playerTwo.getY()) > 2){
            return false;
        }
        return true;
    }

    public boolean haveEnoughFriendShipLevel(String username, int level){
        Game game = App.getCurrentGame();
        User currentUser = App.getCurrentUser();
        FriendShip firstFriendShip = game.getFriedShipBetweenPlayers(currentUser.getUsername(), username);
        FriendShip secondFriendShip = game.getFriedShipBetweenPlayers(username, currentUser.getUsername());
        if (firstFriendShip.getLevel() >= level && secondFriendShip.getLevel() >= level){
            return true;
        }else {
            return false;
        }
    }

    public boolean isGiftAvailable(String giftName){
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        if (currentPlayer.getInventory().getItemByName(giftName) == null){
            return false;
        }
        return true;
    }

    public void ApplyTalk(String Username , String Message)
    {
        Game game = App.getCurrentGame();
        User currentUser = App.getCurrentUser();
        FriendShip firstFriendShip = game.getFriedShipBetweenPlayers(currentUser.getUsername(), Username);
        FriendShip secondFriendShip = game.getFriedShipBetweenPlayers(Username, currentUser.getUsername());
        firstFriendShip.applyTalk(Message);
        secondFriendShip.applyTalk(Message);
    }
    public void ApplyExchange(String UsernameSeller , String UsernameBuyer , Item item)
    {

    }
    public void ApplyGifting(String Username, String itemName , int Count)
    {
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        Pepolee receiverPlayer = App.getCurrentGame().getPlayerByUsername(Username);
        Item item = currentPlayer.getInventory().getItemByName(itemName);
        Gift gift = new Gift(Count, currentPlayer, item);
        Game game = App.getCurrentGame();
        User currentUser = App.getCurrentUser();
        FriendShip firstFriendShip = game.getFriedShipBetweenPlayers(currentUser.getUsername(), Username);
        FriendShip secondFriendShip = game.getFriedShipBetweenPlayers(Username, currentUser.getUsername());
        firstFriendShip.addGift(gift);
        secondFriendShip.addGift(gift);
        receiverPlayer.addGift(gift);
        // remove item from inventory
    }

    public void ApplyRateGift(Gift gift, int rate){
        Pepolee sender = gift.getSender();
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        Game game = App.getCurrentGame();
        User currentUser = App.getCurrentUser();
        User senderUser = sender.getCharacterUser();
        FriendShip firstFriendShip = game.getFriedShipBetweenPlayers(currentUser.getUsername(), senderUser.getUsername());
        FriendShip secondFriendShip = game.getFriedShipBetweenPlayers(senderUser.getUsername(), currentUser.getUsername());
        firstFriendShip.rateGift(rate);
        secondFriendShip.rateGift(rate);
        currentPlayer.removeUpcomingGift(gift);
    }

    public void ApplyHug(String username)
    {
        Game game = App.getCurrentGame();
        User currentUser = App.getCurrentUser();
        FriendShip firstFriendShip = game.getFriedShipBetweenPlayers(currentUser.getUsername(), username);
        FriendShip secondFriendShip = game.getFriedShipBetweenPlayers(username, currentUser.getUsername());
        firstFriendShip.applyHug();
        secondFriendShip.applyHug();
    }
    public void ApplyFlower(String username)
    {
        Game game = App.getCurrentGame();
        User currentUser = App.getCurrentUser();
        FriendShip firstFriendShip = game.getFriedShipBetweenPlayers(currentUser.getUsername(), username);
        FriendShip secondFriendShip = game.getFriedShipBetweenPlayers(username, currentUser.getUsername());
        firstFriendShip.applyFlower();
        secondFriendShip.applyFlower();
    }

    public void sentMarriageRequest(String username, String ringName){
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        Pepolee receiverPlayer = App.getCurrentGame().getPlayerByUsername(username);
        Item ring = currentPlayer.getInventory().getItemByName(ringName);
        Gift gift = new Gift(1, currentPlayer, ring);
        gift.setMarriageRing(true);
        Game game = App.getCurrentGame();
        User currentUser = App.getCurrentUser();
        FriendShip firstFriendShip = game.getFriedShipBetweenPlayers(currentUser.getUsername(), username);
        FriendShip secondFriendShip = game.getFriedShipBetweenPlayers(username, currentUser.getUsername());
        firstFriendShip.addGift(gift);
        secondFriendShip.addGift(gift);
        receiverPlayer.addGift(gift);
        // remove ring from inventory
    }

    public void ApplyMarriage(String username){
        Game game = App.getCurrentGame();
        User currentUser = App.getCurrentUser();
        FriendShip firstFriendShip = game.getFriedShipBetweenPlayers(currentUser.getUsername(), username);
        FriendShip secondFriendShip = game.getFriedShipBetweenPlayers(username, currentUser.getUsername());
        firstFriendShip.applyMarriage();
        secondFriendShip.applyMarriage();
        // marriage main effects
    }
}
