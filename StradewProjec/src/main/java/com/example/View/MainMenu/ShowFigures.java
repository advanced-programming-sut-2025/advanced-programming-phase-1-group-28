package com.example.View.MainMenu;

import com.example.Model.*;
import com.example.Model.Item.Item;
import com.example.Model.Tools.Pepolee;
import com.example.Model.Tools.Tools;

import java.util.ArrayList;

public class ShowFigures {
    public void ShowTime()
    {
        Game currentGame = App.getCurrentGame();
        System.out.println("It's " + currentGame.getTime().showHour());
    }
    public void ShowDate()
    {
        Game currentGame = App.getCurrentGame();
        System.out.println("Today's date is " + currentGame.getTime().showDate());
    }
    public void ShowDateTime()
    {
        Game currentGame = App.getCurrentGame();
        System.out.println("It is currently " + currentGame.getTime().showDateTime());
    }
    public void ShowDayOfWeek()
    {
        Game currentGame = App.getCurrentGame();
        System.out.println("Today is " + currentGame.getTime().getDayOfWeek());
    }
    public void ShowSeason()
    {
        Game currentGame = App.getCurrentGame();
        System.out.println("The current season is " + currentGame.getTime().getSeason());
    }
    public void ShowWeather()
    {
        Game currentGame = App.getCurrentGame();
        System.out.println("Now weather is " + currentGame.getWeather());
    }
    public void PredictWeather()
    {
        //Output here .
    }
    public void PrintMap()
    {
        //Print ColorFull Emtiazi
    }
    public void ShowHelpReadingMap()
    {

    }
    public void ShowEnergy()
    {
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        System.out.println(currentPlayer.getEnergy());
    }
    public void ShowTool()
    {
        if(App.ReturnCurrentPlayer().getInventory().getCurrentTool() != null) {
            System.out.println(App.ReturnCurrentPlayer().getInventory().getCurrentTool());
        }
        else
        {
            System.out.println("You Dont have Tool in your hand");
        }
    }
    public void ShowAvailableTools()
    {
        for(int i = 0;i < App.ReturnCurrentPlayer().getInventory().getTools().size();i++)
        {
            System.out.println(App.ReturnCurrentPlayer().getInventory().getTools().get(i));
        }
    }
    public void ShowInventory()
    {
        Inventory inventory = App.ReturnCurrentPlayer().getInventory();
        System.out.println("Inventory items:");
        System.out.println("item: count");
        for (Tools tools: inventory.getTools()){
            System.out.println(tools.getName() + ": " + tools.getCount());
        }
        for (Item item: inventory.getItems()){
            System.out.println(item.getName() + ": " + item.getCount());
        }

    }
    public void ShowCraft(int x , int y)
    {

    }
    public void ShowPlant(int x, int y)
    {

    }
    public void HowMuchWater()
    {

    }
    public void ShowRecipe()
    {
        //for on on every food Check If he Knows Then Print
    }
    public void ShowAnimals()
    {

    }
    public void ShowProduces()
    {
        //we have this thing in out animal Classes
    }
    public void ShowAllProducts()
    {
        //just for One Store
    }
    public void ShowAllAvailableProducts()
    {

    }
    public void ShowTalkHistory()
    {

    }
    public void ShowUpcomingGifts()
    {
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        int i = 0;
        for (Gift gift: currentPlayer.getUpcomingGifts()){
            System.out.println("Gift number: " + i);
            System.out.println("Sender: " + gift.getSender());
            System.out.println("Item: " + gift.getItem().getName());
            System.out.println("Count: " + gift.getCount());
            i++;
        }
    }

    public void showTradeList(){
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        ArrayList<Trade> upcomingTrades = currentPlayer.getUpcomingTrade();
        System.out.println("Your trade requests: ");
        int i = 1;
        for (Trade trade:upcomingTrades){
            System.out.println("Trade ID: " + i);
            System.out.println("Sender name: " + trade.getSender());
            System.out.println("Trade type: " + trade.getType());
            System.out.println("Offer Item: " + trade.getOfferItem().getName());
            System.out.println("Offer amount: " + trade.getAmount());
            if (trade.getType().equals("offer")){
                System.out.println("Price: " + trade.getPrice());
            }else {
                System.out.println("Target item: " + trade.getTargetItemName());
                System.out.println("Target amount: " + trade.getTargetAmount());
            }
            i++;
        }
    }

    public void showTradeHistory(){
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        ArrayList<Trade> tradeHistory = currentPlayer.getTradeHistory();
        for (Trade trade: tradeHistory){
            System.out.println("Sender name: " + trade.getSender());
            System.out.println("Trade type: " + trade.getType());
            System.out.println("Offer Item: " + trade.getOfferItem().getName());
            System.out.println("Offer amount: " + trade.getAmount());
            if (trade.getType().equals("offer")){
                System.out.println("Price: " + trade.getPrice());
            }else {
                System.out.println("Target item: " + trade.getTargetItemName());
                System.out.println("Target amount: " + trade.getTargetAmount());
            }
            if (trade.isAccept()){
                System.out.println("Response: ACCEPTED");
            }else {
                System.out.println("Response: REJECTED");
            }
        }
    }
    public void ShowGiftsFromDreamMan(String Username)
    {

    }
    public void GiftRating(int Rate)
    {

    }
    public void ShowNPCFriendShips()
    {

    }
}
