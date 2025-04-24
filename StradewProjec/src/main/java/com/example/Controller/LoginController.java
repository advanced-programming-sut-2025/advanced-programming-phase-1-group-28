package com.example.Controller;

import com.example.Model.App;
import com.example.Model.Enums.MenuName;
import com.example.Model.Enums.SecurityQuestions;
import com.example.Model.User;
import com.example.View.Appview;

public class LoginController {
    public boolean IsUsernameValid(String username)
    {
        return App.signUpController.IsUsernameTaken(username);
    }
    public boolean CheckPassword(String Username , String Password)
    {
        int UserIndex = App.ReturnUserIndex(Username);
        return (App.Users.get(UserIndex).getPassword().equals(Password));
    }
    public void ApplyLogin(String UserName , Boolean IfStaySituation)
    {
        int UserIndex = App.ReturnUserIndex(UserName);
        Appview.setUserLoggedInId(UserIndex);
        Appview.Situation = MenuName.MainMenu;
        if(IfStaySituation)
        {
            Appview.IfStaySituation = UserIndex;
        }
    }
    public String PrintQuestion(String UserName)
    {
        int UserIndex = App.ReturnUserIndex(UserName);
        int Count = 0;
        for(SecurityQuestions q : SecurityQuestions.values())
        {
            if(App.Users.get(UserIndex).getAnswerIdQuestion() == Count)
            {
                return q.QuestionName;
            }
            Count++;
        }
        return "";
    }
    public boolean CheckAnswer(String UserName , String Answer)
    {
        int UserIndex = App.ReturnUserIndex(UserName);
        return App.Users.get(UserIndex).getAnswer().equals(Answer);
    }
    public void ApplyChangePassword(String UserName , String NewPassword)
    {
        int USerIndex = App.ReturnUserIndex(UserName);
        App.Users.get(USerIndex).setPassword(NewPassword);
        App.Users.get(USerIndex).setHashedPassword(HashAlghorithm.DecryptPassword(NewPassword));
    }
}
