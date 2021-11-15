package com.avotrack.avotrack.models;

public class Position {
    private Double lat;
    private Double lon;
    private String alt;

    public Position() {
    }

    public Position(Double lat, Double lon, String alt) {
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}


