package Model;

import Model.Enums.DayOfWeek;
import Model.Enums.Season;

public class Time {
    // if in continiue we accses this randoms
    // int Rand Sunny .....
    public int year;
    public int month;
    public int day;
    public int hour;
    public Season season = Season.SPRING;
    public DayOfWeek dayOfWeek = DayOfWeek.TUESDAY;
    public Game game;
    public void UpdateChangingDay()
    {

    }
    public void UpdateTime()
    {
        //Change Days , Months and ...
        //Randomize weather with game
        //App.Games.get(Appview.GameId).Wheather =....
        //game in class randomize weather
        //if Day Change call function UpdateChanges
        //if Day changes as GameController Apply changing Day
    }
    public String ShowDayOfWeek()
    {
        return "mamad";
    }
}
