package ch.etmles.payroll.Controllers;

//TODO This "test class" must be moved to a more suitable folder and rewritten in a test class

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test-db")
    public ResponseEntity<String> testDatabaseConnection() {
        try {
            jdbcTemplate.queryForObject("SELECT TOP 1 * FROM dbo.LOTS", String.class);  // Adaptez cette ligne selon votre schéma de base de données
            return new ResponseEntity<>("Connexion réussie !", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur de connexion : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
