package pl.pogos.tododays.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import pl.pogos.tododays.config.ServiceConfiguration;

import javax.inject.Inject;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        DatabaseConfiguration.class,
        ControllerConfiguration.class,
        SampleDataConfiguration.class,
        ServiceConfiguration.class
    })
@WebAppConfiguration()
@ActiveProfiles("loadData")
public abstract class AbstractControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractControllerTest.class);

    @Inject
    protected WebApplicationContext context;


    MockMvc mockMvc;

    private ObjectMapper objectMapper  = new ObjectMapper();

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                //.apply(springSecurity())
                .build();

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public String toJson(Object source) {
        String result = null;
        try {
            result = objectMapper.writeValueAsString(source);
        }
        catch (JsonProcessingException e) {
            LOGGER.error("Can't convert object to json", e);
        }
        return result;
    }

    public <T> T toObject(String json, Class<T> clazz)  {
        T result = null;
        try {
            result = objectMapper.readValue(json, clazz);
        }
        catch (IOException e) {
            LOGGER.error("Can't convert json to object", e);
        }
        return result;
    }


}