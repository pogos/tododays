package pl.pogos.tododays.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pogos.tododays.model.User;
import pl.pogos.tododays.repository.UserRepository;

import javax.inject.Inject;
import java.util.Optional;

/**
 * User controller
 */
@RestController
public class UserController {

    @Inject
    private UserRepository userRepository;

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {

        Optional<User> userOptional = Optional.ofNullable(userRepository.findOne(id));
        HttpStatus status;
        User user = null;
        if (userOptional.isPresent()) {
            status = HttpStatus.OK;
            user = userOptional.get();
            user.setPassword(null);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(user, status);
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }


}
