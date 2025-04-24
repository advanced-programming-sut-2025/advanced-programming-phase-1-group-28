package com.example.View;

import com.example.Model.App;
import com.example.Model.Enums.MenuName;

public class AppInputCommand {
    public boolean InputCommands()
    {
        String Command = App.scanner.nextLine();
        Command = Command.trim();
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
            App.loginMenu.Input(Command);
            return true;
        }
        if(Appview.Situation == MenuName.GameMenu)
        {
            App.loginMenu.Input(Command);
            return true;
        }
        if(2 == 3)
        {

        }
        return true;
    }
}
