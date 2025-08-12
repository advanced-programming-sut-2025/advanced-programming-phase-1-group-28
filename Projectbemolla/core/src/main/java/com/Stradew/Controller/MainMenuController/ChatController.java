package com.Stradew.Controller.MainMenuController;

import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.View.MainMenu.GameMenu;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
//import jdk.internal.org.commonmark.node.Text;

import java.util.ArrayList;

public class ChatController {

    private TextField text;
    private TextButton SendButton;
    private TextButton backButton;
    private ArrayList<String> Messages = new ArrayList<>();
    private BitmapFont font = new BitmapFont();

    public ArrayList<String> getMessages() {
        return Messages;
    }

    public void FirstTouch(GameMenu menu) {
        text = new TextField("Message" , GameAssetsManager.getInstance().getSkin());
        SendButton = new TextButton("Send", GameAssetsManager.getInstance().getSkin());
        backButton = new TextButton("Back", GameAssetsManager.getInstance().getSkin());
        menu.getChatTable().add(text);
        menu.getChatTable().add(SendButton);
        menu.getChatTable().add(backButton);
    }

    public void Update(GameMenu menu)
    {
        if(SendButton.isChecked())
        {
            if(text.getText() != null)
            {
                App.networkClient.sendMessage("NEW_CHAT " + text.getText());
            }
            SendButton.setChecked(false);
        }
        if(backButton.isChecked())
        {
            menu.getChatTable().setVisible(false);
            menu.getMainTable().setVisible(true);
            backButton.setChecked(false);
        }
        for(int i = 0;i < Messages.size();i++)
        {
            font.draw(Main.getMain().getBatch(), Messages.get(i), App.ReturnCurrentPlayer().getX() - 100 , App.ReturnCurrentPlayer().getY() + 300 - (100 * i));
        }
    }
}
