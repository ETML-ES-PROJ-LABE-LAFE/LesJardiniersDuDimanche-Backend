package ch.etmles.payroll;

import ch.etmles.payroll.Controllers.LotController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ch.etmles.payroll.Entities.Lot;
import ch.etmles.payroll.Repositories.LotRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LotControllerTest {

    private LotRepository lotRepository;
    private LotController lotController;

    @BeforeEach
    public void setUp() {
        lotRepository = new LotRepository(); // Suppose que ceci est un stub ou une implémentation concrète
        lotController = new LotController(lotRepository);
    }

    @Test
    public void all_whenLotsExist_thenLotsReturned() {
        // Given
        List<Lot> expectedLots = Arrays.asList(new Lot("Laptop", "High-end gaming laptop", 1200.0, null, null, null, null));
        lotRepository.saveAll(expectedLots);

        // When
        List<Lot> results = lotController.all();

        // Then
        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("Laptop", results.get(0).getNom());
    }

    @Test
    public void newLot_whenValidLot_thenLotSaved() {
        // Given
        Lot newLot = new Lot("Camera", "DSLR Camera for professionals", 2000.0, null, null, null, null);

        // When
        Lot result = lotController.newLot(newLot);

        // Then
        assertNotNull(result);
        assertEquals("Camera", result.getNom());
    }
}
