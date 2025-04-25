package com.example.Controller.MainMenuController;

import com.example.Model.App;
import com.example.Model.Enums.ConstantFarms;
import com.example.Model.Game;
import com.example.Model.Tools.Pepolee;
import com.example.Model.User;
import com.example.View.Appview;

import java.util.ArrayList;

public class GameMenuController {
    public void ApplyPlayersToGame(ArrayList<String> PlayersInGame)
    {
        Game newgame = new Game(App.Games.size());
        ArrayList<User> players = new ArrayList<User>();
        for(int i = 0; i < PlayersInGame.size() ; i++)
        {
            int Userindex = App.ReturnUserIndex(PlayersInGame.get(i));
            players.add(App.Users.get(Userindex));
        }
        for(int i = 0; i < PlayersInGame.size(); i++)
        {
            newgame.setPlayersInGame(players);
        }
        ArrayList<Pepolee> Characters = new ArrayList<>();
        for(int i = 0;i < PlayersInGame.size() ; i++)
        {
            Pepolee NewPeople = new Pepolee();
            NewPeople.setCharacterUser(players.get(i));
            NewPeople.setId(i);
            Characters.add(NewPeople);
        }
        newgame.setCharactersInGame(Characters);
        for(int i = 0;i < PlayersInGame.size(); i++)
        {
            newgame.getScores().set(i , 0);
        }
        for(int i = 0;i < players.size();i++)
        {
            players.get(i).setGameId(newgame.getID());
        }
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
        App.Games.get(Appview.CurrentGameID).getCharactersInGame().get(Id).setFarm(ReturnFarm(FarmID).farm);
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
    public void ApplyChangeDay()
    {
        //use above function
        //USer random Foraging
    }
}
