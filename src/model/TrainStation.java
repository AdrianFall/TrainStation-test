package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 24/06/2017.
 */
public class TrainStation {

    private String name;
    private List<Route> routes = new ArrayList<>();

    // Constructors
    public TrainStation() {
    }

    public TrainStation(String name, List<Route> routes) {
        this.name = name;
        this.routes = routes;
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
}
