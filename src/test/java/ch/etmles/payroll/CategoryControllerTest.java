package ch.etmles.payroll;

import ch.etmles.payroll.Controllers.CategoryController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ch.etmles.payroll.Entities.Category;
import ch.etmles.payroll.Repositories.CategoryRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryControllerTest {

    // Suppose que ceci est un stub ou une implémentation concrète
    private CategoryRepository categoryRepository;
    private CategoryController categoryController;

    @BeforeEach
    public void setUp() {
        categoryRepository = new CategoryRepository();
        categoryController = new CategoryController(categoryRepository);
    }

    @Test
    public void getAllCategories_whenCategoriesExist_thenCategoriesReturned() {
        // Given
        List<Category> expectedCategories = Arrays.asList(new Category("Electronics", null));
        categoryRepository.saveAll(expectedCategories);

        // When
        List<Category> result = categoryController.getAllCategories();

        // Then
        assertNotNull(result);
        assertEquals(expectedCategories.size(), result.size());
        assertEquals("Electronics", result.get(0).getName());
    }

    @Test
    public void addCategory_whenValidCategory_thenCategorySaved() {
        // Given
        Category newCategory = new Category("Books", null);

        // When
        Category result = categoryController.addCategory(newCategory);

        // Then
        assertNotNull(result);
        assertEquals("Books", result.getName());
    }

    @Test
    public void getCategoryById_whenCategoryExists_thenCategoryReturned() {
        // Given
        Long categoryId = 1L;
        Category expectedCategory = new Category("Music", null);
        categoryRepository.save(expectedCategory);

        // When
        Category result = categoryController.getCategoryById(categoryId);

        // Then
        assertNotNull(result);
        assertEquals("Music", result.getName());
    }

    @Test
    public void updateCategory_whenCategoryExists_thenUpdatedCategoryReturned() {
        // Given
        Long categoryId = 1L;
        Category existingCategory = new Category("OldName", null);
        Category newCategory = new Category("NewName", null);
        categoryRepository.save(existingCategory);

        // When
        Category result = categoryController.updateCategory(newCategory, categoryId);

        // Then
        assertNotNull(result);
        assertEquals("NewName", result.getName());
    }

    @Test
    public void deleteCategory_whenCategoryExists_thenCategoryDeleted() {
        // Given
        Long categoryId = 1L;
        Category category = new Category("ToBeDeleted", null);
        categoryRepository.save(category);

        // When
        categoryController.deleteCategory(categoryId);

        // Then
        assertFalse(categoryRepository.existsById(categoryId));
    }
}
