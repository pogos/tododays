package pl.pogos.tododays.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.pogos.tododays.config.ControllerConfiguration;
import pl.pogos.tododays.config.DatabaseConfiguration;
import pl.pogos.tododays.config.SampleDataConfiguration;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        DatabaseConfiguration.class,
        ControllerConfiguration.class,
        SampleDataConfiguration.class})
@WebAppConfiguration()
@ActiveProfiles("loadData")
public abstract class AbstractControllerTest {

    @Inject
    protected WebApplicationContext context;


    protected MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                //.apply(springSecurity())
                .build();
    }

}
