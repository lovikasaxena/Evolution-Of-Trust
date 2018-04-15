import com.twx.eot.Game;
import com.twx.eot.PlayerInputs;
import com.twx.eot.Result;
import com.twx.eot.exceptions.WrongInputException;
import com.twx.eot.players.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    private Player player1 = new Player("PLAYER 1", new UserBehaviour());
    private Player player2 = new Player("PLAYER 2", new UserBehaviour());
    private Game game = new Game(player1, player2, 5);

    private Player cheatPlayer = new Player("PLAYER 2", new CheatBehaviour());
    private Player cooperatePlayer = new Player("PLAYER 2", new CooperateBehaviour());
    private Player copyCatPlayer = new Player("PLAYER 2", new CopyCatBehaviour());
    private Player grudgePlayer = new Player("Player 2", new GrudgeBehaviour());
    private Player detectivePlayer = new Player("PLAYER 2", new DetectiveBehaviour());

    @Mock
    private Player player3 = new Player("PLAYER 1", new UserBehaviour());
    @Mock
    private Player player4 = new Player("PLAYER 2", new UserBehaviour());


    @Test
    public void shouldReturn0And0ForInputsCheatCheat() {
        assertEquals(new Result(0, 0), game.getResultForRound(new PlayerInputs(PlayerAction.CHEAT, PlayerAction.CHEAT)));
    }

    @Test
    public void shouldReturn3And_1ForInputsCheatCoop() {
        assertEquals(new Result(3, -1), game.getResultForRound(new PlayerInputs(PlayerAction.CHEAT, PlayerAction.COOPERATE)));
    }

    @Test
    public void shouldReturn2And2ForInputsCoopCoop() {
        assertEquals(new Result(2, 2), game.getResultForRound(new PlayerInputs(PlayerAction.COOPERATE, PlayerAction.COOPERATE)));
    }

    @Test
    public void shouldReturn_1And3ForInputsCoopCheat() {
        assertEquals(new Result(-1, 3), game.getResultForRound(new PlayerInputs(PlayerAction.COOPERATE, PlayerAction.CHEAT)));
    }

    @Test
    public void shouldReturnBothScores0() {
        assertEquals("Player1 score = 0; Player2 score = 0", game.displayScore());
    }

    @Test
    public void shouldReturnAddedScore2And2() {
        Result result = new Result(2, 2);
        game.addResultToScores(result);

        assertEquals(2, game.getScoreBoard().getPlayerOneScore());
        assertEquals(2, game.getScoreBoard().getPlayerTwoScore());
    }

    @Test
    public void shouldReturnPlayer1WinsWhenHisScoreIsMore() throws WrongInputException {
        when(player3.takeTurn()).thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT);
        when(player4.takeTurn()).thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE);
        Game game = new Game(player3, player4, 5);
        game.start();

        assertEquals(game.getScoreBoard().getPlayerOneScore(), 8);
        assertEquals(game.getScoreBoard().getPlayerTwoScore(), 0);
        assertEquals(game.whoWins(), player3.getPlayerName() + " WINS");

        //returning name of player as null because player is mocked? So asserting scoreboard also
    }

    @Test
    public void shouldReturnPlayer2WinsWhenHisScoreIsMore() throws WrongInputException {
        when(player4.takeTurn()).thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE);
        when(player3.takeTurn()).thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT);
        Game game = new Game(player4, player3, 5);
        game.start();

        assertEquals(game.getScoreBoard().getPlayerOneScore(), 0);
        assertEquals(game.getScoreBoard().getPlayerTwoScore(), 8);
        assertEquals(game.whoWins(), player3.getPlayerName() + " WINS");
    }

    @Test
    public void shouldReturnDrawWhenScoresEqual() throws WrongInputException {
        when(player4.takeTurn()).thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE);
        when(player3.takeTurn()).thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE);
        Game game = new Game(player4, player3, 5);
        game.start();

        assertEquals(game.getScoreBoard().getPlayerOneScore(), 6);
        assertEquals(game.getScoreBoard().getPlayerTwoScore(), 6);
        assertEquals(game.whoWins(), "DRAW");
    }

    @Test
    public void shouldReturnScoreWhenPlayedWithCHEATPlayerWithGivenActions() throws WrongInputException {
        when(player4.takeTurn()).thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE);
        Game game = new Game(player4, cheatPlayer, 5);
        game.start();

        assertEquals(game.getScoreBoard().getPlayerOneScore(), -3);
        assertEquals(game.getScoreBoard().getPlayerTwoScore(), 9);
        assertEquals(game.whoWins(), cheatPlayer.getPlayerName() + " WINS");
    }

    @Test
    public void shouldReturnScoreWhenPlayedWithCOOPlayerWithGivenActions() throws WrongInputException {
        when(player4.takeTurn()).thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE);
        Game game = new Game(player4, cooperatePlayer, 5);
        game.start();

        assertEquals(game.getScoreBoard().getPlayerOneScore(), 12);
        assertEquals(game.getScoreBoard().getPlayerTwoScore(), 4);
        assertEquals(game.whoWins(), player3.getPlayerName() + " WINS");
    }

    @Test
    public void shouldReturnPlayer1WinsWhenHisScoreGreaterThanCopyCatPlayer() throws WrongInputException {
        when(player3.takeTurn()).thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT);
        Game game = new Game(player3, copyCatPlayer, 5);
        game.start();

        assertEquals(game.getScoreBoard().getPlayerOneScore(), 5);
        assertEquals(game.getScoreBoard().getPlayerTwoScore(), 1);
        assertEquals(game.whoWins(), player3.getPlayerName() + " WINS");
    }

    @Test
    public void shouldReturnDRAWWhenUserPlayerAndCopyCatPlayerScoreSame() throws WrongInputException {
        when(player3.takeTurn()).thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE);
        Game game = new Game(player3, copyCatPlayer, 5);
        game.start();

        assertEquals(game.getScoreBoard().getPlayerOneScore(), 8);
        assertEquals(game.getScoreBoard().getPlayerTwoScore(), 8);
        assertEquals(game.whoWins(), "DRAW");
    }

    @Test
    public void shouldReturnPlayer2WinsWhenUserPlayerCheatsGrudgePlayerInInitialRounds() throws WrongInputException {
        when(player3.takeTurn()).thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE);
        Game game = new Game(player3, grudgePlayer, 5);
        game.start();

        assertEquals(game.getScoreBoard().getPlayerOneScore(), 2);
        assertEquals(game.getScoreBoard().getPlayerTwoScore(), 10);
        assertEquals(game.whoWins(), grudgePlayer.getPlayerName() + " WINS");
    }

    @Test
    public void shouldReturnPlayer1WinsWhenUserPlayerCheatsGrudgePlayerInLastRound() throws WrongInputException {
        when(player3.takeTurn()).thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT);
        Game game = new Game(player3, grudgePlayer, 5);
        game.start();

        assertEquals(game.getScoreBoard().getPlayerOneScore(), 11);
        assertEquals(game.getScoreBoard().getPlayerTwoScore(), 7);
        assertEquals(game.whoWins(), player3.getPlayerName() + " WINS");
    }

    @Test
    public void shouldReturnPlayer1WinsWhenUserPlayerCheatsDetectivePlayerInAllRounds() throws WrongInputException {
        when(player3.takeTurn()).thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.CHEAT);
        Game game = new Game(player3, detectivePlayer, 5);
        game.start();

        assertEquals(game.getScoreBoard().getPlayerOneScore(), 9);
        assertEquals(game.getScoreBoard().getPlayerTwoScore(), -3);
        assertEquals(game.whoWins(), player3.getPlayerName() + " WINS");
    }

    @Test
    public void shouldReturnScore6n6WhenUserPlayerPlaysWithDetectivePlayerWithGivenActions() throws WrongInputException {
        when(player3.takeTurn()).thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.CHEAT);
        Game game = new Game(player3, detectivePlayer, 5);
        game.start();

        assertEquals(game.getScoreBoard().getPlayerOneScore(), 6);
        assertEquals(game.getScoreBoard().getPlayerTwoScore(), 6);
        assertEquals(game.whoWins(), "DRAW");
    }
    @Test
    public void shouldReturnScore7n11WhenUserPlayerPlaysWithDetectivePlayerWithGivenActions() throws WrongInputException {
        when(player3.takeTurn()).thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT)
                .thenReturn(PlayerAction.COOPERATE)
                .thenReturn(PlayerAction.CHEAT);

        Game game = new Game(player3, detectivePlayer, 7);
        game.start();

        assertEquals(game.getScoreBoard().getPlayerOneScore(), 7);
        assertEquals(game.getScoreBoard().getPlayerTwoScore(), 11);
        assertEquals(game.whoWins(), detectivePlayer.getPlayerName() + " WINS");
    }


}
