package com.example.View;

import com.example.Model.App;
import com.example.Model.Enums.MenuName;
import com.example.Model.Enums.Rejex.ForAllmenuRejex;
import com.example.Model.Enums.Rejex.SignupMenuRejex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;

public class AppInputCommand {
    public boolean InputCommands()
    {
        String Command = App.scanner.nextLine();
        Command = Command.trim();
        Matcher matcher;
        //All Menus
        if((matcher = ForAllmenuRejex.GoTOMenu.getMatcher(Command)) != null)
        {
            if(matcher.group(1).equals(MenuName.LoginMenu.name()))
            {
                Appview.Situation = MenuName.LoginMenu;
            }
            if(matcher.group(1).equals(MenuName.SignUpMenu.name()))
            {
                Appview.Situation = MenuName.SignUpMenu;
            }
            if(matcher.group(1).trim().equals(MenuName.ProfileMenu.Name))
            {
                if(Appview.Situation == MenuName.MainMenu)
                {
                    Appview.Situation = MenuName.ProfileMenu;
                }
                else
                {
                    System.out.println("first go to the Main menu");
                }
            }
            if(matcher.group(1).trim().equals(MenuName.GameMenu.name()))
            {
                if(Appview.Situation == MenuName.MainMenu)
                {
                    Appview.Situation = MenuName.GameMenu;
                    return true;
                }
                System.out.println("first go to the mainmenu");
            }
            return true;
        }
        if((matcher = ForAllmenuRejex.ExitMenu.getMatcher(Command)) != null)
        {
            if(Appview.Situation == MenuName.LoginMenu || Appview.Situation == MenuName.SignUpMenu)
            {
                return false;
            }
            else
            {
                Appview.Situation = MenuName.LoginMenu;
            }
            return true;
        }
        if((matcher = ForAllmenuRejex.ShowCurrentMenu.getMatcher(Command)) != null)
        {
            System.out.println(Appview.Situation.Name);
            return true;
        }
        //
        if(Appview.Situation == MenuName.SignUpMenu)
        {
            App.signUpMenu.Input(Command);
            return true;
        }
        if(Appview.Situation == MenuName.LoginMenu)
        {
            App.loginMenu.Input(Command);
            return true;
        }
        if(Appview.Situation == MenuName.ProfileMenu)
        {
            App.profileMenu.Input(Command);
            return true;
        }
        if(Appview.Situation == MenuName.GameMenu)
        {
            App.gameMenu.Input(Command);
            return true;
        }
        return true;
    }
}
