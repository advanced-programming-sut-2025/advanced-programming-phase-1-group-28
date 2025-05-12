package com.example.Model;

import com.example.Model.Enums.NPC;

public class Npc {
    private NPC npc;

    public Npc(NPC npc) {
        this.npc = npc;
    }

    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }

    public String getDialog(){
        //TODO
        return "";
    }

    public int getId(){
        //TODO
        return 1;
    }

    public boolean isFavoriteItem(String giftName){
        //TODO
        return true;
    }
}
