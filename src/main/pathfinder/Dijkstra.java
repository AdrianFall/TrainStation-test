package main.pathfinder;

import main.model.Route;
import main.model.TrainStation;

import java.util.*;

/**
 * Fails on {@link test.service.PathFinderServiceTest#testBthroughCtoE}
 * The algorithm explores the route  B -> A -> D -> E
 *                            before B -> C -> E
 * Upon B->A->D->E being visited the E's previous vertex and duration are being set
 * The algorithm then comes back to exploring the route of B -> C -> E,
 * the duration of the target E is already set to 9 minutes (set by D -> E)
 *                                                      (ideally it should be still Integer.MAX_VALUE at this point)
 * and therefore the calculation is wrong.
 *
 */
@Deprecated
public class Dijkstra {

    public static void computePaths(TrainStation startStation) {
        startStation.setVertexDistance(0);

        Queue<TrainStation> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(startStation);

        while (!vertexQueue.isEmpty()) {
            TrainStation trainStation = vertexQueue.poll(); // u

            // Visit each edge exiting trainStation
            for (Route route : trainStation.getRoutes()) { // e
                TrainStation target = route.getTarget(); // v
                Integer weight = route.getDuration();
                Integer distanceThroughTrainStation = trainStation.getVertexDistance() + weight;
                if (distanceThroughTrainStation < target.getVertexDistance()) {
                    vertexQueue.remove(target);

                    target.setVertexDistance(route.getDuration());
                    target.setVertexPrevious(trainStation);
                    vertexQueue.add(target);
                }
            }
        }

    }

    public static List<TrainStation> getShortestPathTo(TrainStation targetStation) {
        List<TrainStation> path = new ArrayList<>();
        TrainStation vertex = targetStation;
        while (vertex != null) {
            path.add(vertex);
            vertex = vertex.getVertexPrevious();
        }

        Collections.reverse(path);
        return path;
    }
}
