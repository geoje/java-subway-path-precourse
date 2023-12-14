package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.constant.Line;
import subway.constant.Station;
import subway.constant.WeightChoice;

import java.util.List;

import static subway.constant.ErrorMessage.SAME_STATION_DEPART_AND_DEST;

public class CostMeter {
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> distGraph;
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph;

    static {
        distGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        timeGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);

        for (Station station : Station.values()) {
            distGraph.addVertex(station);
            timeGraph.addVertex(station);
        }

        for (Line line : Line.values()) {
            distGraph.setEdgeWeight(
                    distGraph.addEdge(line.getDeparture(), line.getDestination()),
                    line.getDistance()
            );
            timeGraph.setEdgeWeight(
                    distGraph.addEdge(line.getDeparture(), line.getDestination()),
                    line.getTime()
            );
        }
    }

    private final int totalDistance;
    private final int totalTime;
    private final List<Station> route;

    public CostMeter(WeightChoice weightChoice, Station departure, Station destination) {
        validateSameStation(departure, destination);

        DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstraShortestPath = null;
        if (weightChoice == WeightChoice.MIN_DISTANCE) {
            dijkstraShortestPath = new DijkstraShortestPath<>(distGraph);

            totalDistance = (int) dijkstraShortestPath.getPathWeight(departure, destination);
            totalTime = 0;
            route = dijkstraShortestPath.getPath(departure, destination).getVertexList();
            return;
        }
        if (weightChoice == WeightChoice.MIN_TIME) {
            dijkstraShortestPath = new DijkstraShortestPath<>(timeGraph);

            totalDistance = 0;
            totalTime = (int) dijkstraShortestPath.getPathWeight(departure, destination);
            route = dijkstraShortestPath.getPath(departure, destination).getVertexList();
            return;
        }

        totalDistance = 0;
        totalTime = 0;
        route = List.of();
    }

    private void validateSameStation(Station departure, Station destination) {
        if (departure.toString().equals(destination.toString())) {
            throw new IllegalArgumentException(SAME_STATION_DEPART_AND_DEST.toString());
        }
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
