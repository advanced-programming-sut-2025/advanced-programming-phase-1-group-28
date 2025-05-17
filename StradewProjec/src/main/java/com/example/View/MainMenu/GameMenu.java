package com.example.View.MainMenu;

import com.example.Controller.MainMenuController.GameMenuController;
import com.example.Controller.SignUpController;
import com.example.Model.App;
import com.example.Model.Enums.MenuName;
import com.example.Model.Enums.Rejex.GameMenuRejex;
import com.example.Model.User;
import com.example.View.Appview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameMenu {
    SignUpController signUpController = App.signUpController;
    GameMenuController gameMenuController = App.gameMenuController;
    ShowFigures showFigures = App.showFigures;
    CheatCodes cheatCodes = App.cheatCodes;

    public void Input(String command){
        Matcher matcher;
        if(Appview.CurrentGameID != -1)
        {
            if(App.ReturnCurrentPlayer().getEnergy() <= 0)
            {
                App.ReturnCurrentPlayer().setISFainted(true);
                App.gameMenu.NextTurn();
            }
        }
        if ((matcher = GameMenuRejex.EnergyShow.getMatcher(command)) != null){
            showFigures.ShowEnergy();
        } else if ((matcher = GameMenuRejex.EnergySet.getMatcher(command)) != null) {
            cheatCodes.SetEnergy(Integer.parseInt(matcher.group(1)));
        } else if ((matcher = GameMenuRejex.EnergyUnlimited.getMatcher(command)) != null) {
            cheatCodes.SetUnlimitedEnergy();
        } else if ((matcher = GameMenuRejex.InventoryShow.getMatcher(command)) != null) {
            showFigures.ShowInventory();
        } else if ((matcher = GameMenuRejex.CheatWeatherSet.getMatcher(command)) != null) {
            cheatCodes.SetWeather(matcher.group(1));
        } else if ((matcher = GameMenuRejex.ShowWeather.getMatcher(command)) != null) {
            showFigures.ShowWeather();
        } else if ((matcher = GameMenuRejex.WeatherForecast.getMatcher(command)) != null) {
            showFigures.PredictWeather();
        } else if ((matcher = GameMenuRejex.CheatThor.getMatcher(command)) != null) {
            cheatCodes.Thor(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));// This is incomplete
        } else if ((matcher = GameMenuRejex.ShowSeason.getMatcher(command)) != null) {
            showFigures.ShowSeason();
        } else if ((matcher = GameMenuRejex.CheatAdvanceDate.getMatcher(command)) != null) {
            cheatCodes.ChangeDay(Integer.parseInt(matcher.group(1)));
        } else if ((matcher = GameMenuRejex.CheatAdvanceTime.getMatcher(command)) != null) {
            cheatCodes.ChangeHour(Integer.parseInt(matcher.group(1)));
        } else if ((matcher = GameMenuRejex.ShowDayOfWeek.getMatcher(command)) != null) {
            showFigures.ShowDayOfWeek();
        } else if ((matcher = GameMenuRejex.ShowDateTime.getMatcher(command)) != null) {
            showFigures.ShowDateTime();
        } else if ((matcher = GameMenuRejex.ShowDate.getMatcher(command)) != null) {
            showFigures.ShowDate();
        } else if ((matcher = GameMenuRejex.ShowTime.getMatcher(command)) != null) {
            showFigures.ShowTime();
        } else if((matcher = GameMenuRejex.StartGame.getMatcher(command)) != null) {
            ArrayList<String> Usernames = new ArrayList<>();
            String PlayerRejex = "\\w+";
            Pattern Playerpattern = Pattern.compile(PlayerRejex);
            Matcher playerMatcher = Playerpattern.matcher(command.substring(12));
            while (playerMatcher.find()) {
                Usernames.add(playerMatcher.group().trim());
            }
            StartGame(Usernames);
        } else if((matcher = GameMenuRejex.ExitGame.getMatcher(command)) != null)
        {
            Appview.Situation = MenuName.LoginMenu;
        } else if((matcher = GameMenuRejex.BuildGreenhouse.getMatcher(command)) != null)
        {
            App.mechanicGame.BuildGreenHouse();
        } else if((matcher = GameMenuRejex.Walk.getMatcher(command)) != null)
        {
            App.mechanicGame.walk(App.ReturnCurrentPlayer().getX() , App.ReturnCurrentPlayer().getY() , Integer.parseInt(matcher.group(1)) , Integer.parseInt(matcher.group(2)));
        } else if ((matcher = GameMenuRejex.TalkToSomeone.getMatcher(command)) != null) {
            App.friendship.Talk(matcher.group(1), matcher.group(2));
        } else if ((matcher = GameMenuRejex.TalkHistory.getMatcher(command)) != null) {
            App.showFigures.ShowTalkHistory(matcher.group(1));
        } else if ((matcher = GameMenuRejex.GiftSomeone.getMatcher(command)) != null) {
            App.friendship.Gifting(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)));
        } else if ((matcher = GameMenuRejex.GiftList.getMatcher(command)) != null) {
            App.showFigures.ShowUpcomingGifts();
        } else if ((matcher = GameMenuRejex.GiftRate.getMatcher(command)) != null) {
            App.friendship.rateGift(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        } else if ((matcher = GameMenuRejex.GiftHistory.getMatcher(command)) != null) {
            App.showFigures.ShowGiftsFromDreamMan(matcher.group(1));
        }else if ((matcher = GameMenuRejex.Hug.getMatcher(command)) != null){
            App.friendship.Hug(matcher.group(1));
        } else if ((matcher = GameMenuRejex.Flower.getMatcher(command)) != null) {
            App.friendship.Flowering(matcher.group(1));
        } else if ((matcher = GameMenuRejex.AskMarriage.getMatcher(command)) != null) {
            App.friendship.marriageRequest(matcher.group(1), matcher.group(2));
        } else if ((matcher = GameMenuRejex.TradeSomeone.getMatcher(command)) != null) {
            App.friendship.tradeRequest(matcher.group(1), matcher.group(2), matcher.group(3), Integer.parseInt(matcher.group(4)),
                    Integer.parseInt(matcher.group(5)), matcher.group(6), Integer.parseInt(matcher.group(7)));
        } else if ((matcher = GameMenuRejex.TradeList.getMatcher(command)) != null) {
            App.showFigures.showTradeList();
        } else if ((matcher = GameMenuRejex.TradeResponse.getMatcher(command)) != null) {
            App.friendship.tradeResponse(matcher.group(1).equals("-accept"), Integer.parseInt(matcher.group(2)));
        } else if ((matcher = GameMenuRejex.TradeHistory.getMatcher(command)) != null) {
            App.showFigures.showTradeHistory();
        } else if((matcher = GameMenuRejex.PrintMap.getMatcher(command)) != null)
        {
            App.showFigures.PrintMap(Integer.parseInt(matcher.group(1)) , Integer.parseInt(matcher.group(2)) , Integer.parseInt(matcher.group(3)));
        } else if((matcher = GameMenuRejex.HelpReadingMap.getMatcher(command)) != null)
        {
            App.showFigures.ShowHelpReadingMap();
        } else if((matcher = GameMenuRejex.Equiptool.getMatcher(command)) != null)
        {
            App.UseTool.Equiptool(matcher.group(1).trim());
        } else if ((matcher = GameMenuRejex.ToolsShowCurrent.getMatcher(command)) != null) {
            App.showFigures.ShowTool();
        } else if ((matcher = GameMenuRejex.ToolsShowAvailable.getMatcher(command)) != null) {
            App.showFigures.ShowAvailableTools();
        } else if((matcher = GameMenuRejex.ToolUse.getMatcher(command)) != null) {
            App.UseTool.Usetool(Integer.parseInt(matcher.group(1)) , Integer.parseInt(matcher.group(2)));
        } else if((matcher = GameMenuRejex.ShowCraft.getMatcher(command)) != null) {
            App.showFigures.ShowCraft(matcher.group(1).trim());
        } else if((matcher = GameMenuRejex.Planting.getMatcher(command)) != null) {
            App.farming.Planting(matcher.group(1).trim() , Integer.parseInt(matcher.group(2).trim()) , Integer.parseInt(matcher.group(3).trim()));
        } else if((matcher = GameMenuRejex.ShowPlant.getMatcher(command)) != null) {
            App.showFigures.ShowPlant(Integer.parseInt(matcher.group(1).trim()) , Integer.parseInt(matcher.group(2).trim()));
        } else if ((matcher = GameMenuRejex.Fertilizing.getMatcher(command)) != null) {
            App.farming.Cood(matcher.group(1).trim() , Integer.parseInt(matcher.group(2).trim()) , Integer.parseInt(matcher.group(3).trim()));
        } else if((matcher = GameMenuRejex.Crafting.getMatcher(command)) != null) {
            App.Crafting.CraftItem(matcher.group(1).trim());
        } else if((matcher = GameMenuRejex.AddCraftCheatcode.getMatcher(command)) != null) {
            App.cheatCodes.AddItemCheatCode(matcher.group(1).trim() , Integer.parseInt(matcher.group(2).trim()));
        } else if((matcher = GameMenuRejex.ShowCraft.getMatcher(command)) != null) {
        } else if ((matcher = GameMenuRejex.CookingRefrigerator.getMatcher(command)) != null) {
            if (matcher.group(1).equals("put")){
                App.pokhtOPaz.putInRef(matcher.group(2));
            }else {
                App.pokhtOPaz.PickFromRef(matcher.group(2));
            }
        } else if ((matcher = GameMenuRejex.CookingShowRecipes.getMatcher(command)) != null) {
            App.showFigures.ShowRecipe();
        } else if ((matcher = GameMenuRejex.CookingPrepare.getMatcher(command)) != null) {
            App.pokhtOPaz.PokhtingOPazing(matcher.group(1));
        } else if ((matcher = GameMenuRejex.Eat.getMatcher(command)) != null) {
            App.pokhtOPaz.Eating(matcher.group(1));
        } else if ((matcher = GameMenuRejex.Build.getMatcher(command)) != null) {
        } else if ((matcher = GameMenuRejex.BuyAnimal.getMatcher(command)) != null) {

        } else if ((matcher = GameMenuRejex.PetAnimal.getMatcher(command)) != null) {
            App.mechanicGame.Pet(matcher.group(1));
        } else if ((matcher = GameMenuRejex.CheatSetFriendshipWithAnimal.getMatcher(command)) != null) {
            App.cheatCodes.SetFriendShip(matcher.group(1), Integer.parseInt(matcher.group(2)));
        } else if ((matcher = GameMenuRejex.AnimalShow.getMatcher(command)) != null) {
            App.showFigures.ShowAnimals();
        } else if ((matcher = GameMenuRejex.ShepherdAnimal.getMatcher(command)) != null) {
            App.mechanicGame.shepherdAnimal(matcher.group(1), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
        } else if ((matcher = GameMenuRejex.FeedHay.getMatcher(command)) != null) {
            App.mechanicGame.FeedAnimal(matcher.group(1));
        } else if ((matcher = GameMenuRejex.AnimalProduces.getMatcher(command)) != null) {
            App.showFigures.ShowAllAvailableProducts();
        } else if ((matcher = GameMenuRejex.CollectProduce.getMatcher(command)) != null) {
            App.mechanicGame.getAnimalProducts(matcher.group(1));
        } else if ((matcher = GameMenuRejex.SellAnimal.getMatcher(command)) != null) {
            App.mechanicGame.SellAnimal(matcher.group(1));
        }
        else if((matcher = GameMenuRejex.Showallproducts.getMatcher(command)) != null) {
            App.shopMenu.availableProducts();
        }
        else if((matcher = GameMenuRejex.purchase.getMatcher(command)) != null) {
            App.shopMenu.Buy(matcher.group(1) , matcher.group(2));
        }
        else if((matcher = GameMenuRejex.ShippingBinSell.getMatcher(command)) != null) {
            App.shopMenu.shippingBinSells(matcher.group(1) , Integer.parseInt(matcher.group(2)));
        }
    }
    public void StartGame(ArrayList<String> PlayersInGame)
    {
        PlayersInGame.add(0, App.getCurrentUser().getUsername());
        for(int i = 0 ;i < PlayersInGame.size();i++) {
            if (!signUpController.IsUsernameTaken(PlayersInGame.get(i))) {
                System.out.println(PlayersInGame.get(i) + " is not a valid username");
                return;
            }
        }
        if(!gameMenuController.IsInAnotherGame(PlayersInGame)) {
            System.out.println("Your Friend are in the game");
            return;
        }
        System.out.println("i am zende");
        for(int i = 0;i < PlayersInGame.size();i++) {
            System.out.println(PlayersInGame.get(i));
        }
        gameMenuController.ApplyPlayersToGame(PlayersInGame);
        for(int i = 0 ;i < PlayersInGame.size();i++) {
            while (true)
            {
                System.out.println("please Enter the Farm Map for Player" + PlayersInGame.get(i));
                int Mapindex = App.scanner.nextInt();
                if(gameMenuController.CheckMapIDValid(Mapindex)) {
                    gameMenuController.SetFarm(i , Mapindex);
                    break;
                }
                else {
                    System.out.println("please Enter valid map ID");
                }
            }
        }
        System.out.println("Welcome to the game");
        //InputMapValid();
        //call start game commands
    }

    public void NextTurn()
    {
        App.gameMenuController.ApplyNextTurn();
    }

    /*public boolean InputMapValid(ArrayList<String> PlayersInGame)
    {

    }*/
    public void LoadGame()
    {
        //TO DO
    }
    public void ExitGame()
    {
        //Update Files if we were Main
    }
    public void Voting()
    {
        //print Each turn
    }

}
