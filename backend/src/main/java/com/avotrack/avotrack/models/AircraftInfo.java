package com.avotrack.avotrack.models;

public class AircraftInfo {
    private String icao;
    private String registration;
    private String photo_url;
    private String photo_source;
    private String photo_author;
    private String callsign;
    private String type;
    private String category;

    public AircraftInfo() {
    }

    public AircraftInfo(String icao, String registration, String photo_url, String photo_source, String photo_author, String callsign, String type, String category) {
        this.icao = icao;
        this.registration = registration;
        this.photo_url = photo_url;
        this.photo_source = photo_source;
        this.photo_author = photo_author;
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

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getPhoto_source() {
        return photo_source;
    }

    public void setPhoto_source(String photo_source) {
        this.photo_source = photo_source;
    }

    public String getPhoto_author() {
        return photo_author;
    }

    public void setPhoto_author(String photo_author) {
        this.photo_author = photo_author;
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
