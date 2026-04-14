package hotel.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByLogin(String login);
    boolean existsByLogin(String login);

}
