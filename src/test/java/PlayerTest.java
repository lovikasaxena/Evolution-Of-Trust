import com.twx.eot.exceptions.WrongInputException;
import com.twx.eot.players.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

    private Player userPlayer = new Player("1", new UserBehaviour());
    private Player cheatPlayer = new Player("2", new CheatBehaviour());
    private Player cooperatePlayer = new Player("3", new CooperateBehaviour());
    private Player copyCatPlayer = new Player("4", new CopyCatBehaviour());
    private Player grudgePlayer = new Player("5", new GrudgeBehaviour());
    private Player detectivePlayer = new Player("6", new DetectiveBehaviour());

    private DetectiveBehaviour detectiveBehaviour = new DetectiveBehaviour();

    @Test
    public void shouldReturnPlayerActionCHEATForCHEAT() throws WrongInputException {
        String input = "CHEAT";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(userPlayer.takeTurn(), PlayerAction.CHEAT);
    }

    @Test
    public void shouldReturnPlayerActionCOOPERATEForCOOPERATE() throws WrongInputException {
        String input = "COOPERATE";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(userPlayer.takeTurn(), PlayerAction.COOPERATE);
    }

    @Test
    public void shouldReturnPlayerActionCOOPERATEFromEnumPlayerAction() throws WrongInputException {
        String input = "COOPERATE";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(PlayerAction.fromString("COOPERATE"), PlayerAction.COOPERATE);
    }

    @Test
    public void shouldReturnPlayerActionCHEATFromEnumPlayerAction() throws WrongInputException {
        String input = "CHEAT";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(PlayerAction.fromString("CHEAT"), PlayerAction.CHEAT);
    }

    @Test
    public void shouldReturnCHEATWhenPlayerBehavioursIsCHEAT() throws WrongInputException {
        Assert.assertEquals(cheatPlayer.takeTurn(), PlayerAction.CHEAT);
    }

    @Test
    public void shouldReturnCOOPERATEWhenPlayerBehavioursIsCOOPERATE() throws WrongInputException {
        Assert.assertEquals(cooperatePlayer.takeTurn(), PlayerAction.COOPERATE);
    }

    @Test
    public void copyCatShouldReturnCOOPERATEOnOneFirstTurnWhenBehaviourIsCopyCat() {
        Assert.assertEquals(copyCatPlayer.takeTurn(), PlayerAction.COOPERATE);
    }

    @Test
    public void copyCatShouldReturnCHEATWhenOtherPlayerPreviousActionIsCHEAT() {
        copyCatPlayer.setOtherPlayerPreviousAction(PlayerAction.CHEAT);
        Assert.assertEquals(copyCatPlayer.takeTurn(), PlayerAction.CHEAT);

    }

    @Test
    public void copyCatShouldReturnCOOPWhenOtherPlayerPreviousActionIsCOOP() {
        copyCatPlayer.setOtherPlayerPreviousAction(PlayerAction.COOPERATE);
        Assert.assertEquals(copyCatPlayer.takeTurn(), PlayerAction.COOPERATE);

    }

    @Test
    public void grudgePlayerShouldReturnCOOPWhenOtherPlayerHasNotCheated() {
        grudgePlayer.setOtherPlayerPreviousAction(PlayerAction.COOPERATE);
        Assert.assertEquals(grudgePlayer.takeTurn(), PlayerAction.COOPERATE);
    }

    @Test
    public void grudgePlayerShouldReturnCHEATWhenOtherPlayerHasCheated() {
        grudgePlayer.setOtherPlayerPreviousAction(PlayerAction.CHEAT);
        Assert.assertEquals(grudgePlayer.takeTurn(), PlayerAction.CHEAT);
    }

    @Test
    public void detectiveShouldReturnCOOPOnTurn1() {
        Assert.assertEquals(detectivePlayer.takeTurn(), PlayerAction.COOPERATE);
    }

    @Test
    public void detectiveShouldReturnCHEATOnTurn2() {
        detectiveBehaviour.setTurnNumber(1);
        Player detectivePlayer = new Player("2", detectiveBehaviour);

        Assert.assertEquals(detectivePlayer.takeTurn(), PlayerAction.CHEAT);
    }

    @Test
    public void detectiveShouldReturnCOOPOnTurn3() {
        detectiveBehaviour.setTurnNumber(2);
        Player detectivePlayer = new Player("2", detectiveBehaviour);

        Assert.assertEquals(detectivePlayer.takeTurn(), PlayerAction.COOPERATE);
    }

    @Test
    public void detectiveShouldReturnCOOPOnTurn4() {
        detectiveBehaviour.setTurnNumber(3);
        Player detectivePlayer = new Player("2", detectiveBehaviour);

        Assert.assertEquals(detectivePlayer.takeTurn(), PlayerAction.COOPERATE);
    }

    @Test
    public void detectiveShouldReturnCHEATOnTurn5IfOtherPlayerDoesNotCHEAT() {
        detectiveBehaviour.setTurnNumber(4);
        Player detectivePlayer = new Player("2", detectiveBehaviour);

        Assert.assertEquals(detectivePlayer.takeTurn(), PlayerAction.CHEAT);
    }

    @Test
    public void detectiveShouldCopyOnTurn6IfOtherPlayerCheats() {
        detectiveBehaviour.setTurnNumber(4);
        detectiveBehaviour.setOtherPlayerPreviousAction(PlayerAction.CHEAT);
        Player detectivePlayer = new Player("2", detectiveBehaviour);
        detectivePlayer.takeTurn();
        detectivePlayer.getBehaviour().setOtherPlayerPreviousAction(PlayerAction.COOPERATE);

        Assert.assertEquals(detectivePlayer.takeTurn(), PlayerAction.COOPERATE);
    }
    @Test
    public void detectiveShouldCopyOnTurn7IfOtherPlayerCheats() {
        detectiveBehaviour.setTurnNumber(4);
        detectiveBehaviour.setOtherPlayerPreviousAction(PlayerAction.CHEAT);
        Player detectivePlayer = new Player("2", detectiveBehaviour);
        detectivePlayer.takeTurn(); //turn 5
        detectivePlayer.getBehaviour().setOtherPlayerPreviousAction(PlayerAction.COOPERATE);
        detectivePlayer.takeTurn(); // turn 6
        detectivePlayer.getBehaviour().setOtherPlayerPreviousAction(PlayerAction.CHEAT);

        Assert.assertEquals(detectivePlayer.takeTurn(), PlayerAction.CHEAT);
    }




}

