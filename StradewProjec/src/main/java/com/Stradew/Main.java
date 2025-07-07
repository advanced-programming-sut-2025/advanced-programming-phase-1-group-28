package com.Stradew;
import com.Stradew.View.AppInputCommand;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AppInputCommand InputObject = new AppInputCommand();
        while(true) {
            if(!InputObject.InputCommands())
            {
                break;
            }
        }
    }
}