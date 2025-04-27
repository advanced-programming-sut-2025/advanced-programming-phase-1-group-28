package com.example.Model.Enums.Rejex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuRejex {
    StartGame("game new -u(?:\\s+(\\w+)){1,3}"),
    ShowTime("^time$"),
    ShowDate("^date$"),
    ShowDateTime("^datetime$"),
    ShowDayOfWeek("^day\\s+of\\s+the\\s+week"),
    CheatAdvanceTime("^cheat\\s+advance\\s+time\\s+(\\d+)h"),
    CheatAdvanceDate("^cheat\\s+advance\\s+date\\s+(\\d+)d"),
    ShowSeason("^season$"),
    CheatThor("^cheat\\s+Thor\\s+-l\\s+(\\d),(\\d)"),
    ShowWeather("^weather$"),
    WeatherForecast("^weather\\s+forecast"),
    CheatWeatherSet("^cheat\\s+weather\\s+set\\s+(.+)"),
    Walk("^walk\\s+-l\\s+(\\d+),(\\d+)"),
    PrintMap("^print\\s+map\\s+-l\\s+(\\d+),(\\d+)\\s+-s\\s+(\\d+)"),
    HelpReadingMap("^help\\s+reading\\s+map"),
    EnergyShow("^energy\\s+show"),
    EnergySet("^energy\\s+set\\s+-v\\s+(\\d+)"),
    EnergyUnlimited("^energy\\s+unlimited"),
    InventoryShow("^inventory\\s+show"),
    InventoryTrash("^inventory\\s+trash\\s+-i\\s+(.+)\\s+-n\\s+(\\d+)");
    public String command;
    GameMenuRejex(String command) {
        this.command = command;
    }

    public Matcher getMatcher(String line) {
        Matcher matcher = Pattern.compile(command).matcher(line);
        if(matcher.matches())
        {
            return matcher;
        }
        return null;
    }
}
