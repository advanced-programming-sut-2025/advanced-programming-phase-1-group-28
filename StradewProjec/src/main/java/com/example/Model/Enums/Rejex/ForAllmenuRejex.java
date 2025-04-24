package com.example.Model.Enums.Rejex;

import java.util.regex.Pattern;

public enum ForAllmenuRejex {
    ShowCurrentMenu(Pattern.compile("show\\s+current\\s+menu")),
    GoTOMenu(Pattern.compile("menu\\s+enter\\s+(.+)"));
    public final Pattern Rejex;
    ForAllmenuRejex(Pattern Rejex) {
        this.Rejex = Rejex;
    }
}
