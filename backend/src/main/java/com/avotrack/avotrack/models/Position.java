package com.avotrack.avotrack.models;

import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Position {
    @Id
    @GeneratedValue
    private  Long id;
    private Double lat;
    private Double lon;
    private String altitude;
    @Transient
    private JsonNode alt;


//    @ManyToOne
//    @JoinColumn(name="aircraft_flightID")
//    private Aircraft aircraft;

    public Position() {
    }

    public Position(Double lat, Double lon, JsonNode alt) {
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return lat.equals(position.lat) && lon.equals(position.lon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lon);
    }

    @Override
    public String toString() {
        return "Position{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", alt='" + alt + '\'' +
                '}';
    }
}


