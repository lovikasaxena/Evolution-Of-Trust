public class ScoreBoard {
    private int playerOneScore;
    private int playerTwoScore;

    public ScoreBoard(int playerOneScore, int playerTwoScore) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void add(Result result) {
        playerOneScore += result.getPlayerOneScore();
        playerTwoScore += result.getPlayerTwoScore();
    }
}
