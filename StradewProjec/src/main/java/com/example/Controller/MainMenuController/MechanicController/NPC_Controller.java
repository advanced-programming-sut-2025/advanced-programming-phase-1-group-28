package com.example.Controller.MainMenuController.MechanicController;

import com.example.Model.*;
import com.example.Model.Item.Food;
import com.example.Model.Item.Item;
import com.example.Model.Item.PlantsItem;
import com.example.Model.Tools.Pepolee;

public class NPC_Controller {

    public boolean isNpcCloseEnough(Npc npc){
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        if (Math.abs(currentPlayer.getX() - npc.getX_position()) <= 1 &&
                Math.abs(currentPlayer.getY() - npc.getY_position()) <= 1){
            return true;
        }
        return false;
    }

    public String meetNpc(Npc npc){
        Game currentGame = App.getCurrentGame();
        User currentUser = App.getCurrentUser();
        FriendShip friendShip = currentGame.getFriendShips()[currentGame.getPlayerIDByUsername(currentUser.getUsername())][npc.getId()];
        FriendShip otherFriendShip = currentGame.getFriendShips()[npc.getId()][currentGame.getPlayerIDByUsername(currentUser.getUsername())];
        friendShip.meetNpc();
        otherFriendShip.meetNpc();

        return npc.getDialog();
    }

    public void giftNpc(Npc npc, String giftName){
        Game currentGame = App.getCurrentGame();
        User currentUser = App.getCurrentUser();
        FriendShip friendShip = currentGame.getFriendShips()[currentGame.getPlayerIDByUsername(currentUser.getUsername())][npc.getId()];
        FriendShip otherFriendShip = currentGame.getFriendShips()[npc.getId()][currentGame.getPlayerIDByUsername(currentUser.getUsername())];


        Pepolee pepolee = App.ReturnCurrentPlayer();
        Item item = pepolee.getInventory().getItemByName(giftName);
        item.addCount(-1);
        if (item.getCount() == 0){
            pepolee.getInventory().removeItem(item);
        }

        if (npc.isFavoriteItem(item)){
            friendShip.addXp(200);
            otherFriendShip.addXp(200);
            if (friendShip.getLevel() == 1){
                npc.getQuests().get(1).getQuestLocked()[currentGame.getPlayerIDByUsername(currentUser.getUsername())] = false;
            }
        }else {
            friendShip.addXp(50);
            otherFriendShip.addXp(50);
            if (friendShip.getLevel() == 1){
                npc.getQuests().get(1).getQuestLocked()[currentGame.getPlayerIDByUsername(currentUser.getUsername())] = false;
            }
        }
    }

    public String finishQuest(Npc npc, Quest quest){
        Game currentGame = App.getCurrentGame();
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        User currentUser = App.getCurrentUser();
        Item neededItem = quest.getGivenItems();

        //remove needed item
        if (neededItem.getName().equals("plant")){
            boolean enoughItems = false;
            for(Item item : currentPlayer.getInventory().getItems())
            {
                if(item instanceof PlantsItem && item.getCount() >=  neededItem.getCount())
                {
                    enoughItems = true;
                    item.addCount(-neededItem.getCount());
                }
            }
            if(!enoughItems)
            {
                return "You don't have enough plants to finish quest";
            }
        } else if (neededItem.getName().equals("wine")) {
            boolean enoughItems = false;
            for(Item item : currentPlayer.getInventory().getItems())
            {
                if(item instanceof Food && item.getName().toLowerCase().contains("wine") && item.getCount() >=  neededItem.getCount())
                {
                    enoughItems = true;
                    item.addCount(-neededItem.getCount());
                }
            }
            if(!enoughItems)
            {
                return "You don't have enough wine to finish quest";
            }
        }else {
            Item playerItem = currentPlayer.getInventory().getItemByName(neededItem.getName());
            if (playerItem == null){
                return "you don't have enough items!";
            }
            if (playerItem.getCount() < neededItem.getCount()){
                return "you don't have enough items";
            }
            playerItem.addCount(-neededItem.getCount());
        }

        //get rewards
        Item rewardItem = quest.getRewards().getItem();
        currentPlayer.getInventory().addOrIncreaseCount(rewardItem, rewardItem.getCount());
        int gold = quest.getRewards().getCoins();
        currentPlayer.addCoin(gold);
        int friendshipReward = quest.getRewards().getFriendShip();
        FriendShip friendShip = currentGame.getFriendShips()[npc.getId()][currentGame.getPlayerIDByUsername(currentUser.getUsername())];
        FriendShip otherFriendship = currentGame.getFriendShips()[currentGame.getPlayerIDByUsername(currentUser.getUsername())][npc.getId()];
        friendShip.setLevel(friendShip.getLevel() + friendshipReward);
        otherFriendship.setLevel(otherFriendship.getLevel() + friendshipReward);


        return "you get your rewards successfully";
    }
}