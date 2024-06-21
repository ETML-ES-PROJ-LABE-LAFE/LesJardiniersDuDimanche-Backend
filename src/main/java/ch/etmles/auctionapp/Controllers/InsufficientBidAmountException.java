package ch.etmles.auctionapp.Controllers;


public class InsufficientBidAmountException extends RuntimeException {
    public InsufficientBidAmountException(String message) {
        super(message);
    }
}
