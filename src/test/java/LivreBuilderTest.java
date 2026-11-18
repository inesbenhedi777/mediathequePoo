import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivreBuilderTest {

    @Test
    void construitAvecOptionnels() {
        Livre l = new Livre.Builder("Clean Code", 2008, "R. Martin", 464)
                .isbn("978-0132350884")
                .editeur("Prentice Hall")
                .langue("en")
                .build();

        assertEquals("978-0132350884", l.getIsbn());
        assertEquals("Prentice Hall", l.getEditeur());
        assertEquals("en", l.getLangue());
    }

    @Test
    void optionnelsAbsentsSontNull() {
        Livre l = new Livre.Builder("Dune", 1965, "F. Herbert", 800).build();

        assertNull(l.getIsbn());
        assertNull(l.getEditeur());
        assertNull(l.getLangue());
    }

    @Test
    void anneeTropAncienneRefusee() {
        assertThrows(IllegalArgumentException.class,
                () -> new Livre.Builder("Vieux", 1400, "X", 100).build());
    }

    @Test
    void nbPagesNulRefuse() {
        assertThrows(IllegalArgumentException.class,
                () -> new Livre.Builder("Vide", 2000, "X", 0).build());
    }

    @Test
    void livreConstruitParBuilderResteEmpruntable() throws DocumentIndisponibleException {
        Livre l = new Livre.Builder("Refactoring", 1999, "M. Fowler", 448).build();

        l.emprunter();

        assertFalse(l.estDisponible());
    }
}