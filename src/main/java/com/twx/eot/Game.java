import com.twx.eot.players.InputOutput;
import com.twx.eot.players.Player;
import com.twx.eot.players.PlayerInputs;
import com.twx.eot.players.WrongInputException;

public class Game {
    private final Player player1;
    private final Player player2;
    private final int totalRounds;
    private final TurnOptions turnOptions;
    private final ScoreBoard scoreBoard;
    private PlayerInputs previousRoundInputs;

    public Game(Player player1, Player player2, int totalRounds) {
        this.player1 = player1;
        this.player2 = player2;
        this.totalRounds = totalRounds;
        turnOptions = new TurnOptions();
        scoreBoard = new ScoreBoard(0, 0);
        previousRoundInputs = null;
    }

    void start() throws WrongInputException {
        InputOutput inout = new InputOutput();
        for (int i = 0; i < totalRounds; i++) {
            PlayerInputs playerInputs = new PlayerInputs(player1.takeTurn(), player2.takeTurn());
            //System.out.println(playerInputs);
            addResultToScores(getResultForRound(playerInputs));
            inout.display(displayScore());
            previousRoundInputs = playerInputs;
            player2.setOtherPlayerPreviousAction(playerInputs.getPlayer1Action()); //for player 2 only as player 1 will always be userPlayer.
        }
        inout.display(whoWins());
    }

//    private com.twx.eot.players.PlayerInputs getPlayerInputs() {
//        if (previousRoundInputs == null) {
//            return new com.twx.eot.players.PlayerInputs(player1.takeTurn(null), player2.takeTurn(null));
//        }
//        com.twx.eot.players.PlayerAction player1PreviousInput = previousRoundInputs.getPlayer1Action();
//        com.twx.eot.players.PlayerAction player2PreviousInput = previousRoundInputs.getPlayer2Action();
//        return new com.twx.eot.players.PlayerInputs(player1.takeTurn(player2PreviousInput), player2.takeTurn(player1PreviousInput));
//    }

    String displayScore() {
        return "Player1 score = " + scoreBoard.getPlayerOneScore() +
                "; Player2 score = " + scoreBoard.getPlayerTwoScore();
    }

    public Result getResultForRound(PlayerInputs playerInputs) {
        return turnOptions.getOption(playerInputs);
    }

    public void addResultToScores(Result result) {
        scoreBoard.add(result);
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public String whoWins() {
        if (scoreBoard.getPlayerOneScore() > scoreBoard.getPlayerTwoScore()) {
            return player1.getPlayerName() + " WINS";
        } else if (scoreBoard.getPlayerOneScore() == scoreBoard.getPlayerTwoScore()) {
            return "DRAW";
        }
        return player2.getPlayerName() + " WINS";
    }
}
