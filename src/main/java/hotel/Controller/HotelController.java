package hotel.Controller;

import java.util.List;
import  hotel.Model.HotelRepository;
import hotel.Model.Room;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
class HotelController {

    private final HotelRepository repository;

    HotelController(HotelRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    List<Room> all() {
        return repository.findAll();
    }

    @PostMapping
    Room newRoom(@RequestBody Room room) {
        return repository.save(room);
    }

    @GetMapping("/{id}")
    Room one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    @PutMapping("/{id}")
    boolean update(@RequestBody  Room room,@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        Room existingRoom = repository.findById(id).get();
        existingRoom.setNumber(room.getNumber());
        existingRoom.setPrice(room.getPrice());
        existingRoom.setCapacity(room.getCapacity());
        existingRoom.setComfort(room.getComfort());
        existingRoom.setArea(room.getArea());
        repository.save(existingRoom);
        return true;
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
