package ch.etmles.payroll.Controllers;

import ch.etmles.payroll.Entities.Category;
import ch.etmles.payroll.Entities.Lot;
import ch.etmles.payroll.Repositories.CategoryRepository;
import ch.etmles.payroll.Repositories.LotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081") // Allow requests from frontend URL

public class LotController {

    private final LotRepository repository;
    private final CategoryRepository categoryRepository;

    LotController(LotRepository repository, CategoryRepository categoryRepository){
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    /* curl sample :
    curl -i localhost:8080/employees
    */

    @GetMapping("/lots")
    List<Lot> all(){
        System.out.println("Test");
        return repository.findAll();
    }

    /* curl sample :
    curl -i -X POST localhost:8080/employees ^
        -H "Content-type:application/json" ^
        -d "{\"name\": \"Russel George\", \"role\": \"gardener\"}"
    */
    @PostMapping("/lots")
    Lot newLot(@RequestBody Lot newLot){
        return repository.save(newLot);
    }

    /* curl sample :
    curl -i localhost:8080/employees/1
    */
    @GetMapping("/lots/{id}")
    Lot one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new LotNotFoundException(id));
    }

    /* curl sample :
    curl -i -X PUT localhost:8080/employees/2 ^
        -H "Content-type:application/json" ^
        -d "{\"name\": \"Samwise Bing\", \"role\": \"peer-to-peer\"}"
     */
    @PutMapping("/lots/{id}")
    Lot replaceLot(@RequestBody Lot newLot, @PathVariable Long id) {
        return repository.findById(id)
                .map(lot -> {
                    lot.setNom(newLot.getNom());
                    lot.setDescription(newLot.getDescription());
                    return repository.save(lot);
                })
                .orElseGet(() -> {
                    newLot.setId(id);
                    return repository.save(newLot);
                });
    }

    /* curl sample :
    curl -i -X DELETE localhost:8080/employees/2
    */
    @DeleteMapping("/lots/{id}")
    void deleteLot(@PathVariable Long id){
        repository.deleteById(id);
    }

     // Nouvelle route pour obtenir les lots par catégorie
    @GetMapping("/lots/category/{categoryId}")
    public List<Lot> getByCategory(@PathVariable Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        return repository.findByCategory(category);
    }

}
