package ch.etmles.payroll.Controllers;

public class CategoryNotFoundException extends RuntimeException{

    CategoryNotFoundException(Long id){
        super("Could not find this category " + id);
    }
}