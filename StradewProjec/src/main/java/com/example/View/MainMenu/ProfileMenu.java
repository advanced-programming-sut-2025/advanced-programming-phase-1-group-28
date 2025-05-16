package com.example.View.MainMenu;

import com.example.Controller.MainMenuController.ProfileMenuController;
import com.example.Controller.SignUpController;
import com.example.Model.App;
import com.example.Model.Enums.Rejex.ProfileMenuRejex;
import com.example.Model.Enums.Rejex.SignupMenuRejex;
import com.example.Model.User;
import com.example.View.Appview;

import java.util.regex.Matcher;

public class ProfileMenu {
    SignUpController signUpController = App.signUpController;
    ProfileMenuController profileMenuController = App.profileMenuController;
    Matcher matcher;

    
    public void Input(String command){
        if ((matcher = ProfileMenuRejex.ChangeUserName.getMatcher(command)) != null){
            ChangeUsername(matcher.group(1));
        }else if ((matcher = ProfileMenuRejex.ChangeNickName.getMatcher(command)) != null){
            ChangeNickname(matcher.group(1));
        } else if ((matcher = ProfileMenuRejex.ChangeEmail.getMatcher(command)) != null) {
            ChangeEmail(matcher.group(1));
        } else if ((matcher = ProfileMenuRejex.ChangePassword.getMatcher(command)) != null) {
            ChangePassword(matcher.group(1), matcher.group(2));
        } else if ((matcher = ProfileMenuRejex.Logout.getMatcher(command)) != null) {
            Logout();
        } else if((matcher = ProfileMenuRejex.ShowInfo.getMatcher(command)) != null) {
            ShowInfo();
        } else {
            System.out.println("invalid command");
        }
    }
    public void ChangeUsername(String NewUsername)
    {
        User currentUser = App.getCurrentUser();
        if (currentUser.getUsername().equals(NewUsername)){
            System.out.println("the username cannot be the same as current username!");
            return;
        }
        profileMenuController.ApplyChangeUsername(NewUsername);
        System.out.println("your username changed to " + NewUsername + " successfully");
    }
    public void ChangeNickname(String NewNickname)
    {
        User currentUser = App.getCurrentUser();
        if (currentUser.getNickname().equals(NewNickname)){
            System.out.println("the new nickname cannot be the same as current nickname");
            return;
        }
        profileMenuController.ApplyChangeNickname(NewNickname);
        System.out.println("your nickname changed to " + NewNickname + " successfully");
    }
    public void ChangePassword(String CurrentPassword ,String NewPassword)
    {
        User currentUser = App.getCurrentUser();
        if (!CurrentPassword.equals(currentUser.getPassword())){
            System.out.println("incorrect password!");
            return;
        } else if (CurrentPassword.equals(NewPassword)) {
            System.out.println("the new password cannot be the same as current password");
            return;
        } else if (App.signUpController.IsPasswordWeak(NewPassword)) {
            System.out.println("password is weak.");
            return;
        }
        profileMenuController.ApplyChangePassword(NewPassword);
        System.out.println("your password changed to " + NewPassword + " successfully");
    }
    public void ChangeEmail(String NewEmail)
    {
        User currentUser = App.getCurrentUser();
        if (NewEmail.equals(currentUser.getEmail())){
            System.out.println("the new email cannot be the same as current email");
            return;
        }
        profileMenuController.ApplyChangeEmail(NewEmail);
        System.out.println("your email changed to " + NewEmail + " successfully");
    }
    public void ShowInfo()
    {
        User TempUser = App.ReturnUser(Appview.UserLoggedInId);
        System.out.println("User Info:\n\n");
        System.out.println("username: " + TempUser.getUsername());
        System.out.println("nickname: " + TempUser.getNickname());
        System.out.println("highest score: " + TempUser.getHighestScore());
        System.out.println("games played: " + TempUser.getGamesPlayed());
        //Print Info
    }

    public void Logout(){
        profileMenuController.ApplyLogout();
        System.out.println("You logged out successfully.");
    }

}
