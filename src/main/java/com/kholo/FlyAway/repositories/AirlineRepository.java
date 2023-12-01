
package com.kholo.FlyAway.repositories;

import com.kholo.FlyAway.models.Airline;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AirlineRepository extends JpaRepository<Airline, Long> {
    
     Airline findByAirlineName(String airlineName);
}
