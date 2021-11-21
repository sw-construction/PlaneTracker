package com.avotrack.avotrack.db;


import com.avotrack.avotrack.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo  extends JpaRepository<Flight, Long> {
}
