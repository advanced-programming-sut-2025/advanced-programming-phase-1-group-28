package com.example.Controller.MainMenuController.MechanicController;

import com.example.Model.*;
import com.example.Model.Item.Item;
import com.example.Model.Tools.Pepolee;

public class NPC_Controller {
    private void ApplySebastianQuest(int QuestNumber)
    {
        if(QuestNumber == 1)
        {

        }
        else if(QuestNumber == 2)
        {
            if(App.getCurrentGame().getFriendShips()[4][App.getCurrentGame().getWhoseTurn()].getLevel() == 0)
            {
                System.out.println("Not in Seb's yet");
                return;
            }

        }
        else if(QuestNumber == 3)
        {

        }
        else
        {
            System.out.println("Invalid quest number");
        }
    }

    public boolean isNpcCloseEnough(Npc npc){
        return true;
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
        if (npc.isFavoriteItem(giftName)){
            friendShip.addXp(200);
            otherFriendShip.addXp(200);
        }else {
            friendShip.addXp(50);
            otherFriendShip.addXp(50);
        }
        Pepolee pepolee = App.ReturnCurrentPlayer();
        Item item = pepolee.getInventory().getItemByName(giftName);
        item.addCount(-1);
        if (item.getCount() == 0){
            pepolee.getInventory().removeItem(item);
        }
    }
}
