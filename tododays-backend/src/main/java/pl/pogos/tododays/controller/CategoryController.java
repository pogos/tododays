package pl.pogos.tododays.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pogos.tododays.model.Category;
import pl.pogos.tododays.repository.CategoryRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category cat = categoryRepository.save(category);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/category/{name}", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE}, consumes = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Category> getCategory(@PathVariable String name) {
        Optional<Category> category = categoryRepository.findByName(name);

        return null;
    }


}
