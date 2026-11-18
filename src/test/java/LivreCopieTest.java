import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivreCopieTest {

    private Livre original() {
        return new Livre.Builder("Clean Code", 2008, "R. Martin", 464)
                .isbn("978-0132350884")
                .build();
    }

    @Test
    void copieAMemesDonnees() {
        Livre original = original();
        Livre copie = new Livre(original);

        assertEquals(original.descriptionCourte(), copie.descriptionCourte());
        assertEquals(original.getIsbn(), copie.getIsbn());
    }

    @Test
    void copieEstUnAutreObjet() {
        Livre original = original();
        Livre copie = new Livre(original);

        assertNotSame(original, copie);
        assertNotEquals(original.getId(), copie.getId());
    }

    @Test
    void modifierLaCopieNeTouchePasLOriginal() throws DocumentIndisponibleException {
        Livre original = original();
        Livre copie = new Livre(original);

        copie.emprunter();

        assertFalse(copie.estDisponible());
        assertTrue(original.estDisponible());   // l'original n'a pas bougé
    }
}