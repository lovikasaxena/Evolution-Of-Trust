package com.twx.eot.players;

public abstract class CheatCautiousBehaviour extends PlayerBehaviour {

    protected boolean hasOtherPlayerCheatedYet = false;

    protected boolean isOtherPlayerPreviousActionCHEAT() {
        if (otherPlayerPreviousAction == PlayerAction.CHEAT) {
            hasOtherPlayerCheatedYet = true;
            return true;
        }
        return false;
    }
}
