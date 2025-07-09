package com.Stradew.View;

import com.Stradew.Controller.SignUpController;
import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.Rejex.SignupMenuRejex;
import com.Stradew.Model.Enums.SecurityQuestions;
import com.Stradew.Model.GameAssetsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.scenes.scene2d.Actor; // Import Actor for ChangeListener
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener; // Import ChangeListener

import java.util.ArrayList;
import java.util.regex.Matcher;

public class SignUpMenu implements Screen {

    SignUpController signUpController;
    TextField Username;
    TextField Password;
    TextField Nickname;
    TextField Email;
    SelectBox<String> Gender;
    TextButton Confirm;
    Label ErrorMessage;
    TextButton Back;
    Stage stage;
    Table SignupTable;
    Table SequrityQuestions;
    SelectBox Questions;
    TextField Answer;

    public TextField getNickname() {
        return Nickname;
    }

    public TextField getEmail() {
        return Email;
    }

    public SelectBox<String> getGender() {
        return Gender;
    }

    public TextButton getConfirmAnswer() {
        return ConfirmAnswer;
    }

    public Table getSignupTable() {
        return SignupTable;
    }

    public Table getSequrityQuestions() {
        return SequrityQuestions;
    }

    public SelectBox getQuestions() {
        return Questions;
    }

    public TextField getAnswer() {
        return Answer;
    }

    public TextField getUsername() {
        return Username;
    }

    public TextField getPassword() {
        return Password;
    }

    public TextButton getConfirm() {
        return Confirm;
    }

    public Label getErrorMessage() {
        return ErrorMessage;
    }

    public TextButton getBack() {
        return Back;
    }

    private TextButton ConfirmAnswer;

    public SignUpMenu(SignUpController signUpController) {
        this.signUpController = signUpController;
        signUpController.setMenu(this);
        Username = new TextField("username" , GameAssetsManager.getInstance().getSkin());
        Username.setMessageText("Enter Username");
        Password = new TextField("password" , GameAssetsManager.getInstance().getSkin());
        Password.setMessageText("Enter Password");
        Email = new TextField("email" , GameAssetsManager.getInstance().getSkin());
        Email.setMessageText("Enter Email");
        Nickname = new TextField("nickname" , GameAssetsManager.getInstance().getSkin());
        Nickname.setMessageText("Enter Nickname");
        Gender = new SelectBox<>(GameAssetsManager.getInstance().getSkin());
        Array<String> Genders = new Array<>();
        Genders.add("Male");
        Genders.add("Female");
        Gender.setItems(Genders);

        Confirm = new TextButton("confirm", GameAssetsManager.getInstance().getSkin());
        ErrorMessage = new Label("ba", GameAssetsManager.getInstance().getSkin());
        ErrorMessage.setColor(com.badlogic.gdx.graphics.Color.RED);

        Back = new TextButton("back", GameAssetsManager.getInstance().getSkin());
        stage = new Stage();

        SignupTable = new Table();
        SequrityQuestions = new Table();
        Questions = new SelectBox(GameAssetsManager.getInstance().getSkin());
        Answer = new TextField("Answer" , GameAssetsManager.getInstance().getSkin());
        Answer.setMessageText("Your Answer");
        ConfirmAnswer = new TextButton("Submit Answer", GameAssetsManager.getInstance().getSkin());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        SignupTable.setFillParent(true);


        SignupTable.add(new Label("Username:", GameAssetsManager.getInstance().getSkin())).right().padRight(10);
        SignupTable.add(Username).width(400).height(100).padBottom(20).row();

        SignupTable.add(new Label("Password:", GameAssetsManager.getInstance().getSkin())).right().padRight(10);
        SignupTable.add(Password).width(400).height(100).padBottom(30).row();

        SignupTable.add(new Label("Email:", GameAssetsManager.getInstance().getSkin())).right().padRight(10);
        SignupTable.add(Email).width(400).height(100).padBottom(30).row();

        SignupTable.add(new Label("Nickname:", GameAssetsManager.getInstance().getSkin())).right().padRight(10);
        SignupTable.add(Nickname).width(400).height(100).padBottom(30).row();

        SignupTable.add(Gender).width(400).height(100).padBottom(30).row();

        SignupTable.add(Confirm).colspan(2).width(200).height(60).padBottom(10).row();

        SignupTable.add(ErrorMessage).colspan(2).padBottom(20).center().row();


        SignupTable.add(Back).bottom().right().width(120).height(50).pad(20); // Pad from edges

        SignupTable.center();

        stage.addActor(SignupTable);


        SequrityQuestions.setFillParent(true);
        SequrityQuestions.setVisible(false);
        Array<String> Questionss = new Array<>();
        for(SecurityQuestions s : SecurityQuestions.values())
        {
            Questionss.add(s.toString());
        }
        Questions.setItems(Questionss);
        SequrityQuestions.add(Questions).expandX().fillX().pad(10).row();
        SequrityQuestions.add(Answer).expandX().fillX().pad(10).row();
        SequrityQuestions.add(ConfirmAnswer).expandX().fillX().pad(10).row();
        stage.addActor(SequrityQuestions);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 , 0 , 0 , 1);


        Main.getMain().getBatch().begin();
        signUpController.Update();
        Main.getMain().getBatch().end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
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
