package com.twx.eot.players;

public class GrudgeBehaviour extends CheatCautiousBehaviour {

    @Override
    public PlayerAction takeTurn() {
        isOtherPlayerPreviousActionCHEAT();
        if (hasOtherPlayerCheatedYet) {
            return PlayerAction.CHEAT;
        }
        return PlayerAction.COOPERATE;
    }

}
