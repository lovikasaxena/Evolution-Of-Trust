package com.twx.eot.players;

public abstract class PlayerBehaviour {
    protected PlayerAction otherPlayerPreviousAction = null;
    protected Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PlayerAction getOtherPlayerPreviousAction() {
        return otherPlayerPreviousAction;
    }

    public void setOtherPlayerPreviousAction(PlayerAction otherPlayerPreviousAction) {
        this.otherPlayerPreviousAction = otherPlayerPreviousAction;
    }

    public abstract PlayerAction takeTurn();

}