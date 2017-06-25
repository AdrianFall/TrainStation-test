package main.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 24/06/2017.
 */
public class TrainStation extends TrainStationVertex {

    private String name;
    // Direct connections
    private List<Route> routes = new ArrayList<>();

    // Constructors
    public TrainStation() {
    }

    public TrainStation(String name, List<Route> routes) {
        this.name = name;
        this.routes = routes;
    }

    public TrainStation(String name) {
        this.name = name;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainStation that = (TrainStation) o;

        if (!name.equals(that.name)) return false;
        return routes != null ? routes.equals(that.routes) : that.routes == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (routes != null ? routes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getVertexDistance().toString();
    }
}
