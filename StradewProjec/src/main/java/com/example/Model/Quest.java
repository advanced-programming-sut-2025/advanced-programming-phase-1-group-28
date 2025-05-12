package com.example.Model;

import com.example.Model.Item.Item;

public class Quest {
    private final Item GivenItems;
    private final Reward Rewards;
    private boolean QuestCompleted;
    private boolean QuestLocked;

    public Quest(Item givenItems, Reward rewards) {
        GivenItems = givenItems;
        Rewards = rewards;
        QuestCompleted = false;
        QuestLocked = true;
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

    public boolean isQuestLocked() {
        return QuestLocked;
    }

    public void setQuestCompleted(boolean questCompleted) {
        QuestCompleted = questCompleted;
    }

    public void setQuestLocked(boolean questLocked) {
        QuestLocked = questLocked;
    }
}
