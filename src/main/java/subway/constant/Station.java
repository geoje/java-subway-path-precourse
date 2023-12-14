package subway.constant;

import java.util.Arrays;
import java.util.Optional;

import static subway.constant.ErrorMessage.INVALID_STATION;

public enum Station {
    UNIV_OF_EDUCATION("교대역"),
    GANGNAM("강남역"),
    YEOKSAM("역삼역"),
    NAMBU_TERMINAL("남부터미널역"),
    YANGJAE("양재역"),
    MAEBONG("매봉역"),
    YANGJAE_CITIZEN_FOREST("양재시민의숲역");

    private final String name;

    Station(String name) {
        this.name = name;
    }

    public static Station from(String name) {
        Optional<Station> result = Arrays.stream(values()).filter(v -> v.name.equals(name)).findFirst();
        if (result.isEmpty()) {
            throw new IllegalArgumentException(INVALID_STATION.toString());
        }
        return result.get();
    }

    @Override
    public String toString() {
        return name;
    }
}
