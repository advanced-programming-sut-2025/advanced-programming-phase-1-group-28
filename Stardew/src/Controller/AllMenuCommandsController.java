package Controller;

import Model.Enums.MenuName;
import View.Appview;

public class AllMenuCommandsController {
    public String ShowCurrentMenu()
    {
        return Appview.getSituation().Name;
    }
    public MenuName Returnmenuname(String menu)
    {
        for(MenuName menuName : MenuName.values())
        {
            if(menu.equals(menuName.name()))
            {
                return menuName;
            }
        }
        return null;
    }
    public String GoToMenu(MenuName menuName)
    {
        if(menuName.equals(MenuName.ProfileMenu))
        {
            if(Appview.getSituation() != MenuName.MainMenu)
            {
                return "IF You want to go to Profile Menu first enter the Main Menu";
            }
        }
        if(menuName.equals(MenuName.GameMenu))
        {
            if(Appview.getSituation() != MenuName.MainMenu)
            {
                return "If You want to go to the Game Menu first enter the Main Menu";
            }
        }
        if(menuName.equals(MenuName.MainMenu))
        {
            if(Appview.getUserLoggedInId() == -1)
            {
                return "Login First Please";
            }
        }
        return "You Going to" + menuName.Name + "successfully";
    }
}
