package Model;

import Model.Enums.DayOfWeek;
import Model.Enums.Season;

public class Time {
    // if in continiue we accses this randoms
    // int Rand Sunny .....
    private int year;
    private int month;
    private int day;
    private int hour;
    private Season season = Season.SPRING;
    private DayOfWeek dayOfWeek = DayOfWeek.TUESDAY;
    private Game game;

    public Time() {
    }

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
