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
    private Task task;

    @Override
    public void loadData() {
        task = converterService.convert(new TaskDTO.TaskDTOBuilder()
                        .withName("Task First")
                        .withStatus(TaskStatus.NEW)
                        .build(),
                Task.class);
        taskRepository.save(task);
    }

    public Task getTask() {
        return task;
    }
}
