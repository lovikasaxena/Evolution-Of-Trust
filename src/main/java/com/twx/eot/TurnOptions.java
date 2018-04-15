import com.twx.eot.players.PlayerAction;
import com.twx.eot.players.PlayerInputs;

import java.util.HashMap;

public class TurnOptions {
    private final HashMap<PlayerInputs, Result> options;

    public TurnOptions() {
        this.options = new HashMap<>();
        PlayerInputs playerInputs1 = new PlayerInputs(PlayerAction.CHEAT, PlayerAction.CHEAT);
        options.put(playerInputs1,new Result(0,0));
        PlayerInputs playerInputs2 = new PlayerInputs(PlayerAction.CHEAT, PlayerAction.COOPERATE);
        options.put(playerInputs2,new Result(3,-1));
        PlayerInputs playerInputs3 = new PlayerInputs(PlayerAction.COOPERATE, PlayerAction.COOPERATE);
        options.put(playerInputs3,new Result(2,2));
        PlayerInputs playerInputs4 = new PlayerInputs(PlayerAction.COOPERATE, PlayerAction.CHEAT);
        options.put(playerInputs4,new Result(-1,3));
    }

    public Result getOption(PlayerInputs playerInputs) {
        return options.get(playerInputs);
    }
}
