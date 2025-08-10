package com.Stradew.View.MainMenu;

import com.Stradew.Controller.MainMenuController.GameMenuController;
import com.Stradew.Controller.MainMenuController.LobbyController;
import com.Stradew.Controller.MainMenuController.MainmenuController;
import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Server.Lobby;
import com.Stradew.Server.NetworkClient;
import com.Stradew.Server.ServerMessageHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenu implements Screen , ServerMessageHandler {
    private Boolean GoToGameMenu = false;
    private Boolean CreateLobbyTable = false;
    private TextButton ExitButton;
    private Label Username;

    public void setCreateLobbyTable(Boolean createLobbyTable) {
        CreateLobbyTable = createLobbyTable;
    }

    public void setGoToGameMenu(Boolean goToGameMenu) {
        GoToGameMenu = goToGameMenu;
    }

    public TextButton getExitButton() {
        return ExitButton;
    }

    private MainmenuController controller;
    private TextButton GameMenu;
    private TextButton ProfileMenu;
    private TextButton LogoutButton;
    private Stage stage;
    private TextButton GotoLobbyBotton;

    public TextButton getGotoLobbyBotton() {
        return GotoLobbyBotton;
    }

    public TextButton getGameMenu() {
        return GameMenu;
    }

    public TextButton getProfileMenu() {
        return ProfileMenu;
    }

    public TextButton getLogoutButton() {
        return LogoutButton;
    }

    public MainMenu(MainmenuController controller) {
        this.controller = controller;
        controller.setMenu(this);
        GameMenu = new TextButton("Game menu" , GameAssetsManager.getInstance().getSkin());
        ProfileMenu = new TextButton("Profile menu" , GameAssetsManager.getInstance().getSkin());
        LogoutButton = new TextButton("Logout", GameAssetsManager.getInstance().getSkin());
        GotoLobbyBotton = new TextButton("Lobby Setting", GameAssetsManager.getInstance().getSkin());
        ExitButton  = new TextButton("Exit", GameAssetsManager.getInstance().getSkin());
        Username = new Label(App.getCurrentUser().getNickname(), GameAssetsManager.getInstance().getSkin());
        stage = new Stage();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Table LogoutTable = new Table();
        Table MainTable = new Table();
        LogoutTable.setFillParent(true);
        MainTable.setFillParent(true);
        MainTable.center();
        LogoutTable.top().right();
        MainTable.add(GameMenu);
        MainTable.add(ProfileMenu);
        MainTable.add(GotoLobbyBotton);
        LogoutTable.add(LogoutButton).row();
        LogoutTable.add(ExitButton).row();
        LogoutTable.add(Username);
        stage.addActor(LogoutTable);
        stage.addActor(MainTable);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(250 , 250 , 250 , 1);
        if(GoToGameMenu)
        {
            Main.getMain().setScreen(new GameMenu(new GameMenuController() , new Lobby(null , null , null , null)));
        }
        if(CreateLobbyTable)
        {
            Main.getMain().setScreen(new LobbyView(new LobbyController()));
        }
        Main.getMain().getBatch().begin();
        controller.Update();
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

    @Override
    public void handleServerMessage(String message) {

    }

    @Override
    public void handleDisconnection() {

    }
}
