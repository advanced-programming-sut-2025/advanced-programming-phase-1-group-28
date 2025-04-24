package Model.Enums.Rejex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginMenuRejex {
    Login("^login\\s+-u\\s+(.+)\\s+-p\\s+(.+)( –stay-logged-in)?$"),
    ForgetPassword("^forget\\s+password\\s+-u\\s+(.+)$"),
    AnswerSecQuestion("^answer\\s+-a\\s+(.+)$")
    ;


    public String command;
    LoginMenuRejex(String command) {
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
