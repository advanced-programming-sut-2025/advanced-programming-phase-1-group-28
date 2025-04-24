package com.example.Model.Enums;

public enum MenuName {
    SignUpMenu("SignupMenu") ,
    LoginMenu("LoginMenu") ,
    MainMenu("MainMenu") ,
    ProfileMenu("ProfileMenu") ,
    GameMenu("GameMenu");
    public final String Name;
    MenuName(String name) {
        Name = name;
    }
}
