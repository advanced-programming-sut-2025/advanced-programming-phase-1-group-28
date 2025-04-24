package Model;

import Model.Tools.Pepolee;

import java.util.ArrayList;

public class Game {
    public FriendShip[][] FriendShips = new FriendShip[100][100];
    ArrayList<User> PlayersInGame = new ArrayList<>();
    ArrayList<Pepolee> CharactersInGame = new ArrayList<>();
    public int ID;
    public Time Time;
    public ArrayList<Integer> Scores = new ArrayList<>();
    public int WhoseTurn = 0;
    Weather Weather = new Weather();
    //Boolean IsEnd = false;
}
