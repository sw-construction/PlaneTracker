package com.avotrack.avotrack.models;

import java.util.List;

public class Trail {
    private List<List<Position>> trail;

    public Trail() {
    }

    public Trail(List<List<Position>> trail) {
        this.trail = trail;
    }

    public List<List<Position>> getTrail() {
        return trail;
    }

    public void setTrail(List<List<Position>> trail) {
        this.trail = trail;
    }
}
