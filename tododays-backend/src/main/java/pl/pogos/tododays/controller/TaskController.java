package pl.pogos.tododays.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.pogos.tododays.dto.ResponseDTO;
import pl.pogos.tododays.dto.TaskDTO;

import javax.websocket.server.PathParam;

/**
 * Created by SG0952928 on 2016-04-12.
 */
@RestController
@RequestMapping("/api")
public class TaskController {

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public ResponseEntity<TaskDTO> getTasks() {
        return null;
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
