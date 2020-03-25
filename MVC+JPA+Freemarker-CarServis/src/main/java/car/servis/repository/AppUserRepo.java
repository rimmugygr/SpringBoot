package car.servis.repository;

import car.servis.dto.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface to communication with db
 */

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {

    AppUser findByUsername(String username);

}
