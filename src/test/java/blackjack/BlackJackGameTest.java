package blackjack;

import static blackjack.Fixtures.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import blackjack.card.Card;
import blackjack.card.Denomination;
import blackjack.card.Suit;
import blackjack.state.BlackJack;
import blackjack.state.Bust;
import blackjack.state.Hit;
import blackjack.state.Ready;

class BlackJackGameTest {
    @Test
    void hit() {
        final var state = new Ready()
            .draw(CLOVER_TWO)
            .draw(CLOVER_THREE);

        assertThat(state).isInstanceOf(Hit.class);
    }

    @Test
    void hitCards() {
        final var state = new Ready()
            .draw(CLOVER_TWO)
            .draw(CLOVER_THREE);

        final var cards = state.cards();

        assertThat(cards)
            .containsExactly(
                CLOVER_TWO,
                CLOVER_THREE);
    }

    @Test
    void Bust() {
        final var state = new Ready()
            .draw(CLOVER_TEN)
            .draw(HEART_TEN)
            .draw(CLOVER_NINE);

        assertThat(state).isInstanceOf(Bust.class);
    }

    @Test
    void BustDraw() {
        final var state = new Ready()
            .draw(CLOVER_TEN)
            .draw(HEART_TEN)
            .draw(CLOVER_NINE);

        assertThatThrownBy(() -> state.draw(Card.of(Suit.CLOVER, Denomination.NINE)))
            .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void BlackJack() {
        final var state = new Ready()
            .draw(CLOVER_ACE)
            .draw(CLOVER_TEN);

        assertThat(state).isInstanceOf(BlackJack.class);
    }
}
