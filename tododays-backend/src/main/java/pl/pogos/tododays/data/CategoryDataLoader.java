package pl.pogos.tododays.data;

import org.springframework.stereotype.Component;
import pl.pogos.tododays.model.Category;
import pl.pogos.tododays.repository.CategoryRepository;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class CategoryDataLoader implements DataLoader{

    private final List<String> categoryNames = Arrays.asList("Test", "Test 1", "Test 2");

    @Inject
    private CategoryRepository categoryRepository;

    @Override
    public void loadData() {
        for (String name : categoryNames) {
            categoryRepository.save(createCategory(name));
        }
    }

    private Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(name + " desc");
        category.setReadOnly(true);
        return category;
    }

    public List<String> getCategoryNames() {
        return categoryNames;
    }
}
