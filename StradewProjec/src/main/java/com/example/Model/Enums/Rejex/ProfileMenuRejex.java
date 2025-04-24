package com.example.Model.Enums.Rejex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ProfileMenuRejex {
    ChangeUserName("^change\\s+username\\s+-u\\s+(.+)$"),
    ChangeNickName("^change\\s+nickname\\s+-u\\s+(.+)$"),
    ChangeEmail("^change\\s+email\\s+-e\\s+(.+)$"),
    ChangePassword("^change\\s+password\\s+-p\\s+(.+)\\s+-o\\s+(.+)$");
    public String Command;
    ProfileMenuRejex(String command)
    {
        this.Command = command;
    }
    public Matcher getMatcher(String line)
    {
        Matcher matcher = Pattern.compile(this.Command).matcher(line);
        if(matcher.matches())
        {
            return matcher;
        }
        return null;
    }
}
