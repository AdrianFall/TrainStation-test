package model;

/**
 * A route represents a direct connection to the target station
 */

public class Route {

    private TrainStation target;
    private int duration;


    // Constructors
    public Route() {
    }

    public Route(TrainStation target, int duration) {
        this.target = target;
        this.duration = duration;
    }

    // Getters & Setters
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
