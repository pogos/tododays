package pl.pogos.tododays.controller;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class TaskControllerTest extends AbstractControllerTest {


    @Test
    public void shouldReturnListOfTasks() throws Exception {
        //GIVEN

        //WHEN
        final String response = mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //THAN
        assertThat(response).isNotEmpty();
    }

    @Test
    public void shouldCreateTask() {

    }

    @Test
    public void shouldGetTask() {

    }

}