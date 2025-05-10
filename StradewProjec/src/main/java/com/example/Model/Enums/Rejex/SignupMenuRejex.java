package com.example.Model.Enums.Rejex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum SignupMenuRejex {
    Register("^register\\s+-u\\s+(.+)\\s+-p\\s+(.+)\\s+(.+)\\s+-n\\s+(.+)\\s+-e\\s+(.+)\\s+-g\\s+(male|female)$"),
    ValidUser("^[a-zA-Z0-9-]+$"),
    ValidEmail("^(?![._-])[a-zA-Z0-9._-]+(?<![._-])@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*\\.(?:org|com|net)$"),
    ValidPassword("^[a-zA-Z0-9?><#]+"),
    WeakMail("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[?><,\\\\\\\"';:\\\\\\\\\\\\/|\\\\]\\\\[\\\\}\\\\{\\\\+=\\\\)\\\\(\\\\*&\\\\^%\\\\$#!]).{8,}$"),
    PickQuestion("^pick\\s+question\\s+-q\\s+(.+)\\s+-a\\s+(.+)\\s+-c\\s+(.+)")
    ;


    public String command;
    SignupMenuRejex(String command) {
        this.command = command;
    }
    public Matcher getMatcher(String line) {
        Matcher matcher = Pattern.compile(this.command).matcher(line);
        if(matcher.matches())
        {
            return matcher;
        }
        return null;
    }
}
