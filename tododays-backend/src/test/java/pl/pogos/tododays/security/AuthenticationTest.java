package pl.pogos.tododays.security;

import org.junit.Test;
import pl.pogos.tododays.controller.AbstractControllerTest;

import static org.fest.assertions.Assertions.assertThat;

public class AuthenticationTest extends AbstractControllerTest {

    @Test
    public void shouldAuthenticate() throws Exception {
        //given

        //when
        String token = authenticate("admin", "koala");

        //then
        assertThat(token).isNotNull();
    }
}
