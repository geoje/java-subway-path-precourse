package subway.constant;

import java.util.Arrays;
import java.util.Optional;

import static subway.constant.ErrorMessage.INVALID_FUNCTION;

public enum MainChoice {
    VIEW_PATH("1"),
    QUIT("Q");

    private final String choice;

    MainChoice(String choice) {
        this.choice = choice;
    }

    public static MainChoice from(String choice) {
        Optional<MainChoice> result = Arrays.stream(values())
                .filter(v -> v.toString().equals(choice))
                .findFirst();
        if (result.isEmpty()) {
            throw new IllegalArgumentException(INVALID_FUNCTION.toString());
        }
        return result.get();
    }

    @Override
    public String toString() {
        return choice;
    }
}
