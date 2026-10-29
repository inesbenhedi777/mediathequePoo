import java.io.IOException;
import java.util.List;

public class RapportService {
    private final FormatRapport format;
    private final DestinationRapport destination;
    private final Notificateur notificateur;

    public RapportService(FormatRapport format, DestinationRapport destination, Notificateur notificateur) {
        this.format = format;
        this.destination = destination;
        this.notificateur = notificateur;
    }

    public void genererRapport(List<Document> docs) throws IOException {
        String contenu = format.formatter(docs);
        destination.ecrire(contenu);
        notificateur.notifier("Rapport genere");
    }
}
