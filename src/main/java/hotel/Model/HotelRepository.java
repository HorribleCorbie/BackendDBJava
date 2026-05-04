package hotel.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Room, Long> {
    Room findByNumber(int num);
    boolean existsByNumber(int number);

    @Query(value = "SELECT  r.* FROM rooms r WHERE r.id NOT IN (" +
            "SELECT b.id_room FROM booking b " +
            "WHERE (b.check_in_date, b.check_out_date) OVERLAPS " +
            "(:start, :end))", nativeQuery = true)
    List<Room> findBySelectedBookings(@Param("start") LocalDate start, @Param("end")LocalDate end);

    void deleteByNumber(int number);
}