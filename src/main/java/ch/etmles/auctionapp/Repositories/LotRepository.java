package ch.etmles.auctionapp.Repositories;

import ch.etmles.auctionapp.Entities.Category;
import ch.etmles.auctionapp.Entities.Lot;
import ch.etmles.auctionapp.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LotRepository extends JpaRepository<Lot, Long> {
    List<Lot> findByCategory(Category category);
    List<Lot> findBySubCategory_Id(Long subCategoryId);
    List<Lot> findByUser(User user);
    Optional<Lot> findByArticleNumber(int articleNumber);
}
