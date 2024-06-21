package ch.etmles.auctionapp.Controllers;

public class CategoryNotFoundException extends RuntimeException{

    CategoryNotFoundException(Long id){
        super("Could not find this category " + id);
    }
}