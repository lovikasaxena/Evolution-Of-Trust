package com.twx.eot.players;

import com.twx.eot.inputOutput.InputOutput;

public class UserBehaviour extends PlayerBehaviour {

    @Override
    public PlayerAction takeTurn() {
        String turn = new InputOutput().getInput();
        return PlayerAction.fromString(turn);
    }
}
