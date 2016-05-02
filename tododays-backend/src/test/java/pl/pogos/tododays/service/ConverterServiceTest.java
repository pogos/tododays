package pl.pogos.tododays.service;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import pl.pogos.tododays.dto.TaskDTO;
import pl.pogos.tododays.model.Task;
import pl.pogos.tododays.model.TaskPriority;
import pl.pogos.tododays.model.TaskStatus;

import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ConverterServiceTest {


    @Spy
    private Mapper mapper = new DozerBeanMapper();

    @InjectMocks
    private ConverterService converterService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldConvertTaskToTaskDTO() {
        //GIVEN
        Task task = new Task();
        task.setName("Task 1");
        task.setDescription("Task Desc");
        task.setStatus(TaskStatus.NEW);
        task.setCreateDate(new Date());
        task.setPriority(TaskPriority.NORMAL);

        //WHEN
        final TaskDTO taskDTO = converterService.convert(task, TaskDTO.class);

        //THEN
        assertThat(taskDTO).isNotNull();
        assertThat(taskDTO.getName()).isEqualTo(task.getName());
        assertThat(taskDTO.getDescription()).isEqualTo(task.getDescription());
        assertThat(taskDTO.getStatus()).isEqualTo(task.getStatus());
        assertThat(taskDTO.getCreateDate()).isEqualTo(task.getCreateDate());
        assertThat(taskDTO.getPriority()).isEqualTo(task.getPriority());
    }




}