package com.twx.eot.players;

import com.twx.eot.players.PlayerAction;
import com.twx.eot.players.PlayerBehaviour;
public class UserPlayer extends PlayerBehaviour {

    @Override
    public PlayerAction takeTurn() {
        String turn = new InputOutput().getInput();
        return PlayerAction.fromString(turn);
    }
}
