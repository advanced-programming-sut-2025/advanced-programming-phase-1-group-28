package com.example.View;

import com.example.Controller.LoginController;
import com.example.Controller.SignUpController;
import com.example.Model.App;
import com.example.Model.Enums.Rejex.LoginMenuRejex;
import com.example.Model.User;

import java.util.regex.Matcher;

public class LoginMenu {
    LoginController loginController = App.loginController;
    SignUpController signUpController = App.signUpController;
    Matcher matcher;
    public void Input(String Command)
    {
        if((matcher = LoginMenuRejex.Login.getMatcher(Command)) != null)
        {
            Login(matcher.group(1).trim() , matcher.group(2).trim() , matcher.group(3));
        }
        else if((matcher = LoginMenuRejex.ForgetPassword.getMatcher(Command)) != null)
        {
            ForgotPassword(matcher.group(1).trim());
        }
        else
        {
            System.out.println("invalid command");
        }
    }
    public void Login(String UserName, String Password , String StayLoggedIn) {
        if(!App.loginController.IsUsernameValid(UserName))
        {
            System.out.println("Username Does Not Exist");
            return;
        }
        if(!App.loginController.CheckPassword(UserName , Password))
        {
            System.out.println("Password Does Not Match");
            return;
        }
        boolean Stay = false;
        if(StayLoggedIn != null)
        {
            Stay = true;
        }
        App.loginController.ApplyLogin(UserName , Stay);
        System.out.println("Login Successful");
    }

    public void  ForgotPassword(String UserName) {
        if(!App.loginController.IsUsernameValid(UserName)) {
            System.out.println("Username Does Not Exist");
        }
        App.loginController.PrintQuestion(UserName);
        while(true)
        {
            String AnswerGet = App.scanner.nextLine();
            if((matcher = LoginMenuRejex.AnswerSecQuestion.getMatcher(AnswerGet)) != null) {
                if (App.loginController.CheckAnswer(UserName , AnswerGet))
                {
                    System.out.println("enter your New Password");
                    String NewPassword = App.scanner.nextLine();
                    if(NewPassword.equals("Random"))
                    {
                        NewPassword = App.signUpController.RandomPassword();
                    }
                    App.loginController.ApplyChangePassword(UserName , NewPassword);
                    break;
                }
                else
                {
                    System.out.println("Answer Doesnt Match");
                }
            }
            else
            {
                System.out.println("Please enter valid Command");
            }
        }
    }

}
