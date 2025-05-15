package com.example.Model;

import com.example.Controller.AllMenuCommandsController;
import com.example.Controller.LoginController;
import com.example.Controller.MainMenuController.GameMenuController;
import com.example.Controller.MainMenuController.HomeMenucontroller.CraftingController;
import com.example.Controller.MainMenuController.HomeMenucontroller.PokhtOPazController;
import com.example.Controller.MainMenuController.MechanicController.FarmingController;
import com.example.Controller.MainMenuController.MechanicController.FriendShipController;
import com.example.Controller.MainMenuController.MechanicController.MechanicController;
import com.example.Controller.MainMenuController.MechanicController.UseToolController;
import com.example.Controller.MainMenuController.MechanicController.NPC_Controller;
import com.example.Controller.MainMenuController.ProfileMenuController;
import com.example.Controller.SignUpController;
import com.example.Model.Tools.Pepolee;
import com.example.View.AppInputCommand;
import com.example.View.Appview;
import com.example.View.LoginMenu;
import com.example.View.MainMenu.CheatCodes;
import com.example.View.MainMenu.GameMenu;
import com.example.View.MainMenu.MechanicGame.Friendship;
import com.example.View.MainMenu.MechanicGame.HomeMenu.PokhtOPaz;
import com.example.View.MainMenu.MechanicGame.MechanicGame;
import com.example.View.MainMenu.MechanicGame.NPCMenu;
import com.example.View.MainMenu.MechanicGame.UseTool;
import com.example.View.MainMenu.ProfileMenu;
import com.example.View.MainMenu.ShowFigures;
import com.example.View.SignUpMenu;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    File UsersFile;
    public static ArrayList<User> Users = new ArrayList<>();
    public static ArrayList<Game> Games = new ArrayList<>();
    public static FriendShipController friendShipController = new FriendShipController();
    public static ShowFigures showFigures = new ShowFigures();
    public static CheatCodes cheatCodes = new CheatCodes();
    public static File Commands = new File("Commands.txt");
    public static Scanner scanner;
    static {
        try {
            scanner = new Scanner(Commands);
        }catch (FileNotFoundException e)
        {
            System.out.println("bas kon");
        }
    }    public static SignUpController signUpController = new SignUpController();
    public static LoginController loginController = new LoginController();
    public static GameMenuController gameMenuController = new GameMenuController();
    public static ProfileMenuController profileMenuController = new ProfileMenuController();
    public static MechanicController mechanicController = new MechanicController();
    public static NPC_Controller npcController = new NPC_Controller();
    public static MechanicGame mechanicGame = new MechanicGame();
    public static FarmingController farmingController = new FarmingController();
    public static CraftingController craftingController = new CraftingController();
    public static UseToolController useToolController = new UseToolController();
    public static PokhtOPazController pokhtOPazController = new PokhtOPazController();
    public static UseTool UseTool = new UseTool();
    public static AllMenuCommandsController allMenuCommandsController = new AllMenuCommandsController();
    public static SignUpMenu signUpMenu = new SignUpMenu();
    public static ProfileMenu profileMenu = new ProfileMenu();
    public static GameMenu gameMenu = new GameMenu();
    public static LoginMenu loginMenu = new LoginMenu();
    public static NPCMenu npcMenu = new NPCMenu();
    public static PokhtOPaz pokhtOPaz = new PokhtOPaz();
    public static Friendship friendship = new Friendship();
    public static Random random = new Random();
    public static DailyLimits dailyLimits = new DailyLimits();
    static {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("Users.json")) {
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

    public static Game getCurrentGame(){
        return Games.get(Appview.CurrentGameID);
    }

    public static Pepolee ReturnCurrentPlayer()
    {
        return getCurrentGame().getCharactersInGame().get(getCurrentGame().getWhoseTurn());
    }

}
