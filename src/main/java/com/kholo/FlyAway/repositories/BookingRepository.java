
package com.kholo.FlyAway.repositories;
import com.kholo.FlyAway.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    List<Booking> findByUser_Username(String username);

    List<Booking> findByFlight_SourceAndFlight_Destination(String source, String destination);
}
