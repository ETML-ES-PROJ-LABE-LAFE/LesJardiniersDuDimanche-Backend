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
import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(LotRepository repository, CategoryRepository categoryRepository, UserRepository userRepository) {
        return args -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            try {

                // Créer et sauvegarder des utilisateurs
                User user1 = new User("Evan Pineau", "john.doe@example.com", new BigDecimal("100.00"));
                User user2 = new User("Max Verstappen", "max.verstappen@example.com", new BigDecimal("150.00"));

                log.info("Preloading " + userRepository.save(user1));
                log.info("Preloading " + userRepository.save(user2));

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
                Category subCategory5 = categoryRepository.save(new Category("Décoration", mainCategory5));

                Category mainCategory6 = categoryRepository.save(new Category("Électronique", null));
                Category subCategory6 = categoryRepository.save(new Category("Télévision", mainCategory6));


                // Créer et sauvegarder des lots
                Lot lot1 = new Lot("PC HP", "PC HP très très rapide", 1000.00, 1100.00, sdf.parse("2023-01-01T09:00:00"), sdf.parse("2023-01-01T21:00:00"), mainCategory1, subCategory1, user1);
                Lot lot2 = new Lot("Tondeuse", "Tondeuse qui tond bien", 1500.00, 1600.00, sdf.parse("2023-01-02T09:00:00"), sdf.parse("2023-01-02T21:00:00"), mainCategory2, subCategory2, user1);
                Lot lot3 = new Lot("Chaussures Nike", "Chaussures qui courent vite", 400.00, 450.00, sdf.parse("2023-02-04T15:00:00"), sdf.parse("2023-04-05T21:00:00"), mainCategory3, subCategory3, user1);
                Lot lot4 = new Lot("Four intelligent", "Four qui critique vos recettes", 480.00, 530.00, sdf.parse("2023-02-04T15:00:00"), sdf.parse("2023-04-05T21:00:00"), mainCategory4, subCategory4, user1);
                Lot lot5 = new Lot("Aspirateur automatique", "Aspirateur intelligent", 670.00, 720.00, sdf.parse("2023-02-04T15:00:00"), sdf.parse("2023-04-05T21:00:00"), mainCategory5, subCategory5, user1);
                Lot lot6 = new Lot("Télévision 4K", "Télévision ultra haute définition", 800.00, 900.00, sdf.parse("2023-02-05T10:00:00"), sdf.parse("2023-05-05T22:00:00"), mainCategory6, subCategory6, user1);
                Lot lot7 = new Lot("Imprimante 3D", "Imprimante 3D de haute précision", 1200.00, 1300.00, sdf.parse("2023-01-15T09:00:00"), sdf.parse("2023-02-15T21:00:00"), mainCategory1, subCategory1, user2);
                Lot lot8 = new Lot("Robot de jardin", "Robot qui entretient le jardin", 2000.00, 2100.00, sdf.parse("2023-03-10T09:00:00"), sdf.parse("2023-04-10T21:00:00"), mainCategory2, subCategory2, user2);
                Lot lot9 = new Lot("Veste en cuir", "Veste élégante et durable", 500.00, 550.00, sdf.parse("2023-03-20T09:00:00"), sdf.parse("2023-04-20T21:00:00"), mainCategory3, subCategory3, user2);
                Lot lot10 = new Lot("Mixeur haute puissance", "Mixeur pour des smoothies parfaits", 150.00, 200.00, sdf.parse("2023-02-25T09:00:00"), sdf.parse("2023-03-25T21:00:00"), mainCategory4, subCategory4, user2);
                Lot lot11 = new Lot("Canapé en cuir", "Canapé confortable et élégant", 700.00, 800.00, sdf.parse("2023-01-25T09:00:00"), sdf.parse("2023-02-25T21:00:00"), mainCategory5, subCategory5, user2);
                Lot lot12 = new Lot("Smartphone dernier modèle", "Smartphone avec écran OLED", 1000.00, 1100.00, sdf.parse("2023-02-15T09:00:00"), sdf.parse("2023-03-15T21:00:00"), mainCategory6, subCategory6, user2);
                Lot lot13 = new Lot("MacBook Pro", "Ordinateur portable performant", 2500.00, 2600.00, sdf.parse("2023-04-01T09:00:00"), sdf.parse("2023-04-30T21:00:00"), mainCategory1, subCategory1, user1);
                Lot lot14 = new Lot("Tondeuse robotisée", "Tondeuse qui travaille toute seule", 1800.00, 1900.00, sdf.parse("2023-05-01T09:00:00"), sdf.parse("2023-05-31T21:00:00"), mainCategory2, subCategory2, user1);
                Lot lot15 = new Lot("Bottes de randonnée", "Bottes pour terrains difficiles", 200.00, 250.00, sdf.parse("2023-06-01T09:00:00"), sdf.parse("2023-06-30T21:00:00"), mainCategory3, subCategory3, user1);
                Lot lot16 = new Lot("Robot cuiseur", "Robot pour préparer des plats rapidement", 350.00, 400.00, sdf.parse("2023-07-01T09:00:00"), sdf.parse("2023-07-31T21:00:00"), mainCategory4, subCategory4, user1);
                Lot lot17 = new Lot("Table basse en bois", "Table basse pour le salon", 150.00, 200.00, sdf.parse("2023-08-01T09:00:00"), sdf.parse("2023-08-31T21:00:00"), mainCategory5, subCategory5, user1);
                Lot lot18 = new Lot("Caméra de surveillance", "Caméra avec vision nocturne", 300.00, 350.00, sdf.parse("2023-09-01T09:00:00"), sdf.parse("2023-09-30T21:00:00"), mainCategory6, subCategory6, user1);
                Lot lot19 = new Lot("Ordinateur gaming", "PC pour jeux vidéo haute performance", 1500.00, 1600.00, sdf.parse("2023-10-01T09:00:00"), sdf.parse("2023-10-31T21:00:00"), mainCategory1, subCategory1, user2);
                Lot lot20 = new Lot("Tracteur tondeuse", "Tracteur pour grand jardin", 2500.00, 2600.00, sdf.parse("2023-11-01T09:00:00"), sdf.parse("2023-11-30T21:00:00"), mainCategory2, subCategory2, user2);
                Lot lot21 = new Lot("Montre connectée", "Montre avec suivi d'activité", 300.00, 350.00, sdf.parse("2023-12-01T09:00:00"), sdf.parse("2023-12-31T21:00:00"), mainCategory3, subCategory3, user2);
                Lot lot22 = new Lot("Grille-pain intelligent", "Grille-pain avec commandes vocales", 100.00, 150.00, sdf.parse("2024-01-01T09:00:00"), sdf.parse("2024-01-31T21:00:00"), mainCategory4, subCategory4, user2);
                Lot lot23 = new Lot("Lampe de chevet", "Lampe avec lumière ajustable", 50.00, 100.00, sdf.parse("2024-02-01T09:00:00"), sdf.parse("2024-02-28T21:00:00"), mainCategory5, subCategory5, user2);
                Lot lot24 = new Lot("Appareil photo reflex", "Appareil photo pour les professionnels", 800.00, 900.00, sdf.parse("2024-03-01T09:00:00"), sdf.parse("2024-03-31T21:00:00"), mainCategory6, subCategory6, user2);
                Lot lot25 = new Lot("Tablette graphique", "Tablette pour les dessinateurs", 400.00, 450.00, sdf.parse("2024-04-01T09:00:00"), sdf.parse("2024-04-30T21:00:00"), mainCategory1, subCategory1, user1);
                Lot lot26 = new Lot("Drones de surveillance", "Drones pour surveillance aérienne", 2000.00, 2100.00, sdf.parse("2024-05-01T09:00:00"), sdf.parse("2024-05-31T21:00:00"), mainCategory2, subCategory2, user1);
                Lot lot27 = new Lot("Jeans Levi's", "Jeans classiques et confortables", 80.00, 120.00, sdf.parse("2024-06-01T09:00:00"), sdf.parse("2024-06-30T21:00:00"), mainCategory3, subCategory3, user1);
                Lot lot28 = new Lot("Machine à café", "Machine pour café gourmet", 300.00, 350.00, sdf.parse("2024-07-01T09:00:00"), sdf.parse("2024-07-31T21:00:00"), mainCategory4, subCategory4, user1);
                Lot lot29 = new Lot("Plante décorative", "Plante d'intérieur facile d'entretien", 50.00, 100.00, sdf.parse("2024-08-01T09:00:00"), sdf.parse("2024-08-31T21:00:00"), mainCategory5, subCategory5, user1);
                Lot lot30 = new Lot("Casque VR", "Casque de réalité virtuelle", 600.00, 650.00, sdf.parse("2024-09-01T09:00:00"), sdf.parse("2024-09-30T21:00:00"), mainCategory6, subCategory6, user1);

                log.info("Preloading " + repository.save(lot1));
                log.info("Preloading " + repository.save(lot2));
                log.info("Preloading " + repository.save(lot3));
                log.info("Preloading " + repository.save(lot4));
                log.info("Preloading " + repository.save(lot5));
                log.info("Preloading " + repository.save(lot6));
                log.info("Preloading " + repository.save(lot1));
                log.info("Preloading " + repository.save(lot2));
                log.info("Preloading " + repository.save(lot3));
                log.info("Preloading " + repository.save(lot4));
                log.info("Preloading " + repository.save(lot5));
                log.info("Preloading " + repository.save(lot6));
                log.info("Preloading " + repository.save(lot7));
                log.info("Preloading " + repository.save(lot8));
                log.info("Preloading " + repository.save(lot9));
                log.info("Preloading " + repository.save(lot10));
                log.info("Preloading " + repository.save(lot11));
                log.info("Preloading " + repository.save(lot12));
                log.info("Preloading " + repository.save(lot13));
                log.info("Preloading " + repository.save(lot14));
                log.info("Preloading " + repository.save(lot15));
                log.info("Preloading " + repository.save(lot16));
                log.info("Preloading " + repository.save(lot17));
                log.info("Preloading " + repository.save(lot18));
                log.info("Preloading " + repository.save(lot19));
                log.info("Preloading " + repository.save(lot20));
                log.info("Preloading " + repository.save(lot21));
                log.info("Preloading " + repository.save(lot22));
                log.info("Preloading " + repository.save(lot23));
                log.info("Preloading " + repository.save(lot24));
                log.info("Preloading " + repository.save(lot25));
                log.info("Preloading " + repository.save(lot26));
                log.info("Preloading " + repository.save(lot27));
                log.info("Preloading " + repository.save(lot28));
                log.info("Preloading " + repository.save(lot29));
                log.info("Preloading " + repository.save(lot30));

                // Lots list by Seller
                List<User> users = userRepository.findAll();
                for (User user : users) {
                    List<Lot> userLots = repository.findByUser(user);
                    StringBuilder lotsInfo = new StringBuilder();
                    lotsInfo.append("Lots pour ").append(user.getName()).append(": {");
                    for (Lot lot : userLots) {
                        lotsInfo.append("ID=").append(lot.getId()).append(", Nom=").append(lot.getName()).append("; ");
                    }
                    lotsInfo.append("}");
                    log.info(lotsInfo.toString());
                }

            } catch (Exception e) {
                log.error("Error initializing database", e);
            }
        };
    }
}
