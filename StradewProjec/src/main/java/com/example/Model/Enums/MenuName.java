package com.example.Model.Enums;

import com.example.View.MainMenu.GameMenu;

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
