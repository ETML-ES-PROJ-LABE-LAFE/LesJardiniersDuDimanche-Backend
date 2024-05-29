package ch.etmles.auctionapp.Controllers;

public class LotNotFoundException extends RuntimeException{

    LotNotFoundException(Long id){
        super("Pas de lot trouvé" + id);
    }
}
