package com.avotrack.avotrack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @GetMapping(value="/aircrafts", produces = "application/json")
    public @ResponseBody String getAircraft() {
        return "here are your aircrafts";
    }
}
