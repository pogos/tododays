package pl.pogos.tododays.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pogos.tododays.dto.CategoryDTO;
import pl.pogos.tododays.dto.CategoryListDTO;
import pl.pogos.tododays.dto.PagingDTO;
import pl.pogos.tododays.model.Category;
import pl.pogos.tododays.repository.CategoryRepository;
import pl.pogos.tododays.service.ConverterService;

import javax.inject.Inject;
import java.util.Optional;

@RestController
public class CategoryController {

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private ConverterService converterService;

    @RequestMapping(value = "/api/categories/{page}/{size}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CategoryListDTO> getCategories(@PathVariable("page") Integer page, @PathVariable("size") Integer size ) {

        Pageable pageable = new PageRequest(page, size);
        final Page<Category> categories = categoryRepository.findAll(pageable);
        CategoryListDTO categoryListDTO = getCategoryListResponse(page, size, categories);
        return new ResponseEntity<>(categoryListDTO, HttpStatus.OK);
    }

    private CategoryListDTO getCategoryListResponse(Integer page, Integer size, Page<Category> categories) {
        CategoryListDTO categoryListDTO = new CategoryListDTO();
        categoryListDTO.setData(converterService.convert(categories.getContent(), CategoryDTO.class));
        categoryListDTO.setPaging(new PagingDTO(page, size, categories.getTotalPages(), categories.getTotalElements()));
        categoryListDTO.getPaging().setPageSize(size);
        categoryListDTO.getPaging().setPage(page);
        categoryListDTO.getPaging().setPageNumber(categories.getTotalPages());
        categoryListDTO.getPaging().setRecordNumber(categories.getTotalElements());
        return categoryListDTO;
    }

    @RequestMapping(value = "/api/category", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE}, consumes = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CategoryDTO> saveCategory(@RequestBody CategoryDTO category) {
        Optional<Category> optionalCategory = categoryRepository.findByName(category.getName());
        CategoryDTO cat = null;
        HttpStatus status;
        if (optionalCategory.isPresent()) {
            status = HttpStatus.CONFLICT;
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
