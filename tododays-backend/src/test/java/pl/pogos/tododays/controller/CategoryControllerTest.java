package pl.pogos.tododays.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;
import pl.pogos.tododays.config.ControllerConfiguration;
import pl.pogos.tododays.config.DatabaseConfiguration;
import pl.pogos.tododays.model.Category;
import pl.pogos.tododays.repository.CategoryRepository;

import javax.inject.Inject;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


public class CategoryControllerTest extends AbstractControllerTest {

    @Inject
    private CategoryRepository categoryRepository;


    @Test
    public void shouldGetCategory() throws Exception {
        //GIVEN

        //WHEN
        MvcResult mvcResult = mockMvc.perform(get("/api/categories")
        ).andExpect(status().isOk()).andReturn();

        //THEN

        String contentAsString = mvcResult.getResponse().getContentAsString();

    }

    @Test
    public void shouldCreateNewCategory() throws Exception {
        //GIVEN
        String categoryName = "Test name";
        Category category = new Category();
        category.setDescription("Test desc");
        category.setName(categoryName);

        //WHEN
        mockMvc.perform(post("/api/category")
                .content(toJson(category))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
        ).andExpect(status().isOk());

        //THEN
        Optional<Category> dbCategory = categoryRepository.findByName(categoryName);
        assertThat(dbCategory.isPresent(), is(true));
        assertThat(dbCategory.get().getName(), equalTo(categoryName));
    }


    @Test
    public void shouldThrowExceptionWhenCategoryNameAlreadyExists() {
        //TODO add implementation
    }

}