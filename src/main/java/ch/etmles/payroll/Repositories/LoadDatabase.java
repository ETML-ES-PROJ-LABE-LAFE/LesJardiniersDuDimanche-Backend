package ch.etmles.payroll.Repositories;

import ch.etmles.payroll.Entities.Lot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(LotRepository repository) {
        return args -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            try {
                Lot lot1 = new Lot("Bilbo Baggins", "burglar", 1000.00, sdf.parse("2023-01-01T09:00:00"), sdf.parse("2023-01-01T21:00:00"));
                Lot lot2 = new Lot("Frodo Baggins", "thief", 1500.00, sdf.parse("2023-01-02T09:00:00"), sdf.parse("2023-01-02T21:00:00"));

                log.info("Preloading " + repository.save(lot1));
                log.info("Preloading " + repository.save(lot2));
            } catch (Exception e) {
                log.error("Error initializing database", e);
            }
        };
    }
}
