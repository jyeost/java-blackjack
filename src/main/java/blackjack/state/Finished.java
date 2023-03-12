package blackjack.state;

import blackjack.card.Card;
import blackjack.card.Hand;

public abstract class Finished extends State {

    Finished(Hand hand) {
        super(hand);
    }

    @Override
    public final State draw(Card card) {
        throw new IllegalStateException("카드 추가 노노");
    }

    @Override
    public final State stay() {
        throw new IllegalStateException("게임이 끗남읍니다");
    }

}
