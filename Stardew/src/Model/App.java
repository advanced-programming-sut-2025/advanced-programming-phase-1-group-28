package Model;

import Controller.LoginController;
import Controller.MainMenuController.GameMenuController;
import Controller.MainMenuController.ProfileMenuController;
import Controller.SignUpController;
import View.Appview;

import java.io.File;
import java.util.ArrayList;

public class App {
    File UsersFile;
    public static ArrayList<User> Users = new ArrayList<>();
    public static ArrayList<Game> Games = new ArrayList<>();
    public static SignUpController signUpController = new SignUpController();
    public static LoginController loginController = new LoginController();
    public static GameMenuController gameMenuController = new GameMenuController();
    public static ProfileMenuController profileMenuController = new ProfileMenuController();
    public static User ReturnUser(int index)
    {
        return Users.get(index);
    }
    public int ReturnUserIndex(String Username)
    {
        for(int i = 0; i < Users.size(); i++)
        {
            if(Users.get(i).Username.equals(Username))
            {
                return i;
            }
        }
        return -1;
    }
    public Game returnGame(int GameID)
    {
        return Games.get(GameID);
    }
}
