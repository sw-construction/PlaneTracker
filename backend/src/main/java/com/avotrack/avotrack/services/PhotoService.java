package com.avotrack.avotrack.services;


import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    private static final String PHOTO_URL="https://cop.eplasp.io/aircraftinfo/aircraftdata/photos/?icao=";

    public String[] getPhoto(String icao) {
        Requester requester = new Requester();
        String[] photoData = new String[2];
        String url = PHOTO_URL+icao;
        JSONObject  photo =  new JSONObject(requester.makeRequest(url));
        String p_url = photo.get("photo_url").toString();
        if (p_url.equals("error") || p_url.equals("No Photos found")) {
            return photoData;
        }
        photoData[0] = photo.get("photo_url").toString();
        photoData[1] = photo.get("photo_source").toString();
        photoData[2] = photo.get("photographer").toString();
        return  photoData;

    }

}
