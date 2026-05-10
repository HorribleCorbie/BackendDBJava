package hotel.Controller;

public class BookingNotAvailableException extends RuntimeException {
    public BookingNotAvailableException() {
        super("The room is already occupied.");
    }

}
