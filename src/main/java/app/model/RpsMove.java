package app.model;

public class RpsMove {

    private long playerId;
    private Move move;

    public RpsMove() {
        this.playerId = -1;
        this.move = null;
    }

    public RpsMove(long playerId, Move move) {
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