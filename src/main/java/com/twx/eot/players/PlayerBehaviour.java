public abstract class PlayerBehaviour {
    PlayerAction otherPlayerPreviousAction = null;

    public PlayerAction getOtherPlayerPreviousAction() {
        return otherPlayerPreviousAction;
    }

    public void setOtherPlayerPreviousAction(PlayerAction otherPlayerPreviousAction) {
        this.otherPlayerPreviousAction = otherPlayerPreviousAction;
    }

    public abstract PlayerAction takeTurn();

//    public PlayerBehaviour userPlayerTurn = (PlayerAction previousPlayerAction) -> {
//        String turn = new InputOutput().getInput();
//        return PlayerAction.fromString(turn);
//    };
//
//    public PlayerBehaviour cheatPlayerTurn = (PlayerAction previousPlayerAction) -> PlayerAction.CHEAT;
//
//    public PlayerBehaviour cooperatePlayerTurn = (PlayerAction previousPlayerAction) -> PlayerAction.COOPERATE;



}