package pl.pogos.tododays.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pogos.tododays.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
