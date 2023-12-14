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
                    timeGraph.addEdge(line.getDeparture(), line.getDestination()),
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

            route = dijkstraShortestPath.getPath(departure, destination).getVertexList();
            totalDistance = (int) dijkstraShortestPath.getPathWeight(departure, destination);
            totalTime = calcRouteWeight(timeGraph, route);
            return;
        }
        if (weightChoice == WeightChoice.MIN_TIME) {
            dijkstraShortestPath = new DijkstraShortestPath<>(timeGraph);

            route = dijkstraShortestPath.getPath(departure, destination).getVertexList();
            totalTime = (int) dijkstraShortestPath.getPathWeight(departure, destination);
            totalDistance = calcRouteWeight(distGraph, route);
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

    private int calcRouteWeight(
            WeightedMultigraph<Station, DefaultWeightedEdge> graph,
            List<Station> stations
    ) {
        int weight = 0;
        for (int i = 1; i < stations.size(); i++) {
            weight += (int) graph.getEdgeWeight(graph.getEdge(stations.get(i - 1), stations.get(i)));
        }
        return weight;
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
