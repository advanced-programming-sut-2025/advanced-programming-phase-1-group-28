package View;

import Controller.SignUpController;
import Model.App;
import Model.Enums.Rejex.ForAllmenuRejex;
import Model.Enums.Rejex.SignupMenuRejex;

import java.util.regex.Matcher;

public class SignUpMenu {
    SignUpController signUpController = App.signUpController;
    public boolean Input(String Command)
    {
        Matcher ShowCurrentMenu = ForAllmenuRejex.ShowCurrentMenu.Rejex.matcher(Command);
        Matcher GotoMenu = ForAllmenuRejex.GoTOMenu.Rejex.matcher(Command);
        if(ShowCurrentMenu.matches())
        {
            System.out.println(App.allMenuCommandsController.ShowCurrentMenu());
        }
        if(GotoMenu.matches())
        {
            if(App.allMenuCommandsController.Returnmenuname(GotoMenu.group(1).trim()) == null)
            {
                System.out.println("Enter Valid Menu");
            }
            System.out.println(App.allMenuCommandsController.GoToMenu(App.allMenuCommandsController.Returnmenuname(GotoMenu.group(1).trim())));
        }
        return true;
    }
    public void SignUp(String Username , String Password , String ConfirmPassword , String NickName ,  String Email , String Gender) {
        //if password == Random ...
        //print Security
    }

}