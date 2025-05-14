package com.example.View.MainMenu;

import com.example.Controller.MainMenuController.MechanicController.CheatCodeController;
import com.example.Model.App;
import com.example.Model.Enums.*;
import com.example.Model.Game;
import com.example.Model.Item.*;
import com.example.Model.Tile.Animal;
import com.example.Model.Tile.Minreal;
import com.example.Model.Time;
import com.example.Model.Tools.Pepolee;
import com.example.View.Appview;

public class CheatCodes {
    CheatCodeController cheatCodeController = new CheatCodeController();

    public void ChangeHour(int Hour)
    {
        if (Hour < 0){
            System.out.println("Time can only move forward! Please enter a positive number!");
        }
        cheatCodeController.ChangeHour(Hour);
        Game currentGame = App.returnGame(Appview.CurrentGameID);
        Time gameTime = currentGame.getTime();
        System.out.println("Time advanced by " + Hour + " hours. The current datetime is now " + gameTime.showDateTime() + ".");
    }

    public void ChangeDay(int Day)
    {
        if (Day < 0){
            System.out.println("Time can only move forward! Please enter a positive number!");
        }
        cheatCodeController.ChangeDay(Day);
        Game currentGame = App.returnGame(Appview.CurrentGameID);
        Time gameTime = currentGame.getTime();
        System.out.println("Time advanced by " + Day + " days. The current date is now " + gameTime.showDate() + ".");
    }

    public void Thor(int x , int y)
    {
        App.farmingController.RandomLightning(App.ReturnCurrentPlayer() , x , y , true);
        //App.gameMenuController.Applylightning(x , y , App.getCurrentGame().getWhoseTurn());
    }

    public void SetWeather(String Weather)
    {
        if (!Weather.equals(Weathers.SUNNY.name()) && !Weather.equals(Weathers.RAIN.name()) &&
        !Weather.equals(Weathers.SNOW.name()) && !Weather.equals(Weathers.STORM.name())){
            System.out.println("Please choose " + Weathers.SUNNY.name() +  " or" + Weathers.RAIN.name() +  " or" +
                    Weathers.SNOW.name() +  " or" + Weathers.STORM.name() +  " for weather.");
            return;
        }
        cheatCodeController.SetWeather(Weather);
        Game game = App.getCurrentGame();
        System.out.println("Now weather is " + game.getWeather());
    }

    public void SetEnergy(int energy)
    {
        cheatCodeController.SetEnergy(energy);
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        System.out.println("Your energy is " + currentPlayer.getEnergy());
    }


    public void SetUnlimitedEnergy()
    {
        cheatCodeController.SetUnlimitedEnergy();
        System.out.println("Your energy is unlimited");
    }

    public void AddItemCheatCode(String ItemName , int Count)
    {
        for(Ingredients ingredient : Ingredients.values())
        {
            if(ingredient.toString().equals(ItemName))
            {
                Ingredient newingredient = new Ingredient(Count , ingredient);
                App.ReturnCurrentPlayer().getInventory().AddItem(newingredient);
            }
        }
        for(Crafts craft : Crafts.values())
        {
            if(craft.Name.equals(ItemName))
            {
                Craft newcraft = new Craft(Count , craft);
                App.ReturnCurrentPlayer().getInventory().AddItem(newcraft);
            }
        }
        for(Fishes fishes : Fishes.values())
        {
            if(fishes.toString().equals(ItemName))
            {
                FishItem newfish = new FishItem(Count , fishes);
                App.ReturnCurrentPlayer().getInventory().AddItem(newfish);
            }
        }
        for(Minerals mineral : Minerals.values())
        {
            if(mineral.toString().equals(ItemName))
            {
                MineralItem newmineral = new MineralItem(Count , mineral);
                App.ReturnCurrentPlayer().getInventory().AddItem(newmineral);
            }
        }
        for(Plants plants : Plants.values())
        {
            if(plants.toString().equals(ItemName)){
                PlantsItem newplants = new PlantsItem(Count , plants);
                App.ReturnCurrentPlayer().getInventory().AddItem(newplants);
            }
        }
    }


    public void SetFriendShip(String PetName , int Amount)
    {
        Animal animal = App.ReturnCurrentPlayer().getFarm().getAnimalByName(PetName);
        if (animal == null){
            System.out.println("animal not found.");
            return;
        }
        cheatCodeController.SetFriendShip(animal, Amount);
        System.out.println("Your friendship with " + PetName + " has been set successfully.");
    }

    public void SetMoney()
    {

    }
}
