package com.twx.eot.players;

public class CheatPlayer extends PlayerBehaviour {
    @Override
    public PlayerAction takeTurn() {
        return PlayerAction.CHEAT;
    }
}
