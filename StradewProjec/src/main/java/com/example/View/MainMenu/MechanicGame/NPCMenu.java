package com.example.View.MainMenu.MechanicGame;

import com.example.Model.App;
import com.example.Model.Npc;
import com.example.Model.Quest;

public class NPCMenu {
    public void meetNPC(String npcName){
        Npc npc = App.getCurrentGame().getNPCWithName(npcName);
        if (npc == null){
            System.out.println("there is no npc with this name.");
            return;
        }
        if (!App.npcController.isNpcCloseEnough(npc)){
            System.out.println("You are too far away!");
            return;
        }
        System.out.println("Npc said: ");
        System.out.println(App.npcController.meetNpc(npc));
    }

    public void giftNPC(String npcName, String itemName){
        Npc npc = App.getCurrentGame().getNPCWithName(npcName);
        if (npc == null){
            System.out.println("there is no npc with this name.");
            return;
        }
        if (!App.friendShipController.isItemAvailable(itemName)){
            System.out.println("as kiseye khalife nabakhsh");
            return;
        }
        App.npcController.giftNpc(npc, itemName);
        System.out.println("dast shoma mercy");
    }

    public void finishQuest(int questID, int npcId){
        Npc npc = App.getCurrentGame().getGameNPCs().get(npcId);
        if (npc == null){
            System.out.println("there is no npc with this name.");
            return;
        }
        Quest quest = npc.getQuests().get(questID);
        if (quest == null){
            System.out.println("quest not found.");
            return;
        }
        if (quest.getQuestLocked()[App.getCurrentGame().getPlayerIDByUsername(App.getCurrentUser().getUsername())]){
            System.out.println("quest is locked.");
            return;
        }
        System.out.println(App.npcController.finishQuest(npc, quest));
    }

    public void sayHello(){
        System.out.println("hello");
    }



}
