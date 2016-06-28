package pl.pogos.tododays.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import pl.pogos.tododays.data.UserDataLoader;
import pl.pogos.tododays.dto.UserDTO;
import pl.pogos.tododays.model.User;
import pl.pogos.tododays.repository.UserRepository;

import javax.inject.Inject;
import java.util.List;

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
        UserDTO user = createTestUser();

        //WHEN
        final MvcResult mvcResult = mockMvc.perform(
                post("/api/user")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(toJson(user))
        ).andExpect(status().isOk())
                .andReturn();

        //THEN
        final UserDTO resultUser = toObject(mvcResult.getResponse().getContentAsString(), UserDTO.class);
        assertThat(resultUser.getId()).isNotNull();
        assertThat(resultUser.getPassword()).isNull();

        final User dbUser = userRepository.findOne(resultUser.getId());
        assertThat(dbUser).isNotNull();
        assertThat(dbUser.getName()).isEqualTo(user.getName());
        assertThat(dbUser.getLogin()).isEqualTo(user.getLogin());

    }

    @Test
    public void shouldReturnNotFoundStatusForNotExistingUser() throws Exception {
        //GIVEN

        //WHEN
        mockMvc.perform(
                get("/api/user/0")
        ).andExpect(status()
                .isNotFound());

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
        UserDTO user = toObject(result, UserDTO.class);

        assertThat(user).isNotNull();
        assertThat(defaultUser.getId()).isEqualTo(user.getId());
        assertThat(defaultUser.getLogin()).isEqualTo(user.getLogin());
        assertThat(defaultUser.getName()).isEqualTo(user.getName());
        assertThat(user.getPassword()).isNull();
    }

    @Test
    public void shouldGetUsers() throws Exception {
        //GIVEN

        //WHEN
        final String result = mockMvc.perform(
                get("/api/users")
        ).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //THEN
        List<UserDTO> users = toObjectsList(result, UserDTO.class);
        assertThat(users).isNotNull();
        assertThat(users).isNotEmpty();
        assertThat(users.size()).isNotEqualTo(0);
    }

    @Test
    public void shouldGetCurrentUser() {

    }

    private UserDTO createTestUser() {
        return new UserDTO.UserBuilder()
                .withLogin("test1")
                .withName("Test 2")
                .withPassword("password")
                .withEmail("email@o2.pl")
                .build();
    }


}
