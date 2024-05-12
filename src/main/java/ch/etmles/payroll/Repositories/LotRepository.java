//Dossier Repositories / Fichier LotRepository

package ch.etmles.payroll.Repositories;

import ch.etmles.payroll.Entities.Category;
import ch.etmles.payroll.Entities.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LotRepository extends JpaRepository<Lot, Long>{
    List<Lot> findByCategory(Category category);
    List<Lot> findBySouscategory_Id(Long subCategoryId);


}
