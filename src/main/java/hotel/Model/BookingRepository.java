package hotel.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query(value = "SELECT * FROM booking WHERE booking.id_client = :id AND booking.check_out_date >= CURRENT_DATE", nativeQuery = true)
    List<Booking> findAllByClient(@Param("id") Long id);
}