package Controller;

import Model.Enums.Rejex.SignupMenuRejex;

import java.util.regex.Matcher;

public class SignUpController {
    public boolean IsUsernameValid(String Username)
    {
        Matcher UserMatcher = SignupMenuRejex.ValidUser.Rejex.matcher(Username);
        return UserMatcher.matches();
    }
    public boolean IsUsernameTaken(String Username)
    {
        return true;
    }
    public boolean IsEmailValid(String Email)
    {
        Matcher EmailMatcher = SignupMenuRejex.ValidEmail.Rejex.matcher(Email);
        return EmailMatcher.matches();
    }
    public boolean IsPassValid(String Password)
    {
        return true;
    }
    public boolean CheckPasswordEquality(String Password1 , String Password2)
    {
        return true;
    }
    public String RandomPassword()
    {
        return "mamad";
    }
    public void ShowSecurityQuestions()
    {

    }
    public void ApplySignUp(String Username , String Password , String Email , String Answer , int QuestionId)
    {

    }
    public String HashCodeEncrypt(String password)
    {
        return "mamad";
    }

}

