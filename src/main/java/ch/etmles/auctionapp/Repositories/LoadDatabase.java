package ch.etmles.auctionapp.Repositories;

import ch.etmles.auctionapp.Entities.Lot;
import ch.etmles.auctionapp.Entities.Category;
import ch.etmles.auctionapp.Entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(LotRepository repository, CategoryRepository categoryRepository, UserRepository userRepository) {
        return args -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            try {

                // Créer et sauvegarder des catégories
                Category mainCategory1 = categoryRepository.save(new Category("Informatique", null));
                Category subCategory1 = categoryRepository.save(new Category("Ordinateur", mainCategory1));

                Category mainCategory2 = categoryRepository.save(new Category("Jardinerie", null));
                Category subCategory2 = categoryRepository.save(new Category("Tondeuse", mainCategory2));

                Category mainCategory3 = categoryRepository.save(new Category("Vêtements", null));
                Category subCategory3 = categoryRepository.save(new Category("Chaussures", mainCategory3));

                Category mainCategory4 = categoryRepository.save(new Category("Cuisine", null));
                Category subCategory4 = categoryRepository.save(new Category("Électroménager", mainCategory4));

                Category mainCategory5 = categoryRepository.save(new Category("Maison", null));
                Category subCategory6 = categoryRepository.save(new Category("Plantes", mainCategory2));


                //Créer et sauvegarder des lots
                Lot lot1 = new Lot("PC HP", "PC HP très très rapide", 1000.00,1001.00, sdf.parse("2023-01-01T09:00:00"), sdf.parse("2023-01-01T21:00:00"),mainCategory1, subCategory1);
                Lot lot2 = new Lot("Tondeuse", "Tondeuse qui tondeuse bien", 1500.00, 1501.00,sdf.parse("2023-01-02T09:00:00"), sdf.parse("2023-01-02T21:00:00"),mainCategory2,subCategory2 );
                Lot lot3 = new Lot("Nike", "Chaussures qui courent vite", 400.00, 401.00, sdf.parse("2023-02-04T15:00:00"),sdf.parse("2023-04-05T21:00:00"), mainCategory3, subCategory3 );
                Lot lot4 = new Lot("Four Râleur", "Ce four intelligent critique vos recettes et votre technique de cuisson. Parfait pour ceux qui veulent améliorer rapidement leurs compétences en cuisine", 480.00, 481.00, sdf.parse("2023-02-04T15:00:00"),sdf.parse("2023-04-05T21:00:00"), mainCategory4, subCategory4 );
                Lot lot5 = new Lot("Aspirateur Susceptible", "Cet aspirateur ne se contente pas de nettoyer; il se plaint si la pièce est trop sale", 670.00,671.00, sdf.parse("2023-02-04T15:00:00"),sdf.parse("2023-04-05T21:00:00"), mainCategory5, subCategory4 );
                Lot lot6 = new Lot("Plante ", "Cette plante émet un léger grognement lorsque vous oubliez de l'arroser. Parfaite pour ceux qui ont besoin d'un rappel vivant!", 480.00,481.00, sdf.parse("2023-02-04T15:00:00"),sdf.parse("2023-04-05T21:00:00"), mainCategory2, subCategory6 );

                log.info("Preloading " + repository.save(lot1));
                log.info("Preloading " + repository.save(lot2));
                log.info("Preloading " + repository.save(lot3));
                log.info("Preloading " + repository.save(lot4));
                log.info("Preloading " + repository.save(lot5));
                log.info("Preloading " + repository.save(lot6));

                // Créer et sauvegarder des utilisateurs
                User user1 = new User("Evan Pineau", "john.doe@example.com", new BigDecimal("100.00"));
                User user2 = new User("Max Verstappen", "max.verstappen@example.com", new BigDecimal("150.00"));

                log.info("Preloading " + userRepository.save(user1));
                log.info("Preloading " + userRepository.save(user2));

            } catch (Exception e) {
                log.error("Error initializing database", e);
            }
        };
    }
}
