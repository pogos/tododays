package pl.pogos.tododays.data;

import org.springframework.stereotype.Component;
import pl.pogos.tododays.model.User;
import pl.pogos.tododays.repository.UserRepository;

import javax.inject.Inject;


@Component
public class UserDataLoader implements DataLoader {

    @Inject
    private UserRepository userRepository;

    @Override
    public void loadData() {
        User user = new User();
        user.setLogin("admin");
        user.setName("Admin");
        user.setPassword("koala");
        userRepository.save(user);
    }
}
