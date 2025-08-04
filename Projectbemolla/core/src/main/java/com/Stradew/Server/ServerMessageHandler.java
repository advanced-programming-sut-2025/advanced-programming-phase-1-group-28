package com.Stradew.Server;

public interface ServerMessageHandler {
    void handleServerMessage(String message);
    void handleDisconnection();
}
