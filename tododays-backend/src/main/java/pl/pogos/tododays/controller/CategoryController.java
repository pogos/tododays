package pl.pogos.tododays.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pogos.tododays.dto.CategoryDTO;
import pl.pogos.tododays.dto.CategoryListDTO;
import pl.pogos.tododays.dto.ErrorDTO;
import pl.pogos.tododays.dto.PagingDTO;
import pl.pogos.tododays.model.Category;
import pl.pogos.tododays.repository.CategoryRepository;
import pl.pogos.tododays.service.ConverterService;
import pl.pogos.tododays.util.ErrorHelper;
import pl.pogos.tododays.util.ErrorHelper.ErrorType;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private ConverterService converterService;

    @RequestMapping(value = "/api/categories", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CategoryListDTO> getCategories(@RequestParam("offset") Integer offset,
                                                         @RequestParam("limit") Integer limit ) {
        final Page<Category> categories = categoryRepository.findAll(new PageRequest(offset, limit));
        CategoryListDTO categoryListDTO = new CategoryListDTO();
        categoryListDTO.fillResponseList(offset, limit, categories, converterService.convert(categories.getContent(), CategoryDTO.class));
        return new ResponseEntity<>(categoryListDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/category", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE}, consumes = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CategoryDTO> saveCategory(@RequestBody CategoryDTO category) {
        Optional<Category> optionalCategory = categoryRepository.findByName(category.getName());
        CategoryDTO cat;
        HttpStatus status;
        if (optionalCategory.isPresent()) {
            status = HttpStatus.CONFLICT;
            cat = new CategoryDTO(ErrorHelper.getError(ErrorType.CATEGORY_ALREADY_EXISTS));
        } else {
            cat = converterService.convert(
                    categoryRepository.save(
                            converterService.convert(category, Category.class)
                    ), CategoryDTO.class);
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(cat, status);
    }

    @RequestMapping(value = "/api/category/{name}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("name") String name) {
        Optional<Category> category = categoryRepository.findByName(name);
        CategoryDTO result = null;
        HttpStatus status;
        if (category.isPresent()) {
            result = converterService.convert(category.get(), CategoryDTO.class);
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(result, status);
    }


}
