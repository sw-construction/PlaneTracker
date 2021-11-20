package com.avotrack.avotrack.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private static final String AIRCRAFT_DATA_URL="https://cop.eplasp.io/aircraftinfo/aircraftdata/aircraft/?icao=";
    public JsonNode getAircraftData(String icao) throws JsonProcessingException {
        Requester requester = new Requester();
        String url = AIRCRAFT_DATA_URL + icao;
        String result = requester.makeRequest(url);
        if (result == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode aircraftData = mapper.readTree(result);


        return aircraftData;
    }

}
