package pl.pogos.tododays.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pogos.tododays.model.Category;

/**
 * Created by Sebastian on 17.03.2016.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
