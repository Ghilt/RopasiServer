package app.model;

public class Player {

    private long playerId;
    private Move move;

    public Player() {
        this.playerId = 1;
        this.move = null;
    }

    public Player(long playerId, Move move) {
        this.playerId = playerId;
        this.move = move;
    }

    public long getPlayerId() {
        return playerId;
    }

    public Move getMove() {
        return move;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public void setMove(String move) {
        this.move = Move.ROCK;
    }

}