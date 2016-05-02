package pl.pogos.tododays.repository;

/**
 * Created by SG0952928 on 2016-05-02.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pogos.tododays.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
