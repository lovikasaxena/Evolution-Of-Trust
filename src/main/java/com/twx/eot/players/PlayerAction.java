package com.twx.eot.players;

public enum PlayerAction {
    CHEAT, COOPERATE;

    public static PlayerAction fromString(String playerActionString) {
        for(PlayerAction playerAction: PlayerAction.values()) {
            if(playerAction.toString().equals(playerActionString)){
                return playerAction;
            }
        }
        return null;
    }
}
