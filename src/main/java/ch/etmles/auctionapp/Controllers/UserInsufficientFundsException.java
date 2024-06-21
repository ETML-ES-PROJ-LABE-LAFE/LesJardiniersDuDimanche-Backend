package ch.etmles.auctionapp.Controllers;

import java.math.BigDecimal;

public class UserInsufficientFundsException extends RuntimeException {

    public UserInsufficientFundsException(Long userId, BigDecimal amount) {
        super("User with ID " + userId + " has insufficient funds to deduct " + amount + " CHF.");
    }
}
