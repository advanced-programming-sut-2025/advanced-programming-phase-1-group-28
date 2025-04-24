package Model;

import Controller.AllMenuCommandsController;
import Controller.LoginController;
import Controller.MainMenuController.GameMenuController;
import Controller.MainMenuController.ProfileMenuController;
import Controller.SignUpController;
import View.Appview;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    File UsersFile;
    public static ArrayList<User> Users = new ArrayList<>();
    public static ArrayList<Game> Games = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static SignUpController signUpController = new SignUpController();
    public static LoginController loginController = new LoginController();
    public static GameMenuController gameMenuController = new GameMenuController();
    public static ProfileMenuController profileMenuController = new ProfileMenuController();
    public static AllMenuCommandsController allMenuCommandsController = new AllMenuCommandsController();

    public App() {
    }

    public static User ReturnUser(int index)
    {
        return Users.get(index);
    }
    public int ReturnUserIndex(String Username)
    {
        for(int i = 0; i < Users.size(); i++)
        {
            if(Users.get(i).getUsername().equals(Username))
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

    public File getUsersFile() {
        return UsersFile;
    }

    public void setUsersFile(File usersFile) {
        UsersFile = usersFile;
    }

    public static ArrayList<User> getUsers() {
        return Users;
    }

    public static void setUsers(ArrayList<User> users) {
        Users = users;
    }

    public static ArrayList<Game> getGames() {
        return Games;
    }

    public static void setGames(ArrayList<Game> games) {
        Games = games;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        App.scanner = scanner;
    }

    public static SignUpController getSignUpController() {
        return signUpController;
    }

    public static void setSignUpController(SignUpController signUpController) {
        App.signUpController = signUpController;
    }

    public static LoginController getLoginController() {
        return loginController;
    }

    public static void setLoginController(LoginController loginController) {
        App.loginController = loginController;
    }

    public static GameMenuController getGameMenuController() {
        return gameMenuController;
    }

    public static void setGameMenuController(GameMenuController gameMenuController) {
        App.gameMenuController = gameMenuController;
    }

    public static ProfileMenuController getProfileMenuController() {
        return profileMenuController;
    }

    public static void setProfileMenuController(ProfileMenuController profileMenuController) {
        App.profileMenuController = profileMenuController;
    }

    public static AllMenuCommandsController getAllMenuCommandsController() {
        return allMenuCommandsController;
    }

    public static void setAllMenuCommandsController(AllMenuCommandsController allMenuCommandsController) {
        App.allMenuCommandsController = allMenuCommandsController;
    }
}
