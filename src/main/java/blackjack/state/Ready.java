package blackjack.state;

import java.util.List;

import blackjack.card.Card;
import blackjack.card.Hand;

public final class Ready extends State {

    public Ready() {
        super(new Hand());
    }

    @Override
    public State draw(Card card) {
        return new Hit(new Hand(card));
    }

    @Override
    public List<Card> cards() {
        throw new UnsupportedOperationException("카드업쪙");
    }

    @Override
    public State stay() {
        throw new IllegalStateException("게임을 멈출 수 없는 상태입니다.");
    }
}
