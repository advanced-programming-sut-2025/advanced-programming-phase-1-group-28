package com.Stradew.Server; // Your package name

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


public class GameServer {
    private static final int PORT = 8080;
    private final Map<String, ClientHandler> connectedClients = new ConcurrentHashMap<>();

    private final Map<String, Lobby> activeLobbies = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        GameServer server = new GameServer();
        try {
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Listening on port " + PORT + "...");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                new Thread(clientHandler).start();
            } catch (IOException e) {
                System.err.println("Error accepting client connection: " + e.getMessage());
            }
        }
    }


    public synchronized String createLobby(String lobbyName, String adminId, String password , String UsernameId , boolean Visible) {
        Lobby newLobby = new Lobby(lobbyName, adminId, password , UsernameId);
        newLobby.setVisible(Visible);
        activeLobbies.put(newLobby.getId(), newLobby);

        System.out.println("Lobby created: " + newLobby.getName() + " (ID: " + newLobby.getId() + ")");
        broadcastLobbyUpdate();
        return "LOBBY_CREATED" + " " + newLobby.getLobbyInfo();
    }

    public synchronized String joinLobby(String lobbyId, String playerId, String password , String username) {
        Lobby lobby = activeLobbies.get(lobbyId);
        if (lobby == null) {
            return "ERROR_Lobby_not_found.";
        }
        if (!lobby.checkPassword(password)) {
            return "ERROR_Incorrect_password.";
        }
        if (!lobby.addPlayer(playerId)) {
            return "ERROR_Lobby_is_full.";
        }
       // lobby.addPlayer(playerId);
        lobby.getUsernames().add(username);
        broadcastLobbyUpdate();
        return "SUCCESS_JOINED_LOBBY" + " " + lobby.getLobbyInfo();
    }

    public synchronized void leaveLobby(String lobbyId, String playerId) {
        Lobby lobby = activeLobbies.get(lobbyId);
        if (lobby != null) {
            lobby.removePlayer(playerId);
            if (lobby.getPlayerIds().isEmpty()) {
                activeLobbies.remove(lobbyId);
                System.out.println("Lobby removed: " + lobby.getName());
            }
        }
        broadcastLobbyUpdate();
    }

    public String getLobbyListString() {
        if(activeLobbies.isEmpty()) {
            return "LOBBY_LIST_EMPTY";
        }
        return "LOBBY_LIST " + activeLobbies.values().stream()
            .map(Lobby::getLobbyInfo)
            .collect(Collectors.joining("|"));
    }

    public String getOnlinePlayersString() {
        if(connectedClients.isEmpty()) {
            return "PLAYER_LIST_EMPTY";
        }
        return "PLAYER_LIST " + String.join(";", connectedClients.keySet());
    }

    public void broadcastLobbyUpdate() {
        broadcastMessage(getLobbyListString());
    }

    public void broadcastPlayerUpdate() {
        broadcastMessage(getOnlinePlayersString());
    }


    public void broadcastMessage(String message) {
        for (ClientHandler client : connectedClients.values()) {
            client.sendMessage(message);
        }
    }

    public void ApplyStartLobby(String LobbyId){
        Lobby lobby = activeLobbies.get(LobbyId);
        lobby.setGetStarted(true);
        broadcastMessage("LOBBY_STARTED" + " "  + LobbyId);
    }


    public void addClient(ClientHandler handler) {
        connectedClients.put(handler.getClientId(), handler);
        System.out.println("Client " + handler.getClientId() + " added. Total: " + connectedClients.size());
        broadcastPlayerUpdate();
        System.out.println(getLobbyListString() + "Ahmagh");
        handler.sendMessage(getLobbyListString());
    }

    public void removeClient(String clientId) {
        String lobbyLeftId = null;
        for(Lobby lobby : activeLobbies.values()){
            if (lobby.getPlayerIds().contains(clientId)) {
                lobbyLeftId = lobby.getId();
                break;
            }
        }
        if (lobbyLeftId != null) {
            leaveLobby(lobbyLeftId, clientId);
        }

        connectedClients.remove(clientId);
        System.out.println("Client " + clientId + " removed. Total: " + connectedClients.size());
        broadcastPlayerUpdate();
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;
    private final GameServer server;
    private final String clientId;
    private DataOutputStream out;
    private DataInputStream in;

    public ClientHandler(Socket socket, GameServer server) {
        this.socket = socket;
        this.server = server;
        this.clientId = "player-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public String getClientId() {
        return clientId;
    }

    @Override
    public void run() {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            sendMessage("SET_ID " + clientId);
            server.addClient(this);

            String clientMessage;
            while ((clientMessage = in.readUTF()) != null) {
                handleMessage(clientMessage);
            }
        } catch (IOException e) {
            System.out.println("Client " + clientId + " connection lost.");
        } finally {
            closeConnection();
        }
    }

    private void handleMessage(String message) {
        String[] parts = message.split(" ", 10);
        String command = parts[0].toUpperCase();
        System.out.println(message);
        switch (command) {
            case "CREATE_LOBBY":
                if (parts.length > 1) {
                    String lobbyName = parts[1];
                    String password = (parts.length > 4) ? parts[4] : "";
                    String Username = parts[2];
                    boolean visible = Boolean.parseBoolean(parts[3]);
                    String response = server.createLobby(lobbyName, this.clientId, password , Username , visible);
                    sendMessage(response);
                }
                break;

            case "LOBBY_GAME_STARTED":
                if (parts.length > 1) {
                    System.out.println("I AM HERE");
                    String lobbyId = parts[1];
                    server.ApplyStartLobby(lobbyId);
                    //sendMessage(Response);
                }
                break;
            case "JOIN_LOBBY":
                if (parts.length > 1) {
                    String lobbyId = parts[1];
                    String joinPassword = (parts.length > 3) ? parts[3] : "";
                    String Username = parts[2];
                    String response = server.joinLobby(lobbyId, this.clientId, joinPassword , Username);
                    sendMessage(response);
                }
                break;

            case "LEAVE_LOBBY":
                if (parts.length > 1) {
                    String lobbyToLeave = parts[1];
                    server.leaveLobby(lobbyToLeave, this.clientId);
                }
                break;

            default:
                sendMessage("ERROR Unknown command");
                break;
        }
    }

    public void sendMessage(String message) {
        try {
            if (socket.isConnected() && !socket.isClosed()) {
                out.writeUTF(message);
                out.flush();
            }
        } catch (IOException e) {
            closeConnection();
        }
    }

    private void closeConnection() {
        server.removeClient(clientId);
        try {
            if (socket != null) socket.close();
        } catch (IOException e) {}
    }
}
