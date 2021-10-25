package com.avotrack.avotrack.models;


public class Aircraft {
    private String hex;
    private Integer lastSeen;
    private Integer counter;
    private Position[] trailPositions;
    private Flight flight;
    private AircraftInfo aircraftInfo;


    public Aircraft() {}

    public String getHex() {
        return hex;
    }

    public Integer getLastSeen() {
        return lastSeen;
    }

    public Integer getCounter() {
        return counter;
    }

    public Position[] getTrailPositions() {
        return trailPositions;
    }

    public Flight getFlight() {
        return flight;
    }

    public AircraftInfo getAircraftInfo() {
        return aircraftInfo;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public void setLastSeen(Integer lastSeen) {
        this.lastSeen = lastSeen;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public void setTrailPositions(Position[] trailPositions) {
        this.trailPositions = trailPositions;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setAircraftInfo(AircraftInfo aircraftInfo) {
        this.aircraftInfo = aircraftInfo;
    }
}
