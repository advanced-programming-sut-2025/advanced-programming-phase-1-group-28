package com.example.View.MainMenu;

import com.example.Controller.MainMenuController.ProfileMenuController;
import com.example.Controller.SignUpController;
import com.example.Model.App;
import com.example.Model.User;
import com.example.View.Appview;

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
