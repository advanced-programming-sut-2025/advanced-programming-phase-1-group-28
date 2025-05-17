package com.example.Model;

import com.example.Model.Enums.DayOfWeek;
import com.example.Model.Enums.Season;

public class Time {
    // if in continiue we accses this randoms
    // int Rand Sunny .....
    private int year = 0;
    private int month = 1;
    private int day = 1;
    private int hour = 9;
    private Season season = Season.SPRING;
    private DayOfWeek dayOfWeek = DayOfWeek.TUESDAY;
    private Game game;
    private boolean isDayChanged = false;


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
    //--------------------------------------------- update time

    public Time DifreenceTime(Time time1) {
        int thisTotalHours = this.year * 4 * 28 * 24 + this.month * 28 * 24 + this.day * 24 + this.hour;
        int otherTotalHours = time1.year * 4 * 28 * 24 + time1.month * 28 * 24 + time1.day * 24 + time1.hour;

        int resultTotalHours = otherTotalHours - thisTotalHours;

        Time result = new Time();
        result.setYear(resultTotalHours / (4 * 28 * 24));
        resultTotalHours %= 4 * 28 * 24;
        result.setMonth(resultTotalHours / (28 * 24));
        resultTotalHours %= 28 * 24;
        result.setDay(resultTotalHours / 24);
        resultTotalHours %= 24;
        result.setHour(resultTotalHours);


        if (result.month == 1){
            result.setSeason(Season.SPRING);
        } else if (result.month == 2) {
            result.setSeason(Season.SUMMER);
        } else if (result.month == 3) {
            result.setSeason(Season.FALL);
        }else {
            result.setSeason(Season.WINTER);
        }
        return result;
    }

    public void jumpAheadOneHour(){
        isDayChanged = false;
        hour += 1;
        if (hour == 24){
            hour = 0;
            jumpAheadOneDay();
        }
    }

    public void jumpAheadOneDay(){
        day += 1;
        isDayChanged = true;

        int nextDayOrdinal = (dayOfWeek.ordinal() + 1) % DayOfWeek.values().length;
        dayOfWeek = DayOfWeek.values()[nextDayOrdinal];

        if (day > 28) {
            day = 1;
            jumpAheadOneMonth();
        }

        //-------------------------------
    }


    public void jumpAheadOneMonth(){
        month += 1;
        if (month == 5){
            month = 1;
            jumpAheadOneYear();
        }
        if (month == 1){
            season = Season.SPRING;
        }else if (month == 2){
            season = Season.SUMMER;
        } else if (month == 3) {
            season = Season.FALL;
        } else if (month == 4) {
            season = Season.WINTER;
        }
    }

    public void jumpAheadOneYear(){
        year += 1;
    }

    //-------------------------------------ShowDayOfWeek, showHour, showDate, showDateTime, showSeason

    public String ShowDayOfWeek()
    {
        return dayOfWeek.name();
    }

    public String showHour(){
        if (hour <= 12){
            return String.format("%d.A.M", hour);
        }else {
            return String.format("%d.P.M", (hour % 12));
        }
    }

    public String showDate(){
        return String.format("%d,%d,%d", year, month, day);
    }

    public String showDateTime(){
        return String.format("%s %s", this.showDate(), this.showHour());
    }

    //------------------------------------------------------setter and getters

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

    public boolean isDayChanged() {
        return isDayChanged;
    }

    public void setDayChanged(boolean dayChanged) {
        isDayChanged = dayChanged;
    }

    public Time getCopy(){
        Time time = new Time();
        time.setSeason(season);
        time.setHour(hour);
        time.setDay(day);
        time.setYear(year);
        time.setMonth(month);
        time.setDayOfWeek(dayOfWeek);
        time.setGame(game);
        time.setDayChanged(isDayChanged);
        return time;
    }
}
