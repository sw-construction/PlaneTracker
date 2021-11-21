package com.avotrack.avotrack.db;

import com.avotrack.avotrack.models.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AircraftRepo extends JpaRepository<Aircraft, Long> {

}
