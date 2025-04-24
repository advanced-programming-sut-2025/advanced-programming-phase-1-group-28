package Model;

import Model.Item.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class FriendShip {
    private int XP = 0;
    private int level = 0;
    private ArrayList<String> TalkHistory = new ArrayList<>();
    private HashMap<Item , Integer> Gifts = new HashMap<>();

    public FriendShip() {
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

    public HashMap<Item, Integer> getGifts() {
        return Gifts;
    }

    public void setGifts(HashMap<Item, Integer> gifts) {
        Gifts = gifts;
    }
}
