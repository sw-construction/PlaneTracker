package com.avotrack.avotrack.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class Trail {

    private Long id;
    private List<Position> trail;

    @ManyToOne
    @JoinColumn(name="aircraft_flightID")
    private Aircraft aircraft;

    public Trail() {
    }

    public Trail(List<Position> trail) {
        this.trail = trail;
    }

    public List<Position> getTrail() {
        return trail;
    }

    public void setTrail(List<Position> trail) {
        this.trail = trail;
    }


    @Override
    public String toString() {
        return "Trail{" +
                "trail=" + trail +
                '}';
    }
}
