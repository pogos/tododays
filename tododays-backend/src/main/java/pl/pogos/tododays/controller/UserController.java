package pl.pogos.tododays.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pogos.tododays.dto.UserDTO;
import pl.pogos.tododays.model.User;
import pl.pogos.tododays.repository.UserRepository;
import pl.pogos.tododays.service.ConverterService;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * User controller
 */
@RestController
public class UserController {

    @Inject
    private UserRepository userRepository;

    @Inject
    private ConverterService converterService;

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id) {

        Optional<User> userOptional = Optional.ofNullable(userRepository.findOne(id));
        HttpStatus status;
        UserDTO user = null;
        if (userOptional.isPresent()) {
            status = HttpStatus.OK;
            user = converterService.convert(userOptional.get(), UserDTO.class);
            user.setPassword(null);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(user, status);
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user) {
        User dbUser = converterService.convert(user, User.class);
        userRepository.save(dbUser);
        dbUser.setPassword(null);
        return new ResponseEntity<>(converterService.convert(dbUser, UserDTO.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UserDTO>> getUsers() {
        final List<UserDTO> users = converterService.convert(userRepository.findAll(), UserDTO.class);
        users.forEach(userDTO -> userDTO.setPassword(null));
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


}
