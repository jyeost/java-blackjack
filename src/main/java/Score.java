import java.util.Objects;

public class Score {
    // 상수 없이 객체만으로 구현함
    // 상수에서 클래스 변수로 바뀌었으니 이름도 수정해주어야함
    // 왜 상수가 아니지? 상수는 변하지 않는 값이다 -> constant
    // final <-> constant

    // 객체들은 변할 수 있는 것들이잔슴 => 그래서 상수로 보지 않음 // 그리고 구현과 연관된 내용
    // 상수는 -> int, String
    // 클래스 변수 -> 소문자로 사용
    private static final Score min = new Score(0);
    private static final Score ace_additional = new Score(10);
    private static final Score max = new Score(21);
    // 블랙잭 스코어 vs 맥스 스코어
    // => 스코어에 역할을 어디까지 둘건가??
    // 도메인에 대한 지식을 가지는 것은 블랙잭에 굉장히 의존적인 객체가 될 것이다.

    private final int value;

    // 이렇게 공개를 쉽게 할 수 있는 것은 이 객체가 불변이기 때문이다
    // 외부에서 조작될 걱정이 없음
    public static Score min(){
        return min;
    }

    public Score(int value) {
        this.value = value;
    }

    // 더하기
    // 비교

    public Score plusTenIfNotBurst() {
        final var sumScore = add(ace_additional);
        if (sumScore.isLessThanOrEqual(max)) {
            return sumScore;
        }
        return this;
    }

    private boolean isLessThanOrEqual(Score other) {
        return value <= other.value;
    }

    public Score add(final Score other) {
        return new Score(value + other.value);
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return "Score{" +
            "value=" + value +
            '}';
    }

    // 값객체라 오버라이딩
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Score score = (Score)o;
        return value == score.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
