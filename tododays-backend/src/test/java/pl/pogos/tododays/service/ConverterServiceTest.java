package pl.pogos.tododays.service;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.pogos.tododays.dto.TaskDTO;
import pl.pogos.tododays.model.Task;
import pl.pogos.tododays.model.TaskPriority;
import pl.pogos.tododays.model.TaskStatus;

import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ConverterServiceTest {


    @Mock
    private DozerBeanMapper dozerBeanMapper;

    @InjectMocks
    private ConverterService converterService;

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
        final TaskDTO taskDTO = converterService.<TaskDTO>convert(task);

        //THEN
        assertThat(taskDTO).isNotNull();
        assertThat(taskDTO.getName()).equals(task.getName());
        assertThat(taskDTO.getDescription()).equals(task.getDescription());
        assertThat(taskDTO.getStatus()).equals(task.getStatus());
        assertThat(taskDTO.getCreateDate()).equals(task.getCreateDate());
        assertThat(taskDTO.getPriority()).equals(task.getPriority());
    }




}