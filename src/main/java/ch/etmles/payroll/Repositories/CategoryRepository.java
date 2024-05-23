//Dossier Repositories/Fichier CategoryRespository


package ch.etmles.payroll.Repositories;

import ch.etmles.payroll.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByParentCategoryId(Long parentId);
}