package hotel.Controller;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(Long id) {
        super("Could not find booking by id:  " + id);
    }
}
