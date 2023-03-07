package blackjackgame.domain.card;

public class Card {
    private final Symbol symbol;
    private final CardValue cardValue;

    public Card(final Symbol symbol, final CardValue cardValue) {
        this.symbol = symbol;
        this.cardValue = cardValue;
    }

    public String getSymbol() {
        return symbol.getSymbol();
    }

    public int getScore() {
        return cardValue.getScore();
    }

    public String getValue() {
        return cardValue.getValue();
    }

    public boolean isAce() {
        return cardValue.getValue().equals(CardValue.ACE.getValue());
    }
}
