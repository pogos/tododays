package pl.pogos.tododays.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
