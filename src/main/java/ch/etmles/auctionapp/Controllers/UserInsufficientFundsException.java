package ch.etmles.auctionapp.Controllers;

import java.math.BigDecimal;

public class UserInsufficientFundsException extends RuntimeException {

    public UserInsufficientFundsException(Long userId, BigDecimal amount) {
        super("L'utilisateur avec ID " + userId + " n'a pas suffisamment de fonds pour déduire " + amount + " CHF.");
    }
}
