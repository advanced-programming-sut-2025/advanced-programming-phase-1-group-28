package com.example.Model.Tools;

import com.example.Model.*;
import com.example.Model.Enums.Foods;
import com.example.Model.Item.Item;
import com.example.Model.Places.Farm;

import java.util.ArrayList;

public class Pepolee {
    private int x;
    private int y;
    private Farm Farm;
    private int Energy = 200;
    private int Id;
    private int Wood = 0;
    private int Coin = 0;
    private Inventory inventory = new Inventory();
    private Skill[] Skills = new Skill[4];
    private User CharacterUser;
    private ArrayList<Gift> upcomingGifts = new ArrayList<>();
    private ArrayList<Trade> upcomingTrade = new ArrayList<>();
    private ArrayList<Trade> tradeHistory = new ArrayList<>();
    private ArrayList<Foods> knownRecipes = new ArrayList<>();
    private ArrayList<Item> overflowItems = new ArrayList<>();
    {
        knownRecipes.add(Foods.FriedEgg);
        knownRecipes.add(Foods.BakedFish);
        knownRecipes.add(Foods.Salad);
    }

    public ArrayList<Foods> getKnownRecipes() {
        return knownRecipes;
    }

    public void setKnownRecipes(ArrayList<Foods> knownRecipes) {
        this.knownRecipes = knownRecipes;
    }

    public User getCharacterUser() {
        return CharacterUser;
    }

    public void setCharacterUser(User characterUser) {
        CharacterUser = characterUser;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public com.example.Model.Places.Farm getFarm() {
        return Farm;
    }

    public void setFarm(com.example.Model.Places.Farm farm) {
        Farm = farm;
    }

    public int getEnergy() {
        return Energy;
    }

    public void setEnergy(int energy) {
        Energy = energy;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getWood() {
        return Wood;
    }

    public void setWood(int wood) {
        Wood = wood;
    }

    public int getCoin() {
        return Coin;
    }

    public void setCoin(int coin) {
        Coin = coin;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Skill[] getSkills() {
        return Skills;
    }

    public void setSkills(Skill[] skills) {
        Skills = skills;
    }

    public ArrayList<Trade> getTradeHistory() {
        return tradeHistory;
    }

    public void setTradeHistory(ArrayList<Trade> tradeHistory) {
        this.tradeHistory = tradeHistory;
    }

    public ArrayList<Gift> getUpcomingGifts() {
        return upcomingGifts;
    }

    public void setUpcomingGifts(ArrayList<Gift> upcomingGifts) {
        this.upcomingGifts = upcomingGifts;
    }

    public void addGift(Gift gift){
        upcomingGifts.add(gift);
    }

    public void removeUpcomingGift(Gift gift){
        upcomingGifts.remove(gift);
    }

    public ArrayList<Trade> getUpcomingTrade() {
        return upcomingTrade;
    }

    public void setUpcomingTrade(ArrayList<Trade> upcomingTrade) {
        this.upcomingTrade = upcomingTrade;
    }

    public void addTrade(Trade trade){
        upcomingTrade.add(trade);
    }

    public void removeTrade(Trade trade){
        upcomingTrade.remove(trade);
    }

    public void removeTradeByID(int id){
        upcomingTrade.remove(id);
    }

    public void addTradeToHistory(Trade trade){
        tradeHistory.add(trade);
    }

    public void addCoin(int amount){
        Coin += amount;
    }

    public void addEnergy(int count){
        Energy += count;
    }

    public void applyBuff(){

    }

    public void addOverflowItem(Item item){
        overflowItems.add(item);
    }

    public ArrayList<Item> getOverflowItems() {
        return overflowItems;
    }

    public void setOverflowItems(ArrayList<Item> overflowItems) {
        this.overflowItems = overflowItems;
    }

    public void addFoodRecipe(Foods food){
        knownRecipes.add(food);
    }
    //Set Energy
}
