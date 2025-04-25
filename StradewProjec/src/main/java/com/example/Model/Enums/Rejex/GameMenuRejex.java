package com.example.Model.Enums.Rejex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuRejex {
    StartGame("game new -u(?:\\s+(\\w+)){1,3}");
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
