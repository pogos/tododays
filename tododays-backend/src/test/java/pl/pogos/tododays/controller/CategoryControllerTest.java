package pl.pogos.tododays.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import pl.pogos.tododays.data.CategoryDataLoader;
import pl.pogos.tododays.dto.CategoryDTO;
import pl.pogos.tododays.dto.CategoryListDTO;
import pl.pogos.tododays.dto.ErrorDTO;
import pl.pogos.tododays.model.Category;
import pl.pogos.tododays.repository.CategoryRepository;
import pl.pogos.tododays.util.ErrorHelper;

import javax.inject.Inject;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.fest.assertions.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CategoryControllerTest extends AbstractControllerTest {

    private static final String CATEGORY_NAME = "Test name";

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private CategoryDataLoader categoryDataLoader;

    @Test
    public void shouldGetCategory() throws Exception {
        //GIVEN
        String categoryName = categoryDataLoader.getCategoryNames().stream().findFirst().orElse(null);

        //WHEN
        String result = mockMvc.perform(get("/api/category/" + URLEncoder.encode(categoryName, "UTF-8"))
        ).andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        //THEN
        assertThat(result).isNotNull();

        Category dbCategory = categoryRepository.findByName(categoryName).orElse(null);
        CategoryDTO category = toObject(result, CategoryDTO.class);

        assertThat(dbCategory.getName()).isEqualTo(category.getName());
        assertThat(dbCategory.getId()).isEqualTo(category.getId());
        assertThat(dbCategory.getDescription()).isEqualTo(category.getDescription());
    }

    @Test
    public void shouldGetCategorise() throws Exception {
        //GIVEN

        //WHEN
        String result = mockMvc.perform(get("/api/categories/1/1")
        ).andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        //THEN
        CategoryListDTO categories = toObject(result, CategoryListDTO.class);
        assertThat(categories).isNotNull();
        assertThat(categories.getData()).isNotNull();
        assertThat(categories.getData().size()).isGreaterThan(0);

    }

    @Test
    public void shouldCreateNewCategory() throws Exception {
        //GIVEN
        Category category = createCategory(CATEGORY_NAME);

        //WHEN
        mockMvc.perform(post("/api/category")
                .content(toJson(category))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
        ).andExpect(status().isOk());

        //THEN
        Optional<Category> dbCategory = categoryRepository.findByName(CATEGORY_NAME);
        assertThat(dbCategory.isPresent()).isTrue();
        Category cat = dbCategory.orElse(null);
        assertThat(cat.getName()).isEqualTo(CATEGORY_NAME);
    }

    @Test
    public void shouldThrowExceptionWhenCategoryNameAlreadyExists() throws Exception {
        //GIVEN
        String categoryName = categoryDataLoader.getCategoryNames().stream().findFirst().orElse(null);
        Category category = createCategory(categoryName);

        //WHEN
        final String result = mockMvc.perform(post("/api/category")
                .content(toJson(category))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
        ).andExpect(status().isConflict())
                .andReturn().getResponse().getContentAsString();

        //THEN
        final CategoryDTO categoryDTO = toObject(result, CategoryDTO.class);
        assertThat(categoryDTO).isNotNull();
        final Set<ErrorDTO> errors = categoryDTO.getErrors();
        assertThat(errors).isNotNull();
        assertThat(errors).containsOnly(ErrorHelper.getError(ErrorHelper.ErrorType.CATEGORY_ALREADY_EXISTS));
    }

    private Category createCategory(String categoryName) {
        Category category = new Category();
        category.setDescription("Test desc");
        category.setName(categoryName);
        return category;
    }

}