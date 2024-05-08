package ch.etmles.payroll.Repositories;

import ch.etmles.payroll.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}