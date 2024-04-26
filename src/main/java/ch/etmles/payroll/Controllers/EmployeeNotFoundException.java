package ch.etmles.payroll.Controllers;

public class EmployeeNotFoundException extends RuntimeException{

    EmployeeNotFoundException(Long id){
        super("Could not find employee " + id);
    }
}
