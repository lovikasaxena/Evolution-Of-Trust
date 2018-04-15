package com.twx.eot.players;

public class CooperatePlayer extends PlayerBehaviour {
    @Override
    public PlayerAction takeTurn() {
        return PlayerAction.COOPERATE;
    }
}
