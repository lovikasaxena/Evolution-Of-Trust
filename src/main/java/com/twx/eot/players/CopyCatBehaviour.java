package com.twx.eot.players;

public class CopyCatPlayer extends PlayerBehaviour {

    @Override
    public PlayerAction takeTurn() {
        if(otherPlayerPreviousAction == null ){
            return PlayerAction.COOPERATE;
        }
        return otherPlayerPreviousAction;
    }
}
