package ch.etmles.payroll.Repositories;

import ch.etmles.payroll.Entities.Lot;
import ch.etmles.payroll.Entities.Category;
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
    CommandLineRunner initDatabase(LotRepository repository, CategoryRepository categoryRepository) {
        return args -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            try {

                // Créer et sauvegarder des catégories
                Category mainCategory1 = categoryRepository.save(new Category("Electronique", null));
                Category subCategory1 = categoryRepository.save(new Category("Ordinateur", mainCategory1));
                Category mainCategory2 = categoryRepository.save(new Category("Jardinerie", null));
                Category subCategory2 = categoryRepository.save(new Category("Tondeuse", mainCategory2));

                //Créer et sauvegarder des lots
                Lot lot1 = new Lot("PC HP", "PC HP très très rapide", 1000.00, sdf.parse("2023-01-01T09:00:00"), sdf.parse("2023-01-01T21:00:00"), subCategory1);
                Lot lot2 = new Lot("Tondeuse", "Tondeuse qui tondeuse bien", 1500.00, sdf.parse("2023-01-02T09:00:00"), sdf.parse("2023-01-02T21:00:00"),subCategory2);

                log.info("Preloading " + repository.save(lot1));
                log.info("Preloading " + repository.save(lot2));
            } catch (Exception e) {
                log.error("Error initializing database", e);
            }
        };
    }
}
