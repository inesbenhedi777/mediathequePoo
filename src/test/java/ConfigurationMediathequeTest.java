import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfigurationMediathequeTest {

    @Test
    void dureePersonnalisee() {
        var config = new ConfigurationMediatheque(7, 5);
        assertEquals(7, config.getDureeEmprunt());
    }

    @Test
    void dureeParDefaut() {
        var config = new ConfigurationMediatheque(21, 5);
        assertEquals(21, config.getDureeEmprunt());
    }

}