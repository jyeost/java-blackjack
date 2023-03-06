package blackjackgame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum AddCardResponse {
    YES("y"), NO("n");

    private final String value;

    AddCardResponse(final String value) {
        this.value = value;
    }

    public static String printAddCardResponse(final String playerName) {
        return String.format("%s는 한장의 카드를 더 받겠습니까?(예는 %s, 아니오는 %s)%s", System.lineSeparator() + playerName
            , YES.value, NO.value, System.lineSeparator());
    }

    public static Optional<AddCardResponse> findAndCreate(final String input) {
        return Arrays.stream(AddCardResponse.values())
            .filter(cardResponse -> cardResponse.value.equalsIgnoreCase(input))
            .findFirst();
    }

    public static String getErrorPowerMsg() {
        List<String> values = Arrays.stream(AddCardResponse.values())
            .map(AddCardResponse::getValue)
            .collect(Collectors.toList());
        return String.join(",", values) + " 만 입력해주세요";
    }

    private String getValue() {
        return value;
    }
}
