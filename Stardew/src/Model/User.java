package Model;

public class User {
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
                int answerIdQuestion, String answer) {
        Username = username;
        Password = password;
        HashedPassword = hashedPassword;
        Email = email;
        this.ID = ID;
        AnswerIdQuestion = answerIdQuestion;
        Answer = answer;
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
}
