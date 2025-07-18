package com.Stradew.View;

import com.Stradew.Controller.LoginController;
import com.Stradew.Controller.SignUpController;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.Rejex.LoginMenuRejex;
import com.Stradew.Model.GameAssetsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.regex.Matcher;

public class LoginMenu implements Screen {
    LoginController loginController;
    SignUpController signUpController = App.signUpController;
    Matcher matcher;
    Stage stage;

    TextField username;
    TextField password;
    TextField securityAnswer;

    TextButton login;
    TextButton forgetPassword;

    Label errors;

    Table table;

    public LoginMenu(LoginController loginController) {
        this.loginController = loginController;
        loginController.setLoginMenu(this);

        stage = new Stage();
        username = new TextField("username" , GameAssetsManager.getInstance().getSkin());
        password = new TextField("password", GameAssetsManager.getInstance().getSkin());
        securityAnswer = new TextField("security answer", GameAssetsManager.getInstance().getSkin());

        login = new TextButton("login", GameAssetsManager.getInstance().getSkin());
        forgetPassword = new TextButton("forget pass", GameAssetsManager.getInstance().getSkin());

        errors = new Label("", GameAssetsManager.getInstance().getSkin());



        table = new Table();
        table.setFillParent(true);
        table.center();

        table.add(username).colspan(2).fillX().padBottom(10).row();

        table.add(password).colspan(2).fillX().padBottom(20).row();

        table.add(login).uniformX().fillX();
        table.add(forgetPassword).uniformX().fillX();
        table.row();

        table.add(errors).colspan(2).padTop(10);

        stage.addActor(table);

        stage.addActor(table);


        // buttons
        login.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Login(username.getText(), password.getText(), null);
            }
        });
        forgetPassword.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ForgotPassword(username.getText());
            }
        });
    }

    //    public void Input(String Command)
//    {
//        if((matcher = LoginMenuRejex.Login.getMatcher(Command)) != null)
//        {
//            Login(matcher.group(1).trim() , matcher.group(2).trim() , matcher.group(3));
//        }
//        else if((matcher = LoginMenuRejex.ForgetPassword.getMatcher(Command)) != null)
//        {
//            ForgotPassword(matcher.group(1).trim());
//        }
//        else
//        {
//            System.out.println("invalid command");
//        }
//    }
    public void Login(String UserName, String Password , String StayLoggedIn) {
        if(!App.loginController.IsUsernameValid(UserName))
        {
            errors.setText("Username Does Not Exist");
            return;
        }
        if(!App.loginController.CheckPassword(UserName , Password))
        {
            errors.setText("Password Does Not Match");
            return;
        }
        boolean Stay = false;
        if(StayLoggedIn != null)
        {
            Stay = true;
        }
        App.loginController.ApplyLogin(UserName , Stay);
        errors.setText("Login Successful");
    }

    public void  ForgotPassword(String UserName) {
        if(!App.loginController.IsUsernameValid(UserName)) {
            errors.setText("Username Does Not Exist");
            return;
        }
        App.loginController.PrintQuestion(UserName);

        App.loginController.PrintQuestion(UserName);
        String AnswerGet = securityAnswer.getText();
        if((matcher = LoginMenuRejex.AnswerSecQuestion.getMatcher(AnswerGet)) != null) {
            if (App.loginController.CheckAnswer(UserName , matcher.group(1).trim()))
            {
                errors.setText(App.loginController.ReturnPass(UserName));
            }
            else
            {
                errors.setText("Answer Doesnt Match");
            }
        }
        else
        {
            errors.setText("Please enter valid Command");
        }
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
