package hotel.Controller;

public class RoomNotFoundException extends RuntimeException {

    RoomNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}