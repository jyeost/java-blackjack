package blackjack.state;

import blackjack.card.Hand;

public final class Bust extends Finished {
    Bust(Hand hand) {
        super(hand);
    }

}
