package com.avotrack.avotrack.db;

import com.avotrack.avotrack.models.AircraftInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftInfoRepo extends JpaRepository<AircraftInfo, Long> {
}
