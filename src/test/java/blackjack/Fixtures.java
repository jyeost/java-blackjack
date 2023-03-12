package blackjack;

import blackjack.card.Card;
import blackjack.card.Denomination;
import blackjack.card.Suit;

public class Fixtures {
    public static final Card CLOVER_ACE = Card.of(Suit.CLOVER, Denomination.ACE);
    public static final Card CLOVER_TWO = Card.of(Suit.CLOVER, Denomination.TWO);
    public static final Card CLOVER_THREE = Card.of(Suit.CLOVER, Denomination.THREE);
    public static final Card CLOVER_FOUR = Card.of(Suit.CLOVER, Denomination.FOUR);
    public static final Card CLOVER_NINE = Card.of(Suit.CLOVER, Denomination.NINE);
    public static final Card CLOVER_TEN = Card.of(Suit.CLOVER, Denomination.TEN);
    public static final Card HEART_TEN = Card.of(Suit.HEART, Denomination.TEN);
}
