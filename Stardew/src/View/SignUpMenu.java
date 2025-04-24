package View;

import Controller.SignUpController;
import Model.App;
import Model.Enums.Rejex.ForAllmenuRejex;
import Model.Enums.Rejex.SignupMenuRejex;

import java.util.regex.Matcher;

public class SignUpMenu {
    SignUpController signUpController = App.signUpController;
    Matcher matcher;
    public void Input(String Command)
    {
        if((matcher = SignupMenuRejex.Register.getMatcher(Command)) != null)
        {
            // here we go to register menu controller
        }
        else if((matcher = SignupMenuRejex.PickQuestion.getMatcher(Command)) != null)
        {
            // here we pick security question in controller
        }
        else
        {
            System.out.println("Invalid command");
            // invalid command
        }
    }
    public void SignUp(String Username , String Password , String ConfirmPassword , String NickName ,  String Email , String Gender) {
        //if password == Random ...
        //print Security
    }

}