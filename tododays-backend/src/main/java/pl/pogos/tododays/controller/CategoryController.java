package pl.pogos.tododays.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.pogos.tododays.model.Category;
import pl.pogos.tododays.repository.CategoryRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Sebastian on 20.03.2016.
 */
@RestController
public class CategoryController {

    @Inject
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/api/category", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @RequestMapping(value = "/api/category", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE}, consumes = { MediaType.APPLICATION_JSON_VALUE})
    public Category addCategory(Category category) {
        Category cat = categoryRepository.save(category);
        return cat;
    }

    public Category getCategory(String name) {
//        categoryRepository.
        return null;
    }
}
