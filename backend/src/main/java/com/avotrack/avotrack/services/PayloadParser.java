package com.avotrack.avotrack.services;

import com.avotrack.avotrack.models.Aircraft;
import com.avotrack.avotrack.models.AircraftInfo;
import com.avotrack.avotrack.models.Flight;
import com.avotrack.avotrack.models.Position;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



public class PayloadParser {



    public Aircraft createAircraft(JSONObject plane) throws JsonProcessingException {
        Aircraft aircraft = new Aircraft();
        aircraft.setHex(plane.getString("hex"));
        try {
            aircraft.setPosition(createPosition(plane));
        } catch (Exception e) {

        }

        aircraft.setFlight(createFlight(plane));
        aircraft.setAircraftInfo(createAircraftInfo(plane));
        return aircraft;
    }

    public Position createPosition(JSONObject plane) throws JSONException, JsonProcessingException {
        Position position = new Position();
        String jsonString = plane.toString();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj = mapper.readTree(jsonString);
        if(obj.has("lat") && obj.hasNonNull("lat")) {
            position.setLat(obj.get("lat").asDouble(0));
        } else {
            position.setLat(0.0);
        }
        if(obj.has("lon") && obj.hasNonNull("lon")) {
            position.setLon(obj.get("lon").asDouble(0));
        } else {
            position.setLon(0.0);
        }

        if(obj.has("alt_baro") && obj.hasNonNull("alt_baro")) {
            position.setAlt(obj.get("alt_baro"));
        }
        else if(obj.has("alt_geom") && obj.hasNonNull("alt_geom")) {
            position.setAlt(obj.get("alt_geom"));
        }
        else if(obj.has("nav_altitude_mcp") && obj.hasNonNull("nav_altitude_mcp")) {
            position.setAlt(obj.get("nav_altitude_mcp"));
        }
        return position;
    }

    public Flight createFlight(JSONObject plane) throws JSONException {
        Flight flight = new Flight();
        if(plane.has("alt_baro")){
            flight.setBarometric_alt(plane.get("alt_baro").toString());
        }
        if(plane.has("alt_geom")){
            flight.setGeometric_alt(plane.get("alt_geom").toString());
        }
        if(plane.has("gs")){
            flight.setGround_speed(plane.getDouble("gs"));
        }
        if(plane.has("track")){
            flight.setTrack(plane.getDouble("track"));
        }
        if(plane.has("baro_rate")){
            flight.setBarometric_rate(plane.getInt("baro_rate"));
        }
        if(plane.has("squawk")){
            flight.setSquawk(plane.getInt("squawk"));
        }
        if(plane.has("emergency")){
            flight.setEmergency(plane.getString("emergency"));
        }
        if(plane.has("nav_qnh")){
            flight.setNav_qnh(plane.getDouble("nav_qnh"));
        }
        if(plane.has("nav_altitude_mcp")){
            flight.setNav_altitude_mcp(plane.get("nav_altitude_mcp").toString());
        }
        if(plane.has("nav_heading")){
            flight.setHeading(plane.getDouble("nav_heading"));
        }
        if(plane.has("nav_modes")){
            flight.setModes(parseModes(plane.getJSONArray("nav_modes")));
        }
        if(plane.has("nic")){
            flight.setNic(plane.getInt("nic"));
        }
        if(plane.has("rc")){
            flight.setRc(plane.getInt("rc"));
        }
        if(plane.has("version")){
            flight.setVersion(plane.getInt("version"));
        }
        if(plane.has("nic_baro")){
            flight.setNic_baro(plane.getInt("nic_baro"));
        }
        if(plane.has("nac_p")){
            flight.setNac_p(plane.getInt("nac_p"));
        }
        if(plane.has("nac_v")){
            flight.setNac_v(plane.getInt("nac_v"));
        }
        if(plane.has("sil")){
            flight.setSil(plane.getInt("sil"));
        }
        if(plane.has("sil_type")){
            flight.setSil_type(plane.getString("sil_type"));
        }
        if(plane.has("gva")){
            flight.setGva(plane.getInt("gva"));
        }
        if(plane.has("sda")){
            flight.setSda(plane.getInt("sda"));
        }
        if(plane.has("alert")){
            flight.setAlert(plane.getInt("alert"));
        }
        if(plane.has("mlat")){
            flight.setMlat(plane.get("mlat").toString());
        }
        if(plane.has("tisb")){
            flight.setTisb(plane.get("tisb").toString());
        }
        if(plane.has("rssi")){
            flight.setRssi(plane.getDouble("rssi"));
        }
        return flight;
    }

    public AircraftInfo createAircraftInfo(JSONObject plane) throws JsonProcessingException {


        AircraftInfo aircraftInfo = new AircraftInfo();
//        aircraftInfo.setIcao(plane.getString("hex"));
//        String hex = plane.getString("hex");
//
////        System.out.println(photoService.getPhoto(hex));
//        aircraftInfo.setPhoto(photoService.getPhoto(hex));
//        JsonNode extraACData = registrationService.getAircraftData(hex);
//        if(extraACData != null) {
//            if (extraACData.has("registraction") && extraACData.hasNonNull("registraction")) {
//                aircraftInfo.setRegistration(extraACData.get("registraction").asText());
//            }
//        }



        if(plane.has("flight")){
            aircraftInfo.setCallsign(plane.getString("flight"));
        }
        if(plane.has("type")){
            aircraftInfo.setType(plane.getString("type"));
        }
        if(plane.has("category")){
            aircraftInfo.setCategory(plane.getString("category"));
        }
        return aircraftInfo;
    }

    private List<String> parseModes (JSONArray modesArray){
        List<String> modes = new ArrayList<String>();
        for(int i = 0; i < modesArray.length(); i++){
            modes.add(modesArray.getString(i));
        }
        return modes;
    }
}
