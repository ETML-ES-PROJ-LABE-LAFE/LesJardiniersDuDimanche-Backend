package ch.etmles.payroll.Repositories;

import ch.etmles.payroll.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
