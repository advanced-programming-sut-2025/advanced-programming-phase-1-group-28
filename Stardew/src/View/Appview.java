package View;

import Model.Enums.MenuName;

public class Appview {
    public static int UserLoggedInId = -1;
    public static MenuName Situation = MenuName.SignUpMenu;
    public boolean IfStaySituation;
    public int CurrentGameID;

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
