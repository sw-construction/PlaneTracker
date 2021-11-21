package com.avotrack.avotrack;

import com.avotrack.avotrack.models.Aircraft;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public interface Global {
    List<Aircraft> aircrafts = new ArrayList<>(); // holds all active aircrafts

     Queue<List<Aircraft>> AircraftQueue = new PriorityQueue();


}
