package app.model;

public enum Move {
    ROCK, PAPER, SCISSORS;

    public Boolean isDefeatedBy(Move other) {
        int result = this.ordinal() - other.ordinal() % 3;
        if (result == 0) {
            return null;
        } else {
            return result == 1;
        }
    }
}
