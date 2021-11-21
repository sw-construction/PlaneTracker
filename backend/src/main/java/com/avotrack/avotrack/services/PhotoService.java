package com.avotrack.avotrack.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PhotoService {

    private static final String PHOTO_URL="https://cop.eplasp.io/aircraftinfo/aircraftdata/photos/?icao=";

    public JsonNode getPhoto(String icao) throws JsonProcessingException {
        Requester requester = new Requester();
        String url = PHOTO_URL+icao;
        String result = requester.makeRequest(url);
        if(result == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode photoObj = mapper.readTree(result);
        return photoObj;

    }

}
