package com.example.Model;

import com.example.Model.Enums.Weathers;
import com.example.Model.Tools.Pepolee;

import java.util.ArrayList;

public class Game {
    private FriendShip[][] FriendShips = new FriendShip[100][100];
    private ArrayList<User> PlayersInGame = new ArrayList<>();
    private ArrayList<Pepolee> CharactersInGame = new ArrayList<>();
    private int ID;
    private Time Time;
    private ArrayList<Integer> Scores = new ArrayList<>();
    private int WhoseTurn = 0;
    private Weathers Weather;

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

    //Boolean IsEnd = false;
}
