package com.example.Model;

public class User {
    private String Gender;
    private String Nickname;
    private String Username;
    private String Password;;
    private String HashedPassword;
    private String Email;
    private int ID;
    private int AnswerIdQuestion;
    private String Answer;
    private int HighestScore = 0;
    private int GamesPlayed = 0;
    private int GameId = -1;


    public User(String username, String password, String hashedPassword, String email, int ID,
                 String nickname , String Gender) {
        Username = username;
        Password = password;
        HashedPassword = hashedPassword;
        Email = email;
        this.ID = ID;
        Nickname = nickname;
        this.Gender = Gender;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getHashedPassword() {
        return HashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        HashedPassword = hashedPassword;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAnswerIdQuestion() {
        return AnswerIdQuestion;
    }

    public void setAnswerIdQuestion(int answerIdQuestion) {
        AnswerIdQuestion = answerIdQuestion;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public int getHighestScore() {
        return HighestScore;
    }

    public void setHighestScore(int highestScore) {
        HighestScore = highestScore;
    }

    public int getGamesPlayed() {
        return GamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        GamesPlayed = gamesPlayed;
    }

    public int getGameId() {
        return GameId;
    }

    public void setGameId(int gameId) {
        GameId = gameId;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
