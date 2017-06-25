package test.service;

import main.dto.QuickestPathDTO;
import main.dto.TrainStationRouteConnectionDTO;
import main.model.Route;
import main.model.TrainStation;
import main.service.PathFinderService;
import main.service.impl.PathFinderServiceImpl;
import org.junit.Assert;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Adrian on 24/06/2017.
 */
public class BaseServiceTest {

    TrainStation A = new TrainStation("A");
    TrainStation B = new TrainStation("B");
    TrainStation C = new TrainStation("C");
    TrainStation D = new TrainStation("D");
    TrainStation E = new TrainStation("E");

    PathFinderService pathFinderService;

    @Before
    public void setup() throws Exception {
        pathFinderService = new PathFinderServiceImpl();
        // Add direct connections (routes)
        A.setRoutes(Arrays.asList(new Route(B, 3),
                                  new Route(D, 6)));
        B.setRoutes(Arrays.asList(new Route(A, 3),
                                  new Route(C, 7)));
        D.setRoutes(Arrays.asList(new Route(B, 5),
                                  new Route(E, 9),
                                  new Route(C, 9)));
        E.setRoutes(Arrays.asList(new Route(D, 9)));
        C.setRoutes(Arrays.asList(new Route(E, 3),
                                  new Route(D, 9)));

    }

    protected void testDirectConnections(TrainStation origin, TrainStation target, int expectedDuration) throws Exception {
        QuickestPathDTO quickestPath = pathFinderService.getQuickestPath(origin, target);
        // Expected duration
        Assert.assertEquals(expectedDuration, quickestPath.getTotalDuration());
        List<TrainStationRouteConnectionDTO> routeConnections = quickestPath.getRouteConnections();
        // Expect 1 connection (origin -> target)
        Assert.assertEquals(1, routeConnections.size());
        TrainStationRouteConnectionDTO firstConnection = routeConnections.get(0);
        // Expect Route connection origin: origin, target: target, duration: expectedDuration
        Assert.assertEquals(origin, firstConnection.getOrigin());
        Assert.assertEquals(target, firstConnection.getTarget());
        Assert.assertEquals(expectedDuration, firstConnection.getDuration());
    }

    protected void testConnectionsTwoStationsFar(TrainStation origin, TrainStation intermediate,
                                                 TrainStation target, int expectedTravelDuration) throws Exception {
        QuickestPathDTO quickestPath = pathFinderService.getQuickestPath(origin, target);
        // Expected duration
        Assert.assertEquals(expectedTravelDuration, quickestPath.getTotalDuration());
        List<TrainStationRouteConnectionDTO> routeConnections = quickestPath.getRouteConnections();
        // Expect 2 connections (origin -> intermediate -> target)
        Assert.assertEquals(2, routeConnections.size());
        TrainStationRouteConnectionDTO firstConnection = routeConnections.get(0);
        TrainStationRouteConnectionDTO secondConnection = routeConnections.get(1);

        // Expect 1st Route connection origin: origin, target: intermediate
        Assert.assertEquals(origin, firstConnection.getOrigin());
        Assert.assertEquals(intermediate, firstConnection.getTarget());
        // Expect 2nd Route connection origin: intermediate, target: target
        Assert.assertEquals(intermediate, secondConnection.getOrigin());
        Assert.assertEquals(target, secondConnection.getTarget());
    }


}
