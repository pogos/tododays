package pl.pogos.tododays.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pogos.tododays.dto.ResponseDTO;
import pl.pogos.tododays.dto.TaskDTO;
import pl.pogos.tododays.dto.TaskListDTO;
import pl.pogos.tododays.model.Task;
import pl.pogos.tododays.repository.TaskRepository;
import pl.pogos.tododays.service.ConverterService;

import javax.inject.Inject;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TaskController {

    @Inject
    private TaskRepository taskRepository;

    @Inject
    private ConverterService converterService;

    @RequestMapping(value = "/tasks/{page}/{size}", method = RequestMethod.GET)
    public ResponseEntity<TaskListDTO> getTasks(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        final Page<Task> taskPage = taskRepository.findAll(new PageRequest(page, size));
        List<TaskDTO> dtos = converterService.convert(taskPage.getContent(), TaskDTO.class);

        TaskListDTO result = new TaskListDTO();
        result.fillResponseList(page, size, taskPage, dtos);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskDTO> getTask(@PathVariable(value = "id") Long id) {
        final Task task = taskRepository.findOne(id);
        return new ResponseEntity<>(converterService.convert(task, TaskDTO.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public ResponseEntity<TaskDTO> updateTask(TaskDTO task) {
        return null;
    }

    @RequestMapping(value = "/task", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO task) {
        final Task savedTask = taskRepository.save(converterService.convert(task, Task.class));
        return new ResponseEntity<>(converterService.convert(savedTask, TaskDTO.class), HttpStatus.OK);
    }

}
