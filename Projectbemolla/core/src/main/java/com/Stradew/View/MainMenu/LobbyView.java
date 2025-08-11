package com.Stradew.View.MainMenu;

import com.Stradew.Controller.MainMenuController.GameMenuController;
import com.Stradew.Controller.MainMenuController.LobbyController;
import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Server.Lobby;
import com.Stradew.Server.NetworkClient;
import com.Stradew.Server.ServerMessageHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class LobbyView implements Screen , ServerMessageHandler {
    @Override
    public void handleServerMessage(String message) {
        System.out.println(message);
        String[] parts = message.split(" ", 10);
        String command = parts[0].toUpperCase();
        if(command.equals("LOBBY_STARTED")) {
            if(CurrentLobby.getId().equals(parts[1])) {
                GoingToGame = true;
            }
        }
        if(command.equals("LOBBY_LIST_EMPTY"))
        {
            lobbies.clear();
        }
        if(command.equals("LOBBY_LIST"))
        {
                lobbies.clear();
                String[] LobbyData = parts[1].split("\\|");
                for (int i = 0; i < LobbyData.length; i++) {
                    String S = LobbyData[i];
                    String parts2[] = S.split(";", 10);
                    if(parts2.length > 1) {
                        Lobby newlobby;
                        if (parts2[2].equals("false")) {
                            newlobby = new Lobby(parts2[0], null, parts2[2], null);
                            newlobby.setId(parts2[3]);
                        } else {
                            newlobby = new Lobby(parts2[0], null, null, null);
                            newlobby.setId(parts2[3]);
                        }
                        newlobby.setNumberPlayers(Integer.parseInt(parts2[1]));
                        newlobby.setVisible(Boolean.parseBoolean(parts2[parts2.length-1]));
                        lobbies.add(newlobby);
                    }
                }
                for (int i = lobbies.size() - 1; i >= LobbyData.length; i--) {
                    lobbies.remove(i);
                }
                if (CurrentLobby != null) {
                    for (int i = 0; i < LobbyData.length; i++) {
                        String S = LobbyData[i];
                        String parts2[] = S.split(";", 10);
                        if (parts2[3].equals(CurrentLobby.getId())) {
                            Lobby newlobby;
                            if (parts2[2].equals("false")) {
                                newlobby = new Lobby(parts2[0], null, parts2[2], parts2[4]);
                                newlobby.setId(parts2[3]);
                            } else {
                                newlobby = new Lobby(parts2[0], null, null, parts2[4]);
                                newlobby.setId(parts2[3]);
                            }
                            for (int j = 5; j < parts2.length - 1; j++) {
                                newlobby.getUsernames().add(parts2[j]);
                            }
                            newlobby.setNumberPlayers(Integer.parseInt(parts2[1]));
                            CurrentLobby = newlobby;
                        }
                    }
                }

        }
        if(command.equals("SUCCESS_JOINED_LOBBY") || command.equals("LOBBY_CREATED"))
        {
            String S = parts[1];
            String parts2[] = S.split(";" , 15);
            Lobby newlobby;
            if(parts2[2].equals("false")) {
                newlobby = new Lobby(parts2[0], null, parts2[2] , parts2[4]);
                newlobby.setId(parts2[3]);
            }
            else
            {
                newlobby = new Lobby(parts2[0], null, null , parts2[4]);
                newlobby.setId(parts2[3]);
            }
            for(int i = 5 ; i < parts2.length - 1  ; i++)
            {
                newlobby.getUsernames().add(parts2[i]);
            }
            newlobby.setNumberPlayers(Integer.parseInt(parts2[1]));
            CurrentLobby = newlobby;
            JoiningLobbyTable.setVisible(false);
            InsideLobbyTable.setVisible(true);
        }
    }

    private TextButton[] buttons = new TextButton[5];

    private Lobby CurrentLobby;

    private TextButton GoTOGame;

    public ArrayList<Lobby> getLobbies() {
        return lobbies;
    }

    public TextField getLobbyToJoinName() {
        return LobbyToJoinName;
    }

    public TextField getLobbytojoinPassword() {
        return LobbytojoinPassword;
    }

    public Lobby getCurrentLobby() {
        return CurrentLobby;
    }

    public TextButton getJoinLobbyWithThisname() {
        return JoinLobbyWithThisname;
    }

    @Override
    public void handleDisconnection() {

    }

    private ArrayList<Lobby> lobbies = new ArrayList<>();

    private TextField LobbyToJoinName;
    private TextField LobbytojoinPassword;
    private TextButton JoinLobbyWithThisname;
    private TextButton LeaveLobby;
    private TextButton SubmitCreateLobby;
    private TextField LobbyName;
    private TextField LobbyPassword;
    private CheckBox Public_Private;
    private TextButton CreateLobbyButton;
    private TextButton JoinLobbyButton;
    private Table InsideLobbyTable;
    private Table CreateLobbyTable;
    private Table MainTable;
    private Table JoiningLobbyTable;
    private LobbyController lobbyController;
    private boolean GoingToGame = false;
    private CheckBox Visible;


    public void setGoingToGame(boolean goingToGame) {
        GoingToGame = goingToGame;
    }

    public TextButton getGoTOGame() {
        return GoTOGame;
    }

    public TextField getLobbyName() {
        return LobbyName;
    }

    public TextField getLobbyPassword() {
        return LobbyPassword;
    }

    public TextButton getSubmitCreateLobby() {
        return SubmitCreateLobby;
    }

    public CheckBox getPublic_Private() {
        return Public_Private;
    }

    public TextButton getCreateLobbyButton() {
        return CreateLobbyButton;
    }

    public TextButton getJoinLobbyButton() {
        return JoinLobbyButton;
    }

    public Table getInsideLobbyTable() {
        return InsideLobbyTable;
    }

    public Table getCreateLobbyTable() {
        return CreateLobbyTable;
    }

    public Table getMainTable() {
        return MainTable;
    }

    public Table getJoiningLobbyTable() {
        return JoiningLobbyTable;
    }

    public LobbyController getLobbyController() {
        return lobbyController;
    }

    private Stage stage;
    public LobbyView(LobbyController lobbyController) {
        this.lobbyController = lobbyController;
        lobbyController.setLobby(this);

        CreateLobbyButton = new TextButton("Create Lobby" , GameAssetsManager.getInstance().getSkin());
        JoinLobbyButton = new TextButton("Join Lobby" , GameAssetsManager.getInstance().getSkin());
        SubmitCreateLobby = new TextButton("Submit" , GameAssetsManager.getInstance().getSkin());
        InsideLobbyTable = new Table();
        CreateLobbyTable = new Table();
        MainTable = new Table();
        JoiningLobbyTable = new Table();
        stage = new Stage();

        LobbyName = new TextField("Lobbyname", GameAssetsManager.getInstance().getSkin());
        LobbyPassword = new TextField("Password", GameAssetsManager.getInstance().getSkin());
        Public_Private = new CheckBox("Private", GameAssetsManager.getInstance().getSkin());

        for(int i = 0;i < 5 ; i++)
        {
            buttons[i] = new TextButton("Join", GameAssetsManager.getInstance().getSkin());
        }

        for(int i = 0;i < 5 ; i++)
        {
            lobbies.add(new Lobby(null ,null , null , null));
        }

        if(App.networkClient == null)
        {
            App.networkClient = new NetworkClient("localhost" ,8080 , this );
            new Thread(App.networkClient).start();
        }

        LobbyToJoinName = new TextField("Name", GameAssetsManager.getInstance().getSkin());
        LobbytojoinPassword = new TextField("Password", GameAssetsManager.getInstance().getSkin());
        JoinLobbyWithThisname = new TextButton("Join", GameAssetsManager.getInstance().getSkin());
        LeaveLobby = new TextButton("Leave", GameAssetsManager.getInstance().getSkin());
        GoTOGame = new TextButton("GoTOGame", GameAssetsManager.getInstance().getSkin());
        Visible = new CheckBox("Visible", GameAssetsManager.getInstance().getSkin());
    }

    public CheckBox getVisible() {
        return Visible;
    }

    public TextButton[] getButtons() {
        return buttons;
    }

    public TextButton getLeaveLobby() {
        return LeaveLobby;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        //App.networkClient.setMessageHandler(this);

        MainTable.setFillParent(true);
        MainTable.add(CreateLobbyButton);
        MainTable.add(JoinLobbyButton);

        JoiningLobbyTable.setVisible(false);
        JoiningLobbyTable.setFillParent(true);
        JoiningLobbyTable.center();
        JoiningLobbyTable.add(LobbyToJoinName).width(300).row();
        JoiningLobbyTable.add(LobbytojoinPassword).width(300).row();
        JoiningLobbyTable.add(JoinLobbyWithThisname).width(100);
       // for(int i = 0;i < 5 ; i++)
      //  {
    //        JoiningLobbyTable.add(buttons[i]);
  //      }


        CreateLobbyTable.setFillParent(true);
        CreateLobbyTable.setVisible(false);
        CreateLobbyTable.center();
        CreateLobbyTable.add(LobbyName).width(300).pad(20).row();
        CreateLobbyTable.add(LobbyPassword).width(300).pad(20).row();
        CreateLobbyTable.add(Public_Private).pad(40).row();
        CreateLobbyTable.add(Visible).pad(40).row();
        CreateLobbyTable.add(SubmitCreateLobby);


        InsideLobbyTable.setVisible(false);
        InsideLobbyTable.setFillParent(true);
        InsideLobbyTable.right();
        InsideLobbyTable.add(GoTOGame).width(300).pad(20).row();
        InsideLobbyTable.add(LeaveLobby);

        stage.addActor(MainTable);
        stage.addActor(CreateLobbyTable);
        stage.addActor(JoiningLobbyTable);
        stage.addActor(InsideLobbyTable);
    }

    @Override
    public void render(float v) {
        if(GoingToGame)
        {
            GameMenuController.StartGame(new ArrayList<>());
            Main.getMain().setScreen(new GameMenu(new GameMenuController() , CurrentLobby));
        }
        ScreenUtils.clear(250 , 250 , 250 , 1);
        Main.getMain().getBatch().begin();
        lobbyController.Update();
        Main.getMain().getBatch().end();
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
