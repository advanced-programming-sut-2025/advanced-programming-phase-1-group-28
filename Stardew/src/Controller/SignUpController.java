package Controller;

import Model.App;
import Model.Enums.Rejex.SignupMenuRejex;
import Model.Enums.SecurityQuestions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpController {
    public boolean IsUsernameValid(String Username)
    {
        Matcher UserMatcher = SignupMenuRejex.ValidUser.getMatcher(Username);
        return  UserMatcher != null;
    }

    public boolean IsUsernameTaken(String Username)
    {
        return true;
    }

    public boolean IsEmailValid(String Email)
    {
        Matcher EmailMatcher = SignupMenuRejex.ValidEmail.getMatcher(Email);
        return EmailMatcher != null;
    }

    public boolean IsPassValid(String Password)
    {
        Matcher matcher = SignupMenuRejex.ValidPassword.getMatcher(Password);
        return matcher != null;
    }

    public boolean IsPasswordWeak(String Password)
    {
        if(Password.length() < 8)
        {
            return false;
        }
        String SpecialCharacters = "?><,\"';:\\/|][}{+=)(*&^%$#!";
        Boolean Cap = false , Lower =false , Number = false , Symbol = false ;
        for(int i = 0; i < Password.length(); i++)
        {
            for (int j = 0; j < SpecialCharacters.length(); j++)
            {
                if(Password.charAt(i) == SpecialCharacters.charAt(j))
                {
                    Symbol = true;
                }
            }
            int AsciIndex = Password.charAt(i);
            if(AsciIndex >= 65 && AsciIndex <= 90)
            {
                Cap = true;
            }
            if(AsciIndex >= 97 && AsciIndex <= 122)
            {
                Lower = true;
            }
            if(AsciIndex >= 48 && AsciIndex <= 57)
            {
                Number = true;
            }
        }
        return Cap && Lower && Number && Symbol;
    }

    public boolean CheckPasswordEquality(String Password1 , String Password2)
    {
        return Password1.equals(Password2);
    }

    public String RandomPassword()
    {
        while(true) {
            String SpecialCharacters = "?><,\"';:\\/|][}{+=)(*&^%$#!";
            String Numbers = "1234567890";
            String Caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String Lower = "abcdefghijklmnopqrstuvwxyz";
            int RandomPasswordLength = (App.random.nextInt() % 4) + 8;
            char[] RandomPassword = new char[RandomPasswordLength];
            for (int i = 0; i < RandomPasswordLength; i++) {
                int RandomType = App.random.nextInt() % 4;
                if (RandomType == 0) {
                    RandomPassword[i] = SpecialCharacters.charAt((App.random.nextInt() % SpecialCharacters.length()));
                }
                if (RandomType == 1) {
                    RandomPassword[i] = Numbers.charAt((App.random.nextInt() % Numbers.length()));
                }
                if (RandomType == 2) {
                    RandomPassword[i] = Caps.charAt((App.random.nextInt() % Caps.length()));
                }
                if (RandomType == 3) {
                    RandomPassword[i] = Lower.charAt((App.random.nextInt() % Lower.length()));
                }
            }
            String modified = new String(RandomPassword);
            if(IsPasswordWeak(modified))
            {
                return modified;
            }
        }
    }

    public void ShowSecurityQuestions()
    {
        for(SecurityQuestions question : SecurityQuestions.values())
        {
            System.out.println(question.QuestionName);
        }
    }

    public void ApplySignUp(String Username , String Password , String Email , String Answer , int QuestionId)
    {

    }

    public String HashCodeEncrypt(String password)
    {
        return "mamad";
    }
}

