package pl.pogos.tododays.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pogos.tododays.model.Category;
import pl.pogos.tododays.repository.CategoryRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Sebastian on 16.03.2016.
 */
@RestController
public class HelloWorld {

    @Inject
    private CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String home() {
        List<Category> categories = categoryRepository.findAll();
        StringBuilder sb = new StringBuilder("Hello world!!\n");
        for (Category category : categories) {
            sb.append(category.getName()).append("\n");
        }
        return sb.toString();
    }
}
