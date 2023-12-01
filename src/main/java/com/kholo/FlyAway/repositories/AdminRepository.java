
package com.kholo.FlyAway.repositories;
import com.kholo.FlyAway.models.Admin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Admin, Long> {
    
    Admin findByUsername(String username);
    List<Admin> findBySomeCriterion(String criterion);
}
