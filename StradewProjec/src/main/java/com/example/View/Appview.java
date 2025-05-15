package com.example.View;

import com.example.Model.Enums.MenuName;

public class Appview {
    public static int UserLoggedInId = -1;
    public static MenuName Situation = MenuName.SignUpMenu;
    public static int IfStaySituation = -1;
    public static int CurrentGameID = -1;

    public static MenuName getSituation() {
        return Situation;
    }

    public static int getUserLoggedInId() {
        return UserLoggedInId;
    }

    public static void setUserLoggedInId(int userLoggedInId) {
        UserLoggedInId = userLoggedInId;
    }
}
