package com.Stradew.Controller.MainMenuController;

import com.Stradew.Model.App;
import com.Stradew.View.MainMenu.GameMenu;

public class ReactionController {


    public void Update(GameMenu menu)
    {
        for(int i = 0 ;i < 6 ; i++)
        {
            if(menu.getTextReactions()[i].isChecked())
            {
                App.networkClient.sendMessage("REACTION" + " " + "TEXT" + " " + String.valueOf(i));
                menu.getReactionTable().setVisible(false);
                menu.getMainTable().setVisible(true);
                menu.getTextReactions()[i].setChecked(false);
            }
            if(menu.getImageReactions()[i].isChecked())
            {
                App.networkClient.sendMessage("REACTION" + " " + "IMAGE" + " " + String.valueOf(i));
                menu.getReactionTable().setVisible(false);
                menu.getMainTable().setVisible(true);
                menu.getImageReactions()[i].setChecked(false);
            }
        }
    }

    public void End(GameMenu menu)
    {

    }


}
