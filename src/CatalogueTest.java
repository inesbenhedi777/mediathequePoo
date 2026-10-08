import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogueTest {

    @Test
    void empruntNominal() throws DocumentIndisponibleException {
        Livre l = new Livre("Clean Code", 2008, "R. Martin", 464);

        l.emprunter();

        assertFalse(l.estDisponible());

        l.rendre();

        assertTrue(l.estDisponible());
    }

    @Test
    void doubleEmpruntLeveException() throws DocumentIndisponibleException {
        Livre l = new Livre("Refactoring", 1999, "M. Fowler", 448);

        l.emprunter();

        DocumentIndisponibleException exception =
                assertThrows(
                        DocumentIndisponibleException.class,
                        l::emprunter
                );

        assertTrue(exception.getMessage().contains("Refactoring"));
    }

    @Test
    void rechercheInfructueuse() {
        Catalogue<Document> c = new Catalogue<>();

        c.ajouter(new Revue("Science", 2026, 412));

        assertTrue(c.rechercherParTitre("Nature").isEmpty());
    }
}