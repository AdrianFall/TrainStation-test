package dto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Adrian on 24/06/2017.
 */
public class QuickestPathDTO {
    private List<TrainStationRouteConnectionDTO> routeConnections = new ArrayList<>();
    private int totalDuration;

    // Constructors
    public QuickestPathDTO() {
    }

    public QuickestPathDTO(List<TrainStationRouteConnectionDTO> routeConnections, int totalDuration) {
        this.routeConnections = routeConnections;
        this.totalDuration = totalDuration;
    }

    // Getters & Setters
    public List<TrainStationRouteConnectionDTO> getRouteConnections() {
        return routeConnections;
    }

    public void setRouteConnections(List<TrainStationRouteConnectionDTO> routeConnections) {
        this.routeConnections = routeConnections;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }
}
