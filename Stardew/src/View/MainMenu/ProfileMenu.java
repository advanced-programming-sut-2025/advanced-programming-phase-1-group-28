package View.MainMenu;

import Controller.MainMenuController.ProfileMenuController;
import Controller.SignUpController;
import Model.App;
import Model.User;
import View.Appview;

public class ProfileMenu {
    SignUpController signUpController = App.signUpController;
    ProfileMenuController profileMenuController = App.profileMenuController;
    public void ChangeUsername(String NewUsername)
    {

    }
    public void ChangeNickname(String NewNickname)
    {

    }
    public void ChangePassword(String CurrentPassword ,String NewPassword)
    {

    }
    public void ChangeEmail(String NewEmail)
    {

    }
    public void ShowInfo()
    {
        User TempUser = App.ReturnUser(Appview.UserLoggedInId);
        //Print Info
    }

}
