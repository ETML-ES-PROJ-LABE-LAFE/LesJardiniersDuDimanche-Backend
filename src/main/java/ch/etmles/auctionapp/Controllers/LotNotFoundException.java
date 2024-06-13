package ch.etmles.auctionapp.Controllers;

public class LotNotFoundException extends RuntimeException{

    LotNotFoundException(int articlenumber){
        super("Pas de lot trouvé" + articlenumber);
    }
}
