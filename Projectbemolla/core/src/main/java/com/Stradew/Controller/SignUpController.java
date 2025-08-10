package com.Stradew.Controller;

import com.Stradew.Controller.MainMenuController.MainmenuController;
import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.MenuName;
import com.Stradew.Model.Enums.Rejex.SignupMenuRejex;
import com.Stradew.Model.Enums.SecurityQuestions;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.User;
import com.Stradew.View.Appview;
import com.Stradew.View.MainMenu.MainMenu;
import com.Stradew.View.SignUpMenu;
import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class SignUpController {

    SignUpMenu Menu;

    public void setMenu(SignUpMenu menu) {
        Menu = menu;
    }

    public boolean IsUsernameValid(String Username)
    {
        Matcher UserMatcher = SignupMenuRejex.ValidUser.getMatcher(Username);
        return  UserMatcher != null;
    }

    public boolean IsUsernameTaken(String Username)
    {
        for(int i = 0;i < App.Users.size(); i++)
        {
            if(App.Users.get(i).getUsername().equals(Username))
            {
                return true;
            }
        }
        return false;
    }

    public boolean IsEmailValid(String Email)
    {
        Matcher EmailMatcher = SignupMenuRejex.ValidEmail.getMatcher(Email);
        return EmailMatcher != null;
    }

    public boolean IsPassValid(String Password)
    {
        Matcher matcher = SignupMenuRejex.ValidPassword.getMatcher(Password);
        return matcher != null;
    }

    public boolean IsPasswordWeak(String Password)
    {
        if(Password.length() < 8)
        {
            return false;
        }
        String SpecialCharacters = "?><,\"';:\\/|][}{+=)(*&^%$#!";
        Boolean Cap = false , Lower =false , Number = false , Symbol = false ;
        for(int i = 0; i < Password.length(); i++)
        {
            for (int j = 0; j < SpecialCharacters.length(); j++)
            {
                if(Password.charAt(i) == SpecialCharacters.charAt(j))
                {
                    Symbol = true;
                }
            }
            int AsciIndex = Password.charAt(i);
            if(AsciIndex >= 65 && AsciIndex <= 90)
            {
                Cap = true;
            }
            if(AsciIndex >= 97 && AsciIndex <= 122)
            {
                Lower = true;
            }
            if(AsciIndex >= 48 && AsciIndex <= 57)
            {
                Number = true;
            }
        }
        return Cap && Lower && Number && Symbol;
    }

    public boolean CheckPasswordEquality(String Password1 , String Password2)
    {
        return Password1.equals(Password2);
    }

    public String RandomPassword()
    {
        while(true) {
            String SpecialCharacters = "?><,\"';:\\/|][}{+=)(*&^%$#!";
            String Numbers = "1234567890";
            String Caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String Lower = "abcdefghijklmnopqrstuvwxyz";
            int RandomPasswordLength = (App.random.nextInt() % 4) + 8;
            char[] RandomPassword = new char[RandomPasswordLength];
            for (int i = 0; i < RandomPasswordLength; i++) {
                int RandomType = App.random.nextInt() % 4;
                if (RandomType == 0) {
                    int X = App.random.nextInt() % 1000;
                    if(X < 0)
                    {
                        X += 2000;
                    }
                    RandomPassword[i] = SpecialCharacters.charAt((X % SpecialCharacters.length()));
                }
                if (RandomType == 1) {
                    int X = App.random.nextInt() % 1000;
                    if(X < 0)
                    {
                        X += 2000;
                    }
                    RandomPassword[i] = Numbers.charAt((X % Numbers.length()));
                }
                if (RandomType == 2) {
                    int X = App.random.nextInt() % 1000;
                    if(X < 0)
                    {
                        X += 2000;
                    }
                    RandomPassword[i] = Caps.charAt((X % Caps.length()));
                }
                if (RandomType == 3) {
                    int X = App.random.nextInt() % 1000;
                    if(X < 0)
                    {
                        X += 2000;
                    }
                    RandomPassword[i] = Lower.charAt((X % Lower.length()));
                }
            }
            String modified = new String(RandomPassword);
            if(IsPasswordWeak(modified))
            {
                return modified;
            }
        }
    }

    public ArrayList<String> ShowSecurityQuestions()
    {
        ArrayList<String> Output = new ArrayList<>();
        for(SecurityQuestions question : SecurityQuestions.values())
        {
            Output.add(question.QuestionName);
        }
        return Output;
    }

    public void SetQuestion(int QuestionId , String Answer)
    {
        App.Users.get(Appview.getUserLoggedInId()).setAnswerIdQuestion(QuestionId);
        App.Users.get(Appview.getUserLoggedInId()).setAnswer(Answer.trim());
       // return "Answer Submit Successful";
    }

    public String ShowQuestion(String Username)
    {
        int Userid  = App.ReturnUserIndex(Username);
        int count = 1;
        for(SecurityQuestions question : SecurityQuestions.values())
        {
            if(count == App.Users.get(Userid).getAnswerIdQuestion())
            {
                return question.QuestionName;
            }
            count++;
        }
        return null;
    }

    public void ApplySignUp(String Username , String Password , String NickName , String  Email , String Gender)
    {
        String HashedPassword = HashAlghorithm.DecryptPassword(Password);
        User newuser = new User(Username , Password , HashedPassword , Email , App.Users.size() , NickName , Gender);
        newuser.setAvatar(GameAssetsManager.getInstance().RandomAvatar());
        App.Users.add(newuser);
        Appview.UserLoggedInId = App.Users.size() - 1;
        Appview.Situation = MenuName.LoginMenu;
    }

    public void Update()
    {
        if(Menu.getRandom().isChecked())
        {
            String RandomPassword = RandomPassword();
            Menu.getPassword().setText(RandomPassword);
            Menu.getRandom().setChecked(false);
        }
        if(Menu.getSignupTable().isVisible()) {
            if (Menu.getConfirm().isChecked()) {
                if (Menu.getUsername().getText().isEmpty()) {
                    Menu.getErrorMessage().setText("Username feild is empty");
                } else {
                    if (Menu.getPassword().getText().isEmpty()) {
                        Menu.getErrorMessage().setText("Password feild is empty");
                    } else {
                        if (!IsUsernameValid(Menu.getUsername().getText())) {
                            Menu.getErrorMessage().setText("Username is invalid");
                        } else {
                            if (IsUsernameTaken(Menu.getUsername().getText())) {
                                Menu.getErrorMessage().setText("Username already exists");
                            } else {
                                if (Menu.getEmail().getText().isEmpty() || !IsEmailValid(Menu.getEmail().getText())) {
                                    Menu.getErrorMessage().setText("Email address is invalid");
                                } else {
                                    if (!IsPasswordWeak(Menu.getPassword().getText())) {
                                        Menu.getErrorMessage().setText("Password is weak");
                                    } else {
                                        Menu.getSignupTable().setVisible(false);
                                        Menu.getSequrityQuestions().setVisible(true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(Menu.getSequrityQuestions().isVisible())
        {
            if(Menu.getConfirmAnswer().isChecked())
            {
                if(Menu.getAnswer().getText().isEmpty())
                {

                }
                else
                {
                    ApplySignUp(Menu.getUsername().getText() , Menu.getPassword().getText() ,Menu.getNickname().getText() , Menu.getEmail().getText() , Menu.getGender().getSelected());
                    int QuestionId = 0;
                    for(SecurityQuestions question : SecurityQuestions.values())
                    {
                        if(Menu.getQuestions().getSelected().toString().equals(question.toString()))
                        {
                            break;
                        }
                        QuestionId++;
                    }
                    SetQuestion(QuestionId , Menu.getAnswer().getText());
                    Main.getMain().setScreen(new MainMenu(new MainmenuController()));
                }
            }
        }
        Menu.getConfirmAnswer().setChecked(false);
        Menu.getConfirm().setChecked(false);
    }
}

