package com.example.Model;

import com.example.Model.Enums.Dialog;
import com.example.Model.Enums.NPC;
import com.example.Model.Enums.Weathers;
import com.example.Model.Item.Item;

import java.util.ArrayList;

public class Npc {
    private int ID;
    private String name;
    private String job;
    private ArrayList<String> Dialogues;
    private ArrayList<Item> FavouriteItems;
    private ArrayList<Quest> Quests;
    private int x_position;
    private int y_position;
    private int howManyDaysToUnlockQuest = (App.random.nextInt() % 60) + 30;

    public Npc(int ID , String name, String job, ArrayList<String> dialogues, ArrayList<Item> favouriteItems, ArrayList<Quest> quests , int x_position , int y_position) {
        this.ID = ID;
        this.name = name;
        this.job = job;
        Dialogues = dialogues;
        FavouriteItems = favouriteItems;
        Quests = quests;
        this.x_position = x_position;
        this.y_position = y_position;
    }

    public int getId() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getDialogues() {
        return Dialogues;
    }

    public ArrayList<Item> getFavouriteItems() {
        return FavouriteItems;
    }

    public ArrayList<Quest> getQuests() {
        return Quests;
    }

    public int getX_position() {
        return x_position;
    }

    public int getY_position() {
        return y_position;
    }
    private NPC npc;

    public Npc(NPC npc) {
        this.npc = npc;
    }

    public NPC getNpc() {
        return npc;
    }

    public int getHowManyDaysToUnlockQuest() {
        return howManyDaysToUnlockQuest;
    }

    public void setHowManyDaysToUnlockQuest(int howManyDaysToUnlockQuest) {
        this.howManyDaysToUnlockQuest = howManyDaysToUnlockQuest;
    }

    public String getDialog(int friendshipLevel) {
        Weathers currentWeather = App.getCurrentGame().getWeather();
        for (Dialog d : Dialog.values()) {
            if (d.matches(currentWeather, getId(), friendshipLevel)) {
                return d.text;
            }
        }
        return "They seem quiet today...";
    }


    public boolean isFavoriteItem(Item item) {
        for (Item myitem : FavouriteItems) {
            if (myitem.getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
    }
    public void setNpc(NPC npc) {
        this.npc = npc;
    }
}
