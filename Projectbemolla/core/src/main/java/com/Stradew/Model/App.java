package com.Stradew.Model;

import com.Stradew.Controller.AllMenuCommandsController;
import com.Stradew.Controller.LoginController;
import com.Stradew.Controller.MainMenuController.GameMenuController;
import com.Stradew.Controller.MainMenuController.HomeMenucontroller.CraftingController;
import com.Stradew.Controller.MainMenuController.HomeMenucontroller.PokhtOPazController;
import com.Stradew.Controller.MainMenuController.MechanicController.FarmingController;
import com.Stradew.Controller.MainMenuController.MechanicController.FriendShipController;
import com.Stradew.Controller.MainMenuController.MechanicController.MechanicController;
import com.Stradew.Controller.MainMenuController.MechanicController.UseToolController;
import com.Stradew.Controller.MainMenuController.MechanicController.NPC_Controller;
import com.Stradew.Controller.MainMenuController.ProfileMenuController;
import com.Stradew.Controller.SignUpController;
import com.Stradew.Model.Tools.Pepolee;
import com.Stradew.View.Appview;
import com.Stradew.View.LoginMenu;
import com.Stradew.View.MainMenu.CheatCodes;
import com.Stradew.View.MainMenu.GameMenu;
import com.Stradew.View.MainMenu.MechanicGame.Farming;
import com.Stradew.View.MainMenu.MechanicGame.Friendship;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.Crafting;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.PokhtOPaz;
import com.Stradew.View.MainMenu.MechanicGame.MechanicGame;
import com.Stradew.View.MainMenu.MechanicGame.NPCMenu;
import com.Stradew.View.MainMenu.MechanicGame.ShopMenu.Shopping;
import com.Stradew.View.MainMenu.MechanicGame.UseTool;
import com.Stradew.View.MainMenu.ProfileMenu;
import com.Stradew.View.MainMenu.ShowFigures;
import com.Stradew.View.SignUpMenu;

import java.io.File;
import java.io.FileNotFoundException;
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
    public static Farming farming = new Farming();
    public static CraftingController craftingController = new CraftingController();
    public static UseToolController useToolController = new UseToolController();
    public static Crafting Crafting = new Crafting();
    public static UseTool UseTool = new UseTool();
    public static AllMenuCommandsController allMenuCommandsController = new AllMenuCommandsController();
    public static ProfileMenu profileMenu = new ProfileMenu();
    public static GameMenu gameMenu = new GameMenu();
    public static NPCMenu npcMenu = new NPCMenu();
    public static LoginMenu loginMenu = new LoginMenu();
    public static Friendship friendship = new Friendship();
    public static PokhtOPaz pokhtOPaz = new PokhtOPaz();
    public static PokhtOPazController pokhtOPazController = new PokhtOPazController();
    public static Random random = new Random();
    public static DailyLimits dailyLimits = new DailyLimits();
    public static Shopping shopMenu = new Shopping();
    /*static {
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
        for(int i = 0;i < Users.size();i++) {
            System.out.println(Users.get(i).getUsername());
        }
        for(int i = 0;i < Users.size() ; i++)
        {
            if(Users.get(i).isStayLoggedIn())
            {
                Appview.UserLoggedInId = i;
                Appview.Situation = MenuName.MainMenu;
            }
        }
    }*/
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
