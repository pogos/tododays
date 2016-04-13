package pl.pogos.tododays.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.pogos.tododays.config.DatabaseConfiguration;
import pl.pogos.tododays.model.Category;

import javax.inject.Inject;

/**
 * Created by SG0952928 on 2016-04-13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DatabaseConfiguration.class})
@WebAppConfiguration
public class CategoryRepositoryTest {

    @Inject
    private CategoryRepository categoryRepository;

    @Test
    public void shouldSaveNewCategory() {
        Category category = new Category();
        category.setName("Category name");
        category.setDescription("Category description");
        categoryRepository.save(category);
    }

}