package com.twx.eot.players;

public class CheatBehaviour extends PlayerBehaviour {
    @Override
    public PlayerAction takeTurn() {
        return PlayerAction.CHEAT;
    }
}
