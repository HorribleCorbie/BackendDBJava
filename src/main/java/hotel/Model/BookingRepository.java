package hotel.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query(value = "SELECT * FROM booking WHERE booking.id_client = :id AND booking.check_out_date >= CURRENT_DATE", nativeQuery = true)
    List<Booking> findAllByClient(@Param("id") Long id);
    boolean existsById(Long id);
    @Query(value = "SELECT NOT EXISTS (SELECT 1 FROM booking b " +
            "WHERE b.id_room = :id " +
            "AND (b.check_in_date, b.check_out_date) OVERLAPS " +
            "(:in_date, :out_date))", nativeQuery = true)
    boolean available(@Param("id") Long id, @Param("in_date") LocalDate in_date, @Param("out_date") LocalDate out_date);
}