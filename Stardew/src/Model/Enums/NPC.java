package Model.Enums;

import Model.Item.Item;
import Model.Quest;

import java.util.ArrayList;

public enum NPC {
    Mamad();
    public final String name;
    public final String Job;
    public final ArrayList<String> Dialogs;
    public final ArrayList<Item> FavoritItems;
    public final ArrayList<Quest> Quests;
    NPC(String name, String job, ArrayList<String> dialogs, ArrayList<Item> favoritItems, ArrayList<Quest> quests) {
        this.name = name;
        Job = job;
        Dialogs = dialogs;
        FavoritItems = favoritItems;
        Quests = quests;
    }
}
