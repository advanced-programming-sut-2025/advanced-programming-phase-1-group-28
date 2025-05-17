package com.example.Model;

import com.example.Model.Item.Item;

import java.util.ArrayList;

public class Quest {
    private final Item GivenItems;
    private final Reward Rewards;
    private boolean QuestCompleted;
    private boolean[] QuestLocked;
    private boolean[] QuestLockedForever;

    public Quest(Item givenItems, Reward rewards) {
        GivenItems = givenItems;
        Rewards = rewards;
        QuestCompleted = false;
        QuestLocked = new boolean[]{true, true, true, true};
        QuestLockedForever = new boolean[]{false, false, false, false};
    }

    public Item getGivenItems() {
        return GivenItems;
    }

    public Reward getRewards() {
        return Rewards;
    }

    public boolean isQuestCompleted() {
        return QuestCompleted;
    }

    public void setQuestCompleted(boolean questCompleted) {
        QuestCompleted = questCompleted;
    }

    public boolean[] getQuestLocked() {
        return QuestLocked;
    }

    public void setQuestLocked(boolean[] questLocked) {
        QuestLocked = questLocked;
    }

    public boolean[] getQuestLockedForever() {
        return QuestLockedForever;
    }

    public void setQuestLockedForever(boolean[] questLockedForever) {
        QuestLockedForever = questLockedForever;
    }

    public String returnHello(){
        return "bye";
    }
}