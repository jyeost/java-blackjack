package blackjack.state;

import java.util.List;

import blackjack.card.Card;
import blackjack.card.Hand;

public abstract class State {
    private final Hand hand;

    protected State(Hand hand) {
        this.hand = hand;
    }

    public abstract State draw(final Card card);

    public List<Card> cards() {
        return hand.cards();
    }

    public abstract State stay();

    protected final Hand hand() {
        return hand;
    }
}
