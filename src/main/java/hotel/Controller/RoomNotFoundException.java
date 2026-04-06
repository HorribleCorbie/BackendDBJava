package hotel.Controller;

public class RoomNotFoundException extends RuntimeException {

    RoomNotFoundException(Long id) {
        super("Could not find room by id:  " + id);
    }
    RoomNotFoundException(int number) {
        super("Could not find room by number:  " + number);
    }
}