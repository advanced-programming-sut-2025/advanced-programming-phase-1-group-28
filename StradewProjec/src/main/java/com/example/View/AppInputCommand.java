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
        }
        if(Appview.Situation == MenuName.LoginMenu)
        {
            App.loginMenu.Input(Command);
        }
        if(Appview.Situation == MenuName.ProfileMenu)
        {
            App.loginMenu.Input(Command);
        }
        if(Appview.Situation == MenuName.GameMenu)
        {
            App.loginMenu.Input(Command);
        }
        if(2 == 3)
        {
            //Exit
        }
        return true;
    }
}
