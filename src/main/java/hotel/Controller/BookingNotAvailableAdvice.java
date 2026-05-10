package hotel.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookingNotAvailableAdvice {

    @ExceptionHandler(BookingNotAvailableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String BookingNotAvailableHandler(BookingNotAvailableException ex) {
        return ex.getMessage();
    }
}
