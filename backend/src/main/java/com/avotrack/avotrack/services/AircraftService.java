package com.avotrack.avotrack.services;

import com.avotrack.avotrack.Global;
import com.avotrack.avotrack.models.Aircraft;

import java.util.List;

public class AircraftService {

    private static List<Aircraft> old_aircrafts; // holds all old aircrafts
    private static List<Aircraft> temp_aircrafts; // holds all new aircrafts till the get updated on active aircrafts


    // check if aircraft was old aircraft if so then remove it from old_aircrafts and reset last seen
    public void processAircraft(List<Aircraft> aircrafts) {

    }

    // adds or updates each newly added aircraft from temp_aircrafts
    private void updateAircraftList() {

    }
    // updates the aircraft in aircrafts list with new aircraft
    private void updateAircraft(Aircraft new_aircraft) {

    }

    public List<Aircraft> getAircrafts() {
        return Global.aircrafts;

    }



}
