package hotel.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelRepository extends JpaRepository<Room, Long> {
    @Query(value = "SELECT * FROM rooms WHERE number = :num", nativeQuery = true)
    Room findByNumber(@Param("num") int num);
    //    public Room findByNumber(int number);
    @Query(value = "SELECT EXISTS(SELECT 1 FROM rooms WHERE number = :num)", nativeQuery = true)
    boolean existsByNumber(@Param("num")int number);

    void deleteByNumber(int number);
//    boolean existsByNumber(int number);
}