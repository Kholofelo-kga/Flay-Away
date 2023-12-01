
package com.kholo.FlyAway.repositories;
import com.kholo.FlyAway.models.Place;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlaceRepository extends JpaRepository<Place, Long> {
    
     List<Place> findByPlaceName(String placeName);
}
