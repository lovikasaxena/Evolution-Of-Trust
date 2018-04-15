package com.twx.eot.players;

public class Player {
    private final String playerName;
    private PlayerBehaviour behaviour;

    public Player(String playerName, PlayerBehaviour behaviour) {
        this.playerName = playerName;
        this.behaviour = behaviour;
        this.behaviour.setPlayer(this);
    }

    public PlayerAction takeTurn(){
        return this.behaviour.takeTurn();
    }

    public String getPlayerName() {
        return playerName;
    }

    public PlayerBehaviour getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(PlayerBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    public void setOtherPlayerPreviousAction(PlayerAction otherPlayerPreviousAction) {
        this.behaviour.setOtherPlayerPreviousAction(otherPlayerPreviousAction);
    }
}
