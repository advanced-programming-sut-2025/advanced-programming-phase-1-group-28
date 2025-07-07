package com.Stradew.Model.Enums;

public enum MenuName {
    SignUpMenu("SignUpMenu") ,
    LoginMenu("LoginMenu") ,
    MainMenu("MainMenu") ,
    ProfileMenu("ProfileMenu") ,
    GameMenu("GameMenu"),
    Greenhouse("Greenhouse");
    public final String Name;
    MenuName(String name) {
        Name = name;
    }
}
