package com.twx.eot.players;

public class DetectivePlayer extends PlayerBehaviour {
    private int turnNumber = 0;
    private boolean hasOtherPlayerCheated = false;

    @Override
    public PlayerAction takeTurn() {
        if (!hasOtherPlayerCheated) {
            isOtherPlayerPreviousActionCHEAT();
        }
        switch (++turnNumber) {
            case 1:
                return PlayerAction.COOPERATE;
            case 2:
                return PlayerAction.CHEAT;
            case 3:
                return PlayerAction.COOPERATE;
            case 4:
                return PlayerAction.COOPERATE;
            default: {
                if(!hasOtherPlayerCheated){
                    ///////// MAKE IT CHEAT PLAYER
                    PlayerBehaviour newBehaviour = (PlayerBehaviour) new CheatPlayer();

                }
                else{
                    // MAKE COPYCAT
                }
            }
        }

        return null;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }
    private void isOtherPlayerPreviousActionCHEAT() {
        if (otherPlayerPreviousAction == PlayerAction.CHEAT) {
            hasOtherPlayerCheated = true;
        }
    }
}
