package com.Stradew.Server;
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
        private final String password; // Can be null for public lobbies
        private final List<String> playerIds = new ArrayList<>();
        private ArrayList<String> Usernames = new ArrayList<>();
        private int NumberPlayers;
        private String adminId;
        private Boolean GetStarted = false;


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
            this.id = "lobby-" + UUID.randomUUID().toString().substring(0, 8);
            this.name = name;
            this.adminId = adminId;
            this.password = password;
            Usernames.add(Usernameid);
            addPlayer(adminId);
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public boolean isPrivate() { return password != null && !password.isEmpty(); }

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
            if (!isPrivate()) return true;
            return this.password.equals(pass);
        }


        // Method to get a string representation of the lobby for sending to clients
        // Format: LOBBY_ID;LOBBY_NAME;PLAYER_COUNT;IS_PRIVATE
        public String getLobbyInfo() {
            return String.format("%s;%s;%b;%s;%s", name, playerIds.size(),  isPrivate() , id , getUsernamesInfo());
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
