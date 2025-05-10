package com.example.Model.Enums.Rejex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ForAllmenuRejex {
    ShowCurrentMenu("^show\\s+current\\s+menu$"),
    GoTOMenu("^menu\\s+enter\\s+(.+)$"),
    ExitMenu("^exit\\s+menu$");
    public String command;
    ForAllmenuRejex(String command) {
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
