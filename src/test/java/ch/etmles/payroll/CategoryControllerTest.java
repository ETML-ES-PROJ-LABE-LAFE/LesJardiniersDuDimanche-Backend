/*package ch.etmles.payroll.Controllers;

import ch.etmles.payroll.Repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ch.etmles.payroll.Entities.Category;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryControllerTest {

    private CategoryRepository categoryRepository;
    private CategoryController categoryController;

    @BeforeEach
    public void setUp() {
        categoryRepository = new CategoryRepository();
        categoryController = new CategoryController(categoryRepository);
    }

    @Test
    public void getAllCategories_ShouldReturnAllCategories() {
        // Given
        List<Category> storedCategories = List.of(new Category("Electronics", null));
        categoryRepository.saveAll(storedCategories);

        // When
        List<Category> fetchedCategories = categoryController.getAllCategories();

        // Then
        assertNotNull(fetchedCategories);
        assertEquals(storedCategories.size(), fetchedCategories.size());
    }

    @Test
    public void addCategory_ShouldAddCategory() {
        // Given
        Category category = new Category("Books", null);

        // When
        Category savedCategory = categoryController.addCategory(category);

        // Then
        assertNotNull(savedCategory);
        assertEquals("Books", savedCategory.getName());
    }

    @Test
    public void getCategoryById_ShouldReturnCategory() {
        // Given
        Category category = new Category("Music", null);
        categoryRepository.save(category);

        // When
        Category fetchedCategory = categoryController.getCategoryById(category.getId());

        // Then
        assertNotNull(fetchedCategory);
        assertEquals("Music", fetchedCategory.getName());
    }

    @Test
    public void updateCategory_ShouldUpdateCategory() {
        // Given
        Category originalCategory = new Category("Old Category", null);
        categoryRepository.save(originalCategory);
        Category updatedCategory = new Category("Updated Category", null);

        // When
        Category result = categoryController.updateCategory(updatedCategory, originalCategory.getId());

        // Then
        assertNotNull(result);
        assertEquals("Updated Category", result.getName());
    }

    @Test
    public void deleteCategory_ShouldDeleteCategory() {
        // Given
        Category category = new Category("To be deleted", null);
        categoryRepository.save(category);

        // When
        categoryController.deleteCategory(category.getId());

        // Then
        assertFalse(categoryRepository.existsById(category.getId()));
    }
}
*/