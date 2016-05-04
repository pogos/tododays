package pl.pogos.tododays.data;

import org.springframework.stereotype.Component;
import pl.pogos.tododays.model.Category;
import pl.pogos.tododays.repository.CategoryRepository;

import javax.inject.Inject;

@Component
public class CategoryDataLoader implements DataLoader{

    public static final String [] CATEGORY_NAMES = {"Test", "Test 1", "Test 2"};

    @Inject
    private CategoryRepository categoryRepository;

    @Override
    public void loadData() {
        for (String name :  CATEGORY_NAMES) {
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
}
