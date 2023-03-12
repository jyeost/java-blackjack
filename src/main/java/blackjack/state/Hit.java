package blackjack.state;

import blackjack.card.Card;
import blackjack.card.Hand;

public final class Hit extends Running {

    /*public Hit(Card card1, Card card2) {
        this(new Hand(card1, card2));
    }*/

    Hit(Hand hand) {
        super(hand);
    }

    @Override
    public State draw(Card card) {
        Hand newHand = add(card);

        if (newHand.isBust()) {
            return new Bust(newHand);
        }
        if (newHand.isBlackJack()) {
            return new BlackJack(newHand);
        }
        return new Hit(newHand);
    }

}
