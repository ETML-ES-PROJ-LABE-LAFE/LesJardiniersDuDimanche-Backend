package ch.etmles.auctionapp.Services;

import ch.etmles.auctionapp.Entities.State;
import ch.etmles.auctionapp.Repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public State getStateEnCours() {
        return stateRepository.findByStateName("En Cours")
                .orElseThrow(() -> new RuntimeException("State 'En Cours' not found"));
    }
}
