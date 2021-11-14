package com.avotrack.avotrack.models;

public class AircraftInfo {
    private String icao;
    private String registration;
    private String aircraft_picture;
    private String callsign;
    private String type;
    private String category;

    public AircraftInfo() {
    }

    public AircraftInfo(String icao, String registration, String aircraft_picture, String callsign, String type, String category) {
        this.icao = icao;
        this.registration = registration;
        this.aircraft_picture = aircraft_picture;
        this.callsign = callsign;
        this.type = type;
        this.category = category;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getAircraft_picture() {
        return aircraft_picture;
    }

    public void setAircraft_picture(String aircraft_picture) {
        this.aircraft_picture = aircraft_picture;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
