package com.example.Model;

import com.example.Model.Item.Item;

import java.util.ArrayList;

public class Quest {
    private final Item GivenItems;
    private final Reward Rewards;
    private boolean QuestCompleted;
    private boolean[] QuestLocked;

    public Quest(Item givenItems, Reward rewards) {
        GivenItems = givenItems;
        Rewards = rewards;
        QuestCompleted = false;
        QuestLocked = new boolean[]{true, true, true, true};
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
}
