package blackjack.card;

public enum Denomination {

    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    KING(10),
    QUEEN(10),
    ACE(1);
    private final int score;

    Denomination(int score) {
        this.score = score;
    }

    public int score() {
        return score;
    }

    // 에이스인건 여기서 알수 있응꼐롱
    public boolean isAce() {
        return ACE == this;
    }
}
