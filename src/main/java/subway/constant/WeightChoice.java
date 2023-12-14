package subway.constant;

import java.util.Arrays;
import java.util.Optional;

import static subway.constant.ErrorMessage.INVALID_FUNCTION;

public enum WeightChoice {
    MIN_DISTANCE("1"),
    MIN_TIME("2"),
    BACK("B");

    private final String choice;

    WeightChoice(String choice) {
        this.choice = choice;
    }

    public static WeightChoice from(String choice) {
        Optional<WeightChoice> result = Arrays.stream(values())
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
