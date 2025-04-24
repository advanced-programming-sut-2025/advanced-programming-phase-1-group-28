package com.example.Controller.MainMenuController;

import com.example.Model.App;
import com.example.Model.User;

public class ProfileMenuController {
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
}
