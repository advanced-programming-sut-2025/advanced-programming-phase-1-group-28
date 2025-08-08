package com.Stradew.Server;

import com.Stradew.Model.App;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class NetworkClient implements Runnable {

    private final String host;
    private final int port;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;



    private volatile boolean running = true;

    private  ServerMessageHandler messageHandler;

    public void setMessageHandler(ServerMessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public NetworkClient(String host, int port, ServerMessageHandler handler) {
        this.host = host;
        this.port = port;
        this.messageHandler = handler;
    }

    @Override
    public void run() {
        try {
            socket = new Socket(host, port);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            System.out.println("Connected to server: " + host + ":" + port);

            while (running) {
                try {
                    String serverMessage = in.readUTF();
                    if (serverMessage != null) {
                        messageHandler.handleServerMessage(serverMessage);
                    }
                } catch (SocketException e) {
                    if (running) {
                        System.err.println("Connection lost: " + e.getMessage());
                        running = false;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to connect or was disconnected from the server: " + e.getMessage());
        } finally {
            messageHandler.handleDisconnection();
            close();
        }
    }

    public void SendInfoForRanking(String LobbyID)
    {
        sendMessage("INFO_FOR_RANK" + " " + LobbyID + " " + App.ReturnCurrentPlayer().getCoin() + " " + App.ReturnCurrentPlayer().getNumberOfQuests() + " " + App.ReturnCurrentPlayer().GetSumLevelSkills());
    }


    public void sendMessage(String message) {
        if (out != null) {
            try {
                out.writeUTF(message);
                out.flush();
            } catch (IOException e) {
                System.err.println("Failed to send message: " + e.getMessage());
                close();
            }
        }
    }

    public void close() {
        running = false;
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
        }
        System.out.println("Network client closed.");
    }
}
