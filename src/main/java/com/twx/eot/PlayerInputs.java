package com.twx.eot.players;

import java.util.Objects;

public final class PlayerInputs {
    private final PlayerAction player1Action;
    private final PlayerAction player2Action;

    public PlayerInputs(PlayerAction player1Action, PlayerAction player2Action) {
        this.player1Action = player1Action;
        this.player2Action = player2Action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerInputs that = (PlayerInputs) o;
        return player1Action == that.player1Action &&
                player2Action == that.player2Action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(player1Action, player2Action);
    }

    public PlayerAction getPlayer1Action() {
        return player1Action;
    }

    public PlayerAction getPlayer2Action() {
        return player2Action;
    }

    @Override
    public String toString() {
        return "com.twx.eot.players.PlayerInputs{" +
                "player1Action=" + player1Action +
                ", player2Action=" + player2Action +
                '}';
    }
}
