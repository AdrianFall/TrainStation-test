package main.service.impl;

import main.dto.QuickestPathDTO;
import main.dto.TrainStationRouteConnectionDTO;
import main.exception.PathFinderServiceException;
import main.model.TrainStation;
import main.pathfinder.Dijkstra;
import main.service.PathFinderService;

import java.util.List;

import static main.exception.PathFinderServiceException.ErrorCode.*;

/**
 * Created by Adrian on 24/06/2017.
 */
public class PathFinderServiceImpl implements PathFinderService {


    /**
     * Dijkstra implementation
     * @param origin - starting node
     * @param target - target node
     * @return QuickestPathDTO - duration and the list of connections
     * @throws PathFinderServiceException - no connection
     */
    @Override
    public QuickestPathDTO getQuickestPath(TrainStation origin, TrainStation target) throws PathFinderServiceException {
        QuickestPathDTO quickestPathDTO = new QuickestPathDTO();


        Dijkstra.computePaths(origin);

        List<TrainStation> path = Dijkstra.getShortestPathTo(target);

        // Ensure we atleast have 2 paths e.g. A -> B
        if (path.size() < 2)
            throw new PathFinderServiceException(NoRouteConnectionException, "Only " + path.size() + " path(s) were generated, required at least 2");
        TrainStation currentOrigin = path.remove(0);

        for (TrainStation currentTarget : path) {
            // Init DTO
            TrainStationRouteConnectionDTO trainStationRouteConnectionDTO = new TrainStationRouteConnectionDTO();
            trainStationRouteConnectionDTO.setDuration(currentTarget.getVertexDistance());
            // Increment the duration
            quickestPathDTO.setTotalDuration(quickestPathDTO.getTotalDuration() + currentTarget.getVertexDistance());
            // Set the origin & target
            trainStationRouteConnectionDTO.setOrigin(currentOrigin);
            trainStationRouteConnectionDTO.setTarget(currentTarget);

            // finally add the DTO to the quickestPathDTO
            quickestPathDTO.getRouteConnections().add(trainStationRouteConnectionDTO);

            // Let the origin become the target for the next iteration
            currentOrigin = currentTarget;
        }

        return quickestPathDTO;
    }
}
