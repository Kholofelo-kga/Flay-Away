
package com.kholo.FlyAway.repositories;
import com.kholo.FlyAway.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    
    List<Flight> findBySourceAndDestination(String source, String destination);
}
