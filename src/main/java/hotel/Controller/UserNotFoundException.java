package hotel.Controller;

public class UserNotFoundException extends RuntimeException {

    UserNotFoundException(Long id) {
        super("Could not find room by id:  " + id);
    }
    UserNotFoundException(String login) {
        super("Could not find room by login:  " + login);
    }
}
