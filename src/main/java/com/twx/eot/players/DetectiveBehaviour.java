package com.twx.eot.players;

public class DetectiveBehaviour extends CheatCautiousBehaviour {
    private int turnNumber = 0;

    @Override
    public PlayerAction takeTurn() {
        if(!hasOtherPlayerCheatedYet){
            isOtherPlayerPreviousActionCHEAT();
        }
        setTurnNumber(++turnNumber);
        if (turnNumber <= 4) {
            return makeDetectiveAnalysisMove();
        }
        if (hasOtherPlayerCheatedYet) {
            //return otherPlayerPreviousAction;
            player.setBehaviour(new CopyCatBehaviour());
            player.getBehaviour().setOtherPlayerPreviousAction(otherPlayerPreviousAction);
            return player.takeTurn();
        }
        return PlayerAction.CHEAT;
    }

    private PlayerAction makeDetectiveAnalysisMove() {
        switch (turnNumber) {
            case 1:
                return PlayerAction.COOPERATE;
            case 2:
                return PlayerAction.CHEAT;
            case 3:
                return PlayerAction.COOPERATE;
            case 4:
                return PlayerAction.COOPERATE;
        }
        return null;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

}
