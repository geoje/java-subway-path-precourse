package subway.constant;

import static subway.constant.Station.*;

public enum Line {
    SECOND_1(UNIV_OF_EDUCATION, GANGNAM, 2, 3),
    SECOND_2(GANGNAM, YEOKSAM, 2, 3),


    THIRD_1(UNIV_OF_EDUCATION, NAMBU_TERMINAL, 3, 2),
    THIRD_2(NAMBU_TERMINAL, YANGJAE, 6, 5),
    THIRD_3(YANGJAE, MAEBONG, 1, 1),

    SHINBUNDANG_1(GANGNAM, YANGJAE, 2, 8),
    SHINBUNDANG_2(YANGJAE, YANGJAE_CITIZEN_FOREST, 10, 3);

    private final Station departure;
    private final Station destination;
    private final int distance;
    private final int time;

    Line(Station departure, Station destination, int distance, int time) {
        this.departure = departure;
        this.destination = destination;
        this.distance = distance;
        this.time = time;
    }

    public Station getDeparture() {
        return departure;
    }

    public Station getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
