package com.Stradew.Server;
import com.badlogic.gdx.Gdx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


// =================================================================================
// Lobby Class - Represents a single game lobby
// =================================================================================
    /**
     * A new class to hold all information about a game lobby.
     */
    public class Lobby {
        private boolean isVisible;
        private  String id;
        private final String name;
        private final String password;
        private final List<String> playerIds = new ArrayList<>();
        private ArrayList<String> Usernames = new ArrayList<>();
        private ArrayList<Integer> SumLevelSkills = new ArrayList<>();
        private ArrayList<Integer> NumOfQuests = new ArrayList<>();
        private ArrayList<Integer> Coins = new ArrayList<>();
        private int NumberPlayers;
        private String adminId;
        private Boolean GetStarted = false;
        private Boolean PrivateIS  = true;


        public ArrayList<Integer> getCoins() {
            return Coins;
        }

        public ArrayList<Integer> getNumOfQuests() {
            return NumOfQuests;
        }

        public ArrayList<Integer> getSumLevelSkills() {
            return SumLevelSkills;
        }

        public Boolean getGetStarted() {
            return GetStarted;
        }

        public void setGetStarted(Boolean getStarted) {
            GetStarted = getStarted;
        }

        public ArrayList<String> getUsernames() {
            return Usernames;
        }

        public void setNumberPlayers(int numberPlayers) {
            NumberPlayers = numberPlayers;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setVisible(boolean visible) {
            isVisible = visible;
        }

        public Lobby(String name, String adminId, String password , String Usernameid) {
            for(int i =0 ; i < 5 ; i++)
            {
                NumOfQuests.add(0);
                Coins.add(0);
                SumLevelSkills.add(0);
            }
            this.id = "lobby-" + UUID.randomUUID().toString().substring(0, 8);
            this.name = name;
            this.adminId = adminId;
            if(password != null) {
                if (password.equals("AJAB")) {
                    PrivateIS = false;
                }
            }
            if(password == null)
            {
                PrivateIS = false;
            }
            this.password = password;
            Usernames.add(Usernameid);
            addPlayer(adminId);
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public boolean isPrivate() {
            return PrivateIS;
        }

        public synchronized boolean addPlayer(String playerId) {
            if (playerIds.size() < 10) { // Max 4 players per lobby
                playerIds.add(playerId);
                return true;
            }
            return false;
        }

        public int getNumberPlayers() {
            return NumberPlayers;
        }

        public List<String> getPlayerIds() {
            return playerIds;
        }

        public synchronized void removePlayer(String playerId) {
            for(int i = 0; i < playerIds.size(); i++) {
                if (playerId.equals(playerIds.get(i))) {
                    playerIds.remove(i);
                    Usernames.remove(i);
                }
            }
            //playerIds.remove(playerId);
            // If the admin leaves, assign a new admin or close the lobby
            if (playerId.equals(adminId) && !playerIds.isEmpty()) {
                this.adminId = playerIds.get(0);
            }
        }

        public boolean isEmpty() {
            return playerIds.isEmpty();
        }

        public boolean checkPassword(String pass) {
            System.out.println(this.password);
            if (!isPrivate()) {
                System.out.println("BaghaliZAde");
                return true;
            }
            return this.password.equals(pass);
        }

        public boolean isVisible() {
            return isVisible;
        }

        // Method to get a string representation of the lobby for sending to clients
        // Format: LOBBY_ID;LOBBY_NAME;PLAYER_COUNT;IS_PRIVATE
        public String getLobbyInfo() {
                return String.format("%s;%s;%b;%s;%s;%b", name, playerIds.size(), isPrivate(), id, getUsernamesInfo() , isVisible);
        }
        public String getUsernamesInfo()
        {
            if(Usernames.size() == 1)
            {
                return Usernames.get(0);
            }
            if(Usernames.size() == 2)
            {
                return Usernames.get(0) + ";" + Usernames.get(1);
            }
            if(Usernames.size() == 3)
            {
                return Usernames.get(0) + ";" + Usernames.get(1) + ";" + Usernames.get(2);
            }
            if(Usernames.size() == 4)
            {
                return Usernames.get(0) + ";" + Usernames.get(1) + ";" + Usernames.get(2) + ";" + Usernames.get(3);
            }
            return null;
        }
    }
