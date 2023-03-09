import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Hand {
    private final List<Card> cards;

    public Hand() {
        this(Collections.emptyList());
    }

    public Hand(List<Card> cards) {
        // 클린코드 공부하다 보면 방어적 복사에 대해 많이 나오쥬??
        this.cards = new ArrayList<>(cards);
    }

    public Hand add(final Card card){
        // 원시값 포장 -> 불변 객체
        // 일급 컬렉션 -> 불벽 객체 (힘들다)
        // cards.add(card); // 기존의 값이 변경이 됨
        final var newCards = new ArrayList<>(cards); // 항상 복사 꼭 신경써주자!!!
        newCards.add(card);

        return new Hand(newCards);
    }

    // 생성자가 엄청 많아지는데 괜찮나???? 도 고민해봐
    public Hand(final Card... cards) {
        this(List.of(cards));
    }

    // 스코어에 대한 기능들이 굉장히 많아지고 있는데 그러면 값개체에 대한 분리를 고민 해봐야 한다!!
    public int calculateScore() {
        boolean hasAce = hasAce();
        Score score = score();

        if (hasAce ) {
            score = score.plusTenIfNotBurst();
        }
        return score.value();
    }

    private Score score() {
        return cards.stream()
            .map(it -> it.score())
            .reduce(Score.min(), (score, score2)-> score.add(score2));
    }

    private boolean hasAce() {
        return cards.stream()
            .anyMatch(Card::isAce);
    }

    @Override
    public String toString() {
        return "Hand{" +
            "cards=" + cards +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Hand hand = (Hand)o;
        return Objects.equals(cards, hand.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}
