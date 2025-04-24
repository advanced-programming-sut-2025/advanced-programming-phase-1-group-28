package View;

import Controller.LoginController;
import Controller.SignUpController;
import Model.App;
import Model.Enums.Rejex.LoginMenuRejex;

import java.util.regex.Matcher;

public class LoginMenu {
    LoginController loginController = App.loginController;
    SignUpController signUpController = App.signUpController;
    Matcher matcher;
    public void Input(String Command)
    {
        if((matcher = LoginMenuRejex.Login.getMatcher(Command)) != null)
        {
            // here we log in
        }
        else if((matcher = LoginMenuRejex.ForgetPassword.getMatcher(Command)) != null)
        {

        }
        else if((matcher = LoginMenuRejex.AnswerSecQuestion.getMatcher(Command)) != null)
        {
            // here the user enters his answer to the sec question
        }
        else
        {
            System.out.println("invalid command");
        }
    }
    public void Login(String UserName, String Password , boolean StayLoggedIn) {

    }
    public void  ForgotPassword(String UserName) {
        //IF OK output please enter newpassword
    }
}
