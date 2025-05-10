package com.example.Controller;

import com.example.Model.App;
import com.example.Model.Enums.MenuName;
import com.example.Model.Enums.Rejex.SignupMenuRejex;
import com.example.Model.Enums.SecurityQuestions;
import com.example.Model.User;
import com.example.View.Appview;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class SignUpController {
    public boolean IsUsernameValid(String Username)
    {
        Matcher UserMatcher = SignupMenuRejex.ValidUser.getMatcher(Username);
        return  UserMatcher != null;
    }

    public boolean IsUsernameTaken(String Username)
    {
        for(int i = 0;i < App.Users.size(); i++)
        {
            if(App.Users.get(i).getUsername().equals(Username))
            {
                return true;
            }
        }
        return false;
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

    public ArrayList<String> ShowSecurityQuestions()
    {
        ArrayList<String> Output = new ArrayList<>();
        for(SecurityQuestions question : SecurityQuestions.values())
        {
            Output.add(question.QuestionName);
        }
        return Output;
    }

    public String SetQuestion(int QuestionId , String Answer , String ConfirmAnswer)
    {
        if(QuestionId > SecurityQuestions.values().length)
        {
            return "Invalid Security Question Index";
        }
        if(!Answer.equals(ConfirmAnswer))
        {
            return "Invalid Confirm Answer";
        }
        QuestionId--;
        App.Users.get(Appview.getUserLoggedInId()).setAnswerIdQuestion(QuestionId);
        App.Users.get(Appview.getUserLoggedInId()).setAnswer(Answer.trim());
        return "Answer Submit Successful";
    }

    public String ShowQuestion(String Username)
    {
        int Userid  = App.ReturnUserIndex(Username);
        int count = 1;
        for(SecurityQuestions question : SecurityQuestions.values())
        {
            if(count == App.Users.get(Userid).getAnswerIdQuestion())
            {
                return question.QuestionName;
            }
            count++;
        }
        return null;
    }

    public void ApplySignUp(String Username , String Password , String NickName , String  Email , String Gender)
    {
        String HashedPassword = HashAlghorithm.DecryptPassword(Password);
        User newuser = new User(Username , Password , HashedPassword , Email , App.Users.size() , NickName , Gender);
        App.Users.add(newuser);
        Appview.UserLoggedInId = App.Users.size() - 1;
        Appview.Situation = MenuName.LoginMenu;
    }
}

