package app.model;

public class RpsMove {

    private final long playerId;
    private final Move move;

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

}