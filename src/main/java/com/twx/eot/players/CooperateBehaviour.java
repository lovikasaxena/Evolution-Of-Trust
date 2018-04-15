package com.twx.eot.players;

public class CooperateBehaviour extends PlayerBehaviour {
    @Override
    public PlayerAction takeTurn() {
        return PlayerAction.COOPERATE;
    }
}
