package pl.pogos.tododays.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.pogos.tododays.config.*;

import javax.inject.Inject;
import javax.servlet.Filter;
import java.io.IOException;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        DatabaseConfiguration.class,
        ControllerConfiguration.class,
        SampleDataConfiguration.class,
        ServiceConfiguration.class,
        SecurityConfiguration.class,
        OAuth2Configuration.class
    })
@WebAppConfiguration()
@ActiveProfiles("loadData")
public abstract class AbstractControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractControllerTest.class);

    @Inject
    protected WebApplicationContext context;

    @Inject
    private Filter springSecurityFilterChain;

    MockMvc mockMvc;

    private ObjectMapper objectMapper  = new ObjectMapper();

    protected String token;

    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilter(springSecurityFilterChain)
                //.apply(springSecurity())
                .build();

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        token = authenticate("admin", "koala");
    }

    protected String toJson(Object source) {
        String result = null;
        try {
            result = objectMapper.writeValueAsString(source);
        }
        catch (JsonProcessingException e) {
            LOGGER.error("Can't convert object to json", e);
        }
        return result;
    }

    protected <T> T toObject(String json, Class<T> clazz)  {
        T result = null;
        try {
            result = objectMapper.readValue(json, clazz);
        }
        catch (IOException e) {
            LOGGER.error("Can't convert json to object", e);
        }
        return result;
    }

    protected <T> List<T> toObjectsList(String jsonInput, Class<T> clazz) {
        List<T> result = null;
        try {
            result = objectMapper.readValue(jsonInput, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            LOGGER.error("Can't convert json to list of objects");
        }
        return result;
    }

    protected String authenticate(String userName, String password) throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/api/login")
                .param("username", userName)
                .param("password", password)
                .param("grant_type", "password")
                .param("client_secret", "secret")
                .param("client_id", "tododays")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Basic " + new String(Base64.encodeBase64(("tododays:secret").getBytes())))

        ).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        return JsonPath.read(content, "access_token");
    }


}