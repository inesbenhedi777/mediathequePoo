import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ConfigurationMediathequeTest {

    @Test
    @Order(1)
    void dureePersonnalisee() {
        ConfigurationMediatheque.getInstance().setDureeEmprunt(7);
        assertEquals(7, ConfigurationMediatheque.getInstance().getDureeEmprunt());
    }

    @Test
    @Order(2)
    void dureeParDefaut() {
        assertEquals(21, ConfigurationMediatheque.getInstance().getDureeEmprunt());
    }
}