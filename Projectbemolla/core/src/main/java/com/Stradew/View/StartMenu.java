package com.Stradew.View;

import com.Stradew.Controller.StartmenuController;
import com.Stradew.Main;
import com.Stradew.Model.GameAssetsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

public class StartMenu implements Screen {
    private BitmapFont font = new BitmapFont();
    private String Gold = "156700";
    private String DAy = "14 June";
    private String Time = "2:53 PM";
    private StartmenuController Controller;
    private TextButton Exit;
    private TextButton SignUp;
    private TextButton Login;
    private Stage stage = new Stage();

    public TextButton getExit() {
        return Exit;
    }

    public TextButton getSignUp() {
        return SignUp;
    }

    public TextButton getLogin() {
        return Login;
    }

    public StartMenu(StartmenuController controller) {
        Controller = controller;
        Controller.setMenu(this);
        Exit = new TextButton("Exit" , GameAssetsManager.getInstance().getSkin());
        SignUp = new TextButton("SignUp" , GameAssetsManager.getInstance().getSkin());
        Login = new TextButton("Login" , GameAssetsManager.getInstance().getSkin());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Table table = new Table();
        table.setFillParent(true);
        table.center();
        table.add(Exit);
        table.row().padTop(5);
        table.add(SignUp);
        table.row().padTop(5);
        table.add(Login);
        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 , 0 , 0 , 1);
        Main.getMain().getBatch().begin();
        Main.getMain().getBatch().draw(GameAssetsManager.getInstance().getClock(), 0 , 0);
        font.draw(Main.getMain().getBatch(), DAy , 130 , 300);
        font.draw(Main.getMain().getBatch(), Time , 130 , 250);
        font.draw(Main.getMain().getBatch(), Gold , 130 , 60);
        Controller.Update();
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
