package pl.pogos.tododays.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.pogos.tododays.dto.ResponseDTO;
import pl.pogos.tododays.dto.TaskDTO;
import pl.pogos.tododays.model.Task;
import pl.pogos.tododays.repository.TaskRepository;
import pl.pogos.tododays.service.ConverterService;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TaskController {

    @Inject
    private TaskRepository taskRepository;

    @Inject
    private ConverterService converterService;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public ResponseEntity<List<TaskDTO>> getTasks() {
        final List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> dtos = converterService.convert(tasks, TaskDTO.class);

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskDTO> getTask(@PathParam(value = "id") Long id) {
        return null;
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> updateTask(TaskDTO task) {
        return null;
    }

    @RequestMapping(value = "/task", method = RequestMethod.PUT)
    public ResponseEntity<ResponseDTO> createTask(TaskDTO task) {
        return null;
    }

}
