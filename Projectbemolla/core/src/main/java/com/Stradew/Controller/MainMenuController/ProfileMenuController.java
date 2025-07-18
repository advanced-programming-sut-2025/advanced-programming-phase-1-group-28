package com.Stradew.Controller.MainMenuController;

import com.Stradew.Model.App;
import com.Stradew.Model.Enums.MenuName;
import com.Stradew.Model.User;
import com.Stradew.View.Appview;
import com.Stradew.View.MainMenu.ProfileMenu;

public class ProfileMenuController {
    ProfileMenu profileMenu;

    public void setProfileMenu(ProfileMenu profileMenu) {
        this.profileMenu = profileMenu;
    }

    public void ApplyChangeUsername(String NewUserName) {
        User myUser = App.getCurrentUser();
        myUser.setUsername(NewUserName);
    }
    public void ApplyChangeEmail(String NewEmail) {
        User myUser = App.getCurrentUser();
        myUser.setEmail(NewEmail);
    }
    public void ApplyChangePassword(String NewPassword) {
        User myUser = App.getCurrentUser();
        myUser.setPassword(NewPassword);
    }
    public void ApplyChangeNickname(String NewNickname) {
        User myUser = App.getCurrentUser();
        myUser.setNickname(NewNickname);
    }

    public void ApplyLogout(){
        Appview.UserLoggedInId = -1;
        Appview.Situation = MenuName.SignUpMenu;
    }
}
