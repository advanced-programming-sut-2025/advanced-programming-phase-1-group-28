package com.example.Model;

import com.example.Model.Enums.*;
import com.example.Model.Item.Food;
import com.example.Model.Item.Ingredient;
import com.example.Model.Item.Item;
import com.example.Model.Item.MineralItem;
import com.example.Model.Tile.Tile;
import com.example.Model.Tools.Pepolee;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private FriendShip[][] FriendShips = new FriendShip[100][100];//0-3 peeplee , 4-8 npc
    private ArrayList<User> PlayersInGame = new ArrayList<>();
    private ArrayList<Pepolee> CharactersInGame = new ArrayList<>();
    private int ID;
    private Time Time = new Time();
    private ArrayList<Integer> Scores = new ArrayList<>();
    private int WhoseTurn = 0;
    private Weathers Weather = Weathers.SUNNY;
    private ArrayList<Npc> GameNPCs = new ArrayList<>();

    private Tile[][] EntireMap = new Tile[200][200];

    {
        for (int i = 0; i<10; i++){
            for (int j = 0; j<10; j++){
                FriendShips[i][j] = new FriendShip();
            }
        }
        // initialize sebastian
        GameNPCs.add(new Npc(4 , "Sebastian" , "Singer" , new ArrayList<String>(Arrays.asList("City of Stars")) ,
                new ArrayList<Item>(Arrays.asList(new Food(1 , Foods.Pizza) , new Food(1 , Foods.PumpkinPie) , new Ingredient(1 , Ingredients.SheepCotton) , new Ingredient(1 , Ingredients.RabbitWool))) ,
                new ArrayList<Quest>(Arrays.asList(new Quest(new Item(50 , "Iron Bar") , new Reward(0 , new MineralItem(2 , Minerals.Diamond) , 0 , null , null , null)),
                        new Quest(new Food(1 , Foods.PumpkinPie) , new Reward(5000 , null , 0 , null , null , null)) ,
                        new Quest(new Item(150 , "Stone") , new Reward(0 , new MineralItem(50 , Minerals.Quartz) , 0 , null , null , null)))) ,
                60 , 60));
    }
    private void InitializeMap() {
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                EntireMap[i][j] = new Tile(DetermineTerrain(i , j),
                        DeterminePlaceType(i , j),
                        DetermineEntitity(i , j));
            }
        }
    }

    private Terrain DetermineTerrain(int x, int y) {
        if(x < 40 && y < 40) {
            return Terrain.GRASS;
        }
        if(x < 40 && y >= 160) {
            return Terrain.GRASS;
        }
        if(x >= 160 && y < 40) {
            return Terrain.GRASS;
        }
        if(x >= 160 && y >= 160)
        {
            return Terrain.GRASS;
        }
        return Terrain.DIRT;
    }

    private PlaceType DeterminePlaceType(int x, int y) {
        if(x < 40 && y < 40) {
            return PlaceType.FARM;
        }
        if(x < 40 && y >= 160) {
            return PlaceType.FARM;
        }
        if(x >= 160 && y < 40) {
            return PlaceType.FARM;
        }
        if(x >= 160 && y >= 160)
        {
            return PlaceType.FARM;
        }
        return PlaceType.VILLAGE;
    }

    private Entitity DetermineEntitity(int x, int y) {
        if((x >= 40 && x < 160) != (y >= 40 && y < 160)){
            return Entitity.STONE;
        }
        return Entitity.EMPTY;
    }

    public Game(int ID) {
        this.ID = ID;
    }

    public FriendShip[][] getFriendShips() {
        return FriendShips;
    }

    public void setFriendShips(FriendShip[][] friendShips) {
        FriendShips = friendShips;
    }

    public ArrayList<User> getPlayersInGame() {
        return PlayersInGame;
    }

    public void setPlayersInGame(ArrayList<User> playersInGame) {
        PlayersInGame = playersInGame;
    }

    public ArrayList<Pepolee> getCharactersInGame() {
        return CharactersInGame;
    }

    public void setCharactersInGame(ArrayList<Pepolee> charactersInGame) {
        CharactersInGame = charactersInGame;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public com.example.Model.Time getTime() {
        return Time;
    }

    public void setTime(com.example.Model.Time time) {
        Time = time;
    }

    public ArrayList<Integer> getScores() {
        return Scores;
    }

    public void setScores(ArrayList<Integer> scores) {
        Scores = scores;
    }

    public int getWhoseTurn() {
        return WhoseTurn;
    }

    public void setWhoseTurn(int whoseTurn) {
        WhoseTurn = whoseTurn;
    }

    public Weathers getWeather() {
        return Weather;
    }

    public void setWeather(Weathers weather) {
        Weather = weather;
    }

    public int getPlayerIDByUsername(String username){
        int i = 0;
        for (User user: PlayersInGame){
            if (user.getUsername().equals(username)){
                return i;
            }
            i++;
        }
        return -1; // player not found
    }

    public Pepolee getPlayerByID(int id){
        return CharactersInGame.get(id);
    }

    public Pepolee getPlayerByUsername(String username){
        return this.getPlayerByID(getPlayerIDByUsername(username));
    }

    public FriendShip getFriedShipBetweenPlayers(String firstUsername, String secondUsername){
        int firstPlayerId = this.getPlayerIDByUsername(firstUsername);
        int secondPlayerId = this.getPlayerIDByUsername(secondUsername);
        return FriendShips[firstPlayerId][secondPlayerId];
    }

    public Tile[][] getEntireMap() {
        return EntireMap;
    }

    public void setEntireMap(Tile[][] entireMap) {
        EntireMap = entireMap;
    }

    //Boolean IsEnd = false;


}