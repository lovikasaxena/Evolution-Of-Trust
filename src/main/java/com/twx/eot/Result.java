import java.util.Objects;

public class Result {
    private final int playerOneScore;
    private final int playerTwoScore;

    public Result(int playerOneScore, int playerTwoScore) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result that = (Result) o;
        return playerOneScore == that.playerOneScore &&
                playerTwoScore == that.playerTwoScore;
    }

    @Override
    public int hashCode() {

        return Objects.hash(playerOneScore, playerTwoScore);
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

}
