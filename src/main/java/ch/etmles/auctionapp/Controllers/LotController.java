package ch.etmles.auctionapp.Controllers;

import ch.etmles.auctionapp.Entities.Category;
import ch.etmles.auctionapp.Entities.Lot;
import ch.etmles.auctionapp.Entities.State;
import ch.etmles.auctionapp.Entities.User;
import ch.etmles.auctionapp.Repositories.CategoryRepository;
import ch.etmles.auctionapp.Repositories.LotRepository;
import ch.etmles.auctionapp.Repositories.StateRepository;
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
    private final StateRepository stateRepository;

    LotController(LotRepository repository, CategoryRepository categoryRepository, UserRepository userRepository, StateRepository stateRepository){
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.stateRepository = stateRepository;
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
                        return ResponseEntity.ok("Auction Successful");
                    } else {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Your bid price must be higher than the current price");
                    }
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lot not found"));
    }

    @GetMapping("/lots/seller/{userId}")
    public ResponseEntity<List<Lot>> getBySeller(@PathVariable Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    List<Lot> lots = repository.findByUser(user);
                    return new ResponseEntity<>(lots, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/lots/{articleNumber}/endbit")
    public ResponseEntity<String> cloturerLot(@PathVariable int articleNumber) {
        return repository.findByArticleNumber(articleNumber)
                .map(lot -> {
                    State stateTermine = stateRepository.findByStateName("Terminé")
                            .orElseThrow(() -> new RuntimeException("State 'Finish' not found"));
                    lot.setState(stateTermine);
                    repository.save(lot);
                    return ResponseEntity.ok("Lot successfully closed");
                })
                .orElseGet(() -> {
                    System.out.println("Lot not found for item number : " + articleNumber);
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lot not found");
                });
    }
}
