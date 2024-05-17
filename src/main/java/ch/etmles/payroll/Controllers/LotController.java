package ch.etmles.payroll.Controllers;

import ch.etmles.payroll.Entities.Category;
import ch.etmles.payroll.Entities.Lot;
import ch.etmles.payroll.Repositories.CategoryRepository;
import ch.etmles.payroll.Repositories.LotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO Documentation must be updated (employee !!!!)

@RestController
//TODO Crossorigin is hard coded in each controller
//@CrossOrigin(origins = "http://localhost:8081")

public class LotController {

    private final LotRepository repository;
    private final CategoryRepository categoryRepository;

    LotController(LotRepository repository, CategoryRepository categoryRepository){
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/lots")
    List<Lot> all(){
        System.out.println("Test");
        return repository.findAll();
    }

    @PostMapping("/lots")
    Lot newLot(@RequestBody Lot newLot){
        return repository.save(newLot);
    }

    @GetMapping("/lots/{id}")
    Lot one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new LotNotFoundException(id));
    }

    @PutMapping("/lots/{id}")
    Lot replaceLot(@RequestBody Lot newLot, @PathVariable Long id) {
        return repository.findById(id)
                .map(lot -> {
                    lot.setName(newLot.getName());
                    lot.setDescription(newLot.getDescription());
                    return repository.save(lot);
                })
                .orElseGet(() -> {
                    newLot.setId(id);
                    return repository.save(newLot);
                });
    }

    @DeleteMapping("/lots/{id}")
    void deleteLot(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/lots/category/{categoryId}")
    public List<Lot> getByCategory(@PathVariable Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        return repository.findByCategory(category);
    }

    @GetMapping("/lots/subcategory/{subCategoryId}")
    public List<Lot> getBySubCategory(@PathVariable Long subCategoryId) {
        return repository.findBySubCategory_Id(subCategoryId);
    }


}
