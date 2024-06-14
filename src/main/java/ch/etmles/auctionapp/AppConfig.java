package ch.etmles.auctionapp;

import ch.etmles.auctionapp.Services.StateService;
import ch.etmles.auctionapp.Entities.Lot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class AppConfig {

    @Autowired
    private StateService stateService;

    @PostConstruct
    public void init() {
        Lot.setStateService(stateService);
    }
}
