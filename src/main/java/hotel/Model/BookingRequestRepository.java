package hotel.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRequestRepository extends JpaRepository<Booking, Long> {

}
