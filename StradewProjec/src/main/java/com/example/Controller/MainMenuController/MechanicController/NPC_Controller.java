package com.example.Controller.MainMenuController.MechanicController;

import com.example.Model.App;

public class NPC_Controller {
    private void ApplySebastianQuest(int QuestNumber)
    {
        if(QuestNumber == 1)
        {

        }
        else if(QuestNumber == 2)
        {
            if(App.getCurrentGame().getFriendShips()[4][App.getCurrentGame().getWhoseTurn()].getLevel() == 0)
            {
                System.out.println("Not in Seb's yet");
                return;
            }

        }
        else if(QuestNumber == 3)
        {

        }
        else
        {
            System.out.println("Invalid quest number");
        }
    }
}
