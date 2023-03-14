package blackjackgame.domain.card;

import java.util.HashMap;
import java.util.Map;

import blackjackgame.domain.Score;

public class Card {
    private final static Map<String, Card> cache = new HashMap<>(52);

    private final Symbol symbol;
    private final CardValue cardValue;

    private Card(final Symbol symbol, final CardValue cardValue) {
        this.symbol = symbol;
        this.cardValue = cardValue;
    }

    public static Card of(Symbol symbol, CardValue cardValue) {
        return cache.computeIfAbsent(toKey(symbol, cardValue), ignore -> new Card(symbol, cardValue));
    }

    private static String toKey(Symbol symbol, CardValue cardValue) {
        return symbol.getSymbol() + cardValue.getScore();
    }

    public boolean isAce() {
        return cardValue.getValue().equals(CardValue.ACE.getValue());
    }

    @Override
    public String toString() {
        return cardValue.getValue() + symbol.getSymbol();
    }

    public Score score() {
        return new Score(cardValue.getScore());
    }
}
