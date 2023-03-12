package blackjack.card;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import blackjack.Score;

public class Card {
    // 그러면 캐싱을 저장해줄 바구니가 필요함
    private final static Map<String, Card> cache = new ConcurrentHashMap<>(52); // 이제 52개만 존재하는 카드가 되는거임
    // 얘는 인스턴스 변수가 아니라 클래스 변수임
    // 그리고 그거랑 별개로 두개의 제한이 외 생겼는지 생각을 해보라
    // 두개를 제한하면서 어떠한 부분을 이끌어내고 싶은거지??

    // 상수인가
    // 상수는 머지??

    private final Suit suit;
    private final Denomination denomination;

    // 정적 팩토리 메소드를 만드렁 줬다고 한다면 이 생성자는 접근 제어자를 private으로 제한해 주는게 좋음
    // 외냐면 생성자가 외부에서 안보여야 정적 팩토리가 있는지 확인해 볼거아님
    // 글구 캐싱을 해뒀는데 기본 생성자로 생성하면 의미가 없잔슴
    private Card(final Suit suit, Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    // 내부적으로 캐싱을 해주면 됨
    // 어떻게 해주지 ?? Key를 뭘로 두지??
    public static Card of(Suit suit, Denomination denomination) {
        // Map<blackjack.card.Suit, Map<blackjack.card.Denomination, blackjack.card.Card>> cache;
        // Map<Integer, blackjack.card.Card> cache; // 근데 캐시가 동일해지면 어카지?? 튜플같은것도 있음
        //Map<String, blackjack.card.Card> cache; //String 으로 해주겠다 (맨 위로 올림)

        // 있을때 반환을 해주고 없을때 생성을 해주는 api
        return cache.computeIfAbsent(toKey(suit, denomination), ignore -> new Card(suit, denomination));
        // 이렇게 되면 있을때는 똑같은 값을 반환해주고 없을때는 새로 생성을 해주니까 첫번째 테스트가 통과할거임
    }

    private static String toKey(Suit suit, Denomination denomination) {
        return suit.name() + denomination.name();
    }

    // 캐싱을 했고 일종의 값 객체로 사용하고 있기 떄문에 얘네 둘을 오버라이딩 해주는 거임
    @Override
    public String toString() {
        return "blackjack.card.Card{" +
            "suit=" + suit +
            ", denomination=" + denomination +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Card card = (Card)o;
        return suit == card.suit && denomination == card.denomination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, denomination);
    }

    public Score score() {
        return new Score(denomination.score());
    }

    public boolean isAce() {
        return this.denomination.isAce();
    }
}
