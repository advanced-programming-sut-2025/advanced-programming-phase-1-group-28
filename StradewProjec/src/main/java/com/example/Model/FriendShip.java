package com.example.Model;

import com.example.Model.Item.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class FriendShip {
    private boolean isTalkedToday = false;
    private int XP = 0;
    private int level = 0;
    private ArrayList<String> TalkHistory = new ArrayList<>();
    private ArrayList<Gift> gifts = new ArrayList<>();
    private boolean isWithNpc = false;

    public FriendShip() {
    }

    public boolean isWithNpc() {
        return isWithNpc;
    }

    public void setWithNpc(boolean withNpc) {
        isWithNpc = withNpc;
    }

    public void setGifts(ArrayList<Gift> gifts) {
        this.gifts = gifts;
    }

    public ArrayList<Gift> getGifts() {
        return gifts;
    }

    public boolean isTalkedToday() {
        return isTalkedToday;
    }

    public void setTalkedToday(boolean talkedToday) {
        isTalkedToday = talkedToday;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<String> getTalkHistory() {
        return TalkHistory;
    }

    public void setTalkHistory(ArrayList<String> talkHistory) {
        TalkHistory = talkHistory;
    }

    public void addXp(int amount){
        XP += amount;
        if (isWithNpc){
            if (XP > (level + 1) * 200){
                level ++;
            }
        }
        else {
            if (XP > (level + 1) * 100  && level < 2){
                level ++;
            }
        }
    }

    public void applyTalk(String message){
        TalkHistory.add(message);
        this.addXp(20);
    }

    public void addGift(Gift gift){
        gifts.add(gift);
    }

    public void rateGift(int rate){
        int xpChanged = (rate - 3) * 30 + 15;
        this.addXp(xpChanged);
    }

    public void applyHug(){
        this.addXp(60);
    }

    public void applyFlower(){
        if (level < 3){
            level = 3;
        }
    }

    public void applyMarriage(){
        level = 4;
    }

    public void applyAcceptTrade(){
        this.addXp(50);
    }

    public void applyRejectTrade(){
        this.addXp(-30);
    }

    public void meetNpc(){
        if (isTalkedToday){
            return;
        }
        isTalkedToday = true;
        addXp(20);
    }
}
