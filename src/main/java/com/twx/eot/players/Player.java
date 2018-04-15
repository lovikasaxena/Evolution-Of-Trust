
public class Player {
    private String playerName;
    private PlayerBehaviour behaviour;

    public Player(String playerName, PlayerBehaviour behaviour) {
        this.playerName = playerName;
        this.behaviour = behaviour;
    }

    public PlayerAction takeTurn(){
        return this.behaviour.takeTurn();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setOtherPlayerPreviousAction(PlayerAction otherPlayerPreviousAction) {
        behaviour.setOtherPlayerPreviousAction(otherPlayerPreviousAction);
    }
}
