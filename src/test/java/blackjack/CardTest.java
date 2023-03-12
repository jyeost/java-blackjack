package blackjack;

import static blackjack.Fixtures.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import blackjack.card.Card;
import blackjack.card.Denomination;
import blackjack.card.Suit;

class CardTest {

    @Test
    void create() {
        final var card = Card.of(Suit.CLOVER, Denomination.ACE);

        // 캐싱을 한다는건 새로운 클래스와 같다는 것을 의미함.
        // 그래서 equals로 비교하면 안됨(주소값을 비교하잔슴)
        // 캐싱이 되었기떄문에 동일한 값이 나옴
        // assertThat(card == blackjack.card.Card.of(blackjack.card.Suit.CLOVER, blackjack.card.Denomination.ACE)).isTrue();

        // 동일하다는 것을 검증해주는 api
        assertThat(card).isNotNull()
            .isSameAs(CLOVER_ACE);
    }

    @Test
    void score() {
        final var card = CLOVER_ACE;
        assertThat(card.score()).isEqualTo(new Score(1));
    }
}
