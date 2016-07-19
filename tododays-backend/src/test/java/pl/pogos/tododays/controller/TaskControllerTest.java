package pl.pogos.tododays.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import pl.pogos.tododays.data.TaskDataLoader;
import pl.pogos.tododays.dto.TaskDTO;
import pl.pogos.tododays.model.Task;
import pl.pogos.tododays.model.TaskStatus;
import pl.pogos.tododays.repository.TaskRepository;

import javax.inject.Inject;

import static org.fest.assertions.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TaskControllerTest extends AbstractControllerTest {

    @Inject
    private TaskRepository taskRepository;

    @Inject
    private TaskDataLoader taskDataLoader;

    @Test
    public void shouldReturnListOfTasks() throws Exception {
        //GIVEN

        //WHEN
        final String response = mockMvc.perform(get("/api/tasks")
                .header("Authorization", "Bearer " + token)  //add security token
                .param("offset", "0")
                .param("limit", "5")
        )
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //THEN
        assertThat(response).isNotEmpty();
    }

    @Test()
    public void shouldCreateTask() throws Exception {
        //GIVEN
        TaskDTO task = createTestTask();

        //WHEN
        final String result = mockMvc.perform(post("/api/tasks/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .header("Authorization", "Bearer " + token)  //add security token
                .content(toJson(task)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //THEN
        final TaskDTO resultDto = toObject(result, TaskDTO.class);

        assertThat(resultDto).isNotNull();
        assertThat(task.getName()).isEqualTo(resultDto.getName());
        assertThat(task.getStatus()).isEqualTo(resultDto.getStatus());

        final Long id = resultDto.getId();
        assertThat(id).isNotNull();
        final Task taskFromDb = taskRepository.findOne(id);

        assertThat(taskFromDb).isNotNull();

    }

    @Test
    public void shouldGetTask() throws Exception {
        //GIVEN
        final Task task = taskDataLoader.getTask();

        //WHEN
        final String result = mockMvc.perform(get("/api/tasks/" + task.getId())
                .header("Authorization", "Bearer " + token)  //add security token
        )
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        //THEN
        final TaskDTO resultDto = toObject(result, TaskDTO.class);

        assertThat(task.getId()).isEqualTo(resultDto.getId());
        assertThat(task.getName()).isEqualTo(resultDto.getName());
        assertThat(task.getStatus()).isEqualTo(resultDto.getStatus());
        assertThat(task.getDescription()).isEqualTo(resultDto.getDescription());
    }

    private TaskDTO createTestTask() {
        return new TaskDTO.TaskDTOBuilder()
                .withName("Test task")
                .withStatus(TaskStatus.NEW)
                .build();
    }

}
