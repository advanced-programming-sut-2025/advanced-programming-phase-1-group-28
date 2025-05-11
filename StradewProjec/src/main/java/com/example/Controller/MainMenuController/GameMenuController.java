package com.example.Controller.MainMenuController;

import com.example.Model.App;
import com.example.Model.Enums.*;
import com.example.Model.Game;
import com.example.Model.Places.*;
import com.example.Model.Skill;
import com.example.Model.Tile.Animal;
import com.example.Model.Tile.Plants;
import com.example.Model.Tile.Tile;
import com.example.Model.Tile.Trees;
import com.example.Model.Tile.Plants;
import com.example.Model.Tile.Tile;
import com.example.Model.Tools.Pepolee;
import com.example.Model.User;
import com.example.View.Appview;

import java.util.ArrayList;

public class GameMenuController {
    public void ApplyNextTurn()
    {
        App.getCurrentGame().setWhoseTurn(((App.getCurrentGame().getWhoseTurn() + 1)) % App.getCurrentGame().getCharactersInGame().size());
    }
    public void ApplyPlayersToGame(ArrayList<String> PlayersInGame)
    {
        Game newgame = new Game(App.Games.size());
        ArrayList<User> players = new ArrayList<User>();
        for(int i = 0; i < PlayersInGame.size() ; i++)
        {
            int Userindex = App.ReturnUserIndex(PlayersInGame.get(i));
            players.add(App.Users.get(Userindex));
        }
        newgame.setPlayersInGame(players);
        ArrayList<Pepolee> Characters = new ArrayList<>();
        for(int i = 0;i < PlayersInGame.size() ; i++)
        {
            Pepolee NewPeople = new Pepolee();
            NewPeople.setCharacterUser(players.get(i));
            NewPeople.setId(i);
            Skill[] S = new Skill[4];
            S[0] = new Skill(Skills.Foraging);
            S[1] = new Skill(Skills.Fishing);
            S[2] = new Skill(Skills.Farming);
            S[3] = new Skill(Skills.Mining);
            Characters.add(NewPeople);
        }
        newgame.setCharactersInGame(Characters);
        for(int i = 0;i < PlayersInGame.size(); i++)
        {
            newgame.getScores().add(0);
        }
        for(int i = 0;i < players.size();i++)
        {
            players.get(i).setGameId(newgame.getID());
        }
        App.Games.add(newgame);
        Appview.CurrentGameID = newgame.getID();
        //first should Add Creator Id
        //define the Peoplee int the game
        //please Define dasti the Skills
    }

    public boolean IsInAnotherGame(ArrayList<String> PlayersInGame)
    {
        for(int i = 0; i<PlayersInGame.size(); i++)
        {
            int Userindex = App.ReturnUserIndex(PlayersInGame.get(i));
            if(App.Users.get(Userindex).getGameId() != -1)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckMapIDValid(int MapID)
    {
        return MapID < 4;
    }

    public ConstantFarms ReturnFarm(int FarmID)
    {
        int count = 1;
        for(ConstantFarms farm : ConstantFarms.values())
        {
            if(count == FarmID)
            {
                return farm;
            }
            count++;
        }
        return null;
    }

    public void SetFarm(int Id , int FarmID) {
        if(FarmID == 1)
        {
            App.getCurrentGame().getCharactersInGame().get(Id).setFarm(new Farm(new GreenHouse( 8 , 8) , new Cabin(10 , 25) , new Lake(25 , 15) , new Quarry(30 , 25)));
        }
        if(FarmID == 2)
        {
            App.getCurrentGame().getCharactersInGame().get(Id).setFarm(new Farm(new GreenHouse( 25 , 8) , new Cabin(5 , 5) , new Lake(30 , 30) , new Quarry(25 , 8)));
        }
    }
    public void ApplyDeleteGame()
    {
        //Dont delete in ArrayList
    }
    public void RandomAttackCrow()
    {

    }
    public void RandomForagingOnGird()
    {

    }

    public Weathers WeatherForeCasting()
    {
        Season season = App.getCurrentGame().getTime().getSeason();
        if(season == Season.SPRING)
        {
            int Rand = App.random.nextInt() % 5;
            if(Rand == 0 || Rand == 1)
            {
                return Weathers.RAIN;
            }
            if(Rand == 2 || Rand == 3)
            {
                return Weathers.SUNNY;
            }
            if(Rand == 4)
            {
                return Weathers.STORM;
            }
        }
        if(season == Season.SUMMER)
        {
            return Weathers.SUNNY;
        }
        if(season == Season.FALL)
        {
            int Rand = App.random.nextInt() % 5;
            if(Rand == 0 || Rand == 1)
            {
                return Weathers.RAIN;
            }
            if(Rand == 2)
            {
                return Weathers.SNOW;
            }
            if(Rand == 4 || Rand == 3)
            {
                return Weathers.STORM;
            }
        }
        if(season == Season.WINTER)
        {
            int Rand = App.random.nextInt() % 5;
            if(Rand == 0 || Rand == 1)
            {
                return Weathers.STORM;
            }
            if(Rand == 2 || Rand == 3)
            {
                return Weathers.SNOW;
            }
            if(Rand == 4)
            {
                return Weathers.RAIN;
            }
        }
        return Weathers.SUNNY;
    }


    public void ApplyChangeDay()
    {
        App.farmingController.ApplyRandomForagingInFarm();
        App.getCurrentGame().setWeather(WeatherForeCasting());
        //use above function
        //USer random Foraging
        // animals friendship effects
        for (Pepolee pepolee: App.getCurrentGame().getCharactersInGame()){

            for (Animal animal: pepolee.getFarm().getAnimals()){
                if (!animal.isFed()){
                    animal.addFriendship(-20);
                }if (!animal.isPettedToday()){
                    animal.addFriendship(animal.getFriendShip()/200 - 10);
                }if (!animal.isInside()){
                    animal.addFriendship(-20);
                }
            }
        }
    }
    public void ApplyChangeHour(){
        //TODO buff, time
        App.getCurrentGame().getTime().jumpAheadOneHour();
        if (App.getCurrentGame().getTime().isDayChanged()){
            ApplyChangeDay();
        }
    }
}
