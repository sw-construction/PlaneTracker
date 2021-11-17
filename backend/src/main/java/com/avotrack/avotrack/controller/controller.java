package com.avotrack.avotrack.controller;

import com.avotrack.avotrack.models.Aircraft;
import com.avotrack.avotrack.services.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

    @Autowired
    AircraftService aircraftService;
    // cross origin allows any host with the url below to make a request
    @CrossOrigin(origins = "*")
    @GetMapping(value="/aircrafts", produces = "application/json")
    public @ResponseBody
    List<Aircraft> getAircraft() {
        return aircraftService.getAircrafts();
    }

    @GetMapping(value="/aircrafts/positons", produces = "application/json")
    public @ResponseBody String getAircraftPositions() {
        return "here are all aircraft positions";
    }

    @GetMapping(value="/aircrafts/pos", produces = "application/json")
    public @ResponseBody String getAircraftPosition(@RequestParam String flightID) {
        return "here are all aircraft positions";
    }
}
