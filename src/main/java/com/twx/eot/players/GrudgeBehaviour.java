package com.twx.eot.players;

public class GrudgePlayer extends PlayerBehaviour {
    private boolean hasOtherPlayerCheated = false;

    @Override
    public PlayerAction takeTurn() {
        isOtherPlayerPreviousActionCHEAT();
        if (hasOtherPlayerCheated) {
            return PlayerAction.CHEAT;
        }
        return PlayerAction.COOPERATE;
    }

    private void isOtherPlayerPreviousActionCHEAT() {
        if(otherPlayerPreviousAction == PlayerAction.CHEAT){
            hasOtherPlayerCheated = true;
        }
    }

}
