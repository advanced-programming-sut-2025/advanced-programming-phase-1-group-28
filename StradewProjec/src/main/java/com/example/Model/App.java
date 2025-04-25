package com.example.Model;

import com.example.Controller.AllMenuCommandsController;
import com.example.Controller.LoginController;
import com.example.Controller.MainMenuController.GameMenuController;
import com.example.Controller.MainMenuController.ProfileMenuController;
import com.example.Controller.SignUpController;
import com.example.View.AppInputCommand;
import com.example.View.Appview;
import com.example.View.LoginMenu;
import com.example.View.MainMenu.GameMenu;
import com.example.View.MainMenu.ProfileMenu;
import com.example.View.SignUpMenu;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
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
    public static SignUpMenu signUpMenu = new SignUpMenu();
    public static ProfileMenu profileMenu = new ProfileMenu();
    public static GameMenu gameMenu = new GameMenu();
    public static LoginMenu loginMenu = new LoginMenu();
    public static Random random = new Random();
    static {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("StradewProjec/Users.json")) {
        JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
        if(jsonArray != null) {
            for (JsonElement jsonelemnt : jsonArray) {
                User user = gson.fromJson(jsonelemnt, User.class);
                Users.add(user);
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static User ReturnUser(int index)
    {
        return Users.get(index);
    }
    public static int ReturnUserIndex(String Username)
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
    public static Game returnGame(int GameID)
    {
        return Games.get(GameID);
    }

    public static User getCurrentUser(){
        return Users.get(Appview.getUserLoggedInId());
    }
}
