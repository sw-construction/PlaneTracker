package com.avotrack.avotrack.models;

import com.fasterxml.jackson.databind.JsonNode;

public class Position {
    private Double lat;
    private Double lon;
    private JsonNode alt;

    public Position() {
    }

    public Position(Double lat, Double lon, JsonNode alt) {
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

    public JsonNode getAlt() {
        return alt;
    }

    public void setAlt(JsonNode alt) {
        this.alt = alt;
    }
}


