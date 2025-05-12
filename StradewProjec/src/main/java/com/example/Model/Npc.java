package com.example.Model;

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

    public int getID() {
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

    public String getJob() {
        return job;
    }

    public void setQuests(ArrayList<Quest> quests) {
        Quests = quests;
    }
}
