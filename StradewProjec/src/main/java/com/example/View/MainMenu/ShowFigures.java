package com.example.View.MainMenu;

import com.example.Model.*;
import com.example.Model.Enums.*;
import com.example.Model.Item.Item;
import com.example.Model.Tile.Animal;
import com.example.Model.Tile.Plants;
import com.example.Model.Tile.Tile;
import com.example.Model.Tools.Pepolee;
import com.example.Model.Tools.Tools;

import java.io.OutputStream;
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
        System.out.println(App.gameMenuController.WeatherForeCasting().toString());
    }
    public void PrintMap(int x, int y, int l)
    {
        Tile[][] TempGround = App.ReturnCurrentPlayer().getFarm().getGround();
        for(int i = x; i < x + l; i++)
        {
            for(int j = y ;j < y + l ;j++)
            {
                if(App.ReturnCurrentPlayer().getX() == i && App.ReturnCurrentPlayer().getY() == j)
                {
                    System.out.print(MapReading.PEOPEELE.Show);
                }
                else
                {
                    boolean ok = false;
                    for(Animal animal : App.ReturnCurrentPlayer().getFarm().getAnimals())
                    {
                        if(animal.getX() == i && animal.getY() == j)
                        {
                            System.out.print(MapColors.RED.Colorname + MapReading.Animal.Show + MapColors.Reset.Colorname);
                            ok = true;
                        }
                    }
                    if(ok)
                    {

                    } else if(TempGround[i][j].getEntitity() == Entitity.Minreal) {
                        System.out.print(MapColors.RED.Colorname + MapReading.Mineral.Show + MapColors.Reset.Colorname);
                    } else if(TempGround[i][j].getTerrain() == Terrain.DIRT) {
                        if(TempGround[i][j].isHow())
                        {
                            System.out.print("S");
                        }
                        else
                        {
                            System.out.printf("D");
                        }
                    }
                    else
                    {
                        if(TempGround[i][j].getPlaceType() == PlaceType.CABIN)
                        {
                            System.out.print(MapColors.RED.Colorname + MapReading.Cabin.Show + MapColors.Reset.Colorname);
                        }
                        else
                        {
                            if(TempGround[i][j].getPlaceType() == PlaceType.LAKE)
                            {
                                System.out.printf(MapColors.RED.Colorname + MapReading.Lake.Show + MapColors.Reset.Colorname);
                            }
                            else
                            {
                                if(TempGround[i][j].getPlaceType() == PlaceType.GREENHOUSE)
                                {
                                    System.out.printf(MapColors.RED.Colorname + MapReading.Greenhouse.Show + MapColors.Reset.Colorname);
                                }
                                else
                                {
                                    if(TempGround[i][j].getEntitity() == Entitity.TREE)
                                    {
                                        System.out.printf(MapColors.Green.Colorname + MapReading.Tree.Show + MapColors.Reset.Colorname);
                                    }
                                    else if(TempGround[i][j].getEntitity() == Entitity.PLANTS)
                                    {
                                        System.out.printf(MapColors.Green.Colorname + MapReading.Plant.Show + MapColors.Reset.Colorname);
                                    } else if(TempGround[i][j].getPlaceType() == PlaceType.QUARRY)
                                    {
                                        System.out.print(MapColors.RED.Colorname + MapReading.Quarry.Show + MapColors.Reset.Colorname);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
        //Print ColorFull Emtiazi
    }
    public void ShowHelpReadingMap()
    {
        for(MapReading mapReading : MapReading.values())
        {
            System.out.println(mapReading.toString() + " " + mapReading.Show);
        }
    }
    public void ShowEnergy()
    {
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        System.out.println(currentPlayer.getEnergy());
    }
    public void ShowTool()
    {
        if(App.ReturnCurrentPlayer().getInventory().getCurrentTool() != null) {
            System.out.println(App.ReturnCurrentPlayer().getInventory().getCurrentTool().getName());
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

    public void ShowCraft(String name)
    {
        for(com.example.Model.Enums.Plants plant : com.example.Model.Enums.Plants.values()) {
            if(plant.toString().equals(name)) {
                Plants ourplant = new Plants(plant);
                System.out.println("Name : " + ourplant.getPlant().toString());
                System.out.println("Source : " + ourplant.getPlant().Source);
                System.out.println("Stages : " + ourplant.getPlant().stage);
                System.out.println("TotalHarvestTime : " + ourplant.getPlant().TotalTimeHarvest);
                System.out.println("On Time : " + ourplant.getPlant().OnTime);
                if (ourplant.getPlant().RegrowthTime == 0) {
                    System.out.println("Regrowth time is : ");
                } else {
                    System.out.println("Regrowth time is : " + ourplant.getPlant().RegrowthTime);
                }
                System.out.println("Base Sell Price : " + ourplant.getPlant().BasePrice);
                System.out.println("Is Edible :" + ourplant.getPlant().IsEdible);
                System.out.println("Base Energy : " + ourplant.getPlant().energy);
                //System.out.println("Base Health : " + ourplant.getPlant().);
                System.out.println("Seoson : " + ourplant.getPlant().season);
                System.out.println("Can become Giant" + ourplant.getPlant().CanBecomeGiant);
            }
        }
    }

    public void ShowPlant(int x, int y)
    {
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        Tile[][] Tempground = currentPlayer.getFarm().getGround();
        if(Tempground[x][y].getEntitity() == Entitity.PLANTS)
        {
            Plants ourplanr = (Plants) Tempground[x][y];
            System.out.println("Name" + ourplanr.getPlant().toString());
            System.out.println("Time to harvest" + " " + (Math.max(0 , ourplanr.getPlant().TotalTimeHarvest - ourplanr.getBornTime().DifreenceTime(App.getCurrentGame().getTime()).getDay())));
            System.out.println("IS Codded" + ourplanr.isISCooded());
            if(ourplanr.getLastTimeWatering() != null) {
                if (ourplanr.getLastTimeWatering().getDay() == App.getCurrentGame().getTime().getDay()) {
                    System.out.println("Is waterd today");
                } else {
                    System.out.println("Doesnt watered today");
                }
            }
            else
            {
                System.out.println("Does not water today");
            }
        }
        else
        {
            System.out.println("There is no seed here");
        }
    }
    public void HowMuchWater()
    {

    }
    public void ShowRecipe()
    {
        System.out.println("Known recipes: ");
        ArrayList<Foods> knownRecipes = App.ReturnCurrentPlayer().getKnownRecipes();
        for (Foods food: knownRecipes){
            System.out.println("Name: " + food.Name);
            System.out.println("Ingredients: ");
            int i = 0;
            for (String ingredient: food.Ingredient){
                System.out.println(ingredient + " " + food.IngredientCount.get(i));
                i++;
            }
            System.out.println("Energy: " + food.Energy);
            if (food.Buff != null){
                System.out.println("Buff: " + food.Buff);
            }
            System.out.println("Sell price: " + food.SellPrice);
        }
        //for on every food Check If he Knows Then Print
    }
    public void ShowAnimals()
    {
        ArrayList<Animal> animals = App.ReturnCurrentPlayer().getFarm().getAnimals();
        for (Animal animal: animals){
            System.out.println("Name: " + animal.getPetName());
            System.out.println("Type: " + animal.getAnimalType().toString());
            System.out.println("Friendship: " + animal.getFriendShip());
            if (animal.isPettedToday()){
                System.out.println("Has been petted today.");
            }else {
                System.out.println("Hasn't been petted today.");
            }if (animal.isFed()){
                System.out.println("Has been fed today.");
            }else {
                System.out.println("Hasn't been fed today.");
            }
        }
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
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        System.out.println("Animal name: products");
        for (Animal animal: currentPlayer.getFarm().getAnimals()){
            System.out.println(animal.getPetName());
            for (Item item: animal.getProducts()){
                System.out.println(item.getName());
            }
            System.out.println("---------------------------------");
        }
    }
    public void ShowTalkHistory(String username)
    {
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(username);
        if (usernameID == -1){
            System.out.println("User not found");
            return;
        }
        Game game = App.getCurrentGame();
        User currentUser = App.getCurrentUser();
        FriendShip friendShip = game.getFriedShipBetweenPlayers(currentUser.getUsername(), username);
        ArrayList<String> talkHistory = friendShip.getTalkHistory();
        System.out.println("Your talk history with " + username);
        for (String talk: talkHistory){
            System.out.println(talk);
        }
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
        int usernameID = App.getCurrentGame().getPlayerIDByUsername(Username);
        if (usernameID == -1){
            System.out.println("User not found");
            return;
        }
        Game game = App.getCurrentGame();
        User currentUser = App.getCurrentUser();
        FriendShip friendShip = game.getFriedShipBetweenPlayers(currentUser.getUsername(), Username);
        int i = 0;
        for (Gift gift: friendShip.getGifts()){
            System.out.println("Gift number: " + i);
            System.out.println("Sender: " + gift.getSender());
            System.out.println("Item: " + gift.getItem().getName());
            System.out.println("Count: " + gift.getCount());
            i++;
        }
    }
    public void GiftRating(int Rate)
    {

    }
    public void ShowNPCFriendShips()
    {
        System.out.println("npc id: friendship level");
        int userId = App.getCurrentGame().getPlayerIDByUsername(App.getCurrentUser().getUsername());
        for (int i = 4; i<=8; i++){
            System.out.println(i + ": " + App.getCurrentGame().getFriendShips()[userId][i].getLevel());
        }
    }

    public void ShowQuestsList(){
        System.out.println("Your unlocked quests: ");
        for (Npc npc: App.getCurrentGame().getGameNPCs()){
            for (Quest quest: npc.getQuests()){
                if (quest.getQuestLocked()[App.getCurrentGame().getPlayerIDByUsername(App.getCurrentUser().getUsername())]){
                    continue;
                }
                System.out.println("NPC id: " + npc.getId());
                System.out.println("Needed item: " + quest.getGivenItems().getName());
                if (quest.getRewards().getItem() == null){
                    System.out.println("Reward: " + quest.getRewards().getCoins() + " coins");
                }else {
                    System.out.println("Reward: " + quest.getRewards().getItem().getName());
                }
            }
        }
    }
}
