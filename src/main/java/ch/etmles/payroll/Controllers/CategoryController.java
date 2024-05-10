//Dossier Controllers/CategoryController

package ch.etmles.payroll.Controllers;

import ch.etmles.payroll.Entities.Category;
import ch.etmles.payroll.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:8081") // Allow requests from frontend URL
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

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return repository.save(category);
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

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        repository.deleteById(id);
    }
}