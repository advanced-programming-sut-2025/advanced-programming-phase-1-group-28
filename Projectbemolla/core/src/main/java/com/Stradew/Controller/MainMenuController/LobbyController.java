package com.Stradew.Controller.MainMenuController;

import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.View.MainMenu.LobbyView;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class LobbyController {
    private LobbyView lobby;

    BitmapFont font = new BitmapFont();


    public void setLobby(LobbyView lobby) {
        this.lobby = lobby;
    }

    public void Update()
    {
        if(lobby.getMainTable().isVisible())
        {
            if(lobby.getCreateLobbyButton().isChecked())
            {
                lobby.getCreateLobbyTable().setVisible(true);
                lobby.getMainTable().setVisible(false);
                lobby.getCreateLobbyButton().setChecked(false);
            }
            if(lobby.getJoinLobbyButton().isChecked())
            {
                lobby.getJoiningLobbyTable().setVisible(true);
                lobby.getMainTable().setVisible(false);
                lobby.getJoinLobbyButton().setChecked(false);
            }
        }
        if(lobby.getCreateLobbyTable().isVisible())
        {
            if(!lobby.getPublic_Private().isChecked())
            {
                lobby.getLobbyPassword().setVisible(true);
            }
            else
            {
                lobby.getLobbyPassword().setVisible(false);
            }
            if(lobby.getSubmitCreateLobby().isChecked())
            {
                if(!lobby.getPublic_Private().isChecked())
                {
                    //it is public
                    App.networkClient.sendMessage("CREATE_LOBBY "  + lobby.getLobbyName().getText() + " " + App.getCurrentUser().getUsername()  + " " +  "true");
                }
                else
                {
                    //it is not public
                    App.networkClient.sendMessage("CREATE_LOBBY "  + lobby.getLobbyName().getText() + " " + App.getCurrentUser().getUsername() + " " + "true" + " " +  lobby.getLobbyPassword().getText());
                }
                lobby.getInsideLobbyTable().setVisible(true);
                lobby.getCreateLobbyTable().setVisible(false);
                lobby.getSubmitCreateLobby().setChecked(false);
            }
        }
        if(lobby.getJoiningLobbyTable().isVisible())
        {
            font.draw(Main.getMain().getBatch(), "LobbyName" , 500 , 500);
            font.draw(Main.getMain().getBatch(), "Public" , 600 , 500);
            font.draw(Main.getMain().getBatch(), "Players inside" , 700 , 500);
            for(int i = 0; i < lobby.getLobbies().size(); i++)
            {
                if(lobby.getLobbies().get(i).getName() != null) {
                    font.draw(Main.getMain().getBatch(), lobby.getLobbies().get(i).getName(), 500, 600 + (i * 100));
                    font.draw(Main.getMain().getBatch(), String.valueOf(lobby.getLobbies().get(i).isPrivate()), 600, 600 + (i * 100));
                    font.draw(Main.getMain().getBatch(), String.valueOf(lobby.getLobbies().get(i).getNumberPlayers()), 700, 600 + (i * 100));
                }
            }
            if(lobby.getJoinLobbyWithThisname().isChecked())
            {
                for(int i = 0;i < lobby.getLobbies().size();i++)
                {
                    if(lobby.getLobbies().get(i).getName() != null) {
                        if(lobby.getLobbies().get(i).getName().equals(lobby.getLobbyToJoinName().getText())) {
                            App.networkClient.sendMessage("JOIN_LOBBY" + " "  + lobby.getLobbies().get(i).getId() + " " + App.getCurrentUser().getUsername() + " " + lobby.getLobbytojoinPassword().getText());
                        }
                    }
                }
                lobby.getJoinLobbyWithThisname().setChecked(false);
            }

        }
        if(lobby.getInsideLobbyTable().isVisible())
        {
            if(lobby.getCurrentLobby() != null) {
                font.draw(Main.getMain().getBatch(), lobby.getCurrentLobby().getName(), 800, 800);
                for (int i = 0; i < lobby.getCurrentLobby().getUsernames().size(); i++) {
                    font.draw(Main.getMain().getBatch(), lobby.getCurrentLobby().getUsernames().get(i), 500, 800 - i * 100);
                }
                if (lobby.getCurrentLobby().getUsernames().get(0).equals(App.getCurrentUser().getUsername())) {
                    lobby.getGoTOGame().setVisible(true);
                }
                else
                {
                    lobby.getGoTOGame().setVisible(false);
                }
                if (lobby.getLeaveLobby().isChecked()) {
                    App.networkClient.sendMessage("LEAVE_LOBBY" + " " + lobby.getCurrentLobby().getId());
                    lobby.getMainTable().setVisible(true);
                    lobby.getInsideLobbyTable().setVisible(false);
                    lobby.getCreateLobbyTable().setVisible(false);
                    lobby.getJoiningLobbyTable().setVisible(false);
                    lobby.getLeaveLobby().setChecked(false);
                }
                if (lobby.getGoTOGame().isChecked()) {
                    App.networkClient.sendMessage("LOBBY_GAME_STARTED" + " " + lobby.getCurrentLobby().getId());
                    lobby.getGoTOGame().setChecked(false);
                }

            }
        }
    }
}
