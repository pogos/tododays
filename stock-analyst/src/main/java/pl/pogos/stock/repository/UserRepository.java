package pl.pogos.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pogos.stock.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
