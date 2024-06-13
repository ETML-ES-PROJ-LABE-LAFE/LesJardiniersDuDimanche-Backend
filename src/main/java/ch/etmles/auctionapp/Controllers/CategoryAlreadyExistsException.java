package ch.etmles.auctionapp.Controllers;

public class
CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
}
