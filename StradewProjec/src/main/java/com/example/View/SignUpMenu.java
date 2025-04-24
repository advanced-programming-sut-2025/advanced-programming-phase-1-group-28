package com.example.View;

import com.example.Controller.SignUpController;
import com.example.Model.App;
import com.example.Model.Enums.Rejex.SignupMenuRejex;

import java.util.regex.Matcher;

public class SignUpMenu {
    SignUpController signUpController = App.signUpController;
    Matcher matcher;
    public void Input(String Command)
    {
        if((matcher = SignupMenuRejex.Register.getMatcher(Command)) != null)
        {
            SignUp(matcher.group(1).trim() , matcher.group(2).trim() , matcher.group(3).trim() , matcher.group(4).trim()
            , matcher.group(5).trim() , matcher.group(6).trim());
        }
        else if((matcher = SignupMenuRejex.PickQuestion.getMatcher(Command)) != null)
        {
            // go to sec questions
        }
        else
        {
            System.out.println("Invalid command");
        }
    }
    public void SignUp(String Username , String Password , String ConfirmPassword , String NickName ,  String Email , String Gender) {
        if(App.signUpController.IsUsernameTaken(Username))
        {
            System.out.println("Username is taken");
            return;
        }
        if(!App.signUpController.IsUsernameValid(Username))
        {
            System.out.println("Username is not valid");
            return;
        }
        if(!App.signUpController.IsEmailValid(Email))
        {
            System.out.println("Email is not valid");
            return;
        }
        if(!App.signUpController.IsPassValid(Password))
        {
            System.out.println("Password is not valid");
            return;
        }
        if(!App.signUpController.IsPasswordWeak(Password))
        {
            System.out.println("Password is weak");
            return;
        }
        if(!App.signUpController.CheckPasswordEquality(ConfirmPassword, Password))
        {
            System.out.println("Password confirm does not match");
            return;
        }
        if(Password.equals("Random"))
        {
            Password = App.signUpController.RandomPassword();
            return;
        }
        App.signUpController.ApplySignUp(Username , Password , NickName , Email , Gender);
        //if password == Random ...
        //print Security
    }
    public void PickQuestion() {
        //
    }

}