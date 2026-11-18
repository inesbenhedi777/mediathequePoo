import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediathequeExceptionTest {

    @Test
    void indisponibleConserveLaCause() {
        Exception cause = new IllegalStateException("etat interne incoherent");

        DocumentIndisponibleException ex =
                new DocumentIndisponibleException("Document indisponible : Dune", cause);

        assertSame(cause, ex.getCause());
        assertTrue(ex.getMessage().contains("Dune"));
    }

    @Test
    void introuvableConserveLaCause() {
        Exception cause = new RuntimeException("index corrompu");

        DocumentIntrouvableException ex =
                new DocumentIntrouvableException("Document introuvable : Dune", cause);

        assertSame(cause, ex.getCause());
    }

    @Test
    void sansCauseLeGetCauseEstNull() {
        DocumentIndisponibleException ex = new DocumentIndisponibleException("Document indisponible : Dune");

        assertNull(ex.getCause());
    }

    @Test
    void lesDeuxSontDesMediathequeException() {
        assertInstanceOf(MediathequeException.class, new DocumentIndisponibleException("x"));
        assertInstanceOf(MediathequeException.class, new DocumentIntrouvableException("x"));
    }
}