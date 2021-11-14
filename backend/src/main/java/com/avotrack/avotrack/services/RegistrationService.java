package com.avotrack.avotrack.services;

import org.json.JSONObject;

public class RegistrationService {
    private static final String AIRCRAFT_DATA_URL="https://cop.eplasp.io/aircraftinfo/aircraftdata/aircraft/?icao=";
    public String getAircraftData(String icao) {
        Requester requester = new Requester();
        String url = AIRCRAFT_DATA_URL+icao;
        JSONObject aircraft_data =  new JSONObject(requester.makeRequest(url));
        if(aircraft_data.has("registration")) {
            return  aircraft_data.get("registration").toString();
        }
        return null;


    }
}
