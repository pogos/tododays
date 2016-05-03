package pl.pogos.tododays.data;

import org.springframework.stereotype.Component;
import pl.pogos.tododays.model.User;
import pl.pogos.tododays.repository.UserRepository;

import javax.inject.Inject;


@Component
public class UserDataLoader implements DataLoader {

    @Inject
    private UserRepository userRepository;

    private User defaultUser;

    @Override
    public void loadData() {
        defaultUser = new User();
        defaultUser.setLogin("admin");
        defaultUser.setName("Admin");
        defaultUser.setPassword("koala");
        userRepository.save(defaultUser);
    }

    public User getDefaultUser() {
        return defaultUser;
    }
}
