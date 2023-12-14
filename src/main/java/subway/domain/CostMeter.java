package subway.domain;

import subway.constant.Station;
import subway.constant.WeightChoice;

import java.util.List;

public class CostMeter {
    private final int totalDistance;
    private final int totalTime;
    private final List<Station> route;

    public CostMeter(WeightChoice weightChoice, Station departure, Station destination) {
        totalDistance = 0;
        totalTime = 0;
        route = List.of();
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public List<Station> getRoute() {
        return route;
    }
}
