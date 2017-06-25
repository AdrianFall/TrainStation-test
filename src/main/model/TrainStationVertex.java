package main.model;

/**
 * Created by Adrian on 25/06/2017.
 */
public class TrainStationVertex implements Comparable<TrainStationVertex> {
    private Integer vertexDistance = Integer.MAX_VALUE;
    private TrainStation vertexPrevious;

    // Getters & Setters
    public Integer getVertexDistance() {
        return vertexDistance;
    }

    public void setVertexDistance(Integer vertexDistance) {
        this.vertexDistance = vertexDistance;
    }

    public TrainStation getVertexPrevious() {
        return vertexPrevious;
    }

    public void setVertexPrevious(TrainStation vertexPrevious) {
        this.vertexPrevious = vertexPrevious;
    }

    @Override
    public int compareTo(TrainStationVertex o) {
        return Integer.compare(getVertexDistance(), o.getVertexDistance());
    }
}
