import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class RapportServiceTest {

    static class FakeNotificateur implements Notificateur {
        private boolean notifie = false;
        private String dernierMessage;

        @Override
        public void notifier(String message) {
            this.notifie = true;
            this.dernierMessage = message;
        }

        public boolean estNotifie() {
            return notifie;
        }

        public String getDernierMessage() {
            return dernierMessage;
        }
    }

    static class FakeDestination implements DestinationRapport {
        private String contenuEcrit;

        @Override
        public void ecrire(String contenu) throws IOException {
            this.contenuEcrit = contenu;
        }

        public String getContenuEcrit() {
            return contenuEcrit;
        }
    }

    @Test
    void genererRapportAvecFakes() throws IOException {
        List<Document> docs = new ArrayList<>();
        docs.add(new Livre("Clean Code", 2008, "R. Martin", 464));
        docs.add(new Dvd("Matrix", 1999, 136));

        FormatRapport format = new FormatCsv();
        FakeDestination destination = new FakeDestination();
        FakeNotificateur notificateur = new FakeNotificateur();

        RapportService service = new RapportService(format, destination, notificateur);
        service.genererRapport(docs);

        assertTrue(destination.getContenuEcrit().contains("Clean Code"));
        assertTrue(destination.getContenuEcrit().contains("Matrix"));
        assertTrue(notificateur.estNotifie());
        assertEquals("Rapport genere", notificateur.getDernierMessage());
    }
}
