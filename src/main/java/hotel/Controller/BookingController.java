package hotel.Controller;

import hotel.Model.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingRepository repository;
    private final HotelRepository repositoryHotel;
    private final UserRepository repositoryUser;

    public BookingController(BookingRepository repository, HotelRepository repositoryHotel, UserRepository repositoryUser) {
        this.repository = repository;
        this.repositoryHotel = repositoryHotel;
        this.repositoryUser = repositoryUser;
    }


//    public BookingController(BookingRepository repository) {
//        this.repository = repository;
//    }

    @PostMapping
    Booking newBooking(@RequestBody BookingRequest booking) {
        System.out.println("Received: " + booking);
        var room = repositoryHotel.findByNumber(booking.getRoomId());
        var user = repositoryUser.findByLogin(booking.getLogin());
        float price = Float.parseFloat(booking.getPrice());
        Booking newBooking = new Booking(room, user, booking.getIn_date(),booking.getOut_date(),price);
        return repository.save(newBooking);
    }

    @GetMapping
    List<Booking> all() {
        return repository.findAll();
    }

    @GetMapping("/all/{id}")
    List<Booking> allByClient(@PathVariable Long id) {
        return repository.findAllByClient(id);
    }

    @GetMapping("/one/{id}")
    Booking one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    void deleteBooking(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    Booking update(@RequestBody Booking booking, @PathVariable Long id) {
        Booking newBooking = repository.findById(id).orElseThrow(() -> new BookingNotFoundException(id));
        newBooking.setRoom(booking.getRoom());
        newBooking.setIn_date(booking.getIn_date());
        newBooking.setOut_date(booking.getOut_date());
        return repository.save(newBooking);
    }
}

