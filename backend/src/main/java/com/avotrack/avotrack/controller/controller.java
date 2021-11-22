package com.avotrack.avotrack.controller;

import com.avotrack.avotrack.db.AircraftInfoRepo;
import com.avotrack.avotrack.db.AircraftRepo;
import com.avotrack.avotrack.db.FlightRepo;
import com.avotrack.avotrack.db.PositionRepo;
import com.avotrack.avotrack.models.Aircraft;
import com.avotrack.avotrack.models.Position;
import com.avotrack.avotrack.services.AircraftService;
import com.avotrack.avotrack.services.PhotoService;
import com.avotrack.avotrack.services.RegistrationService;
import com.avotrack.avotrack.services.TrailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

    @Autowired
    AircraftService aircraftService;

    @Autowired
    PhotoService photoService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    TrailService trailService;


    @Autowired
    AircraftRepo aircraftRepo;

    @Autowired
    FlightRepo flightRepo;

    @Autowired
    PositionRepo positionRepo;

    @Autowired
    AircraftInfoRepo aircraftInfoRepo;



    // cross origin allows any host with the url below to make a request
    @CrossOrigin(origins = "*")
    @GetMapping(value="/aircrafts", produces = "application/json")
    public @ResponseBody
    List<Aircraft> getAircraft() {
        return aircraftService.getAircrafts();
    }



    @CrossOrigin(origins = "*")
    @GetMapping(value = "/aircrafts/aircraft/trail")
    public  @ResponseBody
    List<Position> getAircraftTrail(@RequestParam String icao) { return trailService.getAircraftTrail(icao); }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/aircrafts/trails")
    public  @ResponseBody
    List<List<Position>> getAllTrails() { return trailService.getAllTrails(); }



    @CrossOrigin(origins = "*")
    @GetMapping(value = "/aircrafts/db/all")
    public  @ResponseBody
    List<Aircraft> getAircraftsInDb() { return aircraftRepo.findAll(); }

//    @CrossOrigin(origins = "*")
//    @GetMapping(value = "/aircrafts/db")
//    public  @ResponseBody
//    List<Aircraft> getAircraftsInDb() { return aircraftRepo.findAll(); }





}
