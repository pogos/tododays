package pl.pogos.tododays.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.pogos.tododays.data.UserDataLoader;
import pl.pogos.tododays.model.User;
import pl.pogos.tododays.repository.UserRepository;

import javax.inject.Inject;

import static org.fest.assertions.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerTest extends AbstractControllerTest{

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserDataLoader userDataLoader;

    @Test
    public void shouldCreateUser() throws Exception {
        //GIVEN
        User user = createTestUser();

        //WHEN
        mockMvc.perform(
                post("/api/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(toJson(user))
        ).andExpect(status().isOk());

        //THEN
    }

    @Test
    public void shouldReturnNotFoundStatusForNotExistingUser() throws Exception {
        //GIVEN

        //WHEN
        mockMvc.perform(
                get("/api/user/0")
        ).andExpect(status().isNotFound());

        //THEN
    }

    @Test
    public void shouldUpdateUser() {

    }

    @Test
    public void shouldGetUser() throws Exception {
        //GIVEN
        User defaultUser = userDataLoader.getDefaultUser();

        //WHEN
        MvcResult mvcResult = mockMvc.perform(
                get("/api/user/" + defaultUser.getId())
        ).andExpect(status().isOk())
                .andReturn();

        //THEN
        String result = mvcResult.getResponse().getContentAsString();
        User user = toObject(result, User.class);

        assertThat(user).isNotNull();
        assertThat(defaultUser.getId()).isEqualTo(user.getId());
        assertThat(defaultUser.getLogin()).isEqualTo(user.getLogin());
        assertThat(defaultUser.getName()).isEqualTo(user.getName());
        assertThat(user.getPassword()).isNull();
    }

    @Test
    public void shouldGetUsers() {

    }

    @Test
    public void shouldGetCurrentUser() {

    }

    private User createTestUser() {
        User user = new User();
        user.setLogin("test");
        user.setName("Test 2");
        user.setPassword("password");
        return user;
    }


}
