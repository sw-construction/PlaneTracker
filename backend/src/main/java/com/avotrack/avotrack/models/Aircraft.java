package com.avotrack.avotrack.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Aircraft {
    private String hex;
    private Integer lastSeen = 0;
    private Position position;
    private Flight flight;
    private AircraftInfo aircraftInfo;
    @JsonIgnore
    private List<Position> trail;


    public Aircraft() {
    }

    public Aircraft(String hex, Integer lastSeen, Position position, Flight flight, AircraftInfo aircraftInfo, List<Position> trail) {
        this.hex = hex;
        this.lastSeen = lastSeen;
        this.position = position;
        this.flight = flight;
        this.aircraftInfo = aircraftInfo;
        this.trail = trail;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public Integer getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Integer lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public AircraftInfo getAircraftInfo() {
        return aircraftInfo;
    }

    public void setAircraftInfo(AircraftInfo aircraftInfo) {
        this.aircraftInfo = aircraftInfo;
    }

    public List<Position> getTrail() {
        return trail;
    }

    public void setTrail(List<Position> trail) {
        this.trail = trail;
    }

    public void addToTrailPositions(Position position) {
        if(this.trail == null) {
            this.trail = new ArrayList<>();
        }
        if(this.trail.size() == 0) {
            this.trail.add(position);
        }
        if(this.trail.size() > 0) {
            Position prevPos = this.trail.get(this.trail.size() -1);
            if(prevPos != position) {
                this.trail.add(position);
            }
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hex == null) ? 0 : hex.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aircraft other = (Aircraft) obj;
        if (hex == null) {
            if (other.hex != null)
                return false;
        } else if (!hex.toLowerCase().equals(other.hex.toLowerCase()))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "hex='" + hex + '\'' +
                ", lastSeen=" + lastSeen +
                ", position=" + position +
                ", flight=" + flight +
                ", aircraftInfo=" + aircraftInfo +
                ", trail=" + trail +
                '}';
    }
}
