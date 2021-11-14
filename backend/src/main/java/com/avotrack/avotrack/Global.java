package com.avotrack.avotrack;

import com.avotrack.avotrack.models.Aircraft;

import java.util.ArrayList;
import java.util.List;

public interface Global {
    List<Aircraft> aircrafts = new ArrayList<>(); // holds all active aircrafts
}
