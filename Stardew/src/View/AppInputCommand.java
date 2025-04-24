package View;

import Model.App;
import Model.Enums.MenuName;

public class AppInputCommand {
    public boolean InputCommands()
    {
        String Command = App.scanner.nextLine();
        Command = Command.trim();
        if(Appview.Situation == MenuName.SignUpMenu)
        {

        }
        return true;
    }
}
