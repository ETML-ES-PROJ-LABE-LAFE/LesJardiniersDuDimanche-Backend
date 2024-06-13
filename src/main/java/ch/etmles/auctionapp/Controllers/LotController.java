package ch.etmles.auctionapp.Controllers;

import ch.etmles.auctionapp.Entities.Category;
import ch.etmles.auctionapp.Entities.Lot;
import ch.etmles.auctionapp.Repositories.CategoryRepository;
import ch.etmles.auctionapp.Repositories.LotRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO Documentation must be updated (employee !!!!) -> do not forget to do this in the pom.xml too.

@RestController
public class LotController {

    private final LotRepository repository;
    private final CategoryRepository categoryRepository;

    LotController(LotRepository repository, CategoryRepository categoryRepository){
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/lots")
    List<Lot> all(){
        //TODO remove this ! The console.log
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
                    lot.setActualPrice(newLot.getActualPrice());
                    return repository.save(lot);
                })
                .orElseGet(() -> {
                    newLot.setId(id);
                    return repository.save(newLot);
                });
    }

    //TODO add exception if lot doesn't exist

    @DeleteMapping("/lots/{id}")
    public ResponseEntity<Void> deleteLot(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new LotNotFoundException(id);
        }
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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

    @PutMapping("/lots/{id}/bid")
    public ResponseEntity<String> placeBid(@PathVariable Long id, @RequestBody Double bidAmount) {
        return repository.findById(id)
                .map(lot -> {
                    if (bidAmount > lot.getActualPrice()) {
                        lot.setActualPrice(bidAmount);
                        repository.save(lot);
                        return ResponseEntity.ok("Enchère effectuée avec succès");
                    } else {
                        throw new InsufficientBidAmountException("Le prix de votre enchère doit être plus élevé que le prix actuel");
                    }
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lot non trouvé"));
    }




}
