//Dossier Repositories / Fichier LotRepository

package ch.etmles.payroll.Repositories;

import ch.etmles.payroll.Entities.Category;
import ch.etmles.payroll.Entities.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LotRepository extends JpaRepository<Lot, Long>{
    List<Lot> findByCategory(Category category);
}
