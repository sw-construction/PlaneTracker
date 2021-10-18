package com.avotrack.avotrack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @GetMapping(value="/aircrafts", produces = "application/json")
    public @ResponseBody String getAircraft() {
        return "here are your aircrafts";
    }

    @GetMapping(value="/aircrafts/positons", produces = "application/json")
    public @ResponseBody String getAircraftPositions() {
        return "here are all aircraft positions";
    }

    @GetMapping(value="/aircrafts/pos", produces = "application/json")
    public @ResponseBody String getAircraftPosition(@RequestParam String flightIDcd) {
        return "here are all aircraft positions";
    }
}
