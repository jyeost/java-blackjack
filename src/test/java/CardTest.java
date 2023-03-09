import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void create() {
        final var card = Card.of(Suit.CLOVER, Denomination.ACE);

        // 캐싱을 한다는건 새로운 클래스와 같다는 것을 의미함.
        // 그래서 equals로 비교하면 안됨(주소값을 비교하잔슴)
        // 캐싱이 되었기떄문에 동일한 값이 나옴
        // assertThat(card == Card.of(Suit.CLOVER, Denomination.ACE)).isTrue();

        // 동일하다는 것을 검증해주는 api
        assertThat(card).isNotNull()
            .isSameAs(Card.of(Suit.CLOVER, Denomination.ACE));
    }

    @Test
    void score() {
        final var card = Card.of(Suit.CLOVER, Denomination.ACE);
        assertThat(card.score()).isEqualTo(1);
    }
}
