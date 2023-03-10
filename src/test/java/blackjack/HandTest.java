package blackjack;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import blackjack.Card;
import blackjack.Denomination;
import blackjack.Hand;
import blackjack.Suit;

class HandTest {

    @Test
    void create(){
        Assertions.assertDoesNotThrow(()-> new Hand());
    }

    @Test
    void twoTen(){
        // 2 10 -> 12
        // 2 3 4 -> 9
        // 10 10 -> 20
        // 10 10 2 -> 22

        // 이런 다양한 케이스가 있겠쥬?? 그럼 이런 케이스들을 만들어보는거임
        final var hand = new Hand(
            Card.of(Suit.CLOVER, Denomination.TWO),
            Card.of(Suit.CLOVER, Denomination.TEN)
        );

        final var score = hand.calculateScore();

        assertThat(score).isEqualTo(12);
    }

    @Test
    void twoThreeFour(){
        // 2 3 4 -> 9
        final var hand = new Hand(
            Card.of(Suit.CLOVER, Denomination.TWO),
            Card.of(Suit.CLOVER, Denomination.THREE),
            Card.of(Suit.CLOVER, Denomination.FOUR)
        );

        final var score = hand.calculateScore();

        assertThat(score).isEqualTo(9);
    }

    @Test
    void tenTenTwo(){
        // 10 10 2 -> 22
        final var hand = new Hand(
            Card.of(Suit.CLOVER, Denomination.TEN),
            Card.of(Suit.CLOVER, Denomination.TEN),
            Card.of(Suit.CLOVER, Denomination.TWO)
        );

        final var score = hand.calculateScore();

        assertThat(score).isEqualTo(22);
    }

    // 여기까지 기본적인 케이스 -> 쉽게 작성함
    // 어려운거는 가장 나중에 구현해줘도 됨.
    // 도메인에 대해 익숙해질때까지 미뤄도 됨

    // ace 2 -> 13
    // ace 10 -> 21
    // ace ace -> 12
    // ace ace ace ace -> 14
    @Test
    void aceOne(){
        // ace 2 -> 13
        final var hand = new Hand(
            Card.of(Suit.CLOVER, Denomination.ACE),
            Card.of(Suit.CLOVER, Denomination.TWO)
        );

        final var score = hand.calculateScore();

        assertThat(score).isEqualTo(13); //-> 처음엔 깨진다.
    }

    // 에이스를 1로 사용할 수 있는 케이스를 판단해보자
    @Test
    void tenNineAceAce(){
        final var hand = new Hand(
            Card.of(Suit.CLOVER, Denomination.TEN),
            Card.of(Suit.CLOVER, Denomination.NINE),
            Card.of(Suit.CLOVER, Denomination.ACE),
            Card.of(Suit.CLOVER, Denomination.ACE)
        );

        final var score = hand.calculateScore();

        assertThat(score).isEqualTo(21);
    }

    @Test
    void aceTen(){
        final var hand = new Hand(
            Card.of(Suit.CLOVER, Denomination.ACE),
            Card.of(Suit.CLOVER, Denomination.TEN)
        );

        final var score = hand.calculateScore();

        assertThat(score).isEqualTo(21);
    }

    @Test
    void aceAceAceAce(){
        final var hand = new Hand(
            Card.of(Suit.CLOVER, Denomination.ACE),
            Card.of(Suit.CLOVER, Denomination.ACE),
            Card.of(Suit.CLOVER, Denomination.ACE),
            Card.of(Suit.CLOVER, Denomination.ACE)
        );

        final var score = hand.calculateScore();

        assertThat(score).isEqualTo(14);
    }
}
