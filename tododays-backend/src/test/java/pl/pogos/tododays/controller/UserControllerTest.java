package pl.pogos.tododays.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.pogos.tododays.config.ControllerConfiguration;
import pl.pogos.tododays.config.DatabaseConfiguration;
import pl.pogos.tododays.model.User;

import javax.inject.Inject;

import java.io.IOException;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Sebastian on 07.04.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfiguration.class, ControllerConfiguration.class})
@WebAppConfiguration
public class UserControllerTest {

    @Inject
    private WebApplicationContext context;


    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                //.apply(springSecurity())
                .build();
    }

    @Test
    public void shouldCreateUser() throws Exception {
//        User user = new User();
//        user.setLogin("test");
//        user.setName("Test 2");
//        user.setPassword("password");
        mockMvc.perform(
                post("/api/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"login\": \"admin\", \"password\": \"koala\", \"name\": \"First Administrator\"}")
        ).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnNotFoundStatusForNotExistingUser() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                get("/api/user/0")
        ).andExpect(status().isNotFound())
         .andReturn();
        mvcResult.getResponse().getContentAsString();
    }

    @Test
    public void shouldUpdateUser() {

    }

    @Test
    public void shouldGetUser() {

    }

    @Test
    public void shouldGetUsers() {

    }

    @Test
    public void shouldGetCurrentUser() {

    }

    @Inject
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }



}
