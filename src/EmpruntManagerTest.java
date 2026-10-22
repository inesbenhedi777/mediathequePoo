import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpruntManagerTest {
    @Test
    void emprunterDocumentIntrouvable() {
        Catalogue<Document> catalogue = new Catalogue<>();
        EmpruntManager manager = new EmpruntManager(catalogue);

        assertThrows(DocumentIntrouvableException.class,
            () -> manager.emprunter("LivreInexistant"));
    }

    @Test
    void emprunterDejaEmprunte() {
        Catalogue<Document> catalogue = new Catalogue<>();
        Livre livre = new Livre("Clean Code", 2008, "R. Martin", 464);
        catalogue.ajouter(livre);
        EmpruntManager manager = new EmpruntManager(catalogue);

        assertDoesNotThrow(() -> manager.emprunter("Clean Code"));

        DocumentIndisponibleException ex = assertThrows(
            DocumentIndisponibleException.class,
            () -> manager.emprunter("Clean Code")
        );
        assertTrue(ex.getMessage().contains("Clean Code"));
    }

    @Test
    void emprunterRevueNonEmpruntable() {
        Catalogue<Document> catalogue = new Catalogue<>();
        Revue revue = new Revue("Science", 2026, 412);
        catalogue.ajouter(revue);
        EmpruntManager manager = new EmpruntManager(catalogue);

        DocumentIndisponibleException ex = assertThrows(
            DocumentIndisponibleException.class,
            () -> manager.emprunter("Science")
        );
        assertTrue(ex.getMessage().contains("Non empruntable"));
    }

    @Test
    void rapportEmpruntsAutoCloseable() {
        Catalogue<Document> catalogue = new Catalogue<>();
        Livre livre = new Livre("Clean Code", 2008, "R. Martin", 464);
        catalogue.ajouter(livre);
        EmpruntManager manager = new EmpruntManager(catalogue);

        // Demonstration de try-with-resources avec AutoCloseable
        try (RapportEmprunts rapport = new RapportEmprunts()) {
            assertDoesNotThrow(() -> manager.emprunter("Clean Code"));
            rapport.enregistrer();
        }
    }
}