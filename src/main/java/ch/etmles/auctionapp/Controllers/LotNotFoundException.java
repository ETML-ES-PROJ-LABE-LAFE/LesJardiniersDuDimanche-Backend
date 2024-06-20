package ch.etmles.auctionapp.Controllers;

public class LotNotFoundException extends RuntimeException{

    LotNotFoundException(int articlenumber){
        super("No lot found" + articlenumber);
    }
}
