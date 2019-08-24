package app.model;

import app.Application;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class GameState {
    private HashMap<Integer, Move> players;

    public GameState(HashMap<Integer, Move> state) {
        this.players = state;
    }

    public void playerExecuteMove(int playerId, Move move) {
        players.put(playerId, move);
        Application.log.info("player " + playerId + " moved. player 1:" + players.get(1) + ", player 2:" + players.get(2));
    }

    public Move getPlayerMove(int playerId) {
        if (playerId != 1 && playerId != 2) throw new IllegalArgumentException("Invalid playerId: " + playerId);
        return players.get(playerId);
    }

    public Set<Integer> getPlayers() {
        return players.keySet();
    }
}
