package pl.pogos.tododays.data;


import pl.pogos.tododays.dto.TaskDTO;
import pl.pogos.tododays.model.Task;
import pl.pogos.tododays.model.TaskStatus;
import pl.pogos.tododays.repository.TaskRepository;
import pl.pogos.tododays.service.ConverterService;

import org.springframework.stereotype.Component;
import javax.inject.Inject;

@Component
public class TaskDataLoader implements DataLoader {

    @Inject
    private TaskRepository taskRepository;

    @Inject
    private ConverterService converterService;

    @Override
    public void loadData() {
        final Task task = converterService.convert(new TaskDTO.TaskDTOBuilder()
                        .withName("Task First")
                        .withStatus(TaskStatus.NEW)
                        .build(),
                Task.class);
        taskRepository.save(task);
    }
}
