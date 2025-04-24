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
            // go to Sign Up Menu Controller
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
        //if password == Random ...
        //print Security
    }
    public void PickQuestion() {
        //
    }

}