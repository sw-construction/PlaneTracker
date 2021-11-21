package com.avotrack.avotrack.services;

import com.avotrack.avotrack.Global;
import com.avotrack.avotrack.db.AircraftInfoRepo;
import com.avotrack.avotrack.db.AircraftRepo;
import com.avotrack.avotrack.db.FlightRepo;
import com.avotrack.avotrack.db.PositionRepo;
import com.avotrack.avotrack.models.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;


@EnableAsync
@Service
public class InsertDb {

    @Autowired
    AircraftRepo aircraftRepo;

    @Autowired
    FlightRepo flightRepo;

    @Autowired
    PositionRepo positionRepo;

    @Autowired
    AircraftInfoRepo aircraftInfoRepo;


    public void startProcessing() {
        for(Aircraft aircraft : Global.aircrafts) {
            aircraftRepo.save(aircraft);
        }
    }
}
