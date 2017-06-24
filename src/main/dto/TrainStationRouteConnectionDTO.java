package main.dto;

import main.model.TrainStation;

/**
 * Created by Adrian on 24/06/2017.
 */
public class TrainStationRouteConnectionDTO {
    private TrainStation origin;
    private TrainStation target;
    private int duration;

    // Constructors
    public TrainStationRouteConnectionDTO() {
    }

    public TrainStationRouteConnectionDTO(TrainStation origin, TrainStation target, int duration) {
        this.origin = origin;
        this.target = target;
        this.duration = duration;
    }

    // Getters & Setters
    public TrainStation getOrigin() {
        return origin;
    }

    public void setOrigin(TrainStation origin) {
        this.origin = origin;
    }

    public TrainStation getTarget() {
        return target;
    }

    public void setTarget(TrainStation target) {
        this.target = target;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
