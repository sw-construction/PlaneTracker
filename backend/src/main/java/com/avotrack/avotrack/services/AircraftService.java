package com.avotrack.avotrack.services;

import com.avotrack.avotrack.Global;
import com.avotrack.avotrack.models.Aircraft;
import com.avotrack.avotrack.models.Position;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AircraftService {

    private static List<Aircraft> old_aircrafts = new ArrayList<>(); // holds all old aircrafts
    private static List<Aircraft> temp_aircrafts = new ArrayList<>(); // holds all new aircrafts till the get updated on active aircrafts


    // check if aircraft was old aircraft if so then remove it from old_aircrafts and reset last seen
    public void processAircraft(List<Aircraft> new_aircrafts) {
        for (Aircraft new_aircraft : new_aircrafts) {
            double lat = new_aircraft.getPosition().getLat();
            double lon = new_aircraft.getPosition().getLon();
            if(lat != 0 && lon != 0) {
                Aircraft old_aircraft = new Aircraft();
                if (old_aircrafts.contains(new_aircraft)) {
                    // get the index of the new aircraft listed in old aircraft
                    int indexOfAircraft = old_aircrafts.indexOf(new_aircraft);
                    old_aircraft = old_aircrafts.get(indexOfAircraft);
                    new_aircraft.setTrail(old_aircraft.getTrail());
                    old_aircrafts.remove(indexOfAircraft);
                }
                new_aircraft.addToTrailPositions(new Position(new_aircraft.getPosition().getLat(), new_aircraft.getPosition().getLon(), new_aircraft.getPosition().getAlt()));
                temp_aircrafts.add(new_aircraft);
            }

        }
        updateAircraftList();

    }

    // adds or updates each newly added aircraft from temp_aircrafts
    private void updateAircraftList() {
        List<Aircraft> aircraftsToBeRemoved = new ArrayList<>();
        if (temp_aircrafts != null) {
            for (Aircraft aircraft : temp_aircrafts) {
                if(Global.aircrafts.contains(aircraft)) {
                    updateAircraft(aircraft);
                } else {
                    Global.aircrafts.add(aircraft);
                }
            }
        }

        for (Aircraft aircraft : Global.aircrafts) {
            int lastSeen = aircraft.getLastSeen();

            aircraft.setLastSeen(lastSeen++);

            if (!temp_aircrafts.contains(aircraft)) {
                if (aircraft.getLastSeen() > 45) {
                    aircraftsToBeRemoved.add(aircraft);
                    old_aircrafts.add(aircraft);
                }
            }
        }

        for(Aircraft aircraft : aircraftsToBeRemoved) {
            int indexOfAircraft = Global.aircrafts.indexOf(aircraft);
            Global.aircrafts.remove(indexOfAircraft);
        }
        temp_aircrafts.clear();
        updateOldAircrafts();

    }
    // updates the aircraft in aircrafts list with new aircraft
    private void updateAircraft(Aircraft new_aircraft) {
        int indexOfOldAircraft= Global.aircrafts.indexOf(new_aircraft);
        Aircraft aircraftToUpdate = Global.aircrafts.get(indexOfOldAircraft);
        new_aircraft.setTrail(aircraftToUpdate.getTrail());
        new_aircraft.addToTrailPositions(new Position(
                new_aircraft.getPosition().getLat(), new_aircraft.getPosition().getLon(), new_aircraft.getPosition().getAlt()
        ));
        Global.aircrafts.set(indexOfOldAircraft, new_aircraft);

    }


    private void updateOldAircrafts() {
        List<Aircraft> aircraftsToBeRemoved = new ArrayList<>();
        if (old_aircrafts != null && !old_aircrafts.isEmpty()) {
            for (Aircraft aircraft : old_aircrafts) {
                if (aircraft.getLastSeen() > 100) {
                    aircraftsToBeRemoved.add(aircraft);
                } else {
                    aircraft.setLastSeen(aircraft.getLastSeen() + 2);
                }
            }
            old_aircrafts.removeAll(aircraftsToBeRemoved);
        }
    }

    public List<Aircraft> getAircrafts() {
        return Global.aircrafts;
    }



}
