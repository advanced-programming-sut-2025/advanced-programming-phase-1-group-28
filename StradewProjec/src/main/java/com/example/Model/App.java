package com.example.Model;

import com.example.Controller.AllMenuCommandsController;
import com.example.Controller.LoginController;
import com.example.Controller.MainMenuController.GameMenuController;
import com.example.Controller.MainMenuController.ProfileMenuController;
import com.example.Controller.SignUpController;
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
    public static Random random = new Random();
    static {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("Users.json")) {
        JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
        for(JsonElement jsonelemnt: jsonArray) {
            User user = gson.fromJson(jsonelemnt, User.class);
            Users.add(user);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
