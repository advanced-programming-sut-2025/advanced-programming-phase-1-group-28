package com.Stradew.Model;

public class UserForRank {

    private String USername;
    private int Coin = 100;
    private int NumberOfQuests = 0;
    private int SumofLevels = 3;

    public String getUSername() {
        return USername;
    }

    public int getCoin() {
        return Coin;
    }

    public int getNumberOfQuests() {
        return NumberOfQuests;
    }

    public int getSumofLevels() {
        return SumofLevels;
    }

    public void setUSername(String USername) {
        this.USername = USername;
    }

    public void setNumberOfQuests(int numberOfQuests) {
        NumberOfQuests = numberOfQuests;
    }

    public void setSumofLevels(int sumofLevels) {
        SumofLevels = sumofLevels;
    }

    public void setCoin(int coin) {
        Coin = coin;
    }
}
