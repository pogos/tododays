package pl.pogos.tododays.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pogos.tododays.model.Tag;

/**
 * Created by SG0952928 on 2016-04-18.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
}
