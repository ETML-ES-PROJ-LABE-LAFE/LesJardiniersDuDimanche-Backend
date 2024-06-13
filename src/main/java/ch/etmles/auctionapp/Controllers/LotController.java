package ch.etmles.auctionapp.Controllers;

import ch.etmles.auctionapp.Entities.Category;
import ch.etmles.auctionapp.Entities.Lot;
import ch.etmles.auctionapp.Entities.User;
import ch.etmles.auctionapp.Repositories.CategoryRepository;
import ch.etmles.auctionapp.Repositories.LotRepository;
import ch.etmles.auctionapp.Repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LotController {

    private final LotRepository repository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    LotController(LotRepository repository, CategoryRepository categoryRepository, UserRepository userRepository){
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
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

    @GetMapping("/lots/{articleNumber}")
    Lot one(@PathVariable int articleNumber){
        return repository.findByArticleNumber(articleNumber)
                .orElseThrow(() -> new LotNotFoundException(articleNumber));
    }

    @PutMapping("/lots/{articleNumber}")
    Lot replaceLot(@RequestBody Lot newLot, @PathVariable int articleNumber) {
        return repository.findByArticleNumber(articleNumber)
                .map(lot -> {
                    lot.setName(newLot.getName());
                    lot.setDescription(newLot.getDescription());
                    lot.setActualPrice(newLot.getActualPrice());
                    return repository.save(lot);
                })
                .orElseGet(() -> {
                    newLot.setArticleNumber(articleNumber);
                    return repository.save(newLot);
                });
    }

    @DeleteMapping("/lots/{articleNumber}")
    void deleteLot(@PathVariable int articleNumber){
        Lot lot = repository.findByArticleNumber(articleNumber)
                .orElseThrow(() -> new LotNotFoundException(articleNumber));
        repository.delete(lot);
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

    @PutMapping("/lots/{articleNumber}/bid")
    public ResponseEntity<String> placeBid(@PathVariable int articleNumber, @RequestBody Double bidAmount) {
        return repository.findByArticleNumber(articleNumber)
                .map(lot -> {
                    if (bidAmount > lot.getActualPrice()) {
                        lot.setActualPrice(bidAmount);
                        repository.save(lot);
                        return ResponseEntity.ok("Enchère effectuée avec succès");
                    } else {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le prix de votre enchère doit être plus élevé que le prix actuel");
                    }
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lot non trouvé"));
    }

    @GetMapping("/lots/seller/{userId}")
    public ResponseEntity<List<Lot>> getBySeller(@PathVariable Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    List<Lot> lots = repository.findByUser(user);
                    System.out.println("Lots for user " + user.getName() + ": " + lots);
                    return new ResponseEntity<>(lots, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
