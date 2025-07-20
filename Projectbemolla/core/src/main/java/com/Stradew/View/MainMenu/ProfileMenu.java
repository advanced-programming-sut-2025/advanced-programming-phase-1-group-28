package com.Stradew.View.MainMenu;

import com.Stradew.Controller.MainMenuController.ProfileMenuController;
import com.Stradew.Controller.SignUpController;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.User;
import com.Stradew.View.Appview;
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

public class ProfileMenu implements Screen {
    SignUpController signUpController = App.signUpController;
    ProfileMenuController profileMenuController = App.profileMenuController;
    Matcher matcher;

    Stage stage;

    Table table;

    TextField username;
    TextField password;
    TextField nickname;
    TextField email;
    TextField gender;

    Label feedback;

    TextButton changeUsername;
    TextButton changePassword;
    TextButton changeNickname;
    TextButton changeEmail;

    public ProfileMenu(ProfileMenuController profileMenuController) {
        this.profileMenuController = profileMenuController;
        profileMenuController.setProfileMenu(this);

        stage = new Stage();

        username = new TextField(App.getCurrentUser().getUsername(), GameAssetsManager.getInstance().getSkin());
        password = new TextField(App.getCurrentUser().getPassword(), GameAssetsManager.getInstance().getSkin());
        email = new TextField(App.getCurrentUser().getEmail(), GameAssetsManager.getInstance().getSkin());
        nickname = new TextField(App.getCurrentUser().getNickname(), GameAssetsManager.getInstance().getSkin());
        gender = new TextField(App.getCurrentUser().getGender(), GameAssetsManager.getInstance().getSkin());
        gender.setDisabled(true);

        feedback = new Label("", GameAssetsManager.getInstance().getSkin());
        feedback.setWrap(true);

        changeUsername = new TextButton("Change", GameAssetsManager.getInstance().getSkin());
        changePassword = new TextButton("Change", GameAssetsManager.getInstance().getSkin());
        changeEmail = new TextButton("Change", GameAssetsManager.getInstance().getSkin());
        changeNickname = new TextButton("Change", GameAssetsManager.getInstance().getSkin());

        table = new Table();
        table.setFillParent(true);
        table.center();

        int textFieldWidth = 300;
        int buttonWidth = 180;
        int pad = 5;

        table.add(username).width(textFieldWidth).pad(pad);
        table.add(changeUsername).width(buttonWidth).pad(pad);
        table.row();

        table.add(password).width(textFieldWidth).pad(pad);
        table.add(changePassword).width(buttonWidth).pad(pad);
        table.row();

        table.add(email).width(textFieldWidth).pad(pad);
        table.add(changeEmail).width(buttonWidth).pad(pad);
        table.row();

        table.add(nickname).width(textFieldWidth).pad(pad);
        table.add(changeNickname).width(buttonWidth).pad(pad);
        table.row();

        table.add(new Label("Gender:", GameAssetsManager.getInstance().getSkin())).pad(pad);
        table.add(gender).width(textFieldWidth).pad(pad);
        table.row();

        table.add(feedback).colspan(2).fillX().padTop(20).pad(pad);

        stage.addActor(table);

        changeUsername.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ChangeUsername(username.getText());
            }
        });
        changePassword.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) { ChangePassword(password.getText()); }
        });
        changeEmail.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) { ChangeEmail(email.getText()); }
        });
        changeNickname.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) { ChangeNickname(nickname.getText()); }
        });
    }

    //    public void Input(String command){
//        if ((matcher = ProfileMenuRejex.ChangeUserName.getMatcher(command)) != null){
//            ChangeUsername(matcher.group(1));
//        }else if ((matcher = ProfileMenuRejex.ChangeNickName.getMatcher(command)) != null){
//            ChangeNickname(matcher.group(1));
//        } else if ((matcher = ProfileMenuRejex.ChangeEmail.getMatcher(command)) != null) {
//            ChangeEmail(matcher.group(1));
//        } else if ((matcher = ProfileMenuRejex.ChangePassword.getMatcher(command)) != null) {
//            ChangePassword(matcher.group(1), matcher.group(2));
//        } else if ((matcher = ProfileMenuRejex.Logout.getMatcher(command)) != null) {
//            Logout();
//        } else if((matcher = ProfileMenuRejex.ShowInfo.getMatcher(command)) != null) {
//            ShowInfo();
//        } else {
//            System.out.println("invalid command");
//        }
//    }
    public void ChangeUsername(String NewUsername)
    {
        User currentUser = App.getCurrentUser();
        if (currentUser.getUsername().equals(NewUsername)){
            feedback.setText("the username cannot be the same as current username!");
            return;
        }
        profileMenuController.ApplyChangeUsername(NewUsername);
        feedback.setText("your username changed to " + NewUsername + " successfully");
        username.setText(App.getCurrentUser().getUsername());
    }
    public void ChangeNickname(String NewNickname)
    {
        User currentUser = App.getCurrentUser();
        if (currentUser.getNickname().equals(NewNickname)){
            feedback.setText("the new nickname cannot be the same as current nickname");
            return;
        }
        profileMenuController.ApplyChangeNickname(NewNickname);
        feedback.setText("your nickname changed to " + NewNickname + " successfully");
        username.setText(App.getCurrentUser().getNickname());
    }
    public void ChangePassword(String NewPassword)
    {
        User currentUser = App.getCurrentUser();
        String CurrentPassword = App.getCurrentUser().getPassword();
        if (!CurrentPassword.equals(currentUser.getPassword())){
            feedback.setText("incorrect password!");
            return;
        } else if (CurrentPassword.equals(NewPassword)) {
            feedback.setText("the new password cannot be the same as current password");
            return;
        } else if (App.signUpController.IsPasswordWeak(NewPassword)) {
            feedback.setText("password is weak.");
            return;
        }
        profileMenuController.ApplyChangePassword(NewPassword);
        feedback.setText("your password changed to " + NewPassword + " successfully");
        password.setText(App.getCurrentUser().getPassword());
    }
    public void ChangeEmail(String NewEmail)
    {
        User currentUser = App.getCurrentUser();
        if (NewEmail.equals(currentUser.getEmail())){
            feedback.setText("the new email cannot be the same as current email");
            return;
        }
        profileMenuController.ApplyChangeEmail(NewEmail);
        feedback.setText("your email changed to " + NewEmail + " successfully");
        email.setText(App.getCurrentUser().getEmail());
    }
    public void ShowInfo()
    {
        User TempUser = App.ReturnUser(Appview.UserLoggedInId);
        System.out.println("User Info:\n\n");
        System.out.println("username: " + TempUser.getUsername());
        System.out.println("nickname: " + TempUser.getNickname());
        System.out.println("highest score: " + TempUser.getHighestScore());
        System.out.println("games played: " + TempUser.getGamesPlayed());
        //Print Info
    }

    public void Logout(){
        profileMenuController.ApplyLogout();
        feedback.setText("You logged out successfully.");
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
