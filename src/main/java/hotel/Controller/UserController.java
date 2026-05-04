package hotel.Controller;

import hotel.Model.AppUser;
import hotel.Model.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    AppUser newClient(@RequestBody AppUser user) {
        return repository.save(user);
    }

    @GetMapping("/{id}")
    AppUser one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    @GetMapping("/login/{login}")
    AppUser UserbyLogin(@PathVariable String login) {
    if (repository.existsByLogin(login)){
        return repository.findByLogin(login);
    }
        else{
        throw new UserNotFoundException(login);
    }
    }
    @GetMapping("/by-login/{login}")
    boolean checkLogin(@PathVariable String login) {
        return repository.existsByLogin(login);
    }

    @GetMapping("/check")
    boolean checkId(@RequestParam Long id) {
        return repository.existsById(id);
    }

    @PutMapping("/{login}")
    AppUser update(@RequestBody  AppUser user, @PathVariable String login) {
        AppUser newUser =repository.findByLogin(login);
        newUser.setLogin(user.getLogin());
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        return  repository.save(newUser);
    }

}
