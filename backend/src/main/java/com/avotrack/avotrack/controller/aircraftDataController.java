package com.avotrack.avotrack.controller;


import com.avotrack.avotrack.services.PhotoService;
import com.avotrack.avotrack.services.RegistrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class aircraftDataController {

    @Autowired
    PhotoService photoService;

    @Autowired
    RegistrationService registrationService;


    @CrossOrigin(origins = "*")
    @GetMapping(value = "/aircrafts/aircraft/photo")
    public  @ResponseBody
    JsonNode getAircraftPhoto(@RequestParam String icao) throws JsonProcessingException { return photoService.getPhoto(icao); }


    @CrossOrigin(origins = "*")
    @GetMapping(value = "/aircrafts/aircraft/reg")
    public  @ResponseBody
    JsonNode getAircraftReg(@RequestParam String icao) throws JsonProcessingException { return registrationService.getAircraftData(icao); }
}
