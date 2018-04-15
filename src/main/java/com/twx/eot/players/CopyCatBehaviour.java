package com.twx.eot.players;

public class CopyCatBehaviour extends PlayerBehaviour {

    @Override
    public PlayerAction takeTurn() {
        if(otherPlayerPreviousAction == null ){
            return PlayerAction.COOPERATE;
        }
        return otherPlayerPreviousAction;
    }
}
