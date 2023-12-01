
package com.kholo.FlyAway.repositories;
import com.kholo.FlyAway.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
}
