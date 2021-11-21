package com.avotrack.avotrack.services;

import com.avotrack.avotrack.Global;
import com.avotrack.avotrack.db.AircraftInfoRepo;
import com.avotrack.avotrack.db.AircraftRepo;
import com.avotrack.avotrack.db.FlightRepo;
import com.avotrack.avotrack.db.PositionRepo;
import com.avotrack.avotrack.models.Aircraft;
import com.avotrack.avotrack.models.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@EnableAsync
public class AircraftService {

    private static List<Aircraft> old_aircrafts = new ArrayList<>(); // holds all old aircrafts
    private static List<Aircraft> temp_aircrafts = new ArrayList<>(); // holds all new aircrafts till the get updated on active aircrafts

    @Autowired
    AircraftRepo aircraftRepo;

    @Autowired
    FlightRepo flightRepo;

    @Autowired
    PositionRepo positionRepo;

    @Autowired
    AircraftInfoRepo aircraftInfoRepo;

//    @Scheduled(fixedRate = 2000)
//    private void oldAircraftUpdate() {
//        updateOldAircrafts();
//    }

    public void saveAircraft() {
        aircraftRepo.saveAll(Global.aircrafts);
    }





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
                    new_aircraft.setFlightID(old_aircraft.getFlightID());
//                    new_aircraft.setFlights(old_aircraft.getFlights());
                    new_aircraft.setFlightStart(old_aircraft.getFlightStart());
                    new_aircraft.setTrail(old_aircraft.getTrail());
                    old_aircrafts.remove(indexOfAircraft);
                }
                new_aircraft.addToTrailPositions(new Position(new_aircraft.getPosition().getLat(), new_aircraft.getPosition().getLon(), new_aircraft.getPosition().getAlt()));
//                new_aircraft.getFlights().add(new_aircraft.getFlight());
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

                    aircraftRepo.save(aircraft);
                }
            }
        }

        for (Aircraft aircraft : Global.aircrafts) {
            int lastSeen = aircraft.getLastSeen();
            aircraft.setLastSeen(aircraft.getLastSeen()+1);
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
        new_aircraft.setFlightID(aircraftToUpdate.getFlightID());
        new_aircraft.setFlightStart(aircraftToUpdate.getFlightStart());
//        new_aircraft.setFlights(aircraftToUpdate.getFlights());
//        new_aircraft.getFlights().add(new_aircraft.getFlight());
        new_aircraft.addToTrailPositions(new Position(
                new_aircraft.getPosition().getLat(), new_aircraft.getPosition().getLon(), new_aircraft.getPosition().getAlt()
        ));
//        aircraftRepo.save(new_aircraft);
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
