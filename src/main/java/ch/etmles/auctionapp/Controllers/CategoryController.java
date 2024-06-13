package ch.etmles.auctionapp.Controllers;

import ch.etmles.auctionapp.Entities.Category;
import ch.etmles.auctionapp.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
//@CrossOrigin(origins = "http://localhost:8081") //TODO this annotation must be removed
public class CategoryController {

    private final CategoryRepository repository;

    @Autowired
    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @GetMapping("/subcategories/{parentId}")
    public List<Category> getSubCategoriesByParentId(@PathVariable Long parentId) {
        return repository.findByParentCategoryId(parentId);
    }


    //TODO add exception if category already exists (using the unique constraint)
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        if (repository.existsByName(category.getName())) {
            throw new CategoryAlreadyExistsException("Category already exists");
        }
        Category savedCategory = repository.save(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category newCategory, @PathVariable Long id) {
        return repository.findById(id)
                .map(category -> {
                    category.setName(newCategory.getName());
                    category.setParentCategory(newCategory.getParentCategory());
                    return repository.save(category);
                })
                .orElseGet(() -> {
                    newCategory.setId(id);
                    return repository.save(newCategory);
                });
    }

    //TODO add exception if category doesn't exist
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new CategoryNotFoundException(id);
        }
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<String> handleCategoryAlreadyExists(CategoryAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFound(CategoryNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}