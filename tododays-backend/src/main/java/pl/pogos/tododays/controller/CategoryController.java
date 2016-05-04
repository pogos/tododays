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

@RestController
public class CategoryController {

    @Inject
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/api/categories", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/category", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE}, consumes = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Optional<Category> optionalCategory = categoryRepository.findByName(category.getName());
        Category cat = null;
        HttpStatus status;
        if (optionalCategory.isPresent()) {
            status = HttpStatus.CONFLICT;
        } else {
            cat = categoryRepository.save(category);
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(cat, status);
    }

    @RequestMapping(value = "/api/category/{name}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Category> getCategory(@PathVariable("name") String name) {
        Optional<Category> category = categoryRepository.findByName(name);
        Category result = null;
        HttpStatus status;
        if (category.isPresent()) {
            result = category.get();
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(result, status);
    }


}
