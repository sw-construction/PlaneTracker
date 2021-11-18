package com.avotrack.avotrack.services;

import com.avotrack.avotrack.Global;
import com.avotrack.avotrack.models.Aircraft;
import com.avotrack.avotrack.models.Position;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrailService {

    public List<List<Position>> getAllTrails() {
        List<List<Position>> positions = new ArrayList<>();
        for(Aircraft aircraft : Global.aircrafts){
            positions.add(aircraft.getTrail());
        }
        return positions;
    }

    public List<Position> getAircraftTrail(String icao) {
        Aircraft aircraft = new Aircraft();
        aircraft.setHex(icao);
        if(Global.aircrafts.contains(aircraft)) {
            int index = Global.aircrafts.indexOf(aircraft);
            Aircraft ac = Global.aircrafts.get(index);
            List<Position> positions = ac.getTrail();
            return  positions;
        } else {
            List<Position> pos = new ArrayList<>();
            return  pos;
        }


    }
}
